package com.example.maquina_de_comida;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/maquinas")
public class DoceController {

    private final Map<String, Maquina> maquinas = new HashMap<>();

    private final Maquina maquina1 = new Maquina("Máquina 1");
    private final Maquina maquina2 = new Maquina("Máquina 2");

    public DoceController() {
        maquinas.put("maquina1", maquina1);
        maquinas.put("maquina2", maquina2);
    }

    @PostMapping("/{nome}/adicionarMoeda")
    public String adicionarMoeda(@PathVariable String nome, @RequestBody int valor) {
        Maquina maquina = getMaquina(nome);
        if (maquina == null) {
            return "Máquina não encontrada!";
        }
        maquina.adicionarMoeda(valor);
        return "Moeda de R$" + valor + " adicionada. Saldo atual: R$" + maquina.getSaldo();
    }

    @PostMapping("/{nome}/comprarDoce")
    public String comprarDoce(@PathVariable String nome, @RequestBody String tipo) {
        Maquina maquina = getMaquina(nome);
        if (maquina == null) {
            return "Máquina não encontrada!";
        }
        return maquina.comprarDoce(tipo) + " Saldo restante: R$" + maquina.getSaldo() + ",00.";
    }

    @PostMapping("/{nome}/retirarTroco")
    public String retirarTroco(@PathVariable String nome) {
        Maquina maquina = getMaquina(nome);
        if (maquina == null) {
            return "Máquina não encontrada!";
        }
        return maquina.darTroco();
    }

    private Maquina getMaquina(String nome) {
        return maquinas.get(nome.toLowerCase());
    }
}