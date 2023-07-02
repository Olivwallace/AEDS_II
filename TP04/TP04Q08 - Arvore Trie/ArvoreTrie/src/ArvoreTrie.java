/**
 * @file ArvoreTrie.java
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP04Q08 - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 16-06-2023
 */

 import java.io.*;
 import java.util.ArrayList;
 
 //------------------------- Principal
public class ArvoreTrie {
 
     private static final String matricula = "784778";
     private static final File arq = new File(matricula + "_arvoreTrie.txt");
     public static FileWriter writer = null;
 
     public static void main(String[] args) {
         MyIO.setCharset("UTF-8");
         configuraLog();
         long startTime = System.currentTimeMillis(); //Inicia Temporizador
 
         String caminho = MyIO.readLine();
         Arvore arv1 = new Arvore();
         Arvore arv2 = new Arvore();
 
         while (!caminho.contains("FIM")){ //Carrega lista com primeiras entradas
             try {
                 arv1.insere(Personagem.toRead(caminho));
             }catch (Exception ignored){}
             finally {
                 caminho = MyIO.readLine();
             }
         }

         caminho = MyIO.readLine();
         while (!caminho.contains("FIM")){ //Carrega lista com primeiras entradas
             try {
                 arv2.insere(Personagem.toRead(caminho));
             }catch (Exception ignored){}
             finally {
                 caminho = MyIO.readLine();
             }
         }

         try {
             arv2.mesclar(arv1);
         }catch (Exception ignored){}

         caminho = MyIO.readLine();
         while (!caminho.contains("FIM")){ //Busca nomes na arvore
            try {
                MyIO.print(caminho);
                MyIO.print((arv1.pesquisar(caminho))?" SIM\n": " NÃO\n");
            }catch(Exception ignored){}
            finally {
                caminho = MyIO.readLine();
            }
         }
 
         //Finaliza Temporizador
         long endTime = System.currentTimeMillis();
         long tempo = endTime - startTime;
 
         //Armazena no arquivo os dados de execucao
         try{
             int cmp_mov = arv1.comp + arv2.comp;
             writer.write(matricula + "\t" + tempo / 1000.0 + "s\t" + cmp_mov + "cmp");
         }catch (IOException ignored){}
         finally {
             try {
                 writer.close();
             }catch (IOException ignored){}
         }
     }

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
 
 //---------------------------- Classes  Manipulacao Arvore Trie

class No {
    private char letra;
    public final int _TAM_TABLE = 255;
    private No[] prox = new No[_TAM_TABLE];
    private boolean folha;

    public No(){
        this(' ', false);
    }

    public No(char elemento){ this(elemento, false); }

    public No(char elemento, boolean folha){
        this.letra = elemento;
        for (int i = 0; i < _TAM_TABLE; i++) prox[i] = null;
        this.folha = folha;
    }

    public void insereNo(char letra, boolean isFolha){
        this.prox[funcHash(letra)] = new No(letra, isFolha);
    }

    public int funcHash(char letra) { return letra; }

    public char getLetra() {
        return letra;
    }

    public No getProx(char letra) {
        return getProx(funcHash(letra));
    }

    public No getProx(int pos){
        No retorno = null;

        if(pos >= 0 && pos <= _TAM_TABLE){
            retorno = this.prox[pos];
        }

        return  retorno;
    }

    public boolean isFolha() {
        return folha;
    }
}

class Arvore {
    No raiz;
    int comp = 0;

    public Arvore(){
        this.raiz = new No();
    }

    public void insere(String nome) throws Exception{
        this.insere(nome, raiz, 0);
    }

    public void insere(Personagem personagem) throws Exception {
        this.insere(personagem.getNome(), raiz, 0);
    }

    private void insere(String palavra, No i, int pos) throws Exception{

        if(i.getProx(palavra.charAt(pos)) == null){

            if(pos == palavra.length() - 1){
                i.insereNo(palavra.charAt(pos), true);
            }else {
                i.insereNo(palavra.charAt(pos), false);
                insere(palavra, i.getProx(palavra.charAt(pos)), ++pos);
            }

            comp += 2;

        } else if (!i.getProx(palavra.charAt(pos)).isFolha() && pos < palavra.length() - 1){
            insere(palavra, i.getProx(palavra.charAt(pos)), ++pos);

            comp+=2;
        } else {
            throw new Exception("Erro ao inserir!");
        }

    }

    public boolean pesquisar(String s) throws Exception {
        return pesquisar(s, raiz, 0);
    }

    private boolean pesquisar(String palavra, No i, int pos) throws Exception {
        boolean resp;

        if(i.getProx(palavra.charAt(pos)) == null){
            comp++;
            resp = false;
        } else if(pos == palavra.length() - 1){
            comp+=2;
            resp = i.getProx(palavra.charAt(pos)).isFolha();
        } else if(pos < palavra.length() - 1 ){
            comp+=3;
            resp = pesquisar(palavra, i.getProx(palavra.charAt(pos)), ++pos);
        } else {
            throw new Exception("Erro ao pesquisar!");
        }

        return resp;
    }

    public void mesclar(Arvore arv) throws Exception {
        mesclar("", raiz, arv);
    }

    public void mesclar(String s, No no, Arvore arv) throws Exception {
        if(no.isFolha()){
            comp++;
            String palavra = s + no.getLetra();
            arv.insere(palavra.replaceFirst(" ", ""));
        } else {
            comp++;
            for(int i = 0; i < no._TAM_TABLE; i++){
                if(no.getProx(i) != null){
                    mesclar(s + no.getLetra(), no.getProx(i), arv);
                }
            }
        }
    }
}

 //---------------------------- Classes Auxiliares

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