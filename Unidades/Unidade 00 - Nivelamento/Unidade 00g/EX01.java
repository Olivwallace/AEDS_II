/**
 * @file EX01.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

/* EX 01 - Faça um programa que leia a nota de um aluno e escreva na tela: “Parabéns, muito bom” (se a nota >= 80);
“Parabéns, aprovado” (se a nota >= 70 && nota < 80); e, caso contrário, “Infelizmente, reprovado */

public class EX01 {
    public static void main(String[] args) {
        float nota = MyIO.readFloat("Informe a nota do aluno:\n\t");

        if (nota >= 80) {
            MyIO.print("Parabéns, muito bom!!");
        } else if (nota >= 70) {
            MyIO.print("Parabéns, aprovado!!");
        } else {
            MyIO.print("Infelizmente, reprovado!!");
        }
    }
}