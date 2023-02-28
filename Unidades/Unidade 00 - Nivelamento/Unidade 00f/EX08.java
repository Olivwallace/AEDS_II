import java.util.Objects;

/**
 * @file EX08.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00f — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 09-02-2023
 */

/* EX08 - Leia o nome de um arquivo contendo uma mensagem criptografada com o Ciframento de César (k = 3),
    descriptografe a mensagem e mostre-a na tela */

public class EX08 {

    /**
     * Função para descriptografar cifra de cesar.
     * @param str String a ser descriptografada.
     * @return Str descriptografada, sem alterar str principal.
     */
    public static String decifrarCesar(String str){
        String strUpper = str.toUpperCase();
        String strDescriptografada = "";
        int i = 0, size = strUpper.length() - 1;

        while (i < size){

            if(strUpper.charAt(i) < 'D') {
                strDescriptografada += (char)(strUpper.charAt(i) + 23);
            }else{
                strDescriptografada += (char)(strUpper.charAt(i) - 3);
            }

            i++;
        }

        return  strDescriptografada.replace(":", " ").replace("!", "\n");
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
            conteudo = decifrarCesar(conteudo);
            MyIO.print("CONTEUDO MENSAGEM:\n" + conteudo);

            Arq.print(conteudo); //Escreve no arquivo.
            Arq.close(); // Fechar arquivo de escrita
        }else {
            MyIO.print("ERRO AO ESCREVER ARQUIVO!");
        }

    }

}
