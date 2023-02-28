/**
 * @file EX36.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 36 - Faça um programa que leia os elementos de uma matriz com L linhas e C colunas e mostre na tela os elementos da matriz Transposta

public class EX36 {

    public static float[][] lerMatriz(int numLinhas, int numColunas){
        float[][] matriz = new float[numLinhas][numColunas];

        for(int i = 0; i < numLinhas; i++){
            for(int j = 0; j < numColunas; j++){
                matriz[i][j] = MyIO.readInt("["+i+"]["+j+"] = ");
            }
        }

        return matriz;
    }

    public static void matrizTransposta(int numL, int numC, float[][] matriz){

        for(int i = 0; i < numC; i++){
            MyIO.print("\n|");
            for(int j = 0; j < numL; j++) {
                MyIO.print(" "+ matriz[j][i] + " |");
            }
        }

    }

    public static void main(String[] args){
        int l = MyIO.readInt("Num linhas: "), c = MyIO.readInt("Num colunas: ");
        float [][] matriz = lerMatriz(l,c);
        matrizTransposta(l,c,matriz);
    }
}
