/**
 * @file EX08.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 08 - Leia dois números reais e imprima a raiz cúbica do menor e o logaritmo do menor considerando o maior como a base desse logaritmo.

public class EX08 {

    /**
     * Função para calcular o logaritmo de Y na base X - Propiedade de conversão de bases logxY = log(Y)/log(X)
     * @param base_x Valor da base;
     * @param logaritmano_y Valor do logaritmano;
     * @return Resultado de logxY;
     */
    public static double logx_Y(float base_x, float logaritmano_y){
        return Math.log(logaritmano_y)/Math.log(base_x);
    }

    public static void main(String[] args){
        float num1, num2;

        num1 = MyIO.readFloat("Informe o primeiro valor:\n\t");
        num2 = MyIO.readFloat("Informe o segundo valor:\n\t");

        if(num1 > num2){
            MyIO.print("Raiz cubica de " + num2 + ": " + Math.cbrt(num2) + " | Log_" + num1 + "( " + num2 + " ): " + logx_Y(num1,num2));
        }else{
            MyIO.print("Raiz cubica de " + num1 + ": " + Math.cbrt(num1) + " | Log_" + num2 + "( " + num1 + " ): " + logx_Y(num2,num1));
        }
    }
}
