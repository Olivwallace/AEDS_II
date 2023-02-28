/**
 * @file EX14.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 14 - Faça um programa que leia um número inteiro N e mostre na tela os N primeiros números inteiros ímpares.

public class EX14 {
    public static void main(String[] args){
        int c = 0;
        int nTermos = MyIO.readInt("Numero de termos:\n\t");

        for(int i = 0; c < nTermos ; i++){
            if(i % 2 != 0){
                MyIO.print("\n" + i);
                c++;
            }
        }
    }
}
