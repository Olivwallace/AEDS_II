/**
 * @file Unidade_00h.h
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Lista Unidade 00h - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 17-02-2023
 */

#pragma once

#ifndef __UNIDADE_00h_h__
#define __UNIDADE_00h_h__

 //---------- Inclusoes
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <time.h>
#include "Uteis.h"

//---------- Constantes
#define MAX_TAM (50)
#define MAX_TAM_ARRAY (1000)
#define TAM_T (10)
#define NUM_TERMOS (3)


//---------- Funcoes

int MultRecursiva(int a, int b);

int buscaMaior(int* array, int tamArray);
int buscarMaiorRecursivo(int* array, int tamArray, int posMaior);

boolean ehPalindromo(string palavra);
boolean palindromoRecursivo(string palavra, uint32_t posInicio, uint32_t posFim);

boolean isVogal(char letra);
int contaVogais(string palavra);
int contaVogaisRecursivo(string palavra, int numItens);

boolean isConsoanteMaiuscula(char letra);
int contaCaracteres(string palavra);
int NOTvogalAND_NOTconsoante(string palavra, int pos);

void ordenarArray(int* array, int numElementosArray);
void mergeSort(int* array, int posInicio, int posFim);
void merge(int* array, int posInicio, int posFim, int meioCalc);

int T_recursivo(int n);
int T_recursivo2(int n);

void hanoi(int numDisc, char init, char aux, char fim);




#endif //__UNIDADE_00h_h__
