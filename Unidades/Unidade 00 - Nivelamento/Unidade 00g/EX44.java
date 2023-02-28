/**
 * @file EX44.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

//EX 44 - Faça um programa para ler uma palavra. Em seguida, mostre os números de caracteres, letras, não letras, vogais e consoantes.

public class EX44 {
    public static String _ISVOGAL = "aeiou";
    public static String _ISCOSOANTE = "bcdfghjklmpqrstvwxy";

    public static void main(String [] args){
        int numLetras = 0, numConsoantes = 0, numVogais = 0;
        String palava = MyIO.readString("Digite uma palavra: ");

        for(int i = 0; i < palava.length(); i++){
            char caracter = Character.toUpperCase(palava.charAt(i));
            if(Character.isLetter(caracter)){
                numLetras++;

                if(_ISCOSOANTE.toUpperCase().indexOf(caracter) != -1)
                    numConsoantes++;
                else if (_ISVOGAL.toUpperCase().indexOf(caracter) != -1)
                    numVogais++;
            }
        }

        MyIO.print("NUM CHAR: " + palava.length());
        MyIO.print("NUM LETRAS: " + numLetras);
        MyIO.print("NUM N LETRAS: " + (palava.length() - numLetras));
        MyIO.print("NUM VOGAIS: " + numVogais);
        MyIO.print("NUM COSOANTES: "+ numConsoantes);
    }
}