
package DAO;

import DTO.ExameDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class ExameDAO {
    Connection conn;
    PreparedStatement pstm;
    
    public void inserirNota(ExameDTO exame){
        String sql = "insert into exame (cod_usuario,vlr_nota,descr_exame) values (?,?,?)";
        conn = new ConexaoDAO().conectaBD();
        try {           
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, exame.getCodUsuario());
            pstm.setDouble(2, exame.getVlrNota());
            pstm.setString(3, exame.getDescExame());
            pstm.execute();
            pstm.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO " + erro);
        }
    }
}
