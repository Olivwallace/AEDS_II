/**
 * @file EX24.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 24 - Faça um programa que leia n números e mostre a soma do i-ésimo com o (2*i+1)-ésimo termo até que (2*i+1) < n

public class EX24 {
    public static void main(String[] args){
        int n = MyIO.readInt("Informe um valor: ");
        int soma = 1;

        for(int i = 0; (2 * i + 1) <= n; i++){
            soma += i + (2*i+1);
        }

        MyIO.print(soma);
    }
}
