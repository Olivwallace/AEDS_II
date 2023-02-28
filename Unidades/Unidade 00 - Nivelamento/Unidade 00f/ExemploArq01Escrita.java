class ExemploArq01Escrita
{
  public static void main(String[] args)
  {
     //Abrir o arquivo texto
     Arq.openWrite("exemplo.txt");


     //Escrever no arquivo texto
     Arq.println(5);
     Arq.println(5.3);
     Arq.println('W');
     Arq.println(true);
     Arq.println("Wallace");


     //Fechar o arquivo texto
     Arq.close();

  } // Fim main()
} // Fim class
