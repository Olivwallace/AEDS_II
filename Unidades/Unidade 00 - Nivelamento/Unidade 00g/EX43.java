/**
 * @file EX43.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

//EX 43 - Faça um programa para ler uma palavra. Em seguida, mostre a primeira ocorrência da letra A

public class EX43 {
    public static void main(String [] args){
        int index = 0;
        String palava = MyIO.readString("Digite uma palavra: ");

        while (Character.toUpperCase(palava.charAt(index)) != 'A' && index < palava.length()){
            index++;
        }

        if(index >= 0 && index < palava.length() )
            MyIO.print("A primeira ocorrencia da letra A eh na posicao: " + (index + 1));
        else
            MyIO.print("Nao existe caracter 'A'");
    }
}
