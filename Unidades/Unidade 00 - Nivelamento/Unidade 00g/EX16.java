/**
 * @file EX16.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

/* EX 16 - Faça um programa que leia um número inteiro N indicando a nota máxima em uma prova P.
Em seguida, leia a nota de 20 alunos (entre 0 e N) e mostre na tela:
    (i) a média da turma,
    (ii) o número de alunos cuja nota foi menor que a média da Universidade (suponha 60%) e
    (iii) a quantidade de alunos com conceito A (mais de 90%).
*/

public class EX16 {
    public static int _NUMALUNOS = 20;
    public static float _PMEDIA = ((float)60/100);
    public static float _PCONCEITO_A = ((float)90/100);

    public static void main(String[] args){
        int somaNotas = 0, nota, notasAbaixo = 0, notasA = 0;
        int notaMax = MyIO.readInt("Nota maxima na prova:\n\t");

        for(int i = 0; i < _NUMALUNOS; i++){
            nota = MyIO.readInt("Nota " + (i + 1) + " aluno:\t");

            somaNotas += nota;

            if(nota < (_PMEDIA * notaMax)){
                notasAbaixo++;
            } else if (nota > (_PCONCEITO_A * notaMax)) {
               notasA++;
            }
        }

        MyIO.print("Media da turma: " + (somaNotas/_NUMALUNOS));
        MyIO.print("Alunos abaixo da Media: " + notasAbaixo);
        MyIO.print("Alunos conceito A: " + notasA);
    }
}
