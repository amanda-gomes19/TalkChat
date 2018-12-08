package modelos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author aluno
 */
// <
public class TabelaUsuario {

    private HashMap<String, String> usuarios = new HashMap<>();
    private ArrayList<String> usuariosOnline = new ArrayList<String>();

    public HashMap<String, String> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(HashMap<String, String> usuarios) {
        this.usuarios = usuarios;
    }

    public void adicionaUsuario(String login, String enderecoIp) {
        usuarios.put(login, enderecoIp);
        usuarios.toString();
    }

    public String getUsuario(String login) {
        return usuarios.get(login);
     
    }

    public ArrayList<String> getUsuariosOnline() {
        return usuariosOnline;
    }

    public void setUsuariosOnline(ArrayList<String> nomesUsuarios) {
        this.usuariosOnline = nomesUsuarios;
    }
    
       public void setUsuarioOnline(String login) {
        this.usuariosOnline.add(login);
    }
       
    @Override
    public String toString() {
        return "Usuários:" + usuarios;
    }

}
