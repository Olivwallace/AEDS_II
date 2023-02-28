/**
 * @file EX10.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

//EX 10 - Faça um programa que mostre na tela os 10 primeiros números pares

public class EX10 {

    public static void main(String[] args){
        int i = 0, count = 0;

        while(count < 10){
           if(i % 2 == 0){
               MyIO.print("\n" + i);
               count++;
           }
           i++;
        }

    }
}
