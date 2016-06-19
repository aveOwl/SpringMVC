package com.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @Configuration tells, that this class is a Spring configuration.
 * @EnableWebMvc imports the Spring MVC configuration.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.spring.mvc.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * Resolves logical String-based view names to actual View types.
     */
    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * No need for custom controller logic - render a home page.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("welcome");
    }

    /**
     * This allows for mapping the DispatcherServlet to "/" (thus overriding the mapping of
     * the container’s default Servlet), while still allowing static resource requests to
     * be handled by the container’s default Servlet.
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
