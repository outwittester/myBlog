package com.sincere.web.admin;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;

@Configuration
public class WebConfig2 {
    @Bean
    public ServletRegistrationBean<HttpServlet> countryServlet() {
        ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
        servRegBean.setServlet(new ServletTest());
        servRegBean.addUrlMappings("/country/*");
        servRegBean.setLoadOnStartup(1);
        return servRegBean;
    }
    @Bean
    public ServletRegistrationBean<HttpServlet> stateServlet() {
        ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
        servRegBean.setServlet(new ServletTest());
        servRegBean.addUrlMappings("/state/*");
        servRegBean.setLoadOnStartup(1);
        return servRegBean;
    }
}
