/**
 * @file EX38.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 38 - Faça um programa que leia os elementos de uma matriz quadrada com N linhas e N colunas e mostre as diagonais principal e secundária

public class EX38 {

    public static float[][] lerMatriz(int numLinhas, int numColunas){
        float[][] matriz = new float[numLinhas][numColunas];

        for(int i = 0; i < numLinhas; i++){
            for(int j = 0; j < numColunas; j++){
                matriz[i][j] = MyIO.readInt("["+i+"]["+j+"] = ");
            }
        }

        return matriz;
    }

    public static void imprimeDiagonais(int numL, float[][] matriz){
        MyIO.print("Diagonal principal:\n ");
        for(int i = 0; i < numL; i++){
            MyIO.print(matriz[i][i] + " ");
        }

        MyIO.print("\nDiagonal secundaria:\n ");
        for (int i = 0; i < numL; i++){
            MyIO.print(matriz[i][numL - 1 - i] + " ");
        }
    }

    public static void main(String[] args){
        int l = MyIO.readInt("Dimensao matriz quadrada: ");
        float [][] matriz = lerMatriz(l,l);
        imprimeDiagonais(l,matriz);
    }
}
