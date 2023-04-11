/**
 * @file ArquivoEmC.c
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP01Q10 - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
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
#define NOME_ARQ ("aux.out")

//------ Tipos e Estruturas
typedef char* string;
typedef unsigned char boolean;

//------ Assinatura de Funcoes
void escreveArquivo(int numItens);
void lerArquivo(int numItens);
boolean ehInteiro(double valor);

//------ Inicio
int main(int argc, char** argv) {
	int n;
	scanf("%d ", &n);

	escreveArquivo(n);
	lerArquivo(n);

	return SUCESSO;
}

//------ Funcoes

/// <summary>
/// Procedimento que ler valores float e armazena-los em arquivo txt.
/// </summary>
/// <param name="numItens">Numero de valores floats a serem lidos.</param>
void escreveArquivo(int numItens) {
	FILE* arq = fopen(NOME_ARQ, "wb");
	float valor;

	if (arq != NULL) { //Valida que arquivo foi aberto.
		
		for (int i = 0; i < numItens; i++) { //Ler valores float e armazena em arquivo.
			scanf("%f ", &valor);
			fwrite(&valor, sizeof(float), 1, arq);
		}

		fclose(arq);
	
	}else { //Se nao aberto escreve na saida de erro mensagem informando.
		fprintf(stderr, "ERRO AO ABRIR ARQUIVO");
	}
	
}

/// <summary>
/// Procedimento para realizar a leitura de um arquivo de floats ao contrario.
/// </summary>
/// <param name="numItens">Numero de valores floats a serem lidos.</param>
void lerArquivo(int numItens) {
	FILE* arq = fopen(NOME_ARQ, "rb");
	float valor;
	int c = -1;

	if (arq != NULL) { //Valida que arquivo foi aberto para leitura.

		//Reposiciona ponteiro e tenta efetuar a leitura, valor de retorno de fread ao atingir FEOF interrompe laco.
		while (fseek(arq, c * sizeof(float), SEEK_END) == 0 && fread(&valor, sizeof(float), 1, arq)) {
			
			if (ehInteiro(valor)) {
				printf("%d\n", (int)valor);
			}
			else {
				printf("%3g\n", valor);
			}

			c--;
		}

		fclose(arq);
	}
	else { //Se nao aberto escreve na saida de erro mensagem informando.
		fprintf(stderr, "ERRO AO ABRIR ARQUIVO");
	}
}

/// <summary>
///	Verifica se um valor recebido eh inteiro ou não. 
/// </summary>
/// <param name="valor">Double a ser verificado</param>
/// <returns>TRUE: Eh um inteiro | FALSE: Nao eh um inteiro</returns>
boolean ehInteiro(double valor) {
	int inteiro = (int)valor;
	double decimal = (valor - inteiro);
	return (decimal == 0);
}

