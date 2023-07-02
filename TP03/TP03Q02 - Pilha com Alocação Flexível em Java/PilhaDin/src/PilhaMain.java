/**
 * @file PilhaMain.java
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP03Q02 - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 28-04-2023
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//------------------------- Principal
public class PilhaMain {

    public static void main(String[] args){
        MyIO.setCharset("UTF-8");
        String caminho = MyIO.readString();

        PilhaDin pilhaPersonagem = new PilhaDin(); //Inicializa Lista

        while (!caminho.contains("FIM")){ //Carrega lista com primeiras entradas
            try {
                pilhaPersonagem.empilha(Personagem.toRead(caminho));
                caminho = MyIO.readString();
            }catch (Exception ignored){}
        }

        int numOperacoesLista = MyIO.readInt(); //Ler numero de operacoes restantes

        operaPilha(pilhaPersonagem, numOperacoesLista); //Realiza operacoes
        pilhaPersonagem.imprime(); //Imprime conteudo final da lista
    }

    /**
     * Metodo para realizar operacoes de insercao e remocao determinadas por entrada externa.
     * @param pilhaPersonagens Lista de personagens operada
     * @param numOp Numero de operacoes a ser realizadas
     */
    public static void operaPilha(PilhaDin pilhaPersonagens, int numOp){
        Personagem p;

        for(int i = 0; i < numOp; i++){
            try {

                String[] operacao = MyIO.readLine().split(" "); //Ler linha de comando

                switch (operacao[0]) {
                    case "I":
                        pilhaPersonagens.empilha(Personagem.toRead(operacao[1]));
                        break;
                    case "R":
                        p = pilhaPersonagens.desempilha();
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
    private itemLista prox;

    public itemLista(Personagem dado){
        setDado(dado);
        setProx(null);
    }

    public itemLista(Personagem dado, itemLista prox){
        setProx(prox);
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
}

class PilhaDin {
    private int numItens;
    private itemLista topo;

    public PilhaDin(){
        setNumItens(0);
        setTopo(null);
    }

    public PilhaDin(Personagem dado){
        setNumItens(numItens + 1);
        itemLista tmp = new itemLista(dado);
        setTopo(tmp);
    }

    /**
     * Metodo responsavel pelo empilhamento
     * @param dado Personagem a ser inserido
     */
    public void empilha(Personagem dado){
        topo = new itemLista(dado, topo);
        setNumItens(numItens + 1);
    }

    /**
     * Remove personagem que ocupa topo da pilha.
     * @return Personagem da posicao
     */
    public Personagem desempilha(){
        Personagem personagem = null;

        if(topo != null){
            itemLista tmp = topo;            // Guarda endereço do primeiro
            topo = topo.getProx();           // Atualiza Primeiro
            personagem = tmp.getDado();      // Recupera dado
            tmp.setProx(null);               // Remove Ponteiro do antigo primeiro
            tmp = null;                      // Libera tmp
            setNumItens(numItens - 1);  // Atualiza número de itens
        }

        return personagem;
    }

    /**
     * Imprime todos os elementos da pilha
     */
    public void imprime(){
        PilhaDin tmp = new PilhaDin(this.desempilha());
        int itens = numItens;
        for(int i = 0; i < itens; i++){
            tmp.empilha(this.desempilha());
        }
        if(tmp.topo != null){
            itemLista atual = tmp.topo;
            for(int i = 0; i < tmp.numItens; i++){
                MyIO.println("[" + i + "] " + atual.getDado().toString());
                atual = atual.getProx();
            }
        }
    }

    //----------------------------- Setter's and Getter's

    public void setNumItens(int numItens) {
        this.numItens = numItens;
    }

    public void setTopo(itemLista topo) {
        this.topo = topo;
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

