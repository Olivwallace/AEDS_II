import java.util.ArrayList;
import java.util.Collections;

/**
 * @file EX34.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 34 -  Faça um programa para ler um vetor contendo N elementos inseridos em
//uma ordem qualquer e mostre os elementos de forma ordenada

public class EX34 {
    public static ArrayList<Float> lerArray(String nomeArray, int size){
        ArrayList<Float> a = new ArrayList<Float>(size);

        MyIO.print(nomeArray);
        for(int i = 0; i < size; i++)
            a.add(MyIO.readFloat("["+ i + "] = "));
        return a;
    };

    public static void main(String[] args){
        int n = MyIO.readInt("Tamanho Primeiro Array: ");
        ArrayList<Float> arrayA = lerArray("\nArray A:\n", n);

        Collections.sort(arrayA);

        MyIO.print("Array Ordenado:\n");
        for (int i = 0; i< arrayA.size();i ++) {
            MyIO.print(arrayA.get(i) + " ");
        }
    }
}
