import java.util.ArrayList;

/**
 * @file EX32.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 32 - Faça um programa para ler dois vetores contendo N elementos cada. Em
//seguida, mostre os elementos de forma intercalada

public class EX32 {
    public static int _SIZE_ARRAY = 5;

    public static ArrayList<Float> lerArray(String nomeArray, int size){
        ArrayList<Float> a = new ArrayList<Float>(size);

        MyIO.print(nomeArray);
        for(int i = 0; i < size; i++)
            a.add(MyIO.readFloat("["+ i + "] = "));
        return a;
    };

    public static void main(String[] args){
        ArrayList<Float> arrayA = lerArray("\nArray A:\n", _SIZE_ARRAY);
        ArrayList<Float> arrayB = lerArray("\nArray B:\n", _SIZE_ARRAY);

        MyIO.print("Arrays intercalados:\n\t");
        for(int i = 0; i < _SIZE_ARRAY; i++){
            MyIO.print(arrayA.get(i) + " " + arrayB.get(i) + " ");
        }
    }
}
