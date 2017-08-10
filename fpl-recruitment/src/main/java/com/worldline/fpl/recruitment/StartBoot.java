package com.worldline.fpl.recruitment;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Application entry point
 * 
 * @author A525125
 *
 */
@SpringBootApplication
@Slf4j
public class StartBoot {

	public static void main(String[] args) {
		log.info("Start application ...");
		ApplicationContext context =  SpringApplication.run(StartBoot.class, args);
		DataSource dataSource = context.getBean(javax.sql.DataSource.class);
		log.info("DATASOURCE = " + dataSource);
	}

}
