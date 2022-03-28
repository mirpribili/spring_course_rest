package com.example.restapi.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// замена web.xml
public class MyWebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // Так мы не будем исп. root конфиг классы
    }

    @Override // дадим ссылку на applicationContext
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // <url-pattern>/</url-pattern>
    }
}
