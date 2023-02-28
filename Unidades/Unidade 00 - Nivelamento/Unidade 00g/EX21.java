/**
 * @file EX21.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 21 - Faça um programa que leia a nota e o nome de 5 alunos e mostre na tela o nome daqueles que ficaram acima da média do grupo

public class EX21 {
    public static int _NALUNOS = 5;

    public static void main(String[] args){
        Aluno[] turma = new Aluno[_NALUNOS];
        float somaNotas = 0, mediaTurma;

        for(int i = 0; i < _NALUNOS; i++){
            turma[i] = new Aluno(MyIO.readString("Nome do " + (i + 1) + " aluno: "), MyIO.readFloat("Nota do " + (i + 1) + " aluno: "));
            somaNotas += turma[i].getNota();
        }
        mediaTurma = somaNotas/_NALUNOS;

        for(int i = 0; i < _NALUNOS; i++){
            if(turma[i].getNota() > mediaTurma)
                MyIO.print("\n" + turma[i].getNome());
        }

    }
}

class Aluno {
    float nota;
    String nome;

    Aluno(String nome, float nota){
        this.setNome(nome);
        this.setNota(nota);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setNota(float nota){
        this.nota = nota;
    }

    public String getNome(){
        return this.nome;
    }

    public float getNota(){
        return this.nota;
    }
}