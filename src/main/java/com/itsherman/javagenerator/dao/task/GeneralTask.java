package com.itsherman.javagenerator.dao.task;

import com.itsherman.javagenerator.dao.model.ModelDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public abstract class GeneralTask<T> implements Task<T> {

    protected Logger log;

    GeneralTask(ModelDefinition m, Class<? extends GeneralTask> taskClass) {
        Assert.notNull(m, String.format("[Assertion Failed] - Task can't start for [%s] is null", m.getSignature()));
        log = LoggerFactory.getLogger(taskClass);
    }

    @Override
    public abstract T run();

}
