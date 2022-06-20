
package login;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;

public class creatUser {
    
    public static void criarConta(String user, String senha,int telefone) throws IOException{
        
        File file =new File("Users.txt");
        String telefon = Integer.toString(telefone);
        
        try{    
            FileWriter fileWritter = new FileWriter(file,true);        
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write("\n"+user+","+telefon+","+senha);
            bufferWritter.close();
            fileWritter.close();

            JOptionPane.showMessageDialog(null,"Conta criada com sucesso!");    

        }catch(FileNotFoundException e){    
                JOptionPane.showMessageDialog(null,"Erro");
        }      
    }    
}
