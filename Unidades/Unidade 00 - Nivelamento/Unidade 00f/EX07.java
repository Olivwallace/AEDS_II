import java.util.Objects;

/**
 * @file EX07.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00f — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 09-02-2023
 */

/* EX07 - Leia o nome de um arquivo e mostre na tela o conteúdo desse arquivo criptografado usando o ciframento de César (k = 3) */

public class EX07 {

    /**
     * Função para criptografar em cifra de cesar uma string.
     * @param str String a ser criptografada.
     * @return Str criptografada, sem alterar str principal.
     */
    public static String cifraCesar(String str){
        String strUpper = str.toUpperCase();
        String strCriptografada = "";
        int i = 0, size = strUpper.length() - 1;

        while (i < size){

            if(strUpper.charAt(i) > 'W') {
                strCriptografada += (char)(strUpper.charAt(i) - 23);
            }else{
                strCriptografada += (char)(strUpper.charAt(i) + 3);
            }

            i++;
        }

        return  strCriptografada;
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
            Arq.print(cifraCesar(conteudo)); //Escreve no arquivo.
            Arq.close(); // Fechar arquivo de escrita
        }else {
            MyIO.print("ERRO AO ESCREVER ARQUIVO!");
        }

    }

}
