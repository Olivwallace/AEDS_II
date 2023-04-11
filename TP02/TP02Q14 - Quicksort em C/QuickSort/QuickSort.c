/**
 * @file QuickSort.c
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP02Q14 - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 31-03-2023
 */

 //--------------- Inclusoes

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <locale.h>
#include <time.h>
#include <errno.h>

//--------------- Erros
#define BAD_ALLOC (100)
#define NULL_EXCEPTION (101)

#define MAX_REACHED (200)

//--------------- Constantes

#define SUCESSO (0)

#define TRUE (1 == 1)
#define FALSE (1 != 1)

#define BUFFER_4 (4)
#define BUFFER_8 (8)
#define BUFFER_16 (16)
#define BUFFER_32 (32)
#define BUFFER_64 (64)
#define BUFFER_128 (128)
#define BUFFER_256 (256)
#define BUFFER_512 (512)
#define BUFFER_1024 (1024)

#define MATRICULA ("784778")

//--------------- Tipos

typedef uint32_t error;
typedef char* string;
typedef char** stringArray;
typedef unsigned char boolean;

typedef void* personagem;

typedef void (*set)(string, personagem);
typedef void (*setInt)(int, personagem);
typedef void (*setDouble)(double, personagem);

typedef string(*get)(personagem);
typedef int(*getInt)(personagem);
typedef double(*getDouble)(personagem);

typedef personagem(*clone)(personagem);
typedef void (*toRead)(personagem, string);
typedef void (*toString)(personagem);

//------------------ Estruturas

typedef struct personagem_s {

	string nome;
	int altura;
	double peso;
	string corDoCabelo;
	string corDaPele;
	string corDosOlhos;
	string anoNascimento;
	string genero;
	string homeworld;

	set setNome;
	setInt setAltura;
	setDouble setPeso;
	set setCorCabelo;
	set setCorPele;
	set setCorOlhos;
	set setAnoNascimento;
	set setGenero;
	set setHomeworld;

	get getNome;
	getInt getAltura;
	getDouble getPeso;
	get getCorCabelo;
	get getCorPele;
	get getCorOlhos;
	get getAnoNascimento;
	get getGenero;
	get getHomeworld;


	toRead ler;
	clone clonar;
	toString imprimir;

} Personagem_t;

typedef Personagem_t* dado_t;

typedef struct listaSeq_s {
	dado_t* listaSeq;
	uint32_t tamMax;
	uint32_t numItens;
}listaSeq_t;


//--------------- Assinaturas de Funcoes

void replace(string str, string oldValue, string newValue);
void lerBufferStdin(string end, size_t maxTam);

Personagem_t* novoPersonagem();
void newPersonagem(Personagem_t* personagem, string nome, int altura, double peso, string corCabelo, string corPele,
	string corOlhos, string anoNascimento, string genero, string homeworld);
void destrutorPersonagem(Personagem_t* ptr);

void setNome(string nome, personagem personagem);
void setAltura(int altura, personagem personagem);
void setPeso(double peso, personagem personagem);
void setCorDoCabelo(string corCabelo, personagem personagem);
void setCorDaPele(string corPele, personagem personagem);
void setCorDosOlhos(string corOlhos, personagem personagem);
void setAnoNascimento(string anoNascimento, personagem personagem);
void setGenero(string genero, personagem personagem);
void setHomeworld(string homeworld, personagem personagem);

string getNome(personagem personagem);
int getAltura(personagem personagem);
double getPeso(personagem personagem);
string getCorDoCabelo(personagem personagem);
string getCorDaPele(personagem personagem);
string getCorDosOlhos(personagem personagem);
string getAnoNascimento(personagem personagem);
string getGenero(personagem personagem);
string getHomeworld(personagem personagem);

void imprime(personagem registro);
personagem clona(personagem registroBase);
void le(personagem personagem, string registroEntrada);

