/**
 * @file EX13.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 13 - Faça um programa que mostre os 10 primeiros números inteiros positivos.

public class EX13 {
    public static int _nTERMOS = 10;

    public static void main(String[] args){
        for(int i = 1; i <= _nTERMOS; i++){
            MyIO.print("\n" + i);
        }
    }
}
