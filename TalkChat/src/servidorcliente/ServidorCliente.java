package servidorcliente;

import Interface.Constant1;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import Interface.InterfaceUsuario;
import modelos.Mensagem;

/**
 *
 * @author aluno
 */
public class ServidorCliente implements InterfaceUsuario {

    public ServidorCliente() {
    }

    public void iniciaCliente() {
        try {

            ServidorCliente servidorCliente = new ServidorCliente();
            InterfaceUsuario usuarioInterface = (InterfaceUsuario) UnicastRemoteObject.exportObject(servidorCliente, 0);

            Registry registry = LocateRegistry.createRegistry(Constant1.RMI_PORT);

            registry.bind(Constant1.RMI_ID, usuarioInterface);
            
            System.out.println("Servidor cliente iniciado...");

        } catch (Exception e) {
            System.out.println("Erro: " + e.toString());
            e.printStackTrace();
        }
    }

    public void encaminhaMensagem(Mensagem mensagem) throws RemoteException {
        System.out.println("A mensagem recebida é: " + mensagem.getConteudoMensagem());
    }

}
