package com.itsherman.javagenerator.utils;


import com.fasterxml.jackson.databind.util.ClassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassUtils {

    private static Logger log = LoggerFactory.getLogger(ClassUtil.class);

    public static List<Class<?>> getClasses(String packageName)

            throws ClassNotFoundException, IOException {


        ClassLoader classLoader = Thread.currentThread()

                .getContextClassLoader();

        String path = packageName.replace(".", "/");

        log.info("path:" + path);

        Enumeration<URL> resources = classLoader.getResources(path);

        log.info("获取资源路径" + resources);

        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();

        while (resources.hasMoreElements()) {

            log.info("resources.hasMoreElements()");

            URL resource = resources.nextElement();

            log.info(resource.getProtocol());

            log.info(resource.getPath());


            String protocol = resource.getProtocol();


            if ("file".equals(protocol)) {

                File file = new File(resource.getFile());

                classes.addAll(findClasses(file, packageName));

            } else if ("jar".equals(protocol)) {

                System.out.println("jar类型的扫描");

                String jarpath = resource.getPath();

                jarpath = jarpath.replace("file:/", "");

                jarpath = jarpath.substring(0, jarpath.indexOf("!"));

                return getClasssFromJarFile(jarpath, path);

            }


        }

        return classes;

    }


    private static List<Class<?>> findClasses(File directory, String packageName)

            throws ClassNotFoundException {

        log.info("directory.exists()=" + directory.exists());

        log.info("directory.getName()=" + directory.getName());

        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();


        if (!directory.exists()) {

            return classes;

        }


        File[] files = directory.listFiles();

        for (File file : files) {

            if (file.isDirectory()) {

                assert !file.getName().contains(".");

                classes.addAll(findClasses(file,

                        packageName + "." + file.getName()));

            } else if (file.getName().endsWith(".class")) {

                classes.add(Class.forName(packageName

                        + "."

                        + file.getName().substring(0,

                        file.getName().length() - 6)));

            }

        }

        return classes;


    }


    /**
     * 从jar文件中读取指定目录下面的所有的class文件
     *
     * @param jarPaht  jar文件存放的位置
     * @param filePaht 指定的文件目录
     * @return 所有的的class的对象
     */

    public static List<Class<?>> getClasssFromJarFile(String jarPaht,

                                                      String filePaht) {

        List<Class<?>> clazzs = new ArrayList<Class<?>>();


        JarFile jarFile = null;

        try {

            jarFile = new JarFile(jarPaht);


            List<JarEntry> jarEntryList = new ArrayList<JarEntry>();


            Enumeration<JarEntry> ee = jarFile.entries();

            while (ee.hasMoreElements()) {

                JarEntry entry = (JarEntry) ee.nextElement();

                // 过滤我们出满足我们需求的东西

                if (entry.getName().startsWith(filePaht)

                        && entry.getName().endsWith(".class")) {

                    jarEntryList.add(entry);

                }

            }

            for (JarEntry entry : jarEntryList) {

                String className = entry.getName().replace('/', '.');

                className = className.substring(0, className.length() - 6);


                try {

                    clazzs.add(Thread.currentThread().getContextClassLoader()

                            .loadClass(className));

                } catch (ClassNotFoundException e) {

                    e.printStackTrace();

                }

            }

        } catch (IOException e1) {

            log.error("解析jar包文件异常");

        } finally {

            if (null != jarFile) {

                try {

                    jarFile.close();

                } catch (Exception e) {

                }


            }

        }

        return clazzs;

    }

}
