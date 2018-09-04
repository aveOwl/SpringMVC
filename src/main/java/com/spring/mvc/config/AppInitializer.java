package com.spring.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Register of the {@code DispatcherServlet}.
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Root WebApplicationContext. Containing middle-tier services, dataSources, etc.
     *
     * @return Class with RootConfiguration.
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                DataConfig.class
        };
    }

    /**
     * Servlet WebApplicationContext. Containing controllers, view resolvers,
     * and other web-related beans.
     *
     * @return Class with WebConfiguration.
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }

    /**
     * Returns mapping(s) for the {@code DispatcherServlet}.
     *
     * @return mapping(s) for the {@code DispatcherServlet}.
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
