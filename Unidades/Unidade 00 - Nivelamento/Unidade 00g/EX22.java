/**
 * @file EX22.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 22 - Faça um programa que leia n números e os armazene em um array e depois exiba todos;

public class EX22 {
    public static void main(String[] args){
        int qtdValores = MyIO.readInt("Ifrome o numero de valores a serem armazenados: ");
        float [] valores = new float[qtdValores];

        for (int i = 0; i < qtdValores; i++){
            valores[i] = MyIO.readFloat("Valor " + (i + 1) + ": ");
        }

        for(int i = 0; i < qtdValores; i++)
            MyIO.print("\n" + valores[i]);
    }
}
