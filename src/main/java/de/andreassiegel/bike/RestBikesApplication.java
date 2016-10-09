package de.andreassiegel.bike;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class RestBikesApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {

        new SpringApplicationBuilder(RestBikesApplication.class).web(true)
            .run(args);
    }

    @Autowired
    Map<String, FormatterRegistrar> formatterRegistrarMap;

    @Override
    public void addFormatters(FormatterRegistry registry) {

        for (FormatterRegistrar registrar : formatterRegistrarMap.values()) {
            registrar.registerFormatters(registry);
        }
    }
}
