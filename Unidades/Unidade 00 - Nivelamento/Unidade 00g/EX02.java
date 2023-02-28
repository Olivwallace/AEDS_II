/**
 * @file EX02.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

/* EX 02 - Faça um programa que leia três números reais representando os lados de um triângulo e informe se seu triângulo é
Equilátero, Isósceles ou Escaleno */

public class EX02 {
    public static void main(String[] args){
       float aresta_a, aresta_b, aresta_c;
       boolean equalAB, equalBC, equalAC, ehTriangulo;

       aresta_a = MyIO.readFloat("Informe o comprimento da aresta A:\n\t");
       aresta_b = MyIO.readFloat("Informe o comprimento da aresta B:\n\t");
       aresta_c = MyIO.readFloat("Informe o comprimento da aresta C:\n\t");

       ehTriangulo = (aresta_a + aresta_b > aresta_c) && (aresta_a + aresta_c > aresta_b) && (aresta_b + aresta_c > aresta_a);

       if(ehTriangulo){

          equalAC = aresta_a == aresta_c;
          equalBC = aresta_b == aresta_c;
          equalAB = aresta_a == aresta_b;

          if(equalAB && equalBC){
             MyIO.print("Equilatero!");
          } else if (equalAB || equalBC || equalAC) {
             MyIO.print("Isoceles!!");
          }else{
             MyIO.print("Escaleno");
          }

       }else{
          MyIO.print("Valores informados nao formam triangulo!");
       }


    }
}
