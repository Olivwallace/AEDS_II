/**
 * @file EX18.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 18 - Faça um programa que leia a nota de 5 alunos e mostre na tela a média das mesmas usando o comando for

public class EX18 {
    public static int _NUMALUNOS = 5;

    public static void main(String[] args){
        float somaNotas = 0;
        float[] notas = new float[_NUMALUNOS];

        for(int i = 0; i < _NUMALUNOS; i++)
            notas[i] += MyIO.readInt("Nota " + (i + 1) + "Aluno: ");

        for(int i = 0; i < _NUMALUNOS; i++)
            somaNotas += notas[i];


        MyIO.print("A media da turma foi: " + (somaNotas/_NUMALUNOS));
    }
}
