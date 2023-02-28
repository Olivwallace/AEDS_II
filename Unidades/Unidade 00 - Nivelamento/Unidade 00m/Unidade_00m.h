/**
 * @file Unidade_00m.h
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Lista Unidade 00m - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 17-02-2023
 */

#pragma once

#ifndef __UNIDADE_00m_h__
#define __UNIDADE_00m_h__

 //---------- Inclusoes
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Uteis.h"

//---------- Constantes
#define MAX (10)
#define MAX_TAM (50)
#define MAX_TAM_ARRAY (1000)

//---------- Tipos
typedef int dado_t;

typedef struct Celula_s {
	dado_t dado;
	struct Celula_s* prox;
}Celula_t;

//---------- Funcoes

void armazenaValoresEmArq(int n, string nomeArq_ext);
void lerValoresDeArq(string nomeArq_ext);
void lerValoresInvertidos(string nomeArq_ext);
void somaValoresArq(int numItens, string nomeArq_ext);

#endif //__UNIDADE_00m_h__


