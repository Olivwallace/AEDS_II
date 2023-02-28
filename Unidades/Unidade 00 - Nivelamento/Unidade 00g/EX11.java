/**
 * @file EX11.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 11 - Faça um programa que mostre na tela o logaritmo na base 10 dos números 1 à 10

public class EX11 {
    public static int _nTERMOS = 10;

    public static void main(String[] args){
        for(int i = 1; i <= _nTERMOS; i++){
            MyIO.print("\nlog("+ i + ") = " + Math.log10(i));
        }
    }
}
