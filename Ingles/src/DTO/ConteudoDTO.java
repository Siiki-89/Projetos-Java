
package DTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JButton;


public class ConteudoDTO {
    private String arquivos [][] = {{"1", "txt/ex1.txt"},{"1P", "txt/ex1p.txt"},{"1FU", "txt/ex1fu.txt"}};
    
    private static Scanner arq;
    
    public List<String> lerFrase(String input) throws FileNotFoundException{ // Ler arquivo que contem as frases
        String conteudo;
        List <String> linha = new ArrayList<>();
        for(int i=0;i<3;i++){
            conteudo=arquivos[i][0];
            if(input.equals(conteudo)){
                arq=new Scanner(new File(arquivos[i][1]));
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
        linha = lerFrase(input);
        for (int i = 0; i < linha.size(); i ++){
            if (linha.get(i) != null){
               contador ++;
            }
        }
        return contador;
    }
    
    public String[] conteudoIng (String input) throws FileNotFoundException{
        List <String> linha = new ArrayList<>();
        linha = lerFrase(input);
        int qtdLinhas = obterLinhas(input);
        String linhaIng [] = new String [qtdLinhas/2];
        int a= 0;
        for (int i = 0; i<qtdLinhas;i++){
            if(i % 2 != 0){
                linhaIng [a] = linha.get(i).toUpperCase();  
                a++;
            }
        } 
        return linhaIng;
    }
    public String[] conteudoPt (String input) throws FileNotFoundException{
        List <String> linha = new ArrayList<>();
        linha = lerFrase(input);
        int qtdLinhas = obterLinhas(input);
        String linhaPt [] = new String [qtdLinhas/2];
        int a= 0;
        for (int i = 0; i<qtdLinhas;i++){
            if(i % 2 == 0){
                linhaPt [a] = linha.get(i);
                a++;
            }
        } 
        return linhaPt;
    }
}
