/**
 * @file PalindromoRecursivo.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP01Q11 — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 24-02-2023
 */

class PalindromoRecursivo {

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

    /**
     * Metodo sobrecarregado para verificar se uma string eh um palindromo.
     * @param str String a ser verificada.
     * @return TRUE: Eh palindromo. | FALSE: Nao eh palindromo.
     */
    public static boolean ehPalindromo(String str){
        return ehPalindromo(str, 0, (str.length() - 1));
    }

    /**
     * Metodo para verificar se uma string eh um palindromo.
     * @param str String a ser verificada.
     * @param begin Menor indice da string.
     * @param end Maior indice da string.
     * @return TRUE: Eh palindromo. | FALSE: Nao eh palindromo.
     */
    private static boolean ehPalindromo(String str, int begin, int end){
        boolean palindromo = true; //Caso Base

        if(begin < end){    //Passo Recursivo
            boolean saoIguais = str.charAt(begin) == str.charAt(end);
            palindromo = saoIguais && ehPalindromo(str, begin + 1, end - 1);
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

}
