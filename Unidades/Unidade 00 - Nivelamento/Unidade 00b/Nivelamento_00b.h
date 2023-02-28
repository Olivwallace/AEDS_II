/**
 * @file Nivelamento_00b.c
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Lista Unidade 00b - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 09-02-2023
 */

#pragma once

#ifndef __NIVELAMENTO_00b_h__
#define __NIVELAMENTO_00b_h__

 //---------- Inclusoes
#include <stdio.h>
#include <stdlib.h>
#include "Uteis.h"

//---------- Funcoes

boolean estaContido(int* array, int buscar, int tamArray);
boolean estaContidoBinaryShared(int* array, int buscar, int tamArray);
void imprimeMaxMin(int* array, int tamArray);

#endif //__NIVELAMENTO_00b_h__