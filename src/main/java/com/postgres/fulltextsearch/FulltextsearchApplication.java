package com.postgres.fulltextsearch;

import com.postgres.fulltextsearch.entities.FtsOne;
import com.postgres.fulltextsearch.repository.FtsOneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;

@SpringBootApplication @EnableAsync
public class FulltextsearchApplication {
	@Autowired
	private FtsOneRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(FulltextsearchApplication.class, args);
	}
}
