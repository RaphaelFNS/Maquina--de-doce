package com.example.maquina_de_comida;

import java.util.ArrayList;
import java.util.List;

public class Maquina {
    private String nome;
    private int saldo;
    private List<String> docesComprados;

    public Maquina(String nome) {
        this.nome = nome;
        this.saldo = 0;
        this.docesComprados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSaldo() {
        return saldo;
    }

    public void adicionarMoeda(int valor) {
        this.saldo += valor;
    }

    public String comprarDoce(String tipo) {
        int preco = 0;
        String tipoCorrigido = tipo.replace("\"", ""); 

        switch (tipoCorrigido) {
            case "A": preco = 6; break;
            case "B": preco = 7; break;
            case "C": preco = 8; break;
            default: return "Doce não encontrado!";
        }

        if (this.saldo >= preco) {
            this.saldo -= preco;
            docesComprados.add(tipoCorrigido);
            return "Você comprou o Doce " + tipoCorrigido + "!";
        } else {
            return "Saldo insuficiente! Insira mais moedas.";
        }
    }

    public String finalizarCompra() {
        if (docesComprados.isEmpty()) {
            return "Nenhum doce comprado!";
        }

        StringBuilder resultado = new StringBuilder("Compra finalizada: ");
        for (String doce : docesComprados) {
            resultado.append("Doce ").append(doce).append(" ");
        }

        if (docesComprados.size() > 1 && saldo > 0) {
            resultado.append("com troco de R$").append(saldo).append(",00.");
        } else {
            resultado.append("sem troco.");
        }

        saldo = 0;
        docesComprados.clear();
        return resultado.toString();
    }
}
