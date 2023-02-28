//---------- Inclusoes
#include <stdio.h>
#include <stdlib.h>
#include "Uteis.h"
#include "Unidade_00h.h"

int main(int argc, char** argv) {

	printf("\n\nEX00 - MULTIPLICACAO RECURSIVA POR SOMA ENTRE 5 x 10 >> %d", MultRecursiva(5, 10));

	int* vetor0 = gerarArrayAleatorio(MAX_TAM_ARRAY);
	printf("\n\nEX01 - BUSCAR MAIOR ELEMENTO NO ARRAY DE %d ITENS ALEATORIOS >> %d", MAX_TAM_ARRAY, vetor0[buscaMaior(vetor0, MAX_TAM_ARRAY)]);

	char* palindromo0 = "OMISSIMO\0"; 
	char* palindromo1 = "ARARA\0"; 
	char *naoPalindromo = "WALLACE\0";
	printf("\n\nEX02 - EH PALINDROMO COM PALAVRAS DEFINIDAS");
	printf("\n%s >> %d", palindromo0, ehPalindromo(palindromo0));
	printf("\n%s >> %d", palindromo1, ehPalindromo(palindromo1));
	printf("\n%s >> %d", naoPalindromo, ehPalindromo(naoPalindromo));

	char palavra[MAX_TAM] = "Wallace Oliveira\0";
	printf("\n\nEX03 - CONTA VOGAIS (%s) >> %d ", palavra, contaVogais(palavra));

	printf("\n\nEX04 - CONTA NOT VOGAIS AND NOT CONSOANTES MAIUSCULAS (%s) >> %d", palavra, contaCaracteres(palavra));

	clock_t start, end;
	start = clock();
	ordenarArray(vetor0, MAX_TAM_ARRAY);
	end = clock();
	printf("\n\nEX05 - ORDENAR ARRAY DE %d ELEMENTOS ALEATORIOS: %lf segundos.", MAX_TAM_ARRAY, ((double)(end - start)) / CLOCKS_PER_SEC);

	printf("\n\nEX06 - T(0) = 1 | T(1) = 2 | T(n) = T(n-1) * T(n-2) - T(n-1) >> Resultado para T(10) >> %d", T_recursivo(TAM_T));

	printf("\n\nEX07 - T(0) = 1 | T(n) = T(n-1) * T(n-1) >> Resultado para T(10) >> %d", T_recursivo2(TAM_T));

	printf("\n\nEX08 - HANOI DE %d TERMOS\n", NUM_TERMOS);
	hanoi(NUM_TERMOS, 'A', 'B', 'C');


	return SUCESSO;
}