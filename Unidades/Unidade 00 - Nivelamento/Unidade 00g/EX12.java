/**
 * @file EX12.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 12 - Faça um programa que leia a nota de 5 alunos e mostre na tela a média das mesmas

public class EX12 {
    public static int _NALUNOS = 5;

    public static void main(String[] args){
        float somaNotas = 0;

        for(int i = 0; i < _NALUNOS; i++)
            somaNotas += MyIO.readFloat("Nota do " + (i+1) + " aluno:\n\t");

        MyIO.print("A media de notas foi " + (somaNotas/_NALUNOS));
    }

}
