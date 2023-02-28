/**
 * @file EX17.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 17 - Faça um programa que leia um número inteiro n e mostre na tela o n-ésimo termo da sequência de Fibonacci

public class EX17 {

    public static int[] vetFibo(int n){
        int[] fibo = new int[n];

        fibo[0] = 1;
        fibo[1] = 1;
        for (int i = 2; i < n; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        return fibo;
    }

    public static void printFibo(int[] vetFibo){
        for(int i = 0; i < vetFibo.length; i++){
            MyIO.print(vetFibo[i] + " ");
        }
    }

    public static void main(String[] args){
        int termo = MyIO.readInt("Informe a quantidade de termos que deseja ver na sequencia de Fibonacci: ");
        printFibo(vetFibo(termo));
    }
}
