/**
 * @file Cifra.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP01Q03 — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 24-02-2023
 */

class Cifra {

    public static void main(String[] args){
        String str = MyIO.readLine();

        //Recebera entradas até que seja lido "FIM"
        while (!ehFIM(str)){
            MyIO.print(ciptrografa(str) + "\n"); //Imprime string cifrada
            str = MyIO.readLine();
        }

    }

    /**
     * Metodo para criptografar uma string em chave k = 3;
     * @param str String a ser criptografada;
     * @return String apos ciframento com chave k = 3;
     */
    public static String ciptrografa(String str){
        String strCriptografada = "";

        for(int i = 0; i < str.length(); i++){
            strCriptografada += (char)(str.charAt(i) + 3);
        }

        return strCriptografada;
    }

    /**
     * Metodo que verifica se eh fim de arquivo de entrada.
     * @param str Ultima String lida, a ser comparada se eh "FIM";
     * @return TRUE: String lida indica "FIM" | FALSE: String lida não eh "FIM"
     */
    public static boolean ehFIM(String str){
        boolean fim = false;

        //Verifica se tamanho da string eh compativel com "FIM" para validar.
        if(str.length() == 3)
            fim  = str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';

        return fim;
    }

}