string json_getString(string JSON, string key);
int json_getInt(string JSON, string key);
double json_getDouble(string JSON, string key);

listaSeq_t* listaCria();
error inicializaLista(listaSeq_t* lista, uint32_t tamMax);
boolean listaVazia(listaSeq_t* lista);
error insereFinal(listaSeq_t* lista, dado_t dado);
dado_t removeFinal(listaSeq_t* lista);

error imprimeLista(listaSeq_t* lista);
void listaClear(listaSeq_t* lista);
boolean buscaBinaria(listaSeq_t* lista, string dado, int* retornoAux);
error quickSort(listaSeq_t* lista, int* retornoAux);
void quickSortRec(dado_t* personagens, int ini, int fim, int* retornoAux);
void swap(dado_t* lista, int posEsq, int posDir);
int particiona(dado_t* personagens, int ini, int fim, int* retornoAux);
int compararCorCabelo(dado_t atual, dado_t comparado);

//--------------- Fim Assinaturas de Funcoes

//------------------------------------------------------ Principal

int main(int argc, char** argv) {
	setlocale(LC_ALL, "pt_BR.utf8");

	FILE* arq = fopen("784778_quicksort.txt", "w");

	double runTime = 0.0;
	clock_t begin = clock(); //Inicializa Temporizador

	Personagem_t* personagem;
	listaSeq_t* lista = listaCria();
	int countComp_Mov[2] = { 0, 0 };

	if (inicializaLista(lista, 50) != BAD_ALLOC) {

		char caminho[BUFFER_64];
		lerBufferStdin(caminho, BUFFER_64); //Ler entrada Stdin


		while (caminho[0] != 'F' && caminho[1] != 'I' && caminho[2] != 'M') { //Se nao atingiu FIM, continua processo.

			personagem = novoPersonagem(); //Cria novo personagem

			if (personagem != NULL) { //Confirma alocacao de memoria
				personagem->ler(personagem, caminho);
				insereFinal(lista, personagem);
			}

			lerBufferStdin(caminho, BUFFER_64); //Ler nova entrada
		}

		quickSort(lista, countComp_Mov);
		imprimeLista(lista);

		for (uint32_t i = 0; i < lista->numItens; i++) destrutorPersonagem(lista->listaSeq[i]); //Desaloca personagens presentes na lista
		listaClear(lista); //Desaloca lista
	}

	clock_t end = clock(); //Finaliza Temporizador
	runTime += (double)(end - begin) / CLOCKS_PER_SEC;

	if (arq != NULL) { //Escreve em arquivo se aberto
		fprintf(arq, "%s\t%gs\t%dcmp\t%dmov", MATRICULA, runTime, countComp_Mov[0], countComp_Mov[1]);
		fclose(arq);
	}

	return SUCESSO;
}

//------------------------------------------------------ Funcoes


/// <summary>
/// Realiza replace em string.
/// </summary>
/// <param name="str">String a ser alterada</param>
/// <param name="oldValue">Cadeia de string anterior</param>
/// <param name="newValue">Cadeia de string substituta</param>
void replace(string str, string oldValue, string newValue) {
	size_t oldMax = strlen(oldValue), newMax = strlen(newValue);

	if (newMax <= oldMax) { //Valida que nova cadeia de string seja menor ou igual a anterior (Evita Estouro de Memoria) 

		string end = strstr(str, oldValue); //Encontra primeira ocorrencia de cadeia anterior

		while (end != NULL) { //Confirma que encontrou ocorrencia

			memmove(end + newMax, end + oldMax, strlen(end + oldMax) + 1); //Movimenta bytes relativos aos tamannhos das cadeias trocadas.
			memcpy(end, newValue, newMax); //Realiza copia dos bytes de cadeia substituta para endereco da posicao de cadeia anterior.
			end = strstr(str, oldValue); //Busca nova ocorrencia

		}

	}
}

