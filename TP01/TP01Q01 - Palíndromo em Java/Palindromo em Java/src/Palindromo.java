/**
 * @file Palindromo.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP01Q01 — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 24-02-2023
 */

class Palindromo {

    /**
     * Verifica se string recebida eh um palindromo.
     * @param str String a ser verificada;
     * @return TRUE: String é palindromo. | FALSE: String nao eh palindromo.
     */
    public static boolean ehPalindromo(String str){
        boolean palindromo = true;

        int lastChar = str.length() - 1; //Posicao da ultima letra da string.
        int i = 0;

        while (i < lastChar && palindromo){
            if(str.charAt(i) != str.charAt(lastChar)){
                palindromo = false;
            }

            i++;
            lastChar--;
        }

        return palindromo;
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

    public static void main(String[] args){
        String str = MyIO.readLine();

        while (!ehFIM(str)){

            if(ehPalindromo(str)){
                MyIO.print("SIM\n");
            }else {
                MyIO.print("NAO\n");
            }

            str = MyIO.readLine();
        }

    }
}
