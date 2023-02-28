import java.util.Objects;

/**
 * @file EX05.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00f — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 09-02-2023
 */

// EX05 - Leia o nome de dois arquivos, abra o primeiro, converta seu conteúdo para letra maiúscula e salve o no segundo;

public class EX05 {

    public static void main(String[] args){

        //Inicializa string auxiliar de copia entre arquivos.
        String conteudo = "";

        //Ler caminhos de arquivos de entrada e saída
        String fileIn = MyIO.readString("Informe o caminho do arquivo de entrada:\n\t");
        String fileOut = MyIO.readString("Informe o caminho de arquivo de destino:\n\t");

        boolean open = Arq.openRead(fileIn); //Abre arquivo de leitura.

        if(open) { //Se aberto ler, senão exibe erro.
            conteudo = Arq.readAll(); //Ler conteudo e armazena temporariamente.
            Arq.close(); // Fechar arquivo de leitura.

            open = Arq.openWrite(fileOut); //Abre arquivo de escrita.
        }else{
            MyIO.print("ERRO AO LER ARQUIVO!");
        }

        if(!Objects.equals(conteudo, "") && open){ //Se aberto e possui conteudo a copiar, escreve, senão exibe erro.
            Arq.print(conteudo.toUpperCase()); //Escreve em UpperCase no arquivo.
            Arq.close(); // Fechar arquivo de escrita
        }else {
            MyIO.print("ERRO AO ESCREVER ARQUIVO!");
        }

    }
}
