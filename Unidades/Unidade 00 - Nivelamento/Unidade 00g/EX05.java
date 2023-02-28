/**
 * @file EX05.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

/* EX 05 - Leia dois números. Se um deles for maior que 45, realize a soma dos mesmos.
Caso contrário, se os dois forem maior que 20, realize a subtração  do maior pelo menor, senão,
se um deles for menor do que 10 e o outro  diferente de 0 realize a divisão do primeiro pelo segundo.
Finalmente, se nenhum dos casos solicitados for válido, mostre seu nome na tela. */

public class EX05 {
    public static void main(String[] args){
        float num1, num2;

        num1 = MyIO.readFloat("Informe o primeiro valor: ");
        num2 = MyIO.readFloat("Informe o segundo valor: ");

        if(num1 > 45 || num2 > 45){
            MyIO.print(num1 + " + " + num2 + " = " + (num1 + num2));
        } else if (num1 > 20 && num2 > 20) {
            MyIO.print(num1 + " - " + num2 + " = " + (num1 - num2));
        } else if ((num1 < 10 && num2 != 0) || (num2 < 10 && num1 != 0)) {
            MyIO.print(num1 + " / " + num2 + " = " + (num1 / num2));
        }else{
            MyIO.print("Wallace");
        }
    }
}
