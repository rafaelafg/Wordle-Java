

import java.util.*;
import java.io.*;

 public class wordlegui{
     //define as cores
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
     public static void main(String[] args) {
         Scanner sc = new Scanner (System.in);
         String string1 = "", string2 = "";
         String [] strings = new String[20];
         int limite  = 10;
         Random rand = new Random();
         // gera um número aleatório de 0 a 9
         int num = rand.nextInt(limite);
         // cria arquivo - (mudar essa linha)
         File arq = new File ("/Users/dtidigital/Downloads/wordleatp/20palavras.txt");
         // tenta executar as ações
         try {
             // indica que o arquivo irá ser lido
            FileReader leitor = new FileReader(arq);
            // cria um leitor que pode ler linhas de arquivos
            BufferedReader bufferedReader = new BufferedReader(leitor);

            // carrega um vetor com as palavras presentes no arquivo
            for(int i = 0; i<20; i++){
                strings[i] = bufferedReader.readLine();
            }
            // percorre o vetor até achar a string na linha que tem a posição do número aleatório e atribui-a a string1
                for(int i = 0; i<num; i++){
                    string1 = strings[i];
                }
                System.out.println();
                System.out.println("Vamos começar!");
                System.out.println(GREEN + "Verde: a letra existe na mesma posição." + RESET);
                System.out.println(YELLOW + "Amarelo: a letra existe em outra posição." + RESET);
                System.out.println(BLACK + "Cinza: a letra não existe." + RESET);
                System.out.println();
                for(int i = 0; i < 6; i++){

                    // imprime a palavra sorteada (para testes)
                    // System.out.println(string1);
                    // se a palavra digitada não for nula imprime ela                    
                    if(!string2.equals("")){
                        System.out.println();
                        System.out.println("Última palavra digitada: " + string2);
                        System.out.println();
                    }

                    //imprime a quantidade de chances restantes
                    if(i != 0){
                        System.out.println("Você tem " + (6-i) + " chances restantes. ");
                        System.out.println();
                    }else{
                        System.out.println("Você terá 6 chances para acertar a palavra. ");
                        System.out.println();
                    }

                    
                    // usuário digita uma palavra
                    System.out.println("Digite uma palavra com 5 letras: ");
                    string2 = sc.nextLine();
                    System.out.println();
                    
                    // se a palavra digitada for igual a palavra sorteada o usuário recebe uma mensagem de sucesso e o contador vai para 6 para sair do for e acabar o programa
                    if(string1.equals(string2)){
                        System.out.println(GREEN + "Você acertou!!" + RESET);
                        i = 6;

                    // se a palavra digitada não for igual á sorteada e tiver tamanho = 5, executa:
                    }else if (string2.length() == 5) {
                        // percorre as palavras
                        for(int j = 0; j < string2.length(); j++){
                            // verifica se o caracter na posição j da string digitada é igual ao caracter na posição j da string sorteada
                            if(string1.charAt(j) == string2.charAt(j)){
                                System.out.print(GREEN + string2.charAt(j) + " " + RESET);
                            // verifica se o caracter na posição j da string digitada existe em qualquer posição da string sorteada
                            }else if(string1.indexOf(string2.charAt(j)) != -1){
                                System.out.print( YELLOW + string2.charAt(j) + " " + RESET);
                            // se o caracter não existe
                            }else{
                                System.out.print(BLACK + string2.charAt(j) + " " + RESET);

                            }
                        }
                    // se o tamanho da palavra digitada não for = 5 nã é feita nenhuma ação apenas mostra uma mensagem evitando exceptions
                    }else{
                        System.out.println();
                        System.out.println(RED + "Tamanho de palavra não aceito!!!" + RESET);

                        //decrementa as tentativas para o usuário não perder uma tentativa
                        i--;
                    }
                    // se o usuário digitou uma palavra 6 vezes acabam as tentativas
                    if (i == 5){
                        System.out.println("\n");
                        System.out.println(RED + "Tentativas esgotadas :( Você perdeu." + RESET);
                        System.out.println();
                        System.out.println(RED + "A palavra era: " + string1 + RESET);
                        System.out.println();
                        
                    }
                }
                bufferedReader.close();
                leitor.close();
               
            //se houver algum erro cai na exceção
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();

    }
}
