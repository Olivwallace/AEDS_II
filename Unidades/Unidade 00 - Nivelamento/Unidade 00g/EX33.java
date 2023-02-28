import java.util.ArrayList;

/**
 * @file EX33.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Unidade 00g — Arquivos em Java — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 11-02-2023
 */

// EX 33 -  Faça um programa para ler um vetor contendo N elementos e outro contendo M elementos.
//Em seguida, mostre os elementos de forma intercalada

public class EX33 {
    public static ArrayList<Float> lerArray(String nomeArray, int size){
        ArrayList<Float> a = new ArrayList<Float>(size);

        MyIO.print(nomeArray);
        for(int i = 0; i < size; i++)
            a.add(MyIO.readFloat("["+ i + "] = "));
        return a;
    };

    public static void main(String[] args){
        int n = MyIO.readInt("Tamanho Primeiro Array: ");
        int m = MyIO.readInt("Tamanho Segundo Array: ");
        int maior;

        ArrayList<Float> arrayA = lerArray("\nArray A:\n", n);
        ArrayList<Float> arrayB = lerArray("\nArray B:\n", m);

        if(n > m)
            maior = n;
        else
            maior = m;

        MyIO.print("Arrays intercalados:\n\t");
        for(int i = 0; i < maior; i++){
            if(i < arrayA.size())
                MyIO.print(arrayA.get(i) + " ");

            if(i < arrayB.size())
                MyIO.print(arrayB.get(i) + " ");
        }
    }
}
