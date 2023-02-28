/**
 * @file EX01.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00f — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 09-02-2023
 */

//EX01 - Leia o nome de um arquivo e uma frase e salve essa frase nesse arquivo

public class EX01 {

    public static void main(String[] args){

        //Ler frase e em seguida nome do arquivo.
        String frase = MyIO.readLine("Digite uma frase que deseja salvar:\n\t");
        String nomeArquivo = MyIO.readString("Digite o nome do arquivo onde deseja salva:\n\t");

        boolean aberto = Arq.openWrite(nomeArquivo); //Abre o arquivo e salva retorno.

        if(aberto)  //Se aberto salva dado, senão retorna erro ao usuário.
            Arq.print(frase);
        else
            MyIO.print("ERRO AO SALVA ARQUIVO!");

        Arq.close(); //Fecha arquivo de escrita.
    }
}
