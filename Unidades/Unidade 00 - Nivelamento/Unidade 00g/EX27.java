/**
 * @file EX27.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 27 - Declare um vetor com contendo os elementos 10, 5, 8, 2 e 8. Em seguida, mostre os elementos contidos no array

public class EX27 {

    public static void main(String[] args){
        int[] vet = {10, 5, 8, 2, 8};

        for(int i = 0; i < vet.length; i++)
            MyIO.print(vet[i] + " ");
    }
}
