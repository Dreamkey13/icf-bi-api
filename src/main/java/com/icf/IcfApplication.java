package com.icf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.icf.*" )
public class IcfApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcfApplication.class, args);
	}

}
