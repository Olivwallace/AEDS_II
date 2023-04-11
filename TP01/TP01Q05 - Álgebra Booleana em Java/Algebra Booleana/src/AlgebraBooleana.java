/**
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @file AlgebraBooleana.java
 * @brief TP01Q05 — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 24-02-2023
 */

class AlgebraBooleana {

    public static Stack pilha;
    public static Stack pilhaAux;

    public static void main(String[] args) {
        String str = MyIO.readLine();

        while (!fimExpressoes(str)){
            MyIO.println(((realizaAlgebra(str))?1:0));
            str = MyIO.readLine();
        }
    }

    //---------------- Metodos Manipulacao Expressao

    /**
     * Metodo responsavel por calcular a expressao lida.<br>
     * Modelo de Expressao: 2 0 0 and(not(A) , not(B))
     * @param str Expressao no formato string.
     * @return TRUE: 1 | FALSE: 0
     */
    public static boolean realizaAlgebra(String str){
        carregaPilhaComExpressao(reduzExpressao(str));
        pilhaAux = new Stack(pilha.getTamMax());

        while (!pilha.pilhaEstaVazia()){      //Enquanto pilha principal nao estiver vazia realiza operacoes.

            char valor = pilha.desempilhar();

             switch (valor){
                 case 'o': //Flag de operacao OR
                     pilha.empilhar((char)realizaOR()); //Empilha resultado de OR
                     break;
                 case 'a': //Flag de operacao AND
                     pilha.empilhar((char)realizaAND()); //Empilha resultado de AND
                     break;
                 case 'n': //Flag de operacao NOT
                     pilha.empilhar((char)realizaNOT()); //Empilha resultado de NOT
                     break;
                 default:
                     pilhaAux.empilhar(valor); //Valores diferente de operacao empilha em pilha auxiliar.
             }
        }

        return pilhaAux.desempilhar() == 1; //Verifica se ultimo valor em pilha auxiliar é 1 ou 0.
    }

    /**
     * Metodo para armazenar em pilha a expressao reduzida.
     * @param expressaoReduzida Expressao reduzida a ser enviada para pilha.
     */
    public static void carregaPilhaComExpressao(String expressaoReduzida){
        int max = expressaoReduzida.length();
        pilha = new Stack(max);

        for(int i = 0; i < max; i++){
            pilha.empilhar(expressaoReduzida.charAt(i));
        }
    }

    /**
     * Realiza redução da expressao para facilitar a leitura.
     * @param expressao Expressao completa em formato String
     * @return Expressao reduzida, com valores settados.
     */
    public static String reduzExpressao(String expressao){
        int numEntradas = parseInt(expressao.charAt(0)); //Obtem numero de entradas.

        //Ler entradas de expressao padrão. EX: 2 0 0 and(not(A) , not(B))
        int A = parseInt(expressao.charAt(2));
        int B = parseInt(expressao.charAt(4));
        int C = 0;
        if(numEntradas > 2) C = parseInt(expressao.charAt(6)); //Possivel Entradas

        int i = 2 + (numEntradas * 2); // Recalcula i para posicao pos entradas.

        String expReduzida = "";
        char caracter;

        //Enquanto não atingir o ultima posicao da expressao realiza leitura e armazena em String.
        while (i < expressao.length()){

            caracter = expressao.charAt(i);

            if(ehLetra(caracter) || caracter == '(' || caracter == ')'){
                switch (caracter){
                    case 'A':
                        expReduzida += A; //Se 'A' altera para valor de entrada A.
                        break;
                    case 'B':
                        expReduzida += B; //Se 'B' altera para valor de entrada B.
                        break;
                    case 'C':
                        expReduzida += C; //Se 'C' altera para valor de entrada C.
                        break;
                    case 'o':
                        expReduzida += caracter;     // Sendo caracteres relativos a expressao
                        i+=1;                        // armazena na String e salta valores sobressalentes.
                        break;
                    case 'a':
                    case 'n':
                        expReduzida += caracter;
                        i+=2;
                        break;
                    default:
                        expReduzida += caracter;
                }
            }

            i++;
        }

        return expReduzida;
    }

    //---------------- Metodos Logicos

    /**
     * Realiza operacao OR sobre valores armazenados na pilha auxiliar.
     * @return Inteiro resultante da operação OR do bloco análisado.
     */
    public static int realizaOR(){
        Stack valores = new Stack(pilhaAux.getNumItens());
        char valor = pilhaAux.desempilhar();

        while (valor != ')'){ //Enquanto não desempilhar o bloco de expressão or, busca valores e armazena em pilha temporária.
            if(ehInteiro(valor)) {
                valores.empilhar((char)parseInt(valor));
            }
            valor = pilhaAux.desempilhar();
        }

        while (valores.getNumItens() > 1){ //Enquanto houver mais de um item na pilha auxiliar realiza or dois a dois.
            int A = parseInt(valores.desempilhar()), B = parseInt(valores.desempilhar());
            int S = ((A == 1 || B == 1)?1:0);
            valores.empilhar((char)S);
        }

        return parseInt(valores.desempilhar());
    }

