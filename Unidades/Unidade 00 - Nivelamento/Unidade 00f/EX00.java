/**
 * @file EX00.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00f — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 09-02-2023
 */

public class EX00 {

    public static void main(String[] args){

        String fileOpen = MyIO.readLine("Digite o caminho do arquivo a ser copiado:\n\t"); //Recebe caminho de arquivo.
        Arq.openRead(fileOpen); //Abre arquivo para leitura
        String conteudoArquivo = Arq.readAll(); //Ler todos os dados do arquivo.
        Arq.close(); //Fechar arquivo de leitura.


        fileOpen = MyIO.readLine("Digite um nome para copia do arquivo:\n\t"); //Recebe nome de aquivo copia, sobrescrevendo anterior.
        Arq.openWrite(fileOpen); //Abre arquivo de escrita
        Arq.print(conteudoArquivo); //Escreve no arquivo
        Arq.close(); //Fechar arquivo de escrita

    }
}
