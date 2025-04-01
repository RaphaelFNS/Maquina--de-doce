package com.example.maquina_de_comida;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

//adicionado exclude para não precisar de login para utilizar o spring
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })  
public class ServidorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServidorApplication.class, args);
    }

    //Método utilizado para carregar todos os arquivos no projeto
    @Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}
}
