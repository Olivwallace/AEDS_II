/**
 * @file EX09.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 09 - Leia 10 números inteiros, selecione o menor e o maior e imprima os seus respectivos valores na tela.

public class EX09 {

    public static int _QTD_IN = 10; // Constante Literal

    /**
     * Imprime o maior e menor valor contido em um Array.
     * @param array Array contendo 'n' valores.
     */
    public static void printMaxMinArray(int[] array){
        int min = 0, max = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[max]) {
                max = i;
            }else if (array[i] < array[min]) {
                min = i;
            }
        }

        MyIO.print("Maior: " + array[max] + " | Menor: " + array[min]);
    }


    public static void main(String[] args){
        int []valores = new int[_QTD_IN];

        for(int i = 0; i < _QTD_IN; i++)
            valores[i] = MyIO.readInt("Informe o " + (i + 1)  + " valor: ");

        printMaxMinArray(valores);
    }
}
