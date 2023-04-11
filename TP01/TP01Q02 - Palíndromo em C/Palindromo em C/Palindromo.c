/**
 * @file Palindromo.c
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP01Q02 - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
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

//------ Tipos e Estruturas
typedef char* string;
typedef unsigned char boolean;

//------ Assinatura de Funcoes

boolean ehPalindromo(string str);
boolean ehFim(string str);
void removeQuebraDeLinha(string str);

//------ Inicio
int main(int argc, char** argv) {
	char str[TAM_STR];
	fgets(str, TAM_STR, stdin);

	while (!ehFim(str)){

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
/// Verifica se string eh um palindromo.
/// </summary>
/// <param name="str">String a ser avaliada.</param>
/// <returns>TRUE: String eh um palindromo | FALSE: String nao eh um palindromo</returns>
boolean ehPalindromo(string str) {
	boolean palindromo = TRUE;
	uint32_t i = 0, lastChar = strlen(str) - 1;

	while (i < lastChar && palindromo){
		
		if (str[i] != str[lastChar]) //Se caracters forem diferentes string nao eh um palindromo. 
			palindromo = FALSE;
		
		i++; lastChar--;
	}

	return palindromo;
}

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
