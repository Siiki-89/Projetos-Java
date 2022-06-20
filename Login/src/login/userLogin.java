
package login;

import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class userLogin {
    private static Scanner arq;
    static boolean achou=false;
    static boolean trocar=false;
    private boolean adm=false;


    

    
    public boolean procurarConta(String users,String nome, String senha, boolean achou)throws IOException{//senha ou login incorreto?
        
        try{
            
            String tempNome="";
            String tempSenha="";
            String nomeAdm="admim";
            arq=new Scanner(new File(users));
            arq.useDelimiter("[,\n]");
            boolean usuario=false;
            boolean admim=false;//éAdmim?
            while(arq.hasNext()&&!achou){
                tempNome=arq.next();
                arq.next();
                tempSenha=arq.next();
                if(tempNome.trim().equals(nome)){
                    if (tempNome.trim().equals("admim") && tempSenha.trim().equals("admim")){
                        setAdm(true);
                        achou=true;
                    }
                    else if(tempSenha.trim().equals(senha)){
                        achou=true;
                    }
                    else if(tempSenha.trim()!=senha){
                        usuario=true;   
                    }
                }
                
            }
            arq.close();
            if(achou==true){
                JOptionPane.showMessageDialog(null,"Bem vindo");
            }
            else if (usuario==true){
                JOptionPane.showMessageDialog(null,"Senha incorreta!");
            }
            else if(usuario==false){
                JOptionPane.showMessageDialog(null,"Usuario não encontrado!");
            }
        }
        catch(FileNotFoundException e){
                System.out.println("Erro");
                }
        return achou;
    }
    
    
    public void mudarSenha(String users,String nome, String telefone, String senha) throws IOException{
        String tempFile="temp.txt";
        File oldFile= new File(users);
        File newFile= new File(tempFile);

        String tempNome="", tempTelefone="",tempSenha="";
        try{
            FileWriter fw= new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            arq=new Scanner(new File(users));
            arq.useDelimiter("[,\n]");        

            while(arq.hasNext()&&!achou){
                tempNome=arq.next();
                tempTelefone=arq.next();  
                tempSenha=arq.next();
                if(tempNome.trim().equals(nome)&&tempTelefone.trim().equals(telefone)){
                    pw.print("\n"+nome+","+telefone+","+senha);
                }
                else{
                    pw.print("\n"+tempNome+","+tempTelefone+","+tempSenha);
                }
            }
            arq.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump=new File(users);
            newFile.renameTo(dump);

        }
        catch(FileNotFoundException e){
            System.out.println("Error");
        }
        JOptionPane.showMessageDialog(null,"Senha alterada com sucesso");
    }
    
    public boolean esqueceuSenha(String users,String nome, String telefone, boolean taCerto)throws IOException{
        try{
            taCerto=false;
            String tempNome="";
            String tempTelefone="";
            arq=new Scanner(new File(users));
            arq.useDelimiter("[,\n]");

            while(arq.hasNextLine()&&!taCerto){
                tempNome=arq.next();
                tempTelefone=arq.next();
                arq.next();                  
                if(tempNome.trim().equals(nome)&&tempTelefone.trim().equals(telefone)){
                        taCerto=true;
                    } 
            }
            arq.close();
        }
        catch(FileNotFoundException e){
                System.out.println("Erro");
                }
        if(taCerto==false){
            JOptionPane.showMessageDialog(null,"Usuario ou telefone não registrados");
        }
        return taCerto;
    }
    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

}
    


