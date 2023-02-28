/**
 * @file EX39.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 39 - Faça um programa que leia os elementos de uma matriz e mostre a média dos elementos

public class EX39 {

    public static float[][] lerMatriz(int numLinhas, int numColunas){
        float[][] matriz = new float[numLinhas][numColunas];

        for(int i = 0; i < numLinhas; i++){
            for(int j = 0; j < numColunas; j++){
                matriz[i][j] = MyIO.readInt("["+i+"]["+j+"] = ");
            }
        }

        return matriz;
    }

    public static float caculaMediaMatriz(int numL, int numC, float[][] matriz){
        float soma = 0;

        for(int i = 0; i < numL; i++)
            for (int j = 0; j < numC; j++)
                soma += matriz[i][j];

        return soma/(numL*numC);
    }

    public static void main(String[] args){
        int l = MyIO.readInt("Num Linhas: "), c = MyIO.readInt("Num colunas: ");
        float [][] matriz = lerMatriz(l,c);
        MyIO.print("A media dos itens da matriz eh: " + caculaMediaMatriz(l,c,matriz));
    }
}
