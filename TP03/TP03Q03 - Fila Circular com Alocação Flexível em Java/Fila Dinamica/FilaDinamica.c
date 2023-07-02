/**
 * @file FilaDinamica.c
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP03Q03 - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 29-04-2023
 */

 //--------------- Inclusoes

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <locale.h>
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

//--------------- Tipos

typedef uint32_t error;
typedef char* string;
typedef char** stringArray;
typedef unsigned char boolean;

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

	boolean inicializado;

} Personagem_t;

//---------------- Definicao de Fila

typedef struct itemFila_s {
	Personagem_t* dado;
	struct itemFila_s* prox;
} itemPilha_t;

typedef struct fila_s {
	itemPilha_t* primeiro;
	itemPilha_t* ultimo;
	uint32_t numItens;
	uint32_t tamMax;
}pilha_t;


//--------------- Assinaturas de Funcoes

void operaFila(pilha_t* lista, int qtdOperacoes);
int mediaAlturaFila(pilha_t* fila);

Personagem_t* novoPersonagem(string nome, int altura, double peso, string corCabelo, string corPele,
	string corOlhos, string anoNascimento, string genero, string homeworld);
void imprimePersonagem(Personagem_t* registros);
Personagem_t* le(string registroEntrada);
void destrutorPersonagem(Personagem_t* ptr);


void inicializaFila(pilha_t* fila, uint32_t tamMax);
void enfileira(pilha_t* fila, Personagem_t* dado);
Personagem_t* desenfileira(pilha_t* fila);
void imprime(pilha_t* fila);
void filaClear(pilha_t* lista);


stringArray split(string str, char caracter);
void replace(string str, string oldValue, string newValue);
void lerBufferStdin(string end, size_t maxTam);

string json_getString(string JSON, string key);
int json_getInt(string JSON, string key);
double json_getDouble(string JSON, string key);


//--------------- Fim Assinaturas de Funcoes

//------------------------------------------------------ Principal

int main(int argc, char** argv) {
	setlocale(LC_ALL, "pt_BR.utf8");

	Personagem_t* personagem;
	pilha_t fila;
	inicializaFila(&fila, 5);

	char caminho[BUFFER_64];
	char numOp[BUFFER_4];
	lerBufferStdin(caminho, BUFFER_64); //Ler entrada Stdin


	while (caminho[0] != 'F' && caminho[1] != 'I' && caminho[2] != 'M') { //Se nao atingiu FIM, continua processo.
		personagem = le(caminho);
		if (fila.tamMax == fila.numItens)	destrutorPersonagem(desenfileira(&fila));
		enfileira(&fila, personagem);
		printf("%d\n", mediaAlturaFila(&fila));
		lerBufferStdin(caminho, BUFFER_64); //Ler nova entrada
	}

	lerBufferStdin(numOp, BUFFER_4);
	operaFila(&fila, atoi(numOp));

	filaClear(&fila); //Desaloca lista

	return SUCESSO;
}

//------------------------------------------------------ Funcoes

/// <summary>
/// Metodo para operar fila
/// </summary>
/// <param name="fila">Fila a ser operada</param>
/// <param name="qtdOperacoes">Numero de operacoes realizadas</param>
void operaFila(pilha_t* fila, int qtdOperacoes) {
	if (fila != NULL) {
		Personagem_t* personagem = NULL;

		char lido[BUFFER_64];
		stringArray op;

		for (int i = 0; i < qtdOperacoes; i++) {

			lerBufferStdin(lido, BUFFER_64);
			op = split(lido, ' '); //Armazena operacao e dado a ser operado em fila

			if (op != NULL) {

				if (op[0][0] == 'I') {
					personagem = le(op[1]);

					if (fila->tamMax == fila->numItens)	destrutorPersonagem(desenfileira(fila));
					enfileira(fila, personagem);
					printf("%d\n", mediaAlturaFila(fila));
					
				}
				else {
					personagem = desenfileira(fila);
					printf("(R) %s\n", personagem->nome);
					destrutorPersonagem(personagem); //Personagem removido eh desalocado da memoria
				}// op[0] == 'I'

				free(op[0]); //Libera string de operacao
				free(op); //Libera vetor de strings 

			}// personagem != NULL && op != NULL
		}
	}
}

/// <summary>
/// Calcula media de altura de itens presente em fila.
/// </summary>
/// <param name="fila"> Objeto fila a ser operado</param>
/// <returns>Tamanho medio de altura dos personagens na fila</returns>
int mediaAlturaFila(pilha_t* fila) {
	float media = 0;
	int med = 0;

	if (fila != NULL && fila->primeiro != NULL) {
		uint32_t qtdItens = fila->numItens;
		float soma = 0;

		itemPilha_t* atual = fila->primeiro;
		while (atual != NULL){
			soma += atual->dado->altura;
			atual = atual->prox;
		}

		media = (soma / qtdItens);
		med = ((int)media);
		if ((media - med) >= 0.5) ++media;
	}

	return (int)media;
}

//------------------------------------------------------ Personagem

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
/// <returns>Novo Personagem</returns>
Personagem_t* novoPersonagem(string nome, int altura, double peso, string corCabelo, string corPele,
	string corOlhos, string anoNascimento, string genero, string homeworld) {

	Personagem_t* novo = (Personagem_t*) malloc(sizeof(Personagem_t)); //Se endereco de personagem for nulo, realiza alocacao

	//Confimar que exite memoria alocada para realiza set dos atribultos. 
	if (novo != NULL) {
		novo->nome = nome;
		novo->altura = altura;
		novo->peso = peso;
		novo->corDoCabelo = corCabelo;
		novo->corDaPele = corPele;
		novo->corDosOlhos = corOlhos;
		novo->anoNascimento = anoNascimento;
		novo->genero = genero;
		novo->homeworld = homeworld;

		novo->inicializado = TRUE;
	}

	return novo;
}

/// <summary>
/// Imprime conteudo de Personagem
/// </summary>
/// <param name="reg">Personagem a ter registro impresso</param>
void imprimePersonagem(Personagem_t * reg) {
	if (reg != NULL) {

		printf("## %s ## %d ## %g ## %s ## %s ## %s ## %s ## %s ## %s ##\n",
			reg->nome, reg->altura, reg->peso, reg->corDoCabelo, reg->corDaPele,
			reg->corDosOlhos, reg->anoNascimento, reg->genero, reg->homeworld);

	}
}

/// <summary>
/// Realiza leitura de dados de registro de um personagem.
/// </summary>
/// <param name="personagem">Personagem lido</param>
/// <param name="registroEntrada">Caminho de Arquivo Registro</param>
/// <returns>Novo Personagem</returns>
Personagem_t* le(string registroEntrada) {
	Personagem_t* novo = NULL;
	char caminho[BUFFER_256] = { "" }, buffer[BUFFER_1024];

	strncat(caminho, registroEntrada, strlen(registroEntrada)); //Concatena Strings para montar caminho completo
	FILE* arq = fopen(caminho, "r"); //Abre arquivo

	if (arq != NULL) { //Se arquivo aberto

		fgets(buffer, BUFFER_1024, arq); //Ler linha de entrada
		replace(buffer, "\': \'", "");	 //Remove caracteres desnecessarios

		//Constroi novo personagem
		novo = novoPersonagem(json_getString(buffer, "name"), json_getInt(buffer, "height"), json_getDouble(buffer, "mass"),
			json_getString(buffer, "hair_color"), json_getString(buffer, "skin_color"), json_getString(buffer, "eye_color"),
			json_getString(buffer, "birth_year"), json_getString(buffer, "gender"), json_getString(buffer, "homeworld"));

		fclose(arq);//Fecha arquivo
	}

	return novo;
}

/// <summary>
/// Finaliza registro de um personagem (Desalocando-o da Memoria)
/// </summary>
/// <param name="ptr">Personagem a ser destruido</param>
void destrutorPersonagem(Personagem_t* ptr) {
	if (ptr != NULL && ptr->inicializado) {
		free(ptr->nome);
		free(ptr->corDoCabelo);
		free(ptr->corDaPele);
		free(ptr->corDosOlhos);
		free(ptr->anoNascimento);
		free(ptr->genero);
		free(ptr->homeworld);
	}
}

//------------------------------------------------------ Fila Dinamica

/// <summary>
/// Realiza inicializacao da fila com valores padroes
/// </summary>
/// <param name="fila">Fila a ser inicializada</param>
void inicializaFila(pilha_t* fila, uint32_t tamMax) {
	if (fila != NULL) {
		fila->primeiro = NULL;
		fila->ultimo = NULL;
		fila->numItens = 0;
		fila->tamMax = tamMax;
	}
}

/// <summary>
/// Realiza insercao na fila
/// </summary>
/// <param name="fila">Fila a ter elemento inserido</param>
/// <param name="dado">Dado a ser inserido</param>
void enfileira(pilha_t* fila, Personagem_t* dado) {
	if (fila != NULL) {
		itemPilha_t* novo = malloc(sizeof(itemPilha_t));

		if(novo != NULL){
			novo->dado = dado;
			novo->prox = NULL;
			
			if (fila->ultimo != NULL) {
				fila->ultimo->prox = novo;
				fila->ultimo = fila->ultimo->prox;
			}else {
				fila->primeiro = fila->ultimo = novo;
			}
			
			fila->numItens++;
		}
	}
}

/// <summary>
/// Realiza remocao de item de fila
/// </summary>
/// <param name="fila">Fila a ter elemento removido</param>
/// <returns>Dado removido da fila</returns>
Personagem_t* desenfileira(pilha_t* fila) {
	Personagem_t* dado = NULL;
	
	if (fila != NULL) {
		dado = fila->primeiro->dado;
		fila->primeiro = fila->primeiro->prox;
		
		fila->numItens--;
	}

	return dado;
}

/// <summary>
/// Realiza impressao de fila
/// </summary>
/// <param name="lista">Objeto de fila de armazenamento</param>
void imprime(pilha_t* fila) {
	if (fila != NULL) {
		uint32_t itens = fila->numItens;

		itemPilha_t* atual = fila->primeiro;
		for (uint32_t i = 0; i < itens; i++) {
			printf("[%d] ", i);
			imprimePersonagem(atual->dado);
			atual = atual->prox;
		}

	}
}

/// <summary>
/// Desaloca Memoria de fila
/// </summary>
/// <param name="lista">Objeto fila a ser desalocado</param>
void filaClear(pilha_t* fila) {

	if (fila != NULL) {
		uint32_t itens = fila->numItens;
				
		itemPilha_t* atual = fila->primeiro, *anterior = NULL;
		for (uint32_t i = 0; i < itens; i++) {
			anterior = atual;
			atual = atual->prox;

			destrutorPersonagem(anterior->dado);
			free(anterior);
		}

		free(fila);
	}
}

//----------------------------------------------------- Lida com Json e Strings

/// <summary>
/// Realiza quebra de string baseada em delimitador
/// </summary>
/// <param name="str">string a ser realizada split</param>
/// <param name="caracter">caracter delimitador</param>
/// <returns>Array de string contendo string original apos split</returns>
stringArray split(string str, char caracter) {
	stringArray retorno = malloc(sizeof(string)); //Aloca array de string
	stringArray tmp; //Temporario

	char* copia = malloc(BUFFER_64); //Aloca memoria para copia 
	int pos = 0;
	size_t len = strlen(str);

	if (copia != NULL && retorno != NULL) {
		int pos = 1;
		strncpy(copia, str, BUFFER_64); //Realiza copia de string original

		retorno[pos - 1] = copia; //Armazena endereco do primeiro bloco da string

		for (int i = 1; i < len; i++) {

			if (copia[i] == caracter) { //Sempre que encontrar delimitador

				tmp = realloc(retorno, (++pos) * sizeof(string)); //Realoca vetor de string

				if (tmp != NULL) {
					retorno = tmp;
					copia[i] = '\0'; //Realiza quebra da string principal
					retorno[pos - 1] = &copia[i + 1]; //Armazena endereco do bloco em array de strings
				}

			}
		}

	}

	return retorno;
}

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