import java.util.Arrays;

/**
 * @file EX26.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 26 - Faça um programa que receba um array e ordene os elementos desse array

public class EX26 {
    public static void main(String [] args){
        int numTermos = MyIO.readInt("Informe o numero de termos: ");
        int [] array = new int[numTermos];

        for(int i = 0; i < numTermos; i++)
            array[i] = MyIO.readInt("[ " + i + " ] = ");

        MyIO.print("Nao ordenados: \n");
        for(int i = 0; i < numTermos; i++){
            MyIO.print(array[i] + " ");
        }

        Arrays.sort(array);

        MyIO.print("\nOrdenados: \n");
        for(int i = 0; i < numTermos; i++){
            MyIO.print(array[i] + " ");
        }
    }
}
