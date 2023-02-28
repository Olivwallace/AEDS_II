import java.util.Objects;

/**
 * @file EX06.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00f — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 09-02-2023
 */

/* EX06 - Leia o nome de dois arquivos e copie o conteúdo do primeiro para o segundo invertendo a ordem dos caracteres.
 O último caractere no arquivo de entrada será o primeiro do de saída, o penúltimo caractere será o segundo; */

public class EX06 {

    /**
     * Função para inverter uma string.
     * @param str String a ser invertida.
     * @return Str em ordem inversa a de entrada, sem alterar str principal.
     */
    public static String inverteString(String str){

        String inversa = "";
        int i = str.length() - 1;

        while (i > 0){
            inversa += str.charAt(i - 1);
            i--;
        }

        return  inversa;
    }

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
            Arq.print(inverteString(conteudo)); //Escreve no arquivo.
            Arq.close(); // Fechar arquivo de escrita
        }else {
            MyIO.print("ERRO AO ESCREVER ARQUIVO!");
        }

    }

}
