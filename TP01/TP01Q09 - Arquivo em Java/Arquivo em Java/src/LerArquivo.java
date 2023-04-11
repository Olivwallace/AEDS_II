/**
 * @file LerArquivo.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP01Q09 — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 24-02-2023
 */

import java.io.RandomAccessFile;

class LerArquivo {

    public static void main(String[] args) throws Exception {

        int n = MyIO.readInt();
        escreveArquivoTxt(n);
        leArquivoAoContrario(n);

    }

    /**
     * Metodo para ler valores float e armazena-los em arquivo txt.
     * @param numItens Numero de valores floats a serem lidos.
     * @throws Exception Erro ao manipular o arquivo.
     */
    public static void escreveArquivoTxt(int numItens) throws Exception{
        RandomAccessFile fileOut = new RandomAccessFile("pub.txt", "rw");
        double valor;
        boolean ehInteiro;

        for(int i = 0; i < numItens; i++){
            valor = MyIO.readDouble();
            fileOut.writeDouble(valor); //Ler valores de entrada e escreve em arquivo auxiliar.
        }

        fileOut.close();
    }

    /**
     * Metodo para realizar a leitura de um arquivo de doubles ao contrario.
     * @param numItens Numero de doubles presente no arquivo.
     * @throws Exception Erro ao manipular o arquivo.
     */
    public static void leArquivoAoContrario(int numItens) throws Exception{
        RandomAccessFile fileOut = new RandomAccessFile("pub.txt", "r");
        int sizeDouble = 8;
        double valor;

        fileOut.seek(((long)(numItens - 1) * sizeDouble)); //Posiciona ponteiro do arquivo no fim.

        for(int i = 0; i < numItens; i++){

            valor = fileOut.readDouble();

            if(ehInteiro(valor)) //Imprime o valor baseado em seu tipo, se double imprime sem converter, caso int realiza cast.
                MyIO.println((int)valor);
            else
                MyIO.println(valor);

            //Obtem nova posicao desconsiderando ultimo valor lido.
            long pos = fileOut.getFilePointer() - (2 * sizeDouble);

            if(pos >= 0) //Se posicao valida, posiciona ponteiro na posicao calculada.
                fileOut.seek(pos);
        }

        fileOut.close();
    }

    /**
     * verifica se um valor lido eh um inteiro.
     * @param valor Double lido
     * @return TRUE: Eh um inteiro | FALSE: Eh um double
     */
    public static boolean ehInteiro(double valor){
        int parteInteira = (int)valor;
        double decimal = valor - parteInteira;
        return (decimal == 0.0);
    }

}
