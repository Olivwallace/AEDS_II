/**
 * @file Retangulo.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00l — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 13-02-2023
 */

/* Faça uma classe retângulo contendo os atributos base e altura, pelo menos dois métodos construtores,
o método double getArea() que retorna a área do retângulo, o método double getPerimetro() que retorna o
perímetro do retângulo e o método double getDiagonal() que retorna a diagonal do retângulo */

public class Retangulo {
    private double largura, comprimento;

    Retangulo(double largura){
        this.setLargura(largura);
        this.setComprimento(largura);
    }

    Retangulo(double largura, double comprimento){
        this.setLargura(largura);
        this.setComprimento(comprimento);
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getArea() {
        return (this.getLargura() * this.getComprimento());
    }

    public double getPerimetro() {
        return ((2 * this.getLargura()) + (2 * this.getComprimento()));
    }

    public double getDiagonal(){
        return Math.sqrt((Math.pow(this.getLargura(),2) + Math.pow(this.getLargura(),2)));
    }

}
