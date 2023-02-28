/**
 * @file Uteis.h
 * @author Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief Codigos geralmente ultilizados.
 * @date 11-12-2022
 */

#pragma once

#ifndef __UTEIS_h__
#define __UTEIS_h__


 //---------- Inclusoes
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

//---------- Constantes
#define SUCESSO (0)
#define TRUE (1 == 1)
#define FALSE (1 != 1)

//---------- Tipos
typedef unsigned char boolean;

//---------- Funcoes

int binaryShared(int* array, int buscar, int tamArray);


#endif //__UTEIS_h__