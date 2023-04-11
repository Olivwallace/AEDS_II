/**
 * @file CiframentoRecursivo.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP01Q13 — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 24-02-2023
 */

class CiframentoRecursivo {

    public static void main(String[] args){
        String str = MyIO.readLine();

        //Recebera entradas até que seja lido "FIM"
        while (!ehFIM(str)){
            MyIO.print(criptografa(str)+ "\n"); //Imprime string cifrada
            str = MyIO.readLine();
        }

    }

    /**
     * Metodo sobrecarregado para criptografar uma string.
     * @param str String a ser criptografada.
     * @return String criptografada.
     */
    public static String criptografa(String str){
        return criptografa(str, 0);
    }

    /**
     * Metodo para criptografar um string em cifra de cesar recursivo.
     * @param str String a ser criptografada.
     * @param pos Posicao do primeiro termo da string.
     * @return String criptografada.
     */
    public static String criptografa(String str, int pos){
        String strCriptografada = "";

        if(pos < str.length()){
            strCriptografada += (char)(str.charAt(pos) + 3);
            strCriptografada += criptografa(str, ++pos);
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
