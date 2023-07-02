/**
 * @file ArvoreAlvinegra.java
 * @author 784778 - Wallace Freitas Oliveira (https://github.com/Olivwallace)
 * @brief TP04Q04 - Algoritmo e Estruturas de Dados II (PUC-Minas 1°/2023)
 * @date 16-06-2023
 */

 import java.io.*;
 import java.util.ArrayList;
 
 //------------------------- Principal
 public class ArvoreAlvinegra {
 
     private static final String matricula = "784778";
     private static final File arq = new File(matricula + "_arvoreAlvinegra.txt");
     public static FileWriter writer = null;
 
     public static void main(String[] args){
         MyIO.setCharset("ISO-8859-1");
         configuraLog();
         long startTime = System.currentTimeMillis(); //Inicia Temporizador
 
         String caminho = MyIO.readLine();
         Arvore arv = new Arvore(null);
 
         while (!caminho.contains("FIM")){ //Carrega lista com primeiras entradas
             try {
                 arv.insere(Personagem.toRead(caminho));
                 caminho = MyIO.readLine();
             }catch (Exception ignored){}
         }

         caminho = MyIO.readLine();
         while (!caminho.contains("FIM")){ //Busca nomes na arvore
            try {
                MyIO.print((arv.buscar(caminho))?" SIM\n": " NÃO\n");
                caminho = MyIO.readLine();
            }catch(Exception ignored){}
         }
 
         //Finaliza Temporizador
         long endTime = System.currentTimeMillis();
         long tempo = endTime - startTime;
 
         //Armazena no arquivo os dados de execucao
         try{
             int cmp_mov = arv.getLogSort();
             writer.write(matricula + "\t" + tempo / 1000.0 + "s\t" + cmp_mov + "cmp");
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
 
 //---------------------------- Classes  Manipulacao de Arvore
 
class No {

    private Personagem personagem;
    private boolean cor;
    private No esq, dir;

    public No (Personagem dado){
        this(dado, false, null, null);
    }

    public No (Personagem dado, boolean cor){
        this(dado, cor, null, null);
    }

    public No (Personagem dado, boolean cor, No esq, No dir){
        setPersonagem(dado);
        setCor(cor);
        setDir(dir);
        setEsq(esq);
    }

    public void setPersonagem(Personagem dado) {
        this.personagem = dado;
    }  

    public void setDir(No dir){
        this.dir = dir;
    }

    public void setEsq(No esq){
        this.esq = esq;
    }

    public void setCor(boolean cor){
        this.cor = cor;
    }

    public Personagem getPersonagem(){
        return this.personagem;
    }

    public No getDir(){
        return this.dir;
    }

    public No getEsq(){
        return this.esq;
    }

    public boolean isCor() {
        return this.cor;
    }

}
 
class Arvore {
    public int comp;
    private No raiz;

    public Arvore(No raiz){
        setRaiz(raiz);
    }

    public void setRaiz(No raiz){
        this.raiz = raiz;
    }

    public No getRaiz(){
        return this.raiz;
    }

    public int getLogSort(){
        return this.comp;
    }

    public void insere(Personagem dado) throws Exception {

        if (raiz == null) {
            raiz = new No(dado);
        } else if (raiz.getDir() == null && raiz.getEsq() == null) {
            if (dado.getNome().compareToIgnoreCase(raiz.getPersonagem().getNome()) < 0) {
                comp++;
                raiz.setEsq(new No(dado));
            } else{
                comp += 2;
                raiz.setDir(new No(dado));
            }
        } else if (raiz.getEsq() == null) {

            if (dado.getNome().compareToIgnoreCase(raiz.getPersonagem().getNome()) < 0){
                comp ++;
                raiz.setEsq(new No(dado));
            } else if (dado.getNome().compareToIgnoreCase(raiz.getDir().getPersonagem().getNome()) < 0){
                comp +=2;
                raiz.setEsq(new No(raiz.getPersonagem()));
                raiz.setPersonagem(dado);
            } else {
                comp+=2;
                raiz.setEsq(new No(raiz.getPersonagem()));
                raiz.setPersonagem(raiz.getDir().getPersonagem());
                raiz.getDir().setPersonagem(dado);
            }

            raiz.getEsq().setCor(false);
            raiz.getDir().setCor(false);

        } else if (raiz.getDir() == null) {

            if (dado.getNome().compareToIgnoreCase(raiz.getPersonagem().getNome()) > 0){
                comp++;
                raiz.setDir(new No(dado));
            } else if (dado.getNome().compareToIgnoreCase(raiz.getEsq().getPersonagem().getNome()) > 0) {
                comp += 2;
                raiz.setDir(new No(raiz.getPersonagem()));
                raiz.setPersonagem(dado);
            } else {
                comp += 2;
                raiz.setDir(new No(raiz.getPersonagem()));
                raiz.setPersonagem(raiz.getEsq().getPersonagem());
                raiz.getEsq().setPersonagem(dado);
            }

            raiz.getEsq().setCor(false);
            raiz.getDir().setCor(false);

        } else {
            insere(dado, null, null, null, raiz);
        }

        raiz.setCor(false);
    }

    private void insere(Personagem dado, No bisavo, No avo, No pai, No i) throws Exception {
        if (i == null) {

            if (dado.getNome().compareToIgnoreCase(pai.getPersonagem().getNome()) < 0) {
                comp++;
                pai.setEsq(new No(dado,true));
                i = pai.getEsq();
            } else {
                comp++;
                pai.setDir(new No(dado, true));
                i = pai.getDir();
            }

            if (pai.isCor()) balancear(bisavo, avo, pai, i);

        } else {

            if (i.getEsq() != null && i.getDir() != null && i.getEsq().isCor() && i.getDir().isCor()) {

                i.setCor(true);
                i.getEsq().setCor(false);
                i.getDir().setCor(false);

                if (i == raiz) {
                    comp++;
                    i.setCor(false);
                } else if (pai.isCor()) {
                    comp += 2;
                    balancear(bisavo, avo, pai, i);
                }

            }

            if (dado.getNome().compareToIgnoreCase(i.getPersonagem().getNome()) < 0) {
                comp++;
                insere(dado, avo, pai, i, i.getEsq());
            } else if (dado.getNome().compareToIgnoreCase(i.getPersonagem().getNome()) > 0) {
                comp += 2;
                insere(dado, avo, pai, i, i.getDir());
            }

        }
    }

    private void balancear(No bisavo, No avo, No pai, No i) {

        if (pai.isCor()) {
            if (pai.getPersonagem().getNome().compareToIgnoreCase(avo.getPersonagem().getNome()) > 0) {

                if (i.getPersonagem().getNome().compareToIgnoreCase(pai.getPersonagem().getNome()) > 0) {
                    avo = rotacaoEsq(avo);
                } else {
                    avo = rotacaoDirEsq(avo);
                }

            } else {
                if (i.getPersonagem().getNome().compareToIgnoreCase(pai.getPersonagem().getNome()) < 0) {
                    avo = rotacaoDir(avo);
                } else {
                    avo = rotacaoEsqDir(avo);
                }
            }

            if (bisavo == null) {
                raiz = avo;
            } else if (avo.getPersonagem().getNome().compareToIgnoreCase(bisavo.getPersonagem().getNome()) < 0) {
                bisavo.setEsq(avo);
            } else {
                bisavo.setDir(avo);
            }

            avo.setCor(false);
            avo.getEsq().setCor(true);
            avo.getDir().setCor(true);
        }
    }

    private No rotacaoDir(No no) {
        No noEsq = no.getEsq();
        No noEsqDir = noEsq.getDir();

        noEsq.setDir(no);
        no.setEsq(noEsqDir);

        return noEsq;
    }

    private No rotacaoEsq(No no) {
        No noDir = no.getDir();
        No noDirEsq = noDir.getEsq();

        noDir.setEsq(no);
        no.setDir(noDirEsq);

        return noDir;
    }

    private No rotacaoDirEsq(No no) {
        no.setDir(rotacaoDir(no.getDir()));
        return rotacaoEsq(no);
    }

    private No rotacaoEsqDir(No no) {
        no.setEsq(rotacaoEsq(no.getEsq()));
        return rotacaoDir(no);
    }

    public Boolean buscar(String nome){
        MyIO.print(nome + " raiz");
        return buscar(nome, raiz);
    }

    private Boolean buscar(String nome, No i){
        Boolean encontrado = false;
        
        if(i != null){

            String nomeNo = i.getPersonagem().getNome();

            if(nomeNo.compareToIgnoreCase(nome) == 0){
                this.comp++;

                encontrado = true;
            }else if(nomeNo.compareToIgnoreCase(nome) > 0){
                this.comp += 2;

                MyIO.print(" dir");
                encontrado = buscar(nome, i.getDir());
            }else if(nomeNo.compareToIgnoreCase(nome) < 0){
                this.comp += 3;

                MyIO.print(" esq");
                encontrado = buscar(nome, i.getEsq());

            }else this.comp += 3;

        }

        return encontrado;
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
 
 