/**
 * @file EX28.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 28 - Faça um programa para ler a nota de cinco alunos, calcular e mostrar: a soma e a média das mesmas e a menor nota

public class EX28 {
    public static int _NALUNOS = 5;

    public static float menorValor(float array[]){
        float menor = array[0];
        for(int i = 1; i < array.length; i++)
            if(menor > array[i])
                menor = array[i];
        return menor;
    }

    public static void main(String[] args){
        float[] notas = new float[_NALUNOS];
        float somaNotas = 0;

        for(int i = 0; i < notas.length; i++){
            notas[i] = MyIO.readFloat("Nota do " + (i+1) + " aluno:\n\t");
            somaNotas += notas[i];
        }

        MyIO.print("SOMA TOTAL: " + somaNotas);
        MyIO.print("MEDIA: " + (somaNotas/_NALUNOS));
        MyIO.print("MENOR NOTA: " + menorValor(notas));
    }

}
