/**
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @file AlgebraBooleanaRecursiva.java
 * @brief TP01Q14 - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 28-02-2023
 */

class AlgebraBooleanaRecursiva {

    public static void main(String[] args) {
        String str = MyIO.readLine();

        while (!fimExpressoes(str)){
            MyIO.println(((realizaAlgebra(str))?1:0));
            str = MyIO.readLine();
        }
    }

    /**
     * Metodo intermediaria de algebra booleana.
     * @param str String contendo uma expressão booleana com padrão pre-definido:<br>
     *            EX: 2 0 0 and(not(A) , not(B))
     * @return TRUE: 1 | FALSE: 0
     */
    public static boolean realizaAlgebra(String str){
        String strComprimida = reduzExpressao(str);
        return  lerExpressao(strComprimida, 0, strComprimida.length()).charAt(0) == '1';
    }

    /**
     * Metodo Recursivo para ler expressao booleana e execultar comandos.
     * @param expressao Expressao booleana reduzida: EX: o ( a ( 1 1 0 ) 0 )
     * @param pos Posicao inicial da expressao.
     * @param posFim Posicao final da expressao
     * @return Microexpressoes resultantes de interacao recursiva.
     */
    public static String lerExpressao(String expressao, int pos, int posFim){
        int inicio = pos, fim, resultado;
        String conteudoInterno = "", operacaoSeguinte = "";

        String retorno = ""; //Caso base, sem microexpressao valida.

        if(pos < posFim){ //Metodo Recursivo

            char valor = expressao.charAt(pos); //Obtem valor atual

            if(ehLetra(valor)){

                fim = buscaFim(expressao, pos + 1); //Obtem fim da expressao atual.

                operacaoSeguinte = lerExpressao(expressao, fim, posFim); //Chamada Recursiva para realiza operação seguinte.
                conteudoInterno = lerExpressao(expressao, inicio + 2, fim); //Chamada Recursiva para obter valores internos da expressao.

                switch (valor){
                    case 'a': //AND
                        resultado = execultaAND(conteudoInterno);
                        break;
                    case 'o': //OR
                        resultado = execultaOR(conteudoInterno);
                        break;
                    case 'n': //NOT
                        resultado = execultaNOT(conteudoInterno);
                        break;
                    default:
                        resultado = 0;
                }

                //Retorno eh uma microexpressao da chamada recursiva da operacao seguinte com valor obtido atual.
                retorno = resultado + operacaoSeguinte;

            } else if (ehInteiro(valor)) {

                //Se numero busca outros recursivamente e monta microexpressao.
                retorno = valor + lerExpressao(expressao, inicio + 1, posFim);
            }
        }

        return retorno; //Retorna microexpressao resultante de interacoes recursivas.
    }

    /**
     * Realiza busca do termino da expressao.
     * @param str Expressao booleana.
     * @param posInicio Posicao de Partida
     * @return Indice do terminador de expressao.
     */
    public static int buscaFim(String str, int posInicio){
        int count = 1, i = posInicio + 1;
        char valor;

        if(posInicio < str.length()){
            while (count > 0){ //Enquanto não encontrar ')' fechamento da expressao analisada, percorre expressao.
                valor = str.charAt(i);

                if(valor == '('){ //Se encontrar uma nova abertura soma.
                    count++;
                }else if(valor == ')'){ //Encontrou correspondente fecha.
                    count--;
                }

                i++;
            }
        }
        return i;
    }

    //------------------- Metodos Logicos

    /**
     * Realiza operaca NOT sobre string recebida;
     * @param valores String contendo valor a ser operado.
     * @return TRUE: 1 | FALSE: 0
     */
    public static int execultaNOT(String valores){
        int valor =  parseInt(valores.charAt(0));
        return (valor == 1)?0:1;
    }

    /**
     * Realiza operacao OR sobre string recebida.
     * @param valores String contendo operandos.
     * @return TRUE: 1 | FALSE: 0
     */
    public static int execultaOR(String valores){
        int qtdValores = valores.length();
        int retorno = parseInt(valores.charAt(0));
        int valor;

        for(int i = 1; i < qtdValores; i++){ //Enquanto não tiver aplicado operacao sobre todos valores repete.
            valor = parseInt(valores.charAt(i));
            retorno = (retorno == 1 || valor == 1)?1:0;
        }

        return retorno;
    }

    /**
     * Realiza operacao AND sobre string recebida.
     * @param valores String contendo operandos.
     * @return TRUE: 1 | FALSE: 0
     */
    public static int execultaAND(String valores){
        int qtdValores = valores.length();
        int retorno = parseInt(valores.charAt(0));
        int valor;

        for(int i = 1; i < qtdValores; i++){ //Enquanto não tiver aplicado operacao sobre todos valores repete.
            valor = parseInt(valores.charAt(i));
            retorno = (retorno == 1 && valor == 1)?1:0;
        }

        return retorno;
    }

    //---------------- Metodos Auxiliares

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
