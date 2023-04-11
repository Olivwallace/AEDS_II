/**
 * @file IsEmC.c
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP01Q07 - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
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
void removeQuebraDeLinha(string str);
boolean ehLetra(char caracter);
boolean isVogal(char caracter);
boolean isConsoante(char caracter);
boolean isDigit(char caracter);
boolean compostaPorVogais(string str);
boolean compostaPorConsoantes(string str);
boolean ehInteiro(string str);
boolean ehReal(string str);
void avaliarString(string str);


//------ Inicio
int main(int argc, char** argv) {
	char str[TAM_STR];
	fgets(str, TAM_STR, stdin);

	while (!ehFim(str)) {

		removeQuebraDeLinha(str);

		avaliarString(str);
		fgets(str, TAM_STR, stdin);
	}

	return SUCESSO;
}

//------ Funcoes

/// <summary>
/// Confere se um caracter eh uma letra.
/// </summary>
/// <param name="caracter">Caracter verificado</param>
/// <returns>TRUE: Eh uma letra | FALSE: Nao eh letra</returns>
boolean ehLetra(char caracter) {
	return (caracter >= 'a' && caracter <= 'z' || caracter >= 'A' && caracter <= 'Z');
}

/// <summary>
/// Confere se um caracter eh uma vogal.
/// </summary>
/// <param name="caracter">Caracter verificado</param>
/// <returns>TRUE: Eh uma vogal | FALSE: Nao eh vogal</returns>
boolean isVogal(char caracter) {
	boolean retorno = FALSE;

	if (ehLetra(caracter)) {
		retorno = (caracter == 'a' || caracter == 'A' || caracter == 'e' || caracter == 'E' || caracter == 'i' ||
						caracter == 'I' || caracter == 'o' || caracter == 'O' || caracter == 'u' || caracter == 'U');
	}
	
	return retorno;
}

/// <summary>
/// Confere se caracter eh uma consoante.
/// </summary>
/// <param name="caracter">Caracter verificado</param>
/// <returns>TRUE: Eh consoante | FALSE: Nao eh consoante</returns>
boolean isConsoante(char caracter) {
	return ehLetra(caracter) && !isVogal(caracter);
}

/// <summary>
/// Confere se caracter eh um algarismo.
/// </summary>
/// <param name="caracter">Caracter a ser verificado</param>
/// <returns>TRUE: Eh um digito | FALSE: Nao eh um digito</returns>
boolean isDigit(char caracter) {
	return (caracter >= '0' && caracter <= '9');
}

/// <summary>
/// Confere se string eh composta apenas por vogais.
/// </summary>
/// <param name="str">String analisada</param>
/// <returns>TRUE: Eh composta apenas por vogais | FALSE: Nao eh composta apenas por vogais</returns>
boolean compostaPorVogais(string str) {
	int i = 0;
	boolean composta = TRUE;

	while (i < (strlen(str) - 1) && composta) {
		composta = isVogal(str[i]);
		i++;
	}

	return composta;
}

/// <summary>
/// Confere se string eh composta apenas por consoantes.
/// </summary>
/// <param name="str">String analisada</param>
/// <returns>TRUE: Eh composta apenas por consoantes | FALSE: Nao eh composta apenas por consoantes</returns>
boolean compostaPorConsoantes(string str) {
	int i = 0;
	boolean composta = TRUE;

	while (i < (strlen(str) - 1) && composta) {
		composta = isConsoante(str[i]);
		i++;
	}

	return composta;
}

/// <summary>
/// Confere se string eh um numero inteiro.
/// </summary>
/// <param name="str">String analisada</param>
/// <returns>TRUE: Eh inteiro | FALSE: Nao eh inteiro</returns>
boolean ehInteiro(string str) {
	int i = 0;
	boolean inteiro = TRUE;
	
	while (i < (strlen(str) - 1) && inteiro) {
		inteiro = isDigit(str[i]);
		i++;
	}

	return inteiro;
}

/// <summary>
/// Confere se string eh um numero real.
/// </summary>
/// <param name="str">String analisada</param>
/// <returns>TRUE: Eh real | FALSE: Nao eh real</returns>
boolean ehReal(string str) {
	int i = 0, count = 0;
	boolean real = TRUE;

	while (i < (strlen(str) - 1) && real) {
		
		if (str[i] == '.' || str[i] == ',') {
			count++;
			if (count > MAX_VIRGULA) real = FALSE;
		}else{
			real = isDigit(str[i]);
		}

		i++;
	}

	return real;
}

/// <summary>
/// Procedimento que imprime resposta (SIM | NAO) para:<para/>
/// Composta apenas por vogais?<para/>
/// Composta apenas por consoantes?<para/>
/// Eh um digito?<para/>
/// Eh um inteiro?
/// </summary>
/// <param name="str">String analisada</param>
void avaliarString(string str) {
	char verdade[3 + 1] = "SIM\0";
	char falso[3 + 1] = "NAO\0";

	printf("%s %s %s %s\n", (compostaPorVogais(str)) ? verdade : falso, (compostaPorConsoantes(str)) ? verdade : falso, 
								(ehInteiro(str)) ? verdade : falso, (ehReal(str)) ? verdade : falso);

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