package login;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class adm {

    private static Scanner arq;

    public ArrayList obterUsuarios(String users, boolean ler) throws FileNotFoundException {
        ArrayList array = new ArrayList();

        arq = new Scanner(new File(users));
        arq.useDelimiter("[,\n]");
        while (arq.hasNext()) {
            array.add(arq.next());
            array.add(arq.next());
            array.add(arq.next());
        }
        if (ler == true) {
            for (int i = 3; i < array.size(); i++) {
                System.out.println(array.get(i) + " " + array.get(i + 1) + " " + array.get(i + 2));
                i += 2;
            }
        }
        return array;
    }

    public int buscarUsuario(String usuario) throws FileNotFoundException {
        String users = "Users.txt";
        ArrayList array = new ArrayList();
        array = obterUsuarios(users, false);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(usuario)) {
                return i;
            }
        }
        return -1;
    }

    public void removerUsuario(String usuario) throws FileNotFoundException, IOException {
        String users = "Users.txt";
        ArrayList array = new ArrayList();
        array = obterUsuarios(users, false);

        int i = buscarUsuario(usuario);
        if(i>0){
            File file =new File("Users.txt");
            FileWriter fileWritter = new FileWriter(file,true);        
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            
            array.remove(i);
            array.remove(i);
            array.remove(i);
            
            for (i=0;i<array.size();i++){
                
                System.out.println(array.get(i));
                bufferWritter.write("\n"+array.get(i));
                i++;
                System.out.println(array.get(i));
                bufferWritter.write(","+array.get(i));
                i++;
                System.out.println(array.get(i));
                bufferWritter.write(","+array.get(i));
                
            }
            bufferWritter.close();
            fileWritter.close();

            JOptionPane.showMessageDialog(null, "Usuario apagado com sucesso");
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuario não existe");
        }
        
    }
    public static void deleteARQ(File file) {
        if (file.isFile()) {
            file.delete();
        } else {
            File files[] = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteARQ(files[i]);
            }
        }
    }
}

