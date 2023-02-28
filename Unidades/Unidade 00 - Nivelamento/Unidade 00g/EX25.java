/**
 * @file EX25.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 25 - Faça um programa que leia os elementos de um array de tamanho n e mostre a posição do menor elemento do array

public class EX25 {
    public static void main(String[] args){
        int numTermos = MyIO.readInt("Informe o numero de termos: ");
        int menor;
        int [] array = new int[numTermos];

        for(int i = 0; i < numTermos; i++)
            array[i] = MyIO.readInt("[ " + i + " ] = ");

        menor = 0;
        for(int i = 1; i < numTermos; i++)
            if(array[menor] > array[i])
                menor = i;

        MyIO.print("A posição do menor foi: " + menor + "Valor - " + array[menor]);
    }
}
