
package modelos;

import java.io.Serializable;

/**
 *
 * @author aluno
 */


public class Mensagem implements Serializable {
    
    private String conteudoMensagem;
    private String destinatario;
    private String ipRemetente;
    
    private static final long serialVersionUID = 10L;

    public String getConteudoMensagem() {
        return conteudoMensagem;
    }

    public void setConteudoMensagem(String conteudoMensagem) {
        this.conteudoMensagem = conteudoMensagem;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getIpRemetente() {
        return ipRemetente;
    }

    public void setIpRemetente(String ipRemetente) {
        this.ipRemetente = ipRemetente;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "conteudoMensagem=" + conteudoMensagem + ", destinatario=" + destinatario + ", ipRemetente=" + ipRemetente + '}';
    }
    
    
    
}
