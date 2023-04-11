/**
 * @file IsJava.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP01Q15 — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 24-02-2023
 */

class IsJavaRecursivo {

    public static void main(String[] args){
        String str = MyIO.readLine();

        while(!ehFIM(str)){
            MyIO.println(avaliaString(str));
            str = MyIO.readLine();
        }

    }

    //------------ Metodos Avaliadores String

    /**
     * Avalia se string eh composta por apenas consoantes ou vogais ou se eh um numero inteiro e/ou real.
     * @param str String a ser avalida.
     * @return String contendo resposta 'SIM' ou 'NAO':<br>
     * x1 = Apenas consoantes?<br>
     * x2 = Apenas vogais?<br>
     * x3 = Eh Inteiro?<br>
     * x4 = Eh Real?
     */
    public static String avaliaString(String str){
        String resultado = "";
        resultado += (compostaPorVogais(str))? "SIM " : "NAO ";
        resultado += (compostaPorConsoantes(str))? "SIM ": "NAO ";
        resultado += (ehInteiro(str))? "SIM " : "NAO ";
        resultado += (ehReal(str))? "SIM " : "NAO ";
        return resultado;
    }

    /**
     * Metodo sobrecarregado para verifica se string eh composta apenas por vogais.
     * @param str String analisada.
     * @return TRUE: Composta apenas por vogais | FALSE: Nao eh composta apenas por vogais
     */
    public static boolean compostaPorVogais(String str){
        return compostaPorVogais(str, 0);
    }

    /**
     * Metodo para verifica se string eh composta apenas por vogais.
     * @param str String analisada.
     * @param index Posicao de partida.
     * @return TRUE: Composta apenas por vogais | FALSE: Nao eh composta apenas por vogais
     */
    public static boolean compostaPorVogais(String str, int index){
        boolean ehComposta;

        if(index == (str.length() - 1)){ //Caso Base - Ultima posicao String
            ehComposta = isVolgal(str.charAt(index));
        }else{
            ehComposta = compostaPorVogais(str, index + 1) && isVolgal(str.charAt(index));
        }

        return ehComposta;
    }

    /**
     * Metodo sobrecarregado para verifica se string eh composta apenas por consoantes.
     * @param str String analisada.
     * @return TRUE: Composta apenas por consoantes | FALSE: Nao eh composta apenas por consoantes
     */
    public static boolean compostaPorConsoantes(String str){
        return compostaPorConsoantes(str, 0);
    }

    /**
     * Metodo para verifica se string eh composta apenas por consoantes.
     * @param str String analisada.
     * @param index Posicao de partida.
     * @return TRUE: Composta apenas por consoantes | FALSE: Nao eh composta apenas por consoantes
     */
    public static boolean compostaPorConsoantes(String str, int index){
        boolean ehComposta;

        if(index == (str.length() - 1)){ //Caso Base - Ultima posicao String
            ehComposta = isConsoante(str.charAt(index));
        }else{
            ehComposta = compostaPorConsoantes(str, index + 1) && isConsoante(str.charAt(index));
        }

        return ehComposta;
    }

    /**
     * Metodo sobrecarregado para verificar se string eh um valor inteiro.
     * @param str String analisada.
     * @return TRUE: Eh um valor inteiro | FALSE: Nao eh um valor inteiro
     */
    public static boolean ehInteiro(String str){
        return ehInteiro(str, 0);
    }

    /**
     * Metodo sobrecarregado para verificar se string eh um valor inteiro.
     * @param str String analisada.
     * @param index Posicao de partida.
     * @return TRUE: Eh um valor inteiro | FALSE: Nao eh um valor inteiro
     */
    public static boolean ehInteiro(String str, int index){
        boolean ehInteiro;

        if(index == (str.length() - 1)){ //Caso Base - Ultima posicao String
            ehInteiro = isDigit(str.charAt(index));
        }else{
            ehInteiro = ehInteiro(str, index + 1) && isDigit(str.charAt(index));
        }

        return ehInteiro;
    }

    /**
     * Metodo sobrecarregado para verificar se uma string eh um valor real.
     * @param str String analisada.
     * @return TRUE: Eh um valor real | FALSE: Nao eh um valor real
     */
    public static boolean ehReal(String str){
        return ehReal(str, 0, 0);
    }

    /**
     * Metodo recursivo para verifica se uma string eh um numero Real.
     * @param str String analisda.
     * @param index Posicao de partida.
     * @param count Contador de ponto e virgula (Padrao = 0)
     * @return TRUE: Eh um valor real | FALSE: Nao eh um valor real
     */
    public static boolean ehReal(String str, int index, int count){
        boolean real = false;

        if(index == (str.length() - 1)){ //Caso Base - chegou ao fim.
            real = (count <= 1);
        } else if (str.charAt(index) == '.' || str.charAt(index) == ',') { //Passo recursivo - Eh um ponto ou virgula.
            real = ehReal(str, index + 1, count + 1);
        }else{ //Passo recursivo - Pode ser um digito ou nao.
            real = ehReal(str, index + 1, count) && isDigit(str.charAt(index));
        }

        return real;
    }


    //------------ Fim Metodos Avaliadores String


    //------------ Metodos is

    /**
     * Verifica se caracter recebido eh um vogal.
     * @param caracter Caracter analisado;
     * @return TRUE: Eh vogal. | FALSE: Nao eh vogal.
     */
    public static boolean isVolgal(char caracter){
        String vogais = "AaEeIiOoUu";
        boolean ehVogal = false;

        //Verifica se caracter pertence a string de vogais, parando na primeira ocorrência de char na str.
        for(int i = 0; i < vogais.length() && !ehVogal; i++){

            if (caracter == vogais.charAt(i)) {
                ehVogal = true;
            }

        }

        return ehVogal;
    }

    /**
     * Verifica se caracter recebido eh uma cosoante.
     * @param caracter Caracter analisado;
     * @return TRUE: Eh cosoante. | FALSE: Nao eh cosoante.
     */
    public static boolean isConsoante(char caracter){
        return isLetra(caracter) && !isVolgal(caracter);
    }

    /**
     * Verifica se caracter recebido eh um digito.
     * @param caracter Caracter a ser analisado;
     * @return TRUE: Eh digito. | FALSE: Nao eh digito.
     */
    public static boolean isDigit(char caracter){
        return (caracter >= '0' && caracter <= '9');
    }

    /**
     * Verifica se caracter recebido eh uma letra.
     * @param caracter Caracter a ser analisado;
     * @return TRUE: Eh letra. | FALSE: Nao eh letra.
     */
    public static boolean isLetra(char caracter){
        return (caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z');
    }

    //------------ Fim Metodos is


    /**
     * Metodo que verifica se eh fim de arquivo de entrada.
     * @param str Ultima String lida, a ser comparada se eh "FIM";
     * @return TRUE: String lida indica "FIM" | FALSE: String lida não eh "FIM"
     */
    public static boolean ehFIM(String str){
        boolean fim = false;

        //Verifica se tamanho da string eh compativel com "FIM" para validar.
        if(str.length() == 3)
            fim  = str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';

        return fim;
    }

}
