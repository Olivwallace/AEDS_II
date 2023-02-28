/**
 * @file EX03.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00f — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 09-02-2023
 */

// EX03 - Leia o nome de um arquivo e mostre seu conteúdo convertido para letras maiúsculas

public class EX03 {

    public static void main(String[] args){

        //Ler nome de arquivo a ser convertido para UpperCase
        String file = MyIO.readString("Digite o caminho do arquivo a ser impresso em UpperCase:\n\t");

        boolean open = Arq.openRead(file); //Abre arquivo para leitura e salva retorno.

        if(open) // Se aberto imprime em UpperCase, senão informa erro ao usuário.
            MyIO.print("CONTEUDO:\n\t" + Arq.readAll().toUpperCase());
        else
            MyIO.print("ERRO AO LER ARQUIVO!");

        Arq.close(); //Fechar arquivo.
    }

}
