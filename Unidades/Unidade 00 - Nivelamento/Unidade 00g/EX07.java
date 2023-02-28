/**
 * @file EX07.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

/* EX 07 - O banco do Zé abriu uma linha de crédito para os seus clientes. O valor  máximo da prestação não poderá
ultrapassar 40% do salário bruto. Fazer um algoritmo que permita entrar com o salário bruto e o valor da prestação
e informar se o empréstimo será concedido. */

public class EX07 {
    public static float _PCENTO_MAX = ((float) 40)/ 100; // 40%

    public static void main(String [] args){
        float salarioBruto = MyIO.readFloat("Informe o salario bruto:\n\t");
        float valorPrestacao = MyIO.readFloat("Informe o valor da prestacao:\n\t");

        if(valorPrestacao <= (_PCENTO_MAX * salarioBruto)){
            MyIO.print("Emprestimo Concedido!");
        }else {
            MyIO.print("Emprestimo Negado!");
        }
    }
}
