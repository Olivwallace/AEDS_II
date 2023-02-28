/**
 * @file Ponto.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00l — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 13-02-2023
 */

public class Ponto {
    private double x, y;
    private int id = 0;
    private static int nextID = 0;

    Ponto(){
        this.setX(0);
        this.setY(0);
        this.setId(getNextID());
        this.setNextID(this.getID() + 1);
    }

    Ponto(double x, double y){
        this.setX(x);
        this.setY(y);
        this.setId(getNextID());
        this.setNextID(this.getID() + 1);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNextID(int nextID) {
        this.nextID = nextID;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getID() {
        return id;
    }

    public static int getNextID() {
        return nextID;
    }

    public double dist(Ponto ponto){
        double DistX = this.getX() - ponto.getX();
        double DistY = this.getY() - ponto.getY();

        if(DistX < 0) DistX *= (-1);
        if(DistY < 0) DistY *= (-1);

        return Math.sqrt((Math.pow(DistX, 2) + Math.pow(DistY, 2)));
    }

    public double dist(double x, double y){
        double DistX = this.getX() - x;
        double DistY = this.getY() - y;

        if(DistX < 0) DistX *= (-1);
        if(DistY < 0) DistY *= (-1);

        return Math.sqrt((Math.pow(DistX, 2) + Math.pow(DistY, 2)));
    }

    public static double dist(double x1, double y1, double x2, double y2){
        double DistX = x1 - x2;
        double DistY = y1 - y2;

        if(DistX < 0) DistX *= (-1);
        if(DistY < 0) DistY *= (-1);

        return Math.sqrt((Math.pow(DistX, 2) + Math.pow(DistY, 2)));
    }

    public static boolean isTriangulo(Ponto x, Ponto y, Ponto z){
        boolean ehTriangulo = (y.dist(z) + z.dist(x) > x.dist(y) &&
                                x.dist(y) + z.dist(x) > y.dist(z) &&
                                    x.dist(y) + y.dist(z) > z.dist(x));

        return ehTriangulo;
    }

    public double getAreaRetangulo(Ponto ponto){
        double DistX = this.getX() - ponto.getX();
        double DistY = this.getY() - ponto.getY();

        if(DistX < 0) DistX *= (-1);
        if(DistY < 0) DistY *= (-1);

        return DistX * DistY;
    }

}
