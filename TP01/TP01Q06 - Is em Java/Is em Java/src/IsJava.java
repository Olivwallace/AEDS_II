/**
 * @file IsJava.java
 * @author 784778 — Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP01Q06 — Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 24-02-2023
 */

class IsJava {

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
        resultado += (compostaPorCosoantes(str))? "SIM ": "NAO ";
        resultado += (ehInteiro(str))? "SIM " : "NAO ";
        resultado += (ehReal(str))? "SIM " : "NAO ";
        return resultado;
    }

    /**
     * Avalia se string recebida eh composta apenas por vogais.
     * @param str String a ser avaliada;
     * @return TRUE: Composta apenas por vogais | FALSE: Composta por simbolos diversos.
     */
    public static boolean compostaPorVogais(String str){
        int i = 0, tamStr = str.length();
        boolean ehComposta = true;

        while (i < tamStr && ehComposta){

            if(!isVolgal(str.charAt(i))) //Se char nao eh vogal --> str nao eh composta apenas por vogais.
                ehComposta = false;

            i++;
        }

        return ehComposta;
    }

    /**
     * Avalia se string recebida eh composta apenas por consoantes.
     * @param str String a ser avaliada;
     * @return TRUE: Composta apenas por consoantes | FALSE: Composta por simbolos diversos.
     */
    public static boolean compostaPorCosoantes(String str){
        int i = 0, tamStr = str.length();
        boolean ehComposta = true;

        while (i < tamStr && ehComposta){

            if(!isConsoante(str.charAt(i))) //Se char nao eh consoante --> str nao eh composta apenas por consoantes.
                ehComposta = false;

            i++;
        }

        return ehComposta;
    }

    /**
     * Avalia se string recebida eh um numero inteiro.
     * @param str String a ser avalida;
     * @return TRUE: Eh numero inteiro. | FALSE: Nao eh numero inteiro.
     */
    public static boolean ehInteiro(String str){
        int i = 0, tamStr = str.length();
        boolean inteiro = true;

        while (i < tamStr && inteiro){

            if(!isDigit(str.charAt(i))) //Se char nao eh digito --> Str nao eh inteiro
                inteiro = false;

            i++;
        }

        return inteiro;
    }

    /**
     * Avalia se string recebida eh um numero real.
     * @param str String a ser avalida;
     * @return TRUE: Eh numero real. | FALSE: Nao eh numero real.
     */
    public static boolean ehReal(String str){
        int i = 0, tamStr = str.length();
        boolean real = true;
        int coutVirgulaPonto = 0;

        while (i < tamStr && real){

            if(str.charAt(i) == '.' || str.charAt(i) == ','){

                coutVirgulaPonto++;
                if(coutVirgulaPonto > 1) real = false; //Se tem + de 1 '.' ou ',' --> Str nao eh real

            }else if(!isDigit(str.charAt(i))){ //Se char nao eh digito --> Str nao eh inteiro
                 real = false;
            }

            i++;
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

