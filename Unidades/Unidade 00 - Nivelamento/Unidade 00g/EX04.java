/**
 * @file EX04.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 04 - Leia 10 números inteiros, selecione o maior e imprima seu valor na tela.

public class EX04 {

    public static int _QTD_IN = 10;

    public static void main(String [] args){
        int maior;
        int []valores = new int[_QTD_IN];

        for(int i = 0; i < _QTD_IN; i++)
            valores[i] = MyIO.readInt("Informe o " + (i + 1)  + " valor: ");

        maior = valores[0];
        for(int i = 1; i < _QTD_IN; i++)
            if(valores[i] > maior)
                maior = valores[i];

        MyIO.print("O maior valor informado foi " + maior);
    }
}
