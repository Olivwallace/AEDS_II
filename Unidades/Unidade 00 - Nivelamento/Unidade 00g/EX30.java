/**
 * @file EX30.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 30 - Faça um programa que leia N números inteiros e mostre na tela a soma do primeiro e do último,
// a do segundo e do penúltimo, a do terceiro e do antepenúltimo,…

public class EX30 {
    public static void main(String[] args){
        int numTermos = MyIO.readInt("Numero de itens: ");
        int [] valores = new int [numTermos];

        for(int i = 0; i < valores.length; i++){
            valores[i] = MyIO.readInt("["+i+"]");
        }

        for(int i = 0; i < (valores.length/2); i++){
            int soma = valores[i] + valores[valores.length - i - 1];
            MyIO.print("\n"+ valores[i] + " + " +  valores[valores.length - i - 1] + " = " + soma);
        }
    }
}
