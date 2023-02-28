/**
 * @file Unidade_00h.c
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Lista Unidade 00h - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 17-02-2023
 */

 //---------- Inclusoes
#include <stdio.h>
#include <stdlib.h>
#include "Uteis.h"
#include "Unidade_00h.h"

//---------- Funcoes

boolean isVogal(char letra) {
	boolean ehVogal = FALSE;
	char Vogais[] = { 'A','E','I','O','U','\0' };

	for (int i = 0; i < strlen(Vogais) && !ehVogal; i++) {
		ehVogal = towupper(letra) == Vogais[i];
	}

	return ehVogal;
}

int contaVogais(string palavra) {
	return contaVogaisRecursivo(palavra, 0);
}

int contaVogaisRecursivo(string palavra, int pos) {
	int cont = 0;

	if (pos < strlen(palavra)) {
		if (isVogal(palavra[pos])) {
			cont = 1;
		}

		cont += contaVogaisRecursivo(palavra, ++pos);
	}

	return cont;

}

boolean isConsoanteMaiuscula(char letra) {
	return (letra >= 'A' && letra <= 'Z') ? TRUE : FALSE;
}

int contaCaracteres(string palavra) {
	int tam = strlen(palavra);
	return (tam - NOTvogalAND_NOTconsoante(palavra, 0));
}

int NOTvogalAND_NOTconsoante(string palavra, int pos) {
	int cont = 0;

	if (pos < strlen(palavra)) {
		if (isVogal(palavra[pos]) || isConsoanteMaiuscula(palavra[pos])) {
			cont = 1;
		}

		cont += NOTvogalAND_NOTconsoante(palavra, ++pos);
	}

	return cont;
}

int MultRecursiva(int a, int b) {
	int retorno = 0;

	if (a == 1)
		retorno = b;
	else
		retorno = b + MultRecursiva(a - 1, b);

	return retorno;
}

int buscaMaior(int* array, int tamArray) {
	int posValidas = tamArray - 1;
	return buscarMaiorRecursivo(array, posValidas, posValidas);
}

int buscarMaiorRecursivo(int* array, int tamArray, int posMaior) {
	int posEncontrada = posMaior;

	if (tamArray >= 0) {
		if (array[(tamArray - 1)] > array[posMaior]) {
			posEncontrada = (tamArray - 1);
		}

		posEncontrada = buscarMaiorRecursivo(array, tamArray - 1, posEncontrada);
	}

	return posEncontrada;
}

boolean ehPalindromo(string palavra) {
	return palindromoRecursivo(palavra, 0, (strlen(palavra) - 1));
}

boolean palindromoRecursivo(string palavra, uint32_t posInicio, uint32_t posFim) {
	boolean ehPalindromo = TRUE;
	if (posInicio < posFim)
		ehPalindromo = palavra[posInicio] == palavra[posFim] && palindromoRecursivo(palavra, posInicio + 1, posFim - 1);
	return ehPalindromo;
}

void ordenarArray(int* array, int numElementosArray) {
	mergeSort(array, 0, (numElementosArray - 1));
}

void mergeSort(int* array, int left, int right) {
	int meio;

	if (right > left) {
		meio = (left + right) / 2;

		mergeSort(array, left, meio);
		mergeSort(array, meio + 1, right);

		merge(array, left, right, meio);
	}

}

void merge(int* array, int left, int right, int meio) {
	int numItens = (right - left) + 1;
	int* subArr = (int*)malloc(numItens * sizeof(int));
	int i = left, j = meio + 1, k = 0;

	if (subArr != NULL) {

		while (i <= meio && j <= right) {
			if (array[i] < array[j]) {
				subArr[k] = array[i];
				i++; k++;
			}
			else {
				subArr[k] = array[j];
				j++; k++;
			}
		}

		while (i <= meio) {
			subArr[k] = array[i];
			i++; k++;
		}
		while (j <= right) {
			subArr[k] = array[j];
			j++; k++;
		}

		for (int m = 0; m < k; m++) {
			int pos = left + m;
			array[pos] = subArr[m];
		}

		free(subArr);
	}
}

int T_recursivo(int n) {
	int t = 1;

	if (n == 2)
		t++;
	else if (n > 2)
		t = T_recursivo(n - 1) * T_recursivo(n - 2) - T_recursivo(n - 1);

	return t;
}

int T_recursivo2(int n) {
	int t = 0;

	if (n == 0) {
		t = 1;
	}
	else if (n > 0) {
		t = pow(T_recursivo2(n - 1), 2);
	}

	return t;
}

void hanoi(int numDisc, char init, char aux, char fim) {
	
	if (numDisc == 1) {
		printf("\nDISCO %d DE ( %c ) >> PARA ( %c )", numDisc, init, fim);
	}else {
		hanoi(numDisc - 1, init, aux, fim);
		printf("\nDISCO %d DE ( %c ) >> PARA ( %c )", numDisc, init, fim);
		hanoi(numDisc - 1, aux, fim, init);
	}

}