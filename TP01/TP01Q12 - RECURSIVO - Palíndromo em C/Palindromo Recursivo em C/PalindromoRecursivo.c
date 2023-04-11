/**
 * @file PalindromoRecursivo.c
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP01Q12 - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 25-02-2023
 */

 //------ Inclusoes
#include <stdio.h>
#include <stdint.h>
#include <string.h>

//------ Constantes
#define SUCESSO (0)
#define TRUE (1 == 1)
#define FALSE (1 != 1)
#define TAM_STR (511 + 1)
#define MAX_VIRGULA (1)

//------ Tipos e Estruturas
typedef char* string;
typedef unsigned char boolean;

//------ Assinatura de Funcoes

boolean ehFim(string str);
boolean ehPalindromo(string str);
boolean palindromoRecursivo(string str, int begin, int end);
void removeQuebraDeLinha(string str);

//------ Inicio
int main(int argc, char** argv) {
	char str[TAM_STR];
	fgets(str, TAM_STR, stdin);

	while (!ehFim(str)) {
		removeQuebraDeLinha(str);

		if (ehPalindromo(str)) {
			printf("SIM\n");
		}else {
			printf("NAO\n");
		}

		fgets(str, TAM_STR, stdin);
	}

	return SUCESSO;
}

//------ Funcoes

/// <summary>
/// Verifica se string eh igual a palavra "FIM"
/// </summary>
/// <param name="str">String a ser avaliada</param>
/// <returns>TRUE: String corresponde a "FIM" | FALSE: String diferente de "FIM" </returns>
boolean ehFim(string str) {
	boolean fim = FALSE;

	if (strlen(str) == (3 + 1)) {
		if (str[0] == 'F' && str[1] == 'I' && str[2] == 'M') fim = TRUE;
	}

	return fim;
}

/// <summary>
/// Procedimento para remover quebra de linha no final de uma string.
/// </summary>
/// <param name="str">String a ser removida quebra de linha do final</param>
void removeQuebraDeLinha(string str) {
	int posFinal = (strlen(str) - 1);	
	if (str[posFinal] == '\n') str[posFinal] = '\0'; //Se presente \n eh substituido pelo terminador de string \0
}

/// <summary>
/// Funcao simplificada para verificar se uma string eh palindromo.
/// </summary>
/// <param name="str">String a ser verificada</param>
/// <returns>TRUE: String eh palindromo | FALSE: String nao eh palindromo</returns>
boolean ehPalindromo(string str) {
	return palindromoRecursivo(str, 0, (strlen(str) - 1));
}

/// <summary>
/// Funcao recursiva para verificar se uma string eh palindromo.
/// </summary>
/// <param name="str">String a ser verificada</param>
/// <param name="begin">Posicao inicial da string</param>
/// <param name="end">Posicao final da string</param>
/// <returns>TRUE: String eh palindromo | FALSE: String nao eh palindromo</returns>
boolean palindromoRecursivo(string str, int begin, int end) {
	boolean palindromo = TRUE;
	
	if (begin < end) {
		palindromo = (str[begin] == str[end]) && palindromoRecursivo(str, begin + 1, end - 1);
	}

	return palindromo;
}