/// <summary>
/// Realiza leitura e tratamento de entrada de dados vindos da STDIN
/// </summary>
/// <param name="end">Endereco de armazenamento</param>
/// <param name="maxTam">Tamanho maximo de entrada</param>
void lerBufferStdin(string end, size_t maxTam) {
	int tam = (int)(maxTam);

	fgets(end, tam, stdin);
	size_t pos = strlen(end);

	if (end[pos - 1] == '\n') //Remove quebra do final de entrada
		end[pos - 1] = '\0';
}

/// <summary>
/// Obtem valor de um valor string referente a chave em JSON.
/// </summary>
/// <param name="JSON">String JSON</param>
/// <param name="key">Chave buscada</param>
/// <returns>String correspondente a chave | NULL</returns>
string json_getString(string JSON, string key) {
	int i = 0;
	size_t keyMax = strlen(key), max = strlen(JSON);
	char leitura[BUFFER_256] = { "\0" };
	string end, retorno = '\0';

	if (JSON != NULL) { //Garante que existe JSON.

		end = strstr(JSON, key); //Obtem posicao da chave
		end += keyMax; //Recalcula para pos chave


		if (end != NULL) { //Garante que posicao calculada e valida.

			while (i < max && end[i] != '\'') {  //Ler valor correspondente a chave. obs: padrao chave valor -> 'key':'value',...
				leitura[i] = end[i];
				i++;
			}

			leitura[i] = '\0'; //Posiciona final de string na ultima posica pos value.
		}

		retorno = malloc(strlen(leitura) + 1); //Para finalizar aloca memoria para retorno
		if (retorno != NULL) {
			strcpy(retorno, leitura);		//Realiza copia de leitura para ponteiro retornado.
		}

	}

	return retorno;
}

/// <summary>
/// Obtem valor de um valor int referente a chave em JSON.
/// </summary>
/// <param name="JSON">String JSON</param>
/// <param name="key">Chave buscada</param>
/// <returns>Inteiro correspondente a chave (caso int) | 0 </returns>
int json_getInt(string JSON, string key) {
	string erro, strValue = json_getString(JSON, key); //Obtem valor string referente a chave.
	errno = 0; //Inicializa macro errno

	long int valor = strtol(strValue, &erro, 0); //Tenta ler um int 

	if (errno != 0 || erro[0] != '\0') { // Se foi sinalizado algum erro altera valor para 0;
		valor = 0;
	}
	else { //Se nao realiza cast para int.
		valor = (int)valor;
	}

	free(strValue);

	return valor;
}

/// <summary>
/// Obtem valor de um valor double referente a chave em JSON.
/// </summary>
/// <param name="JSON">String JSON</param>
/// <param name="key">Chave buscada</param>
/// <returns>Double correspondente a chave (caso double) | 0 </returns>
double json_getDouble(string JSON, string key) {
	string erro, strValue = json_getString(JSON, key); //Obtem valor string referente a chave.
	errno = 0; //Inicializa macro errno

	double valor = strtod(strValue, &erro); //Tenta ler um double

	if (errno != 0 || erro[0] != '\0') {

		replace(strValue, ",", "");                          //Se foi sinalizado algum erro
		errno = 0;											 //realiza alteracao da string e valida se eh um double com virgula de milhar.
		valor = strtod(strValue, &erro);                     //Se novo erro retorna 0.

		if (errno != 0 || erro[0] != '\0') valor = 0;
	}

	free(strValue);

	return valor;
}

//---- Contrutores

