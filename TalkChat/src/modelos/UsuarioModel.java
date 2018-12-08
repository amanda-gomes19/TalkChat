
package modelos;

/**
 *
 * @author aluno
 */


public class UsuarioModel {
    private String login;
    private String enderecoIp;

    public UsuarioModel(String login, String enderecoIp) {
        this.login = login;
        this.enderecoIp = enderecoIp;
    }

    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEnderecoIp() {
        return enderecoIp;
    }

    public void setEnderecoIp(String enderecoIp) {
        this.enderecoIp = enderecoIp;
    }
    
    }
