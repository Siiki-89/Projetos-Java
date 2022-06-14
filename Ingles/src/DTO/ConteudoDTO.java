
package DTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ConteudoDTO {
    private String conteudos [][] = {{"1", "ex1.txt"}};
    
    private static Scanner arq;
    
    public List<String> lerTXT(String input) throws FileNotFoundException{
        String conteudo;
        List <String> linha = new ArrayList<>();
        for(int i=0;i<1;i++){
            conteudo=conteudos[i][0];
            if(input.equals(conteudo)){
                arq=new Scanner(new File(conteudos[i][1]));
                while(arq.hasNextLine()){
                    linha.add(arq.nextLine());
                }
            }
        }
        return linha;
    }
    public int obterLinhas(String input) throws FileNotFoundException{
        int contador = 0;
        List <String> linha = new ArrayList<>();
        linha = lerTXT(input);
        for (int i = 0; i < linha.size(); i ++){
            if (linha.get(i) != null){
               contador ++;
            }
        }
        return contador;
    }
    public String[] conteudoIng (String input) throws FileNotFoundException{
        List <String> linha = new ArrayList<>();
        linha = lerTXT(input);
        int qtdLinhas = obterLinhas(input);
        String linhaIng [] = new String [qtdLinhas/2];
        int a= 0;
        for (int i = 0; i<qtdLinhas;i++){
            if(i % 2 != 0){
                linhaIng [a] = linha.get(i); 
                a++;
            }
        } 
        return linhaIng;
    }
}
