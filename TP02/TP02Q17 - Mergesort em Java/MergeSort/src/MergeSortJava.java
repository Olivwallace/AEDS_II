/**
 * @file MergeSortJava.java
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP02Q17 - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 01-04-2023
 */

import java.io.*;
import java.util.ArrayList;

//------------------------- Principal
public class MergeSortJava {

    private static final String matricula = "784778";
    private static final File arq = new File(matricula + "_mergesort.txt");
    public static FileWriter writer = null;

    public static void main(String[] args){
        MyIO.setCharset("UTF-8");
        configuraLog();
        long startTime = System.currentTimeMillis(); //Inicia Temporizador


        ListaSeq listaPersonagens = new ListaSeq(); //Inicializa Lista

        //Ler primeira entrada e linhas seguintes ate FIM
        String in = MyIO.readLine().replace('é', '\u00e9');
        while (!in.contains("FIM")) {
            try {
                listaPersonagens.insereFinal(Personagem.toRead(in));
                in = MyIO.readLine().replace('é', '\u00e9');
            } catch (Exception ignored) {}
        }

        //Ordena lista e imprime
        listaPersonagens.MergeSort();
        listaPersonagens.imprime();


        //Finaliza Temporizador
        long endTime = System.currentTimeMillis();
        long tempo = endTime - startTime;

        //Armazena no arquivo os dados de execucao
        try{
            int[] cmp_mov = listaPersonagens.getLogSort();
            writer.write(matricula + "\t" + tempo / 1000.0 + "s\t" + cmp_mov[0] + "cmp\t" + cmp_mov[1] + "mov");
        }catch (IOException ignored){}
        finally {
            try {
                writer.close();
            }catch (IOException ignored){}
        }

    }

    /**
     * Configura arquivo de "log" para armazena tempo e dados de execusão
     */
    public static void configuraLog(){
        try{
            if(!arq.exists()){
                arq.createNewFile();
            }
            writer = new FileWriter(arq);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
    protected Object clona() {
        return new Personagem(this);
    }

    /**
     * Realiza a leitura de um registro de personagem
     * @return Instancia do personagem lido.
     */
    public static Personagem toRead(String caminho){
        Personagem novo = null;
        caminho = caminho.replace("é", "\u00e9");
        caminho = ""+ caminho;

        try {

            //Realiza abetura da memória temporaria de entrada e ler da entrada padrao caminho para o registro
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
    protected int[] logSort;

    /**
     * Criar lista com tamanho 100;
     */
    ListaSeq(){
        this(50);
    }

    /**
     * Cria lista de tamanho determinado pelo usuario
     * @param tamMax limite da lista
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
        Personagem dadoRecuperado;

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
        Personagem dadoRecuperado;

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
        Personagem dadoRecuperado;

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
            MyIO.println(" " + p.toString());
        }
    }

    /**
     * Operacao de busca sequencial em lista
     * @param retornoAux Retorno auxiliar contendo numero de comparacoes[1] e posicao encontrada [0]
     * @param nome nome buscado
     * @return TRUE: Encontrado | FALSE: Nao encontrado
     */
    public boolean buscaSequencial(int[] retornoAux, String nome){
        boolean encontrado = false;
        int i = 0;
        retornoAux[0] = -1;

        while (!encontrado && i < numItens){

            if(lista[i].getNome().equals(nome)){
                retornoAux[0] = i;
                encontrado = true;
            }

            i++;
        }

        retornoAux[1] = i;
        return encontrado;
    }

    /**
     * Ordena lista através de MergeSort
     */
    public void MergeSort(){
        setLogSort(new int[2]);
        MergeSort(0, (numItens - 1));
    }

    /**
     * Metodo MergeSort para particionar recursivamente lista
     * @param ini Inicio da lista
     * @param fim Final da lista
     */
    private void MergeSort(int ini, int fim){
        int meio = (fim + ini)/2;
        if(fim > ini){
            MergeSort(ini, meio);
            MergeSort(meio + 1, fim);
            Merge(ini, meio, fim);
        }
    }

    /**
     * Metodo Merge para unir duas partes da lista ordenando
     * @param ini Inicio da subListaA
     * @param meio Item central as sublistas
     * @param fim Final da subListaB
     */
    private void Merge(int ini, int meio,  int fim){
        int iniA = ini, iniB = meio + 1, max = (fim - ini) + 1;
        boolean fimA = false, fimB = false;

        Personagem[] temp = new Personagem[max];

        for(int i = 0; i < max; i++){
            if(!fimA && !fimB){

                //Obtem strings a serem comparadas
                String homeA = lista[iniA].getHomeworld(), nomeA = lista[iniA].getNome();
                String homeB = lista[iniB].getHomeworld(), nomeB = lista[iniB].getNome();

                //Compara e adiciona menores no inicio do array auxiliar ordenado
                int comp = homeA.compareTo(homeB);
                if(comp < 0 || (comp == 0 && nomeA.compareToIgnoreCase(nomeB) < 0)){
                    temp[i] = lista[iniA++];
                }else{
                    temp[i] = lista[iniB++];
                }

                //Verifica se atingiu fim de alguma subLista
                if(iniA > meio) fimA = true;
                if(iniB > fim) fimB = true;

                logSort[0]++;
            }else{

                //Concluir insercao de subLista restante
                if(!fimA)   temp[i] = lista[iniA++];
                else        temp[i] = lista[iniB++];

            }
        }

        //Copia array auxiliar para lista principal
        for(int j = 0, k = ini; j < max; j++, k++, logSort[1]++) lista[k] = temp[j];
    }

    /**
     * Recupera log de ultima ordenacao
     * @return Log contendo numero de comparacoes e moviementacoes
     */
    public int[] getLogSort(){
        return this.logSort;
    }

    /**
     * Realiza set de log de ordenacao
     * @param log Log atualizado.
     */
    public void setLogSort(int[] log){
        this.logSort = log;
    }
}

//---------------------------- Classe Auxiliar
class JSONObject{

    private final ArrayList<String> Keys = new ArrayList<>();
    private final ArrayList<Object> valores = new ArrayList<>();

    /**
     * Inicializa um objeto JSON para leitura de registro JSON.
     * @param JSON string JSON
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
     * Recupera um int Correspondente a chave
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


