package com.arek.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Arek on 08.02.2017.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.arek"})
public class AppConfig {

}
