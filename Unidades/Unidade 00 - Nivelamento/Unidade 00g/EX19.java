/**
 * @file EX19.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 19 - Faça um programa que leia a nota de 5 alunos e mostre na tela a média das notas cujo valor é maior ou igual a oitenta

public class EX19 {
    public static int _NOTABASE = 80;
    public static int _NUMALUNOS = 5;

    public static void main(String[] args){
        float notasA = 0;

        for(int i = 0; i < _NUMALUNOS; i++){
            float nota = MyIO.readFloat("Informe a nota do " + (i + 1) + " aluno: ");

            if(nota > _NOTABASE)
                notasA++;
        }

        MyIO.print("A media de notas acima de 80 eh: " + (notasA/_NUMALUNOS));
    }
}
