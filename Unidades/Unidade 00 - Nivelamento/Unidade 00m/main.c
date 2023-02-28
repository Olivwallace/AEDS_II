/**
 * @file Unidade_00m.h
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Lista Unidade 00m - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 17-02-2023
 */

 //---------- Inclusoes
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Uteis.h"
#include "Unidade_00m.h"


int main(int argc, char** argv) {
	
	armazenaValoresEmArq(MAX, "Valores.bin");
	lerValoresDeArq("Valores.bin");
	lerValoresInvertidos("Valores.bin");
	somaValoresArq(MAX, "Valores.bin");

	return SUCESSO;
}