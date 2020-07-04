package br.com.lrsantos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.lrsantos.config.ListSuperApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(ListSuperApiProperty.class)
public class ListsuperApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListsuperApiApplication.class, args);
	}

}
