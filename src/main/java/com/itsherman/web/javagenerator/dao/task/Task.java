package com.itsherman.web.javagenerator.dao.task;

public interface Task<T> {

    T run() throws ClassNotFoundException;
}
