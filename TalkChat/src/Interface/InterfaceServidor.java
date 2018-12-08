package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import modelos.Mensagem;

public interface InterfaceServidor extends Remote {

    public void enviarMensagem(Mensagem mensagem) throws RemoteException; //método para enviar mensagens

    public ArrayList<String> autentica(String login, String enderecoIp) throws RemoteException;
    
    public ArrayList<String> atualizaListaUsuariosOnline() throws RemoteException;
   
}
