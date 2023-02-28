/**
 * @file Unidade_00m.h
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Lista Unidade 00m - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 17-02-2023
 */

 //---------- Inclusoes
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Uteis.h"
#include "Unidade_00m.h"

//---------- Funcoes

void armazenaValoresEmArq(int n, string nomeArq_ext) {
	FILE* arq = fopen(nomeArq_ext, "wb");
	int valor;
	
	if (arq != NULL) {

		for (int i = 0; i < n; i++) {
			scanf("%d", &valor);
			fwrite(&valor, sizeof(int), 1, arq);
		}
		
		fclose(arq);
	}
	else {
		fprintf(stderr, "ERRO AO ABRIR ARQUIVO");
	}

}

void lerValoresDeArq(string nomeArq_ext) {
	FILE* arq = fopen(nomeArq_ext, "rb");
	int valor;

	if (arq != NULL) {
		printf("\n|");

		while (fread(&valor, sizeof(int), 1, arq)) {
			printf(" %d |", valor);
		}
	
		fclose(arq);
	}
	else {
		fprintf(stderr, "ERRO AO ABRIR ARQUIVO");
	}

}

void lerValoresInvertidos(string nomeArq_ext) {
	FILE* arq = fopen(nomeArq_ext, "rb");
	int valor;
	int c = -1;

	if (arq != NULL) {
		
		printf("\n|");
		while (fseek(arq, c * sizeof(int), SEEK_END) == 0 && fread(&valor, sizeof(int), 1, arq)) {
			printf(" %d |", valor);
			c--;
		}

		fclose(arq);
	}
	else {
		fprintf(stderr, "ERRO AO ABRIR ARQUIVO");
	}

}

void somaValoresArq(int numItens, string nomeArq_ext) {
	FILE* arq = fopen(nomeArq_ext, "rb");
	int valorA = 0, valorB = 0;
	int metade = numItens/2;
	int soma = 0;
	
	if (arq != NULL) {
	
		for (int i = 1; i <= metade; i++) {
			if (fseek(arq, -i * sizeof(int), SEEK_END) == 0) {
				fread(&valorA, sizeof(int), 1, arq);
			}
			if (fseek(arq, (i - 1) * sizeof(int), SEEK_SET) == 0) {
				fread(&valorB, sizeof(int), 1, arq);
			}
			soma += (valorA + valorB);
		}

		if (numItens % 2 != 0) {
			if (fseek(arq, metade * sizeof(int), SEEK_SET) == 0) {
				fread(&valorA, sizeof(int), 1, arq);
				soma += valorA;
			}
		}

		fclose(arq);
		printf("\nSOMA = %d", soma);
	}
}