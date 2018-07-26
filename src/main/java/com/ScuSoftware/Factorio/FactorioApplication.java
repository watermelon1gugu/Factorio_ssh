package com.ScuSoftware.Factorio;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ScuSoftware.Factorio.dao")
public class FactorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactorioApplication.class, args);
	}
}