/// <summary>
/// Contrutor principal de Personagem
/// </summary>
/// <returns>Novo Personagem</returns>
Personagem_t* novoPersonagem() {

	Personagem_t* novo = (Personagem_t*)malloc(sizeof(Personagem_t)); //Aloca Memoria

	//Confima alocacao para realizar pre-carregamento de funcoes dentro do novo objeto.
	if (novo != NULL) {
		novo->setNome = setNome;
		novo->setAltura = setAltura;
		novo->setPeso = setPeso;
		novo->setCorCabelo = setCorDoCabelo;
		novo->setCorPele = setCorDaPele;
		novo->setCorOlhos = setCorDosOlhos;
		novo->setAnoNascimento = setAnoNascimento;
		novo->setGenero = setGenero;
		novo->setHomeworld = setHomeworld;

		novo->getNome = getNome;
		novo->getAltura = getAltura;
		novo->getPeso = getPeso;
		novo->getCorCabelo = getCorDoCabelo;
		novo->getCorPele = getCorDaPele;
		novo->getCorOlhos = getCorDosOlhos;
		novo->getAnoNascimento = getAnoNascimento;
		novo->getGenero = getGenero;
		novo->getHomeworld = getHomeworld;

		novo->ler = le;
		novo->imprimir = imprime;
		novo->clonar = clona;
	}

	return novo;
}

/// <summary>
/// Construtor secundario de personagens.
/// </summary>
/// <param name="novo">Endereco de personagem j� gerado pelo principal</param>
/// <param name="nome">String</param>
/// <param name="altura">Int</param>
/// <param name="peso">Double</param>
/// <param name="corCabelo">String</param>
/// <param name="corPele">String</param>
/// <param name="corOlhos">String</param>
/// <param name="anoNascimento">String</param>
/// <param name="genero">String</param>
/// <param name="homeworld">String</param>
void newPersonagem(Personagem_t* novo, string nome, int altura, double peso, string corCabelo, string corPele,
	string corOlhos, string anoNascimento, string genero, string homeworld) {

	if (novo == NULL) novo = novoPersonagem(); //Se endereco de personagem for nulo, realiza alocacao

	//Confimar que exite memoria alocada para realiza set dos atribultos. 
	if (novo != NULL) {
		novo->setNome(nome, novo);
		novo->setAltura(altura, novo);
		novo->setPeso(peso, novo);
		novo->setCorCabelo(corCabelo, novo);
		novo->setCorPele(corPele, novo);
		novo->setCorOlhos(corOlhos, novo);
		novo->setAnoNascimento(anoNascimento, novo);
		novo->setGenero(genero, novo);
		novo->setHomeworld(homeworld, novo);
	}
}

//---- Setter's

/// <summary>
/// Altera Nome
/// </summary>
/// <param name="nome">string nome substituta</param>
/// <param name="personagem">Personagem Alterado</param>
void setNome(string nome, personagem personagem) {
	if (personagem != NULL)
		((Personagem_t*)personagem)->nome = nome;
}

/// <summary>
/// Altera Altura
/// </summary>
/// <param name="altura">int altura substituto</param>
/// <param name="personagem">Personagem Alterado</param>
void setAltura(int altura, personagem personagem) {
	if (personagem != NULL)
		((Personagem_t*)personagem)->altura = altura;
}

/// <summary>
/// Altera Peso
/// </summary>
/// <param name="peso">double peso substituto</param>
/// <param name="personagem">Personagem Alterado</param>
void setPeso(double peso, personagem personagem) {
	if (personagem != NULL)
		((Personagem_t*)personagem)->peso = peso;
}

/// <summary>
/// Altera Cor Cabelo
/// </summary>
/// <param name="corCabelo">string corCabelo substituta</param>
/// <param name="personagem">Personagem Alterado</param>
void setCorDoCabelo(string corCabelo, personagem personagem) {
	if (personagem != NULL)
		((Personagem_t*)personagem)->corDoCabelo = corCabelo;
}

/// <summary>
/// Altera Cor Pele
/// </summary>
/// <param name="corPele">string corPele substituta</param>
/// <param name="personagem">Personagem Alterado</param>
void setCorDaPele(string corPele, personagem personagem) {
	if (personagem != NULL)
		((Personagem_t*)personagem)->corDaPele = corPele;
}

/// <summary>
/// Altera Cor Olhos
/// </summary>
/// <param name="corOlhos">string corOlhos substituta</param>
/// <param name="personagem">Personagem Alterado</param>
void setCorDosOlhos(string corOlhos, personagem personagem) {
	if (personagem != NULL)
		((Personagem_t*)personagem)->corDosOlhos = corOlhos;
}

/// <summary>
/// Altera Ano Nascimento
/// </summary>
/// <param name="anoNascimenot">string anoNascimento substituta</param>
/// <param name="personagem">Personagem Alterado</param>
void setAnoNascimento(string anoNascimento, personagem personagem) {
	if (personagem != NULL)
		((Personagem_t*)personagem)->anoNascimento = anoNascimento;
}

/// <summary>
/// Altera Genero
/// </summary>
/// <param name="genero">string genero substituta</param>
/// <param name="personagem">Personagem Alterado</param>
void setGenero(string genero, personagem personagem) {
	if (personagem != NULL)
		((Personagem_t*)personagem)->genero = genero;
}

/// <summary>
/// Altera Homeworld
/// </summary>
/// <param name="homeworld">string homeworld substituta</param>
/// <param name="personagem">Personagem Alterado</param>
void setHomeworld(string homeworld, personagem personagem) {
	if (personagem != NULL)
		((Personagem_t*)personagem)->homeworld = homeworld;
}

//---- Getter's

/// <summary>
/// Recupera nome
/// </summary>
/// <param name="personagem">Personagem solicitado</param>
/// <returns>String nome</returns>
string getNome(personagem personagem) {
	string retorno = NULL;

	if (personagem != NULL)
		retorno = ((Personagem_t*)personagem)->nome;

	return retorno;
}

/// <summary>
/// Recupera Altura
/// </summary>
/// <param name="personagem">Personagem solicitado</param>
/// <returns>Int altura</returns>
int getAltura(personagem personagem) {
	int retorno = 0;

	if (personagem != NULL)
		retorno = ((Personagem_t*)personagem)->altura;

	return retorno;
}

/// <summary>
/// Recupera Peso
/// </summary>
/// <param name="personagem">Personagem solicitado</param>
/// <returns>Double Peso</returns>
double getPeso(personagem personagem) {
	double retorno = 0;

	if (personagem != NULL)
		retorno = ((Personagem_t*)personagem)->peso;

	return retorno;
}

/// <summary>
/// Recupera Cor Cabelo
/// </summary>
/// <param name="personagem">Personagem solicitado</param>
/// <returns>String Cor Cabelo</returns>
string getCorDoCabelo(personagem personagem) {
	string retorno = NULL;

	if (personagem != NULL)
		retorno = ((Personagem_t*)personagem)->corDoCabelo;

	return retorno;
}

/// <summary>
/// Recupera Cor Pele
/// </summary>
/// <param name="personagem">Personagem solicitado</param>
/// <returns>String Cor Pele</returns>
string getCorDaPele(personagem personagem) {
	string retorno = NULL;

	if (personagem != NULL)
		retorno = ((Personagem_t*)personagem)->corDaPele;

	return retorno;
}

/// <summary>
/// Recupera Cor Olhos
/// </summary>
/// <param name="personagem">Personagem solicitado</param>
/// <returns>String Cor Olhos</returns>
string getCorDosOlhos(personagem personagem) {
	string retorno = NULL;

	if (personagem != NULL)
		retorno = ((Personagem_t*)personagem)->corDosOlhos;

	return retorno;
}

/// <summary>
/// Recupera Ano Nascimento
/// </summary>
/// <param name="personagem">Personagem solicitado</param>
/// <returns>String Ano Nascimento</returns>
string getAnoNascimento(personagem personagem) {
	string retorno = NULL;

	if (personagem != NULL)
		retorno = ((Personagem_t*)personagem)->anoNascimento;

	return retorno;
}

