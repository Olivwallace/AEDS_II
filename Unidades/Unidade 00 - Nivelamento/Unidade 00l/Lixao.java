/**
 * @file Lixao.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00l — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 13-02-2023
 */

public class Lixao {
    public static void main(String[] args){
        Retangulo a = new Retangulo(3,4);
        Retangulo b = new Retangulo(6);

        MyIO.print("\nAREA A: " + a.getArea() + "| AREA B: " + b.getArea());
        MyIO.print("\nPERIMETRO A: " + a.getPerimetro() + "| PERIMETRO B: " + b.getPerimetro());
        MyIO.print("\nDIAGONAL A: " + a.getDiagonal() + "| DIAGONAL B: " + b.getDiagonal());
    }
}
