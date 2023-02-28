/**
 * @file EX37.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 37 - Faça um programa que leia duas matrizes com os mesmos números de linhas e colunas, faça a soma das mesmas
// e imprima na tela a matriz resultante

public class EX37 {

    public static float[][] lerMatriz(int numLinhas, int numColunas){
        float[][] matriz = new float[numLinhas][numColunas];

        for(int i = 0; i < numLinhas; i++){
            for(int j = 0; j < numColunas; j++){
                matriz[i][j] = MyIO.readInt("["+i+"]["+j+"] = ");
            }
        }

        return matriz;
    }

    public static float[][] somarMatrizes(float[][] a, float[][] b, int numLinhas, int numColunas){
        float[][] matriz = new float[numLinhas][numColunas];

        for(int i = 0; i < numLinhas; i++){
            for(int j = 0; j < numColunas; j++){
                matriz[i][j] = (a[i][j] + b[i][j]);
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
        float [][] matrizA = lerMatriz(l,c);
        float [][] matrizB = lerMatriz(l,c);
        printMatriz(l,c,somarMatrizes(matrizA,matrizB,l,c));
    }
}
