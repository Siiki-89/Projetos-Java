
package DTO;


public class UsuarioDTO {
    private String nomeUsuario;
    private String senhaUsuario;
    private String emailUsuario;
    public String usuario;

    public void UsuarioDTOCadastro(String nomeUsuario, String senhaUsuario, String emailUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        this.emailUsuario = emailUsuario;
    }
    public void usuarioDTOLogin (String nomeUsuario, String senhaUsuario){
        this.nomeUsuario=nomeUsuario;
        this.senhaUsuario=senhaUsuario;
    }
    public void usuarioDTIEsqueciSenha(String nomeUsuario, String emailUsuario){
        this.nomeUsuario= nomeUsuario;
        this.emailUsuario= emailUsuario;
    }
    

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
    
}
