package com.example.maquina_de_comida;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class ServidorController {

    @GetMapping("/status")
    public String status() {
        return "Servidor rodando com sucesso!";
    }
}