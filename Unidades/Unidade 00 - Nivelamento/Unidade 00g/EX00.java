/**
 * @file EX00.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 00 - Faça um programa que leia uma String, caractere, inteiro e real. Em seguida, seu programa deve imprimir na tela os valores lidos do teclado

public class EX00 {
    public static void main(String[] args){
        String nome = MyIO.readString("Escreva um nome:\n\t");
        char caracter = MyIO.readChar("Digite um caracter:\n\t");
        int inteiro = MyIO.readInt("Digite um inteiro:\n\t");
        float real = MyIO.readFloat("Digite um numero real [xxxx.xxxx]:\n\t");

        MyIO.print("\nOs valores digitados foram:\nSTRING: " + nome + "\nCHAR: " + caracter + "\nINT: " + inteiro + "\nREAL: " + real);
    }
}
