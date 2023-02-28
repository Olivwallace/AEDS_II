/**
 * @file EX31.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 31 - Faça um programa que leia N números inteiros e mostre na tela a soma
//daqueles que forem múltiplos de três

public class EX31 {
    public static void main(String[] args){
        int n = MyIO.readInt("QTD Entradas: ");
        int [] valores = new int[n];
        int soma = 0;

        for(int i = 0; i < n; i++){
            valores[i] = MyIO.readInt("["+i+"] = ");
        }

        for(int i = 0; i < n; i++)
            if(valores[i] % 3 == 0)
                soma += valores[i];

        MyIO.print("SOMA DOS MULTIPLOS DE 3: " + soma);
    }
}
