package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by pengsh on 09/08 11:38
 */
@Component
public class SpringContextHolder {

    @Autowired
    private static ApplicationContext context;

    public SpringContextHolder(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static <T> T get(Class<T> z) {
        return context.getBean(z);
    }
}
