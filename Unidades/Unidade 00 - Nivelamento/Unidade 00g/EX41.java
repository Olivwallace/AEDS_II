/**
 * @file EX41.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 41 - Faça um programa que leia os elementos de uma matriz e mostre a média dos elementos de cada coluna

public class EX41 {
    public static float[][] lerMatriz(int numLinhas, int numColunas){
        float[][] matriz = new float[numLinhas][numColunas];

        for(int i = 0; i < numLinhas; i++){
            for(int j = 0; j < numColunas; j++){
                matriz[i][j] = MyIO.readInt("["+i+"]["+j+"] = ");
            }
        }

        return matriz;
    }

    public static float[] mediaColunasMatriz(int numL, int numC, float[][] matriz){
        float[] vetMedias = new float[numL];

        for(int i = 0; i < numL; i++){
            float soma = 0;
            for (int j = 0; j < numC; j++){
                soma += matriz[j][i];
            }
            vetMedias[i] = soma/numC;
        }

        return vetMedias;
    }

    public static void main(String[] args){
        int l = MyIO.readInt("Num Linhas: "), c = MyIO.readInt("Num colunas: ");
        float [][] matriz = lerMatriz(l,c);
        float[] vetMedias = mediaColunasMatriz(l,c,matriz);

        for(int i = 0; i < vetMedias.length; i++)
            MyIO.print("\nColuna " + (i + 1) +": " + vetMedias[i]);
    }
}
