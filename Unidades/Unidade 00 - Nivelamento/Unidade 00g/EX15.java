/**
 * @file EX15.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 15 - Faça um programa que leia um número inteiro N e mostre na tela os N  primeiros números
// da sequência 1, 5, 12, 16, 23, 27 34.

public class EX15 {
    public static void main(String[] args){
        int valor = 1;
        int nTermos = MyIO.readInt("Informe o numero de termos desejado:\n\t");

        MyIO.print(valor);
        for(int i = 1; i < nTermos; i++){
            if(i % 2 != 0){
                MyIO.print("\n" + (valor + 4));
                valor += 4;
            }else{
                MyIO.print("\n" + (valor + 7));
                valor += 7;
            }
        }
    }
}