/// <summary>
/// Recupera Genero
/// </summary>
/// <param name="personagem">Personagem solicitado</param>
/// <returns>String Genero</returns>
string getGenero(personagem personagem) {
	string retorno = NULL;

	if (personagem != NULL)
		retorno = ((Personagem_t*)personagem)->genero;

	return retorno;
}

/// <summary>
/// Recupera Homeworld
/// </summary>
/// <param name="personagem">Personagem solicitado</param>
/// <returns>String Homeworld</returns>
string getHomeworld(personagem personagem) {
	string retorno = NULL;

	if (personagem != NULL)
		retorno = ((Personagem_t*)personagem)->homeworld;

	return retorno;
}

//---- Metodos Imprime, Clona, Ler

/// <summary>
/// Imprime conteudo de Personagem
/// </summary>
/// <param name="reg">Personagem a ter registro impresso</param>
void imprime(personagem registro) {
	Personagem_t* reg = (Personagem_t*)registro;

	if (reg != NULL) {

		printf("## %s ## %d ## %g ## %s ## %s ## %s ## %s ## %s ## %s ##\n",
			reg->getNome(reg), reg->getAltura(reg), reg->getPeso(reg), reg->getCorCabelo(reg), reg->getCorPele(reg),
			reg->getCorOlhos(reg), reg->getAnoNascimento(reg), reg->getGenero(reg), reg->getHomeworld(reg));

	}

}

/// <summary>
/// Realiza Clonagem de um personagem
/// </summary>
/// <param name="reg">Personagem Clonado</param>
/// <returns>Personagem indentico ao recebido por paramentro</returns>
personagem clona(personagem registro) {
	Personagem_t* reg = (Personagem_t*)registro;
	Personagem_t* novo = novoPersonagem();

	if (novo != NULL) {
		newPersonagem(novo, reg->getNome(reg), reg->getAltura(reg), reg->getPeso(reg), reg->getCorCabelo(reg), reg->getCorPele(reg),
			reg->getCorOlhos(reg), reg->getAnoNascimento(reg), reg->getGenero(reg), reg->getHomeworld(reg));
	}

	return novo;
}

/// <summary>
/// Realiza leitura de dados de registro de um personagem.
/// </summary>
/// <param name="personagem">Personagem lido</param>
/// <param name="registroEntrada">Caminho de Arquivo Registro</param>
void le(personagem personagem, string registroEntrada) {
	char caminho[BUFFER_256] = { "" }, buffer[BUFFER_1024];

	strncat(caminho, registroEntrada, strlen(registroEntrada)); //Concatena Strings para montar caminho completo
	FILE* arq = fopen(caminho, "r"); //Abre arquivo

	if (arq != NULL) { //Se arquivo aberto

		fgets(buffer, BUFFER_1024, arq); //Ler linha de entrada
		replace(buffer, "\': \'", "");	 //Remove caracteres desnecessarios

		//Constroi novo personagem
		newPersonagem(personagem, json_getString(buffer, "name"), json_getInt(buffer, "height"), json_getDouble(buffer, "mass"),
			json_getString(buffer, "hair_color"), json_getString(buffer, "skin_color"), json_getString(buffer, "eye_color"),
			json_getString(buffer, "birth_year"), json_getString(buffer, "gender"), json_getString(buffer, "homeworld"));

		fclose(arq);//Fecha arquivo
	}
}

/// <summary>
/// Finaliza registro de um personagem (Desalocando-o da Memoria)
/// </summary>
/// <param name="ptr">Personagem a ser destruido</param>
void destrutorPersonagem(Personagem_t* ptr) {
	free(ptr->nome);
	free(ptr->corDoCabelo);
	free(ptr->corDaPele);
	free(ptr->corDosOlhos);
	free(ptr->anoNascimento);
	free(ptr->genero);
	free(ptr->homeworld);
}

//------------------------------------------------------ Lista Sequencial

/// <summary>
/// Cria um objeto de lista;
/// </summary>
/// <returns>Objeto criado dinamicamente</returns>
listaSeq_t* listaCria() {
	return (listaSeq_t*)malloc(sizeof(listaSeq_t));
}

/// <summary>
/// Inicializa um objeto de lista.
/// </summary>
/// <param name="lista">Objeto a ser inicializado</param>
/// <param name="tamMax">Tamanho maximo de lista interna do objeto</param>
/// <returns>Status de Incializacao (ERROR)</returns>
error inicializaLista(listaSeq_t* lista, uint32_t tamMax) {
	error status = BAD_ALLOC;

	if (tamMax > 1 && lista != NULL) {
		lista->listaSeq = malloc(tamMax * sizeof(dado_t));

		if (lista->listaSeq != NULL) {
			lista->numItens = 0;
			lista->tamMax = tamMax;

			status = SUCESSO;
		}

	}

	return status;
}

/// <summary>
/// Avalia se um objeto de lista esta vazio
/// </summary>
/// <param name="lista">Objeto a ser avaliado</param>
/// <returns>TRUE: Lista vazia, NULL | FALSE: Lista Preenchida</returns>
boolean listaVazia(listaSeq_t* lista) {
	return (lista == NULL || lista->numItens == 0);
}

/// <summary>
/// Realiza insercao em posicao final
/// </summary>
/// <param name="lista">Objeto de lista de armazenamento</param>
/// <param name="dado">Dado a ser inserido</param>
/// <returns>Status de insercao (ERROR)</returns>
error insereFinal(listaSeq_t* lista, dado_t dado) {
	error status = NULL_EXCEPTION;

	if (lista != NULL && lista->listaSeq != NULL) {
		uint32_t numItens = lista->numItens, tamanho = lista->tamMax;
		dado_t* listaDados = lista->listaSeq;

		if (numItens < tamanho) {
			listaDados[numItens] = dado;
			lista->numItens++;

			status = SUCESSO;
		}
		else {
			status = MAX_REACHED;
		}
	}

	return status;
}

/// <summary>
/// Remove dado presente em posicao final
/// </summary>
/// <param name="lista">Objeto ed lista de armazenamento</param>
/// <returns>Dado contido na posicao final</returns>
dado_t removeFinal(listaSeq_t* lista) {
	dado_t dado = NULL;

	if (lista != NULL && lista->listaSeq != NULL) {
		uint32_t numItens = --lista->numItens;
		dado = lista->listaSeq[numItens];
	}

	return dado;
}

/// <summary>
/// Realiza impressao de lista
/// </summary>
/// <param name="lista">Objeto de lista de armazenamento</param>
/// <returns>Status de impressao (ERROR)</returns>
error imprimeLista(listaSeq_t* lista) {
	error status = NULL_EXCEPTION;

	if (lista != NULL && lista->listaSeq != NULL) {
		uint32_t numIntens = lista->numItens;

		for (uint32_t i = 0; i < numIntens; i++) {
			printf(" ");
			lista->listaSeq[i]->imprimir(lista->listaSeq[i]);
		}

		status = SUCESSO;
	}

	return status;
}

/// <summary>
/// Desaloca Memoria de lista
/// </summary>
/// <param name="lista">Objeto lista a ser desalocado</param>
void listaClear(listaSeq_t* lista) {

	if (lista != NULL) {
		free(lista->listaSeq);
		free(lista);
	}

}

/// <summary>
/// Realiza busca binaria em lista de personagens.
/// </summary>
/// <param name="lista">Endereco de lista</param>
/// <param name="dado">Nome do personagem buscado</param>
/// <param name="retornoAux">Array contendo posicao encontrada e numero de comparacoes necessaria</param>
/// <returns>TRUE: Contem item | FALSE: Item nao presente ou lista nao existe</returns>
boolean buscaBinaria(listaSeq_t* lista, string dado, int* retornoAux) {
	boolean contem = FALSE;
	int i = 0;

	if (lista != NULL && lista->listaSeq != NULL && retornoAux != NULL) {
		retornoAux[0] = -1;
		int min = 0, max = (lista->numItens - 1), meio = (min + max) / 2;

		while (!contem && max >= min) {

			dado_t personagem = lista->listaSeq[meio];
			string nome = personagem->getNome(personagem);

			int cmp = strcmp(nome, dado); //Compara daddos

			if (cmp > 0) { //Se valor de busca maior que nome chute pesquisa na direita
				max = meio - 1;
				meio = (min + max) / 2;

			}
			else if (cmp < 0) { //Se valor de busca menor que nome chute pesquisa na esquerda
				min = meio + 1;
				meio = (min + max) / 2;

			}
			else { // Se chute igual valor de busca, retorna
				contem = TRUE;
				retornoAux[0] = i;
			}

			i++;
		}

		retornoAux[1] = i; //Salva numero de comparacoes realizadas em array auxiliar.
	}

	return contem;
}

/// <summary>
/// Ordena lista de personagens por meio de QuickSort
/// </summary>
/// <param name="lista">Lista a ser ordenada</param>
/// <param name="retornoaux">Vetor auxiliar de retorno</param>
/// <returns>Status de Erro</returns>
error quickSort(listaSeq_t* lista, int* retornoaux) {
	error status = NULL_EXCEPTION;

	if (lista != NULL && lista->listaSeq != NULL && retornoaux != NULL) {
		dado_t* personagens = lista->listaSeq;
		quickSortRec(personagens, 0, lista->numItens - 1, retornoaux);
		status = SUCESSO;
	}

	return status;
}

int compararCorCabelo(dado_t atual, dado_t comparado) {
	int result = strcmp(atual->getCorCabelo(atual), comparado->getCorCabelo(comparado));

	if (result == 0) {
		result = strcmp(atual->getNome(atual), comparado->getNome(comparado));
	}

	return result;
}

/// <summary>
/// Funcao recursiva para ordenacao via QuickSort
/// </summary>
/// <param name="personagens">Vetor de Personagens</param>
/// <param name="ini">Inicio do array</param>
/// <param name="fim">Fim do array</param>
/// <param name="retornoAux">Retorno auxiliar</param>
void quickSortRec(dado_t* personagens, int ini, int fim, int* retornoAux) {
	if (personagens != NULL && retornoAux != NULL && fim > ini) {
		int posPivo = particiona(personagens, ini, fim, retornoAux);
		quickSortRec(personagens, ini, posPivo - 1, retornoAux);
		quickSortRec(personagens, posPivo + 1, fim, retornoAux);
	}
}

int particiona(dado_t* personagens, int ini, int fim, int* retornoAux) {
	int posPivo = fim;
	int i = ini;

	if (personagens != NULL && retornoAux != NULL) {

		dado_t personagemPivo = personagens[posPivo];

		for (int j = ini; j < fim; j++) {
			dado_t atual = personagens[j];

			if (compararCorCabelo(atual, personagemPivo) <= 0) {
				swap(personagens, i, j);
				i++;
				retornoAux[1]++;
			}

			retornoAux[0]++;
		}

		swap(personagens, i, fim);
		retornoAux[1]++;
	}

	return i;
}

/// <summary>
/// Funcao de troca entre posicoes esquerda e direita em QuickSort
/// </summary>
/// <param name="lista">Lista a ser ordenada</param>
/// <param name="posEsq">Posicao de troca esquerda</param>
/// <param name="posDir">Posicao de troca direita</param>
void swap(dado_t* lista, int posEsq, int posDir) {
	dado_t temp = lista[posEsq];
	lista[posEsq] = lista[posDir];
	lista[posDir] = temp;
}