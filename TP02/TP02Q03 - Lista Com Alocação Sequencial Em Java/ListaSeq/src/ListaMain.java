/**
 * @file ListaMain.java
 * @author 784778 ? Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP02Q03 ? Algoritmo e Estruturas de Dados II (PUC-Minas 1�/2023)
 * @date 20-03-2023
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//------------------------- Principal
public class ListaMain{

    public static void main(String[] args){
        MyIO.setCharset("UTF-8");
        String caminho = MyIO.readString();

        ListaSeq listaPersonagens = new ListaSeq(); //Inicializa Lista

        while (!caminho.contains("FIM")){ //Carrega lista com primeiras entradas
            try {
                listaPersonagens.insereFinal(Personagem.toRead(caminho));
                caminho = MyIO.readString();
            }catch (Exception ignored){}
        }

        int numOperacoesLista = MyIO.readInt(); //Ler numero de operacoes restantes

        operaLista(listaPersonagens, numOperacoesLista); //Realiza operacoes
        listaPersonagens.imprime(); //Imprime conteudo final da lista
    }

    /**
     * Metodo para realiza operacoes de insercao e remocao determinadas por entrada externa.
     * @param listaPersonagens Lista de personagens operada
     * @param numOp Numero de operacoes a ser realizadas
     */
    public static void operaLista(ListaSeq listaPersonagens, int numOp){
        Personagem p;

        for(int i = 0; i < numOp; i++){
            try {

                String[] operacao = MyIO.readLine().split(" "); //Ler linha de comando

                switch (operacao[0]) {
                    case "II":
                        listaPersonagens.insereInicio(Personagem.toRead(operacao[1]));
                        break;
                    case "I*":
                        listaPersonagens.inserePosicao(Personagem.toRead(operacao[2]),
                                                                    Integer.parseInt(operacao[1]));
                        break;
                    case "IF":
                        listaPersonagens.insereFinal(Personagem.toRead(operacao[1]));
                        break;
                    case "RI":
                        p = listaPersonagens.removeInicio();
                        MyIO.println("(R) " + p.getNome());
                        break;
                    case "R*":
                        p = listaPersonagens.removePosicao(Integer.parseInt(operacao[1]));
                        MyIO.println("(R) " + p.getNome());
                        break;
                    case "RF":
                        p = listaPersonagens.removeFinal();
                        MyIO.println("(R) " + p.getNome());
                        break;
                }

            }catch (Exception ignored){}
        }
    }

}

//---------------------------- Classe Personagem
class Personagem {

    //------------------- Atribultos

    private String nome;
    private int altura;
    private double peso;
    private String corDoCabelo;
    private String corDaPele;
    private String corDosOlhos;
    private String genero;
    private String anoNascimento;
    private String homeworld;

    //------------------- Construtor

    /**
     * Construtor de Clonagem
     * @param personagem Personagem a ser Clonado.
     */
    public Personagem(Personagem personagem){
        this.setNome( personagem.getNome() );
        this.setAltura( personagem.getAltura() );
        this.setPeso( personagem.getPeso() );
        this.setCorDoCabelo( personagem.getCorDoCabelo() );
        this.setCorDaPele( personagem.getCorDaPele() );
        this.setCorDosOlhos( personagem.getCorDosOlhos() );
        this.setAnoNascimento( personagem.getAnoNascimento() );
        this.setGenero( personagem.getGenero() );
        this.setHomeworld( personagem.getHomeworld() );
    }

    /**
     * Contrutor Padrao
     * @param nome Nome Personagem
     * @param altura Altura Personagem
     * @param peso Peso Personagem
     * @param corDoCabelo Cor Cabelo Personagem
     * @param corDaPele Cor Pele Personagem
     * @param corDosOlhos Cor Olhos Personagem
     * @param anoNascimento Nascimento Personagem
     * @param genero Genero Personagem
     * @param homeworld Homeworld Personagem
     */
    public Personagem(String nome, int altura, double peso, String corDoCabelo, String corDaPele,
                      String corDosOlhos, String anoNascimento, String genero, String homeworld){

        this.setNome(nome);
        this.setAltura(altura);
        this.setPeso(peso);
        this.setCorDoCabelo(corDoCabelo);
        this.setCorDaPele(corDaPele);
        this.setCorDosOlhos(corDosOlhos);
        this.setAnoNascimento(anoNascimento);
        this.setGenero(genero);
        this.setHomeworld(homeworld);

    }

    //------------------- Setter's

    /**
     * Altera nome
     * @param nome Novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Altera Altura
     * @param altura Nova altura.
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Altera Peso
     * @param peso Novo peso.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Altera cor do cabelo
     * @param corDoCabelo Nova cor
     */
    public void setCorDoCabelo(String corDoCabelo) {
        this.corDoCabelo = corDoCabelo;
    }

    /**
     * Altera cor da pele
     * @param corDaPele Nova cor
     */
    public void setCorDaPele(String corDaPele) {
        this.corDaPele = corDaPele;
    }

    /**
     * Altera cor dos olhos
     * @param corDosOlhos Nova cor
     */
    public void setCorDosOlhos(String corDosOlhos) {
        this.corDosOlhos = corDosOlhos;
    }

    /**
     * Altera genero
     * @param genero Nova genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Altera ano nascimento
     * @param anoNascimento novo ano nascimento
     */
    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    /**
     * Altera homeworld
     * @param homeworld novo homeworld
     */
    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    //------------------- Getter's

    /**
     * Recupera nome
     * @return nome personagem
     */
    public String getNome() {
        return nome;
    }

    /**
     * Recupera altura
     * @return altura personagem
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Recupera peso
     * @return peso personagem
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Recupera cor cabelo
     * @return cor do cabelo do personagem
     */
    public String getCorDoCabelo() {
        return corDoCabelo;
    }

    /**
     * Recupera cor da pele
     * @return cor da pele do personagem
     */
    public String getCorDaPele() {
        return corDaPele;
    }

    /**
     * Recupera cor dos olhos
     * @return cor dos olhos do personagem
     */
    public String getCorDosOlhos() {
        return corDosOlhos;
    }

    /**
     * Recupera genero
     * @return genero do personagem
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Recupera ano nascimento
     * @return ano nascimento do personagem
     */
    public String getAnoNascimento() {
        return anoNascimento;
    }

    /**
     * Recupera homeworld
     * @return homeworld do personagem
     */
    public String getHomeworld() {
        return homeworld;
    }

    //------------------- ToString, ToRead e Clone

    /**
     * Sobrescrita de toString para retornar registro do personagem
     * @return registro do personagem
     */
    @Override
    public String toString(){
        double peso = getPeso();
        int pesoInt = (int)peso;

        return String.format("## %s ## %s ## %s%s ## %s ## %s ## %s ## %s ## %s ## %s ## ",
                getNome(), getAltura(), pesoInt, pesoInt == peso ? "" : "." + (int)((peso - pesoInt) * 10),
                getCorDoCabelo(), getCorDaPele(), getCorDosOlhos(), getAnoNascimento(), getGenero(), getHomeworld()
        );
    }

    /**
     * Implementacao de Clone de um personagem
     * @return Object Personagem clone.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Personagem(this);
    }

    /**
     * Realiza a leitura de um registro de personagem
     * @return Instancia do personagem lido.
     */
    public static Personagem toRead(String caminho){
        Personagem novo = null;
        caminho = caminho.replace("�", "\u00e9");
        caminho = ""+ caminho;

        try {

            //Realiza abetura do buffer de entrada e ler da entrada padrao caminho para o registro
            BufferedReader buffer = new BufferedReader(new FileReader(caminho));
            String jsonStr = buffer.readLine(); //Realiza leitura do registro

            //Instancia um Objeto JSON relativo ao registro lido.
            JSONObject json = new JSONObject(jsonStr);
            buffer.close(); //Fecha arquivo

            //Instacia novo personagem com dados do registro
            novo = new Personagem(json.getString("name"),json.getInt("height"), json.getDouble("mass"),
                    json.getString("hair_color"), json.getString("skin_color"), json.getString("eye_color"),
                    json.getString("birth_year"), json.getString("gender"),json.getString("homeworld"));


        }catch (IOException ex) {
            MyIO.println(ex.getMessage());
        }

        return novo;
    }
}

//---------------------------- Classe Lista Sequencial

class ListaSeq {
    protected int tamMax;
    protected int numItens;
    protected Personagem[] lista;

    /**
     * Criar lista com tamanho 100;
     */
    ListaSeq(){
        this(100);
    }

    /**
     * Cria lista de tamanho determinado pelo usuario
     * @param tamMax
     */
    ListaSeq(int tamMax){
        this.tamMax = tamMax;
        this.numItens = 0;
        this.lista = new Personagem[tamMax];
    }

    /**
     * Realiza insercao no inicio da lista
     * @param dado Dado a ser inserido
     * @throws Exception MAX_RECHEAD - Lista Cheia
     */
    public void insereInicio(Personagem dado) throws Exception{

        if(numItens < tamMax) {
            for(int i = numItens; i > 0; i--){
                lista[i] = lista[i - 1];
            }

            lista[0] = dado;
            numItens++;
        }else{
            throw new Exception("MAX_RECHEAD");
        }
    }

    /**
     * Realiza insercao em posicao determinada da lista
     * @param dado Dado a ser inserido
     * @throws Exception MAX_RECHEAD - Lista Cheia
     */
    public void inserePosicao(Personagem dado, int pos) throws Exception{

        if(numItens < tamMax){
            for(int i = numItens; i > pos; i--){
                lista[i] = lista[i - 1];
            }

            lista[pos] = dado;
            numItens++;
        }else{
            throw new Exception("MAX_RECHEAD");
        }
    }

    /**
     * Realiza insercao no final da lista
     * @param dado Dado a ser inserido
     * @throws Exception MAX_RECHEAD - Lista Cheia
     */
    public void insereFinal(Personagem dado) throws Exception{

        if(numItens < tamMax){
            lista[numItens] = dado;
            numItens++;
        }else{
            throw new Exception("MAX_RECHEAD");
        }
    }

    /**
     * Recupera dado presente em lista.
     * @return Dado recuperado
     * @throws Exception LISTA_VAZIA
     */
    public Personagem removeInicio() throws Exception{
        Personagem dadoRecuperado = null;

        if(numItens != 0){
            dadoRecuperado = lista[0];

            for(int i = 0; i < numItens; i++){
                lista[i] = lista[i + 1];
            }

            numItens--;
        }else{
            throw new Exception("LISTA_VAZIA");
        }

        return dadoRecuperado;
    }

    /**
     * Recupera dado presente em determinada posicao da lista.
     * @return Dado recuperado
     * @throws Exception POSICAO_INVALIDA
     */
    public Personagem removePosicao(int pos) throws  Exception{
        Personagem dadoRecuperado = null;

        if(pos >= 0 && pos < numItens){
           dadoRecuperado = lista[pos];

           for(int i = pos; i < numItens; i++){
               lista[i] = lista[i + 1];
           }

           numItens--;
        }else{
            throw new Exception("POSICAO_INVALIDA");
        }

        return dadoRecuperado;
    }

    /**
     * Recupera dado presente no final da lista
     * @return Dado recuperado
     * @throws Exception LISTA_VAZIA
     */
    public Personagem removeFinal() throws Exception{
        Personagem dadoRecuperado = null;

        if(numItens != 0){
            dadoRecuperado = lista[numItens - 1];
            numItens--;
        }else{
            throw new Exception("LISTA_VAZIA");
        }

        return dadoRecuperado;
    }

    /**
     * Realiza Impressao de dados presentes na lista
     */
    public void imprime(){
        Personagem p;
        for(int i = 0; i < numItens; i++){
            p = lista[i];
            MyIO.println("[" + i + "] " + p.toString());
        }
    }
}

//---------------------------- Classe Auxiliar

class JSONObject{

    private final ArrayList<String> Keys = new ArrayList<>();
    private final ArrayList<Object> valores = new ArrayList<>();

    /**
     * Inicializa um objeto JSON para leitura de registro JSON.
     * @param JSON
     */
    public JSONObject(String JSON){

        JSON = JSON.replaceAll("[{}]", ""); //Remove caracters desnecessarios
        StringBuilder leitura;
        char caracter;

        int i = 1;
        do{

            caracter = JSON.charAt(i);

            //Realiza leiutura da chave
            leitura = new StringBuilder();
            while (caracter != ':'){
                leitura.append(caracter);
                i++;
                caracter = JSON.charAt(i);
            }

            Keys.add(leitura.toString().replace("'","")); //Armazena chave lida

            i+=3;
            caracter = JSON.charAt(i);

            //Realiza leitura de valor correspondente a chave
            leitura = new StringBuilder();
            while (caracter != '\''){
                leitura.append(caracter);
                i++;
                caracter = JSON.charAt(i);
            }

            valores.add(leitura.toString().replace("'","")); //Armazena em array de valores

            i+=3;

        }while(i < JSON.length());

    }

    /**
     * Recupera uma string correspondente a chave.
     * @param chave Chave de busca
     * @return Valor string correspondente
     */
    public String getString(String chave){
        return  (String)getValor(getIndice(chave));
    }

    /**
     * Recupera um int correspondente a chave
     * @param chave Chave de busca
     * @return Valor inteiro correspondente
     */
    public int getInt(String chave){
        int valor;

        try {
            valor = Integer.parseInt(getString(chave));
        }catch (NumberFormatException ex){
            valor = 0;
        }

        return valor;
    }

    /**
     * Recupera um double correspondente a chave
     * @param chave Chave de busca
     * @return Valor double correspondente
     */
    public double getDouble(String chave){
        String valorStr = getString(chave);
        double valor;

        try {
            valor = Double.parseDouble(valorStr);
        }catch (NumberFormatException ex){
            if(valorStr.contains(",")){
                valorStr = valorStr.replace(",","");
                valor = Double.parseDouble(valorStr);
            }else{
                valor = 0;
            }
        }

        return valor;
    }

    /**
     * Recupera indice de uma chave em array.
     * @param key Chave buscada
     * @return indice da chave.
     */
    private int getIndice(String key){
        return this.Keys.indexOf(key);
    }

    /**
     * Recupera valor de um indice do array
     * @param indice Indice de busca.
     * @return Valor presente no indice
     */
    private Object getValor(int indice){
        return this.valores.get(indice);
    }
}

