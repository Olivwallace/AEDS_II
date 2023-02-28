/**
 * @file EX42.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

//EX 42 - Faça um programa para ler uma palavra. Em seguida, mostre o número de caracteres da mesma e seu número de caracteres maiúsculos

public class EX42 {
    public static void main(String [] args){
        int c = 0;
        String palava = MyIO.readString("Digite uma palavra: ");
        MyIO.print("NUM CARACTERES: " + palava.length());

        for(int i = 0; i < palava.length(); i++){
            if(Character.isUpperCase(palava.charAt(i))){
                c++;
            }
        }

        MyIO.print("\nNUM DIGITOS MAIUSCULOS: " + c);
    }
}
