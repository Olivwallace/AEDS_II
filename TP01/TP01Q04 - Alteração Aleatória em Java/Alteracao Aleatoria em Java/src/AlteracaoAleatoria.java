/**
 * @file AlteracaoAleatoria.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP01Q04 — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 24-02-2023
 */

import java.util.Random;

public class AlteracaoAleatoria {

    public static Random gerador = new Random(); //Atribulto estatico para gerar valores pseudoaleatorios.

    public static void main(String[] args){
        gerador.setSeed(4); //Inicializacao do gerador com valor semente geradora igual a 4.

        String str = MyIO.readLine();

        while (!ehFIM(str)){ //Imprime string com troca de letras ate que atinja "FIM".
            MyIO.print(AlteraAleatoriamente(str) + "\n");
            str = MyIO.readLine();
        }

    }

    /**
     * Metodo para alterar caracteres aleatorios de um string.
     * @param str String a ter caracteres alterados.
     * @return String com alteracao aleatoria de caracteres.
     */
    public static String AlteraAleatoriamente(String str){
        char letraSubstitui = gerarLetra(); //Letra a ser substituida
        char letraSubstituta = gerarLetra();
        String strAlterada = "";

        for(int i = 0; i < str.length(); i++){

            if(letraSubstitui == str.charAt(i)) {
                strAlterada += letraSubstituta;
            }else {
                strAlterada += str.charAt(i);
            }

        }

        return strAlterada;
    }

    /**
     * Gerador de letras peseudoaleatorio
     * @return Letra gerada.
     */
    public static char gerarLetra(){
        return (char)('a' + (Math.abs(gerador.nextInt()) % 26));
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