    /**
     * Realiza operacao AND sobre valores armazenados na pilha auxiliar.
     * @return Inteiro resultante da operação AND do bloco análisado.
     */
    public static int realizaAND(){
        Stack valores = new Stack(pilhaAux.getNumItens());
        char valor = pilhaAux.desempilhar();

        while (valor != ')'){ //Enquanto não desempilhar o bloco de expressão and, busca valores e armazena em pilha temporária.
            if(ehInteiro(valor)) {
                valores.empilhar((char)parseInt(valor));
            }
            valor = pilhaAux.desempilhar();
        }

        while (valores.getNumItens() > 1){ //Enquanto houver mais de um item na pilha auxiliar realiza and dois a dois.
            int A = parseInt(valores.desempilhar()), B = parseInt(valores.desempilhar());
            int S = ((A == 1 && B == 1)?1:0);
            valores.empilhar((char)S);
        }

        return parseInt(valores.desempilhar());
    }

    /**
     * Realiza operação NOT sobre valores armazenados na pilha auxiliar.
     * @return Inteiro resultante da operação NOT
     */
    public static int realizaNOT(){
        int A = 0;
        char valor = pilhaAux.desempilhar();

        while (valor != ')'){ //Enquanto não desempilhar o bloco de expressão not, busca valores.
            if(ehInteiro(valor)) {
                A = parseInt(valor);
            }
            valor = pilhaAux.desempilhar();
        }

        return (A == 1)?0:1;
    }

    //---------------- Metodos Auxiliares

    /**
     * Metodo para verificar se caracter eh uma letra.
     * @param caracter Caracter verificado.
     * @return TRUE: Eh letra | FALSE: Nao eh letra
     */
     public static boolean ehLetra(char caracter){
        return (caracter >= 'a' && caracter <= 'z' || caracter >= 'A' && caracter <= 'Z');
     }

    /**
     * Metodo para converter um caracter, para correspondente valor inteiro.
     * @param caracter Caracter de inteiro
     * @return Valor inteiro correspondente || 0: Valores diferente de caracter de inteiro.
     */
     public static int parseInt(char caracter){
         int retorno = -1;

         if(ehInteiro(caracter)) {
             if (caracter >= '0') retorno = ((int) caracter - 48);
             else retorno = caracter;
         }

         return retorno;
     }

    /**
     * Metodo para verificar se caracter eh um inteiro.
     * @param caracter Caracter verificado.
     * @return TRUE: Eh inteiro | FALSE: Nao eh inteiro
     */
     public static boolean ehInteiro(char caracter){
        return (caracter >= 0 && caracter <= 9) || (caracter >= '0' && caracter <= '9');
     }

    /**
     * Metodo que verifica se atingiu fim de arquivo de entrada.
     *
     * @param str Ultima String lida, a ser comparada se eh igual a flag de parada;
     * @return TRUE: String lida indica flag parada | FALSE: String lida não eh flag
     */
    public static boolean fimExpressoes(String str) {
        return str.length() == 1;
    }
}

/**
 * Classe Pilha Auxiliar - Responsável por armazenar expressao e valores durante a execução do programa
 */
class Stack {

    private int tamMax = 0;
    private int topoAtual = -1;
    private int numItens = 0;
    private char[] Stack = null;
    private boolean estaVazia = true;

    //------------ Contrutores ------------------//

    Stack(int max) {
        setTamMax(max);
        setTopoAtual(-1);
        setNumItens(0);
        setStack(criaStack(max));
    }

    Stack(int max, char valor) {
        setTamMax(max);
        setTopoAtual(-1);
        setNumItens(1);
        setStack(criaStack(max));

        empilhar(valor);
    }

    //------------ Metodos Pilha ---------------//

    /**
     * Cria uma pilha alocada em vetor.
     * @param tamMax Tamanho maximo da pilha
     * @return Vetor de char interpretado como pilha.
     */
    public char[] criaStack(int tamMax) {
        return new char[tamMax];
    }

    /**
     * Responsável por empilhar itens na pilha.
     * @param valor Valor a ser empilhado.
     */
    public void empilhar(char valor) {
        int topo = getTopoAtual();

        if (topo + 1 <= getTamMax()) { //Se existe espaço empilha

            this.Stack[topo + 1] = valor;
            setTopoAtual(topo + 1);
            setNumItens(getNumItens() + 1);

            setEstaVazia(false); //Altera estado da pilha para populada.
        }

    }

    /**
     * Responsável por desempilhar itens.
     * @return Item do topo ou '#' representando null.
     */
    public char desempilhar() {
        char valor = '#';

        if(!pilhaEstaVazia()){ //Se existem itens na pilha: desempilhar
            int topo = getTopoAtual();
            valor = this.Stack[topo];

            setTopoAtual(topo - 1);
            setNumItens(getNumItens() - 1);

            if(getNumItens() == 0) setEstaVazia(true); //Altera estado da pilha se ficar vazia.
        }

        return valor;
    }

    //---------- Getter's and Setter's

    public void setTopoAtual(int i) {
        this.topoAtual = i;
    }

    public int getTopoAtual() {
        return this.topoAtual;
    }

    public void setTamMax(int tam) {
        this.tamMax = tam;
    }

    public int getTamMax() {
        return this.tamMax;
    }

    public void setStack(char[] stack) {
        this.Stack = stack;
    }

    public void setNumItens(int numItens){
        this.numItens = numItens;
    }

    public int getNumItens(){
        return this.numItens;
    }

    public void setEstaVazia(boolean estado){
        this.estaVazia = estado;
    }

    public boolean pilhaEstaVazia(){
        return this.estaVazia;
    }
}

