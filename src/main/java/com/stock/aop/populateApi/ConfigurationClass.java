package com.stock.aop.populateApi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.stock.aop.populateApi")
@ComponentScan("com.stock.test")
@Component
@EnableAspectJAutoProxy
public class ConfigurationClass {

}
