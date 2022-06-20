
package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UsuarioDAO {
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrarUsuario(UsuarioDTO usuariodto){
        String sql = "insert into usuario (usuario_nome,usuario_senha,usuario_email) values (?,?,?)";
        
        
        try {
            conn = new ConexaoDAO().conectaBD();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuariodto.getNomeUsuario());
            pstm.setString(2, usuariodto.getSenhaUsuario());
            pstm.setString(3, usuariodto.getEmailUsuario());
            pstm.execute();
            pstm.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO " + erro);
        }
    }
    public ResultSet conferirUsuario(UsuarioDTO usuariodto) {
        conn = new ConexaoDAO().conectaBD();
        try{
            String sql = "select * from usuario where usuario_nome = ? and usuario_senha = ? ";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuariodto.getNomeUsuario());
            pstm.setString(2, usuariodto.getSenhaUsuario());
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioDAO " + erro);
            return null;
        } 
    }
    public ResultSet conferirEmail (UsuarioDTO usuariodto) {
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "select * from usuario where usuario_nome = ? and usuario_email = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuariodto.getNomeUsuario());
            pstm.setString(2, usuariodto.getEmailUsuario());
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO " +erro);
            return null;
        }
    }
    public void alterarSenha(UsuarioDTO usuariodto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "update usuario set usuario_senha = ? where usuario_nome = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuariodto.getSenhaUsuario());
            pstm.setString(2, usuariodto.getNomeUsuario());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso! ");
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioDAO " + erro);
        }
            
    }
    public int obterCod(UsuarioDTO usuariodto){
        conn = new ConexaoDAO().conectaBD();
        int valor = 0;
        try {
            String sql = "SELECT cod_usuario FROM usuario WHERE usuario_nome = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuariodto.getNomeUsuario());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                valor = rs.getInt(1);
            }
            return valor;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO " +erro);
        }
        return 0;
    }
    
}
