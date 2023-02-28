/**
 * @file EX29.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 29 - Faça um programa para ler um número inteiro N e N elementos de um array.
// Em seguida, calcular e mostrar o número de elementos pares e o de divisíveis por três.

public class EX29 {
    public static void main(String [] args){
        int n = MyIO.readInt("Numero de itens no array: ");
        int contPar = 0, contMultTres = 0;
        int [] array = new int[n];

        for(int i = 0; i < n; i++){
            array[i] = MyIO.readInt("[ " + i + " ] = ");
        }

        for(int i = 0; i < n; i++){
            if(array[i] % 2 == 0)
                contPar++;

            if(array[i] % 3 == 0)
                contMultTres++;
        }

        MyIO.print("Quantidade de Pares: " + contPar);
        MyIO.print("Quantidade de Multiplos de 3: " + contMultTres);
    }
}
