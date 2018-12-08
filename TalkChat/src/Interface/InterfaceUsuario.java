package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import modelos.Mensagem;

/**
 *
 * @author aluno
 */
public interface InterfaceUsuario extends Remote {

    public void encaminhaMensagem(Mensagem mensagem) throws RemoteException;  //método para encaminhar mensagens

}
