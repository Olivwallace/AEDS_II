/**
 * @file Uteis.c
 * @author Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Codigos geralmente ultilizados.
 * @date 11-12-2022
 */

//---------- Inclusoes
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

//---------- Constantes

//---------- Tipos

//---------- Funcoes
int binaryShared(int* array, int buscar, int tamArray) {
	return buscaBinaria(array, buscar, 0, (tamArray - 1));
}

int buscaBinaria(int* array, int buscar, int left, int right) {
	int pos = -1;
	int meio = (right + left) / 2;

	if (left < right) {
		if (array[meio] == buscar)
			pos = meio;
		else if (array[meio] < buscar)
			pos = buscaBinaria(array, buscar, left, meio - 1);
		else
			pos = buscaBinaria(array, buscar, meio + 1, right);
	}

	return pos;
}

