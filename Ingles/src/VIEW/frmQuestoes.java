/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import DAO.ExameDAO;
import DTO.ConteudoDTO;
import DTO.ExameDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author Alexandre
 */
public class frmQuestoes extends javax.swing.JFrame {
    int usuario=0;
    public static int contador = 0;
    public static int contadorPT = 0;
    ConteudoDTO conteudo = new ConteudoDTO ();
    int i = conteudo.obterLinhas("1");
    public double nFrases = i/2;
    double peso = nFrases/10;
    double nota = 0;
    public boolean para = false;
    public frmQuestoes() throws FileNotFoundException, InterruptedException {
        
        initComponents();
        

        if(contador==0){
            btnComecar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnComecar.setText("Proximo");
                    if(contador>=0&&contador<nFrases){
                        lbContador.setText("Questão "+(Integer.toString(contador+1))+"/"+i/2);
                        try {
                            String[] valoresPt= conteudo.conteudoPt("1"); 
                            
                            lbQuestao.setText("");
                            lbQuestao.setText(lbQuestao.getText()+ "<html>" + valoresPt[contador] + "<br/>");
                            if(contador>0){
                                String[] valoresING= conteudo.conteudoIng("1");
                                String texto = txtResposta.getText().toUpperCase();
                                if(texto.equals(valoresING[contadorPT])){
                                    nota = nota + peso;
                                    System.out.println(nota);
                                }
                                contadorPT++;
                            }
                            
                            contador++;
                            txtResposta.setText("");
                            
                            if (contador == nFrases){
                                btnComecar.setText("Concluir");;
                            }
                        } catch (FileNotFoundException ex) {
                        }
                    } else {
                        ExameDTO examedto = new ExameDTO();
                        examedto.setCodUsuario(usuario);
                        examedto.setDescExame("EX1");
                        examedto.setVlrNota(nota);
                        
                        ExameDAO examedao = new ExameDAO();
                        examedao.inserirNota(examedto);
                        
                        JOptionPane.showMessageDialog(null, nota);
                        para=true;
                    }
                    
                }
            });
            
        }
          
/*
        this.txtResposta.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("Hello");
                    JOptionPane.showMessageDialog(null, "Enter key pressed !");
                }

            }
        });
        */
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        lbQuestao = new javax.swing.JLabel();
        txtResposta = new javax.swing.JTextField();
        btnComecar = new javax.swing.JButton();
        lbContador = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(102, 0, 102));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbQuestao.setFont(new java.awt.Font("Arial", 0, 17));
        jPanel1.add(lbQuestao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 30));

        txtResposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespostaActionPerformed(evt);
            }
        });
        jPanel1.add(txtResposta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 370, -1));

        btnComecar.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btnComecar.setText("Começar");
        btnComecar.setBorderPainted(false);
        btnComecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComecarActionPerformed(evt);
            }
        });
        jPanel1.add(btnComecar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, 30));
        btnComecar.setBackground(new java.awt.Color(255, 255, 255));

        lbContador.setFont(new java.awt.Font("Consolas", 3, 12)); // NOI18N
        jPanel1.add(lbContador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void txtRespostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespostaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespostaActionPerformed

    private void btnComecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComecarActionPerformed
        System.out.println(usuario);
        if(para){
            this.setVisible(false);       
        }
    }//GEN-LAST:event_btnComecarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmQuestoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQuestoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQuestoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQuestoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {   
                    new frmQuestoes().setVisible(true);
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(frmQuestoes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmQuestoes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComecar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lbContador;
    private javax.swing.JLabel lbQuestao;
    private javax.swing.JTextField txtResposta;
    // End of variables declaration//GEN-END:variables
}
