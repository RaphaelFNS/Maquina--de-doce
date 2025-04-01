package com.example.maquina_de_comida;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
               .allowedOrigins("http://localhost:3000") // Endereço do frontend React
                .allowedMethods("GET", "POST", "PUT", "DELETE");
            //    .allowedMethods("*")
//                .allowCredentials(true);
//        http://localhost:8080/api/maquinas/instalar
    }
}