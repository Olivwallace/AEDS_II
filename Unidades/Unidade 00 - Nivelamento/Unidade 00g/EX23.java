/**
 * @file EX23.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 23 - Faça um programa que leia n números e mostre quais deles são maiores que a média;

public class EX23 {
    public static void main(String[] args) {
        int qtdValores = MyIO.readInt("Ifrome o numero de valores a serem armazenados: ");
        float[] valores = new float[qtdValores];
        float soma = 0, media;

        for (int i = 0; i < qtdValores; i++) {
            valores[i] = MyIO.readFloat("Valor " + (i + 1) + ": ");
            soma += valores[i];
        }

        media = soma / qtdValores;
        for (int i = 0; i < qtdValores; i++){
            if (valores[i] > media) {
                MyIO.print("\n" + valores[i]);
            }
        }
    }
}