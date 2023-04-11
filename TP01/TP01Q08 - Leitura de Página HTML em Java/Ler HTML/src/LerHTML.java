import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @file LerHTML.java
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP01Q08 -  Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 26-02-2023
 */


public class LerHTML {

    public static void main(String[] args){
        String str = MyIO.readLine();

        while(!ehFIM(str)){
            String url = MyIO.readLine();
            MyIO.println(contaCaracteresEmHTML(url) + str);
            str = MyIO.readLine();
        }

    }

    public static String contaCaracteresEmHTML(String url){
        String htmlString = getHtml(url);
        int [] valores = new int[25];
        char caracter;

        for(int i = 0; i < htmlString.length(); i++){

            caracter = htmlString.charAt(i);

            if(isLetra(caracter)){

                if(isConsoante(caracter)){
                    valores[22]++;
                }else{
                    contabilizaVogais(caracter, valores);
                }

            } else if (caracter == '<') {
                if(htmlString.charAt(i + 1) == 'b' && htmlString.charAt(i + 2) == 'r' && htmlString.charAt(i + 3) == '>')
                    valores[23]++;
                else if (htmlString.charAt(i + 1) == 't' && htmlString.charAt(i + 2) == 'a' && htmlString.charAt(i + 3) == 'b'
                        && htmlString.charAt(i + 2) == 'l' && htmlString.charAt(i + 3) == 'e' && htmlString.charAt(i + 3) == '>') {
                    valores[24]++;
                }
            }else{
                contabilizaAcentuados(caracter, valores);
            }
        }

        return prepararStringImpressao(valores);
    }

    public static String prepararStringImpressao(int[] valoresContados){
        String str = "a("+valoresContados[0]+")" + " e("+valoresContados[1]+")" + " i("+valoresContados[2]+")" +
                " o("+valoresContados[3]+")" + " u("+valoresContados[4]+") " + (char)225 + "("+valoresContados[5]+") " +
                (char)233 + "("+valoresContados[6]+") " + (char)237 + "("+valoresContados[7]+") " + (char)243 + "("+valoresContados[8]+") " +
                (char)250 + "("+valoresContados[9]+") " + (char)224 + "("+valoresContados[10]+") " + (char)232 + "("+valoresContados[11]+") " +
                (char)236 + "("+valoresContados[12]+") " + (char)242 + "("+valoresContados[13]+") " + (char)249 + "("+valoresContados[14]+") " +
                (char)227 + "("+valoresContados[15]+") " + (char)245 + "("+valoresContados[16]+") " + (char)226 + "("+valoresContados[17]+") " +
                (char)234 + "("+valoresContados[18]+") " + (char)238 + "("+valoresContados[19]+") " + (char)244 + "("+valoresContados[20]+") " +
                (char)251 + "("+valoresContados[21]+")" + " consoante("+valoresContados[22]+")" +
                " <br>("+valoresContados[23]+")" + " <table>("+valoresContados[24]+") ";

        return str;
    }




    /**
     * Verifica se caracter recebido eh um vogal.
     * @param caracter Caracter analisado;
     * @return TRUE: Eh vogal. | FALSE: Nao eh vogal.
     */
    public static boolean isVogal(char caracter){
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
        return isLetra(caracter) && !isVogal(caracter);
    }

    /**
     * Verifica se caracter recebido eh uma letra.
     * @param caracter Caracter a ser analisado;
     * @return TRUE: Eh letra. | FALSE: Nao eh letra.
     */
    public static boolean isLetra(char caracter){
        return (caracter >= 'a' && caracter <= 'z');// || (caracter >= 'A' && caracter <= 'Z');
    }


    public static void contabilizaAcentuados(char caracter, int[] valoresDeSomas){

        switch (caracter) {
            case 224: //à
                valoresDeSomas[10]++;
                break;
            case 225: //á
                valoresDeSomas[5]++;
                break;
            case 226: //â
                valoresDeSomas[17]++;
                break;
            case 227: //ã
                valoresDeSomas[15]++;
                break;
            case 232: //è
                valoresDeSomas[11]++;
                break;
            case 233: //é
                valoresDeSomas[6]++;
                break;
            case 234: //ê
                valoresDeSomas[18]++;
                break;
            case 236: //ì
                valoresDeSomas[12]++;
                break;
            case 237: //í
                valoresDeSomas[7]++;
                break;
            case 238: //î
                valoresDeSomas[19]++;
                break;
            case 242: //ò
                valoresDeSomas[13]++;
                break;
            case 243: //ó
                valoresDeSomas[8]++;
                break;
            case 244: //ô
                valoresDeSomas[20]++;
                break;
            case 245: //õ
                valoresDeSomas[16]++;
                break;
            case 249: //ù
                valoresDeSomas[14]++;
                break;
            case 250: //ú
                valoresDeSomas[9]++;
                break;
            case 251: //û
                valoresDeSomas[21]++;
                break;
            default:
                // caso o caracter não se enquadre em nenhum dos casos acima
                break;
        }



    }

    public static void contabilizaVogais(char caracter, int[] valoresDeSomas){
        switch (caracter){
            case 'a':
                valoresDeSomas[0]++;
                break;
            case 'e':
                valoresDeSomas[1]++;
                break;
            case 'i':
                valoresDeSomas[2]++;
                break;
            case 'o':
                valoresDeSomas[3]++;
                break;
            case 'u':
                valoresDeSomas[4]++;
                break;
        }
    }


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

    public static String getHtml(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is, Charset.forName("ISO-8859-1")));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }

        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here

        }

        return resp;
    }

}
