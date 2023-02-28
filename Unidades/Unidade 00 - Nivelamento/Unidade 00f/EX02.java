/**
 * @file EX02.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00f — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 09-02-2023
 */

// EX02 - Leia o nome de um arquivo e mostre o seu conteúdo na tela.

public class EX02 {

    public static void main(String[] args){

        //Ler nome do arquivo a ser impresso na tela.
        String file = MyIO.readString("Digite o caminho do arquivo a ser impresso:\n\t");

        boolean aberto = Arq.openRead(file); //Abre arquivo para leitura.

        if(aberto) //Se aberto imprime conteúdo, senão erro.
            MyIO.print("CONTEUDO:\n\t" + Arq.readAll());
        else
            MyIO.print("ERRO AO ABRIR ARQUIVO!");

        Arq.close(); //Fecha arquivo aberto para leitura.
    }

}
