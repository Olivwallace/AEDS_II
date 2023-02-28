/**
 * @file EX35.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 35 - Faça um programa que leia os elementos de uma matriz com L linhas e C
//colunas e mostre na tela os elementos da matriz em formato de grid

public class EX35 {

    public static float[][] lerMatriz(int numLinhas, int numColunas){
        float[][] matriz = new float[numLinhas][numColunas];

        for(int i = 0; i < numLinhas; i++){
            for(int j = 0; j < numColunas; j++){
                matriz[i][j] = MyIO.readInt("["+i+"]["+j+"] = ");
            }
        }

        return matriz;
    }

    public static void printMatriz(int numLin, int numCol, float[][] matriz){
        for(int i = 0; i < numLin; i++){
            MyIO.print("\n|");
            for(int j = 0; j < numCol; j++) {
                MyIO.print(" "+ matriz[i][j] + " |");
            }
        }
    }

    public static void main(String[] args){
        int l = MyIO.readInt("Num linhas: "), c = MyIO.readInt("Num colunas: ");
        float [][] matriz = lerMatriz(l,c);
        printMatriz(l,c,matriz);
    }
}
