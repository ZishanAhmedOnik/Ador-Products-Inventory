package com.onik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by onik on 1/7/17.
 */
@SpringBootApplication
public class Main extends SpringBootServletInitializer {
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Main.class);
	}

	public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
