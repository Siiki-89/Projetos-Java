
package login;

import java.io.IOException;
import javax.swing.ImageIcon;
import java.util.*;
import javax.swing.JOptionPane;


public class Login {

    
    public static void main(String[] args) throws IOException {

        String users="Users.txt";
        
        userLogin verificar=new userLogin();
        String espaco = "                                                      ";
        String botao[] = { "Fazer login", "Cadastrar", "Esqueci minha senha", "Sair" };//botão do questionamento
        String botaoADM[] = {"Obter dados da lista","Remover Usuario"};
        String usuario = "", senha = "", telefone = "";
        
        
        boolean correto=false,acertou=false, exit=false, admim=false;
        
        while(correto==false && exit==false){
            int rc = JOptionPane.showOptionDialog(null,espaco+"Escolha a opção referente ao interesse:","Login",0,JOptionPane.DEFAULT_OPTION, null, botao, botao[3]);
            switch (rc) {
                case 0://Fazer login
                    usuario = JOptionPane.showInputDialog("Usuario: ");
                    senha= JOptionPane.showInputDialog("Senha: ");               
                    correto = verificar.procurarConta(users, usuario, senha,correto);

                    break;
                case 1://Fazer cadastramento 
                    try {
                        usuario = JOptionPane.showInputDialog("Nome de Usuario: ");
                        senha = JOptionPane.showInputDialog("Senha: ");
                        int telefon = Integer.parseInt(JOptionPane.showInputDialog("Telefone para cadastro: "));
                        //Verificar se os campos estão preenchidos
                        if(usuario.isEmpty() || senha.isEmpty() || usuario.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Preencha todos os campos!");
                        }
                        else {
                            creatUser.criarConta(usuario, senha, telefon);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não foi possivel realizar o cadastro (Ocorreu algum erro)");
                    }
                    
                    break;
                case 2://Esqueci minha senha 
                    usuario = JOptionPane.showInputDialog("Digite seu nome de usuario: ");
                    telefone = JOptionPane.showInputDialog("Digite seu numero de telefone: ");
                    //Verificar se os campos estão preenchidos
                    if(usuario.isEmpty() || telefone.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Preencha todos os campos!");
                    }
                    else{
                        acertou= verificar.esqueceuSenha(users, usuario, telefone, acertou);
                        if(acertou==true){
                            senha = JOptionPane.showInputDialog("Digite uma nova senha: ");
                            verificar.mudarSenha(users, usuario, telefone, senha);
                        }
                    }
                    break;
                case 3://sair
                    exit=true;
                    break;
                default://botão de fechar
                    exit=true;
            }    
        }
        if(verificar.isAdm()==true){//tela de adm
            JOptionPane.showMessageDialog(null,"É admim");
            adm adm=new adm();
            int rc = JOptionPane.showOptionDialog(null,"Escolha a opção referente ao interesse:","TABLE ADMIM",0,JOptionPane.DEFAULT_OPTION, null, botaoADM, botaoADM[0]);
            
            switch (rc){
                case 0://obter lista de usuarios
                    adm.obterUsuarios(users, true);
                    
                    break;
                case 1:
                    usuario = JOptionPane.showInputDialog("Digite o nome do usuario que deseja remover: ");

                    adm.removerUsuario(usuario);

                    break;
            }
        }
    }
}

    

