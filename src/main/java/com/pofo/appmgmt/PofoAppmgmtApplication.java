package com.pofo.appmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PofoAppmgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(PofoAppmgmtApplication.class, args);
	}

}
