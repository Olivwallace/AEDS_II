/**
 * @file ListaDuplaMain.java
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP03Q02 - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 29-04-2023
 */

import java.io.*;
import java.util.ArrayList;

//------------------------- Principal
public class ListaDuplaMain {

    private static final String matricula = "784778";
    private static final File arq = new File(matricula + "_quicksortparcial.txt");
    public static FileWriter writer = null;

    public static void main(String[] args){
        MyIO.setCharset("UTF-8");
        configuraLog();
        long startTime = System.currentTimeMillis(); //Inicia Temporizador

        String caminho = MyIO.readString();
        ListaDupla listaDupla = new ListaDupla(); //Inicializa Lista

        while (!caminho.contains("FIM")){ //Carrega lista com primeiras entradas
            try {
                listaDupla.insereFinal(Personagem.toRead(caminho));
                caminho = MyIO.readString();
            }catch (Exception ignored){}
        }

        listaDupla.sort();
        listaDupla.imprime(); //Imprime conteudo final da lista

        //Finaliza Temporizador
        long endTime = System.currentTimeMillis();
        long tempo = endTime - startTime;

        //Armazena no arquivo os dados de execucao
        try{
            int[] cmp_mov = listaDupla.getLogSort();
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

        return String.format(" ## %s ## %s ## %s%s ## %s ## %s ## %s ## %s ## %s ## %s ## ",
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
        caminho = caminho.replace("é", "\u00e9");
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

//---------------------------- Classes  Manipulacao de Lista Dinamica

class itemLista{
    private Personagem dado;
    private itemLista prox, ant;

    public itemLista(Personagem dado){
        setDado(dado);
        setProx(null);
        setAnt(null);
    }

    public itemLista(Personagem dado, itemLista prox){
        setProx(prox);
        setAnt(null);
        setDado(dado);
    }

    public itemLista(Personagem dado, itemLista prox, itemLista ant){
        setProx(prox);
        setAnt(ant);
        setDado(dado);
    }

    //----------------------------- Setter's and Getter's

    public Personagem getDado() {
        return dado;
    }

    public void setDado(Personagem dado) {
        this.dado = dado;
    }

    public itemLista getProx() {
        return prox;
    }

    public void setProx(itemLista prox) {
        this.prox = prox;
    }

    public itemLista getAnt() { return  ant;}

    public void setAnt(itemLista ant){ this.ant = ant;}
}

class ListaDupla {
    private int numItens;
    private itemLista primeiro, ultimo;
    protected int[] logSort;

    public ListaDupla(){
        setNumItens(0);
        setPrimeiro(null);
        setUltimo(null);
    }

    public ListaDupla(Personagem dado){
        setNumItens(numItens + 1);
        itemLista tmp = new itemLista(dado);
        setPrimeiro(tmp);
        setUltimo(tmp);
    }

    /**
     * Metodo responsavel pela inserçao
     * @param dado Personagem a ser inserido
     */
    public void insereFinal(Personagem dado){
        itemLista novo = new itemLista(dado, null, null);

        if(ultimo != null){
            ultimo.setProx(novo);
            novo.setAnt(ultimo);
            ultimo = ultimo.getProx();
        }else{
            primeiro = ultimo = novo;
        }

        novo = null;
        setNumItens(numItens + 1);
    }

    /**
     * Remove personagem que ocupa inicio.
     * @return Personagem da posicao
     */
    public Personagem removeInicio(){
        Personagem personagem = null;

        if(primeiro != null){
            itemLista tmp = primeiro;        // Guarda endereço do primeiro
            primeiro = primeiro.getProx();   // Atualiza Primeiro
            personagem = tmp.getDado();      // Recupera dado
            tmp.setProx(null);               // Remove Ponteiro do antigo primeiro
            primeiro.setAnt(null);           // Remove Ponteiro de retorno ao antigo primeiro
            tmp = null;                      // Libera tmp
            setNumItens(numItens - 1);       // Atualiza número de itens
        }

        return personagem;
    }

    /**
     * Imprime todos os elementos da lista
     */
    public void imprime(){
        itemLista atual = primeiro;
        for(int i = 0; i < numItens; i++){
            MyIO.println(atual.getDado().toString());
            atual = atual.getProx();
        }
    }

    //----------------------------- Setter's and Getter's

    public void setNumItens(int numItens) {
        this.numItens = numItens;
    }

    public void setPrimeiro(itemLista primeiro){
        this.primeiro = primeiro;
    }

    public void setUltimo(itemLista ultimo){
        this.ultimo = ultimo;
    }

    public int[] getLogSort(){return  logSort;}

    //----------------------------- Sort

    /**
     * Metodo intermediario para odernar atraves de quicksort.
     */
    public void sort(){
        logSort = new int[2];
        quickSort(primeiro, ultimo, 0, numItens - 1);
    }

    private void quickSort(itemLista i, itemLista f, int ini, int fim){
        int esq = ini, dir = fim;
        itemLista pEsq = i, pDir = f;

        int meio = (ini + fim) / 2;
        itemLista pivo = getPosicao(meio);

        if(esq <= dir) {

            while (comparar(pivo.getDado(), pEsq.getDado()) > 0){
                pEsq = pEsq.getProx();
                esq++;
            }
            while (comparar(pivo.getDado(), pDir.getDado()) < 0){
                pDir = pDir.getAnt();
                dir--;
            }

            if (esq <= dir) {
                swap(pEsq, pDir);
                esq++;
                dir--;
                logSort[1] += 3;
            }
        }

        if(ini < dir) quickSort(i, pDir.getAnt(), ini, dir);
        if(esq < fim) quickSort(pEsq.getProx(), f, esq, fim);
    }

    private itemLista getPosicao(int pos){
        itemLista resposta = null;
        if(primeiro != null){

            itemLista atual = primeiro;
            for (int i = 0; i < pos; i++){
                atual = atual.getProx();
            }
            resposta = atual;

        }
        return resposta;
    }

    private void swap(itemLista i, itemLista j){
        if(i != null && j != null){
            Personagem temp = i.getDado();
            i.setDado(j.getDado());
            j.setDado(temp);
            temp = null;
        }
    }

    /**
     * Compara personagens pela cor do cabelo e nome em caso de desempate
     * @param pivo Pivo da lista no momento
     * @param comparado Personagem a ser comparado
     * @return x < 0 Pivo Maior | x > 0 Pivo Menor | x = 0 Mesmo personagem
     */
    private int comparar(Personagem pivo, Personagem comparado){
        int result = 0;

        if(pivo != null && comparado != null) {
            result = pivo.getCorDoCabelo()
                    .compareToIgnoreCase(comparado.getCorDoCabelo());

            if (result == 0) {
                result = pivo.getNome()
                        .compareToIgnoreCase(comparado.getNome());
                logSort[0]++;
            }

            logSort[0]++;
        }

        return result;
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

