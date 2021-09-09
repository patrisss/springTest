package com.patricia.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan(basePackages={"com.patricia.pages","com.patricia.basics"})
@PropertySources({
        @PropertySource("classpath:/test.properties")
})
public class Config {
}
