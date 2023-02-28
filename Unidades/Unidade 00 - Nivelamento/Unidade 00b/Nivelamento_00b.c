/**
 * @file Nivelamento_00b.c
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Lista Unidade 00b - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 09-02-2023
 */

//---------- Inclusoes
#include <stdio.h>
#include <stdlib.h>
#include "Uteis.h"

//---------- Funcoes

boolean estaContido(int* array, int buscar, int tamArray) {
	boolean contido = FALSE;
	uint32_t i = 0;

	while (!contido && tamArray > i) {
		if (array[i] == buscar) {
			contido = TRUE;
		}

		i++;
	}

	return contido;
}

boolean estaContidoBinaryShared(int* array, int buscar, int tamArray) { 
	return (binaryShared(array, buscar, tamArray) >= 0)? TRUE: FALSE;
}

void imprimeMaxMin(int* array, int tamArray) {
	int min = 0, max = 0;

	for (int i = 1; i < tamArray; i++) {
		if (array[i] > array[max]) {
			max = i;
		}
		else if (array[i] < array[min]) {
			min = i;
		}
	}

	printf("\nMaior: %d, Menor: %d", array[max], array[min]);
}





