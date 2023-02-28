/**
 * @file main.c
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Lista Unidade 00b - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 09-02-2023
 */

 //---------- Inclusoes
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Uteis.h"
#include "Nivelamento_00b.h"

//---------- Constantes
#define MAX_VET 10

//---------- Inicio
int main(int argc, char** argv) {
	clock_t start, end;
	int vetor0[MAX_VET] = { -5, -2, 0, 1, -3, 4, 7, -1, -4, 3 };
	
	printf("SEM BUSCA BINARIA ----");
	for (int i = -10; i < MAX_VET; i++) {
		
		start = clock();
		boolean resultado = estaContido(vetor0, i, MAX_VET);
		end = clock();

		printf("\nValor %d: %s - Tempo %lf seg", i, ((resultado) ? "ESTA CONTIDO\0" : "NAO ESTA CONTIDO\0"), ((double)(end - start)) / CLOCKS_PER_SEC);
	}

	printf("\nCOM BUSCA BINARIA ----");
	for (int i = -10; i < MAX_VET; i++) {

		start = clock();
		boolean resultado = estaContidoBinaryShared(vetor0, i, MAX_VET);
		end = clock();

		printf("\nValor %d: %s - Tempo %lf seg", i, ((resultado)?"ESTA CONTIDO\0" : "NAO ESTA CONTIDO\0"), ((double)(end - start)) / CLOCKS_PER_SEC);
	}

	imprimeMaxMin(vetor0, MAX_VET);

	return SUCESSO;
}