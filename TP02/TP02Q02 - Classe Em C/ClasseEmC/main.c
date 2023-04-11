//--------------- Inclusoes

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>

//--------------- Constantes

#define SUCESSO (0)

#define TRUE (1 == 1)
#define FALSE (1 != 1)

#define BUFFER_64 (64)
#define BUFFER_128 (128)
#define BUFFER_256 (256)
#define BUFFER_512 (512)
#define BUFFER_1024 (1024)

//--------------- Tipos

typedef char* string;
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

//--------------- Fim Assinaturas de Funcoes

//------------------------------------------------------ Principal

int main(int argc, char** argv) {
	Personagem_t* personagem;

	char caminho[BUFFER_64];
	lerBufferStdin(caminho, BUFFER_64); //Ler entrada Stdin

	while (caminho[0] != 'F' && caminho[1] != 'I' && caminho[2] != 'M') { //Se nao atingiu FIM, continua processo.
		
		personagem = novoPersonagem(); //Cria novo personagem

		if (personagem != NULL) { //Confirma alocacao de memoria

			personagem->ler(personagem, caminho);
			personagem->imprimir(personagem); 

		}

		destrutorPersonagem(personagem); //Desaloca personagem
		free(personagem);

		lerBufferStdin(caminho, BUFFER_64); //Ler nova entrada
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
/// <param name="novo">Endereco de personagem já gerado pelo principal</param>
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
	Personagem_t *reg = (Personagem_t*)registro;
	
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
	char caminho[BUFFER_256] = { "C:" }, buffer[BUFFER_1024];

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