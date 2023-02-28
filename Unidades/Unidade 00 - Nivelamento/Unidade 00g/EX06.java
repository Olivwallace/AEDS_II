/**
 * @file EX06.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 06 - Seja uma partida de futebol, leia os números de gols do mandante e do visitante e imprima
// quem foi o vencedor ou se foi empate.

public class EX06 {
    public static void main(String[] args){
        int equipeMandante, equipeVisitante;

        equipeMandante = MyIO.readInt("Informe o saldo de gols do mandante: \n\t");
        equipeVisitante = MyIO.readInt("Informe o saldo de gols do visitante: \n\t");

        if(equipeMandante > equipeVisitante){
            MyIO.print("Equipe vencedora foi a Mandante");
        } else if (equipeVisitante > equipeMandante) {
            MyIO.print("Equipe vencedora foi a Visitante");
        }else{
            MyIO.print("O jogo terminou em empate");
        }
    }
}
