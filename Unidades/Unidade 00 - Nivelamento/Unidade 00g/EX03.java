/**
 * @file EX03.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 03 - Leia 3 números inteiros, selecione o menor e o maior e imprima os seus respectivos valores na tela.

public class EX03 {
    public static void main(String[] args){
        int num1, num2, num3;

        num1 = MyIO.readInt("Informe o primeiro valor:\n\t");
        num2 = MyIO.readInt("Informe o segundo valor:\n\t");
        num3 = MyIO.readInt("Informe o terceiro valor:\n\t");

        if(num1 > num2 && num1 > num3){
            if(num2 > num3){
                MyIO.print("Maior: " + num1 + " Menor: " + num3);
            }else{
                MyIO.print("Maior: " + num1 + " Menor: " + num2);
            }
        }else if(num2 > num3){
            if(num3 > num1){
                MyIO.print("Maior: " + num2 + " Menor: " + num1);
            }else{
                MyIO.print("Maior: " + num2 + " Menor: " + num3);
            }
        }else{
            if(num2 > num1){
                MyIO.print("Maior: " + num3 + " Menor: " + num1);
            }else{
                MyIO.print("Maior: " + num3 + " Menor: " + num2);
            }
        }
    }
}
