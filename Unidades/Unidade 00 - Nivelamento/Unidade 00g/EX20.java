/**
 * @file EX20.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 20 - Faça um programa que leia n números inteiros, calcule a média desses valores e mostre aqueles que forem maiores que a média

public class EX20 {
    public static void main(String[] args){
        float media;
        int soma = 0, nTermos = MyIO.readInt("Informe o numero de notas: ");
        int[] valores = new int[nTermos];

        for(int i = 0; i < nTermos; i++){
            valores[i] = MyIO.readInt("informe o " + (i + 1) + " valor: ");
            soma += valores[i];
        }

        media = ((float)soma/nTermos);

        for (int i = 0; i < nTermos; i++)
            if(valores[i] >= media)
                MyIO.print("\n" + valores[i]);

    }
}
