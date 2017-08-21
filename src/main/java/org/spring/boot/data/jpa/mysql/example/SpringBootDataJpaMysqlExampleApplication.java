package org.spring.boot.data.jpa.mysql.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class SpringBootDataJpaMysqlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaMysqlExampleApplication.class, args);
	}
}
