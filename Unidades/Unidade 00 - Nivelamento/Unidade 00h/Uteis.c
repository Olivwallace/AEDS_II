/**
 * @file Uteis.h
 * @author Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Codigos geralmente ultilizados.
 * @date 11-12-2022
 */

 //---------- Inclusoes
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <time.h>
#include <math.h>
#include "Uteis.h"

//---------- Funcoes

int* gerarArrayAleatorio(int n) {
	int* array = (int*)malloc(n * sizeof(int));
	if (array == NULL) {
		printf("Erro na alocação de memória.\n");
		exit(1);
	}
	srand(time(NULL));

	for (int i = 0; i < n; i++) {
		array[i] = rand();
	}

	return array;
}

void imprimeArray(int* array, int tam) {
	printf("\n| ");
	for (int i = 0; i < tam; i++)
		printf("%d | ", array[i]);
	printf("\n\n");
}