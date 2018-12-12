package servidor;

import Interface.Constant;
import Interface.Constant1;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import modelos.Mensagem;
import modelos.TabelaUsuario;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interface.InterfaceServidor;
import Interface.InterfaceUsuario;
import java.util.ArrayList;

public class Servidor implements InterfaceServidor {

    private TabelaUsuario tabelaUsuario = new TabelaUsuario();
    private String msgRecebida = "Sem mensagem";
    private static Servidor uniqueInstance;
    private String todasMensagens;


    public Servidor() {
        
    }
    
     public static synchronized Servidor getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Servidor();
        }
        return uniqueInstance;

    }

    public String getTodasMensagens() {
        return todasMensagens;
    }

    public void setTodasMensagens(String todasMensagens) {
        this.todasMensagens = todasMensagens;
    }

     
    
    public void iniciaServidor() throws RemoteException{
         try {

            Servidor servidor = new Servidor();

            InterfaceServidor usuarioInterface = (InterfaceServidor) UnicastRemoteObject.exportObject(servidor, 0);

            Registry registry = LocateRegistry.createRegistry(Constant.RMI_PORT);

            registry.bind(Constant.RMI_ID, usuarioInterface);

            System.out.println("Servidor pronto!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.toString());
            e.printStackTrace();
        }
    }

    public void enviarMensagem(Mensagem mensagem) throws RemoteException {

        try {

            Registry registry = LocateRegistry.getRegistry(buscaDestinatario(mensagem.getDestinatario()), Constant1.RMI_PORT);
            InterfaceUsuario remote = (InterfaceUsuario) registry.lookup(Constant1.RMI_ID);
            setTodasMensagens(mensagem.toString());
            String ipDestinatario = tabelaUsuario.getUsuario(mensagem.getDestinatario());
            msgRecebida = mensagem.getConteudoMensagem();

            remote.encaminhaMensagem(mensagem);

        } catch (NotBoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public String buscaDestinatario(String destinatario) {
        String ipDestinatario = null;

        if (tabelaUsuario.getUsuarios().containsKey(destinatario)) {
            ipDestinatario = tabelaUsuario.getUsuario(destinatario);
        }
        return ipDestinatario;

    }

    public ArrayList<String> autentica(String login, String enderecoIp) throws RemoteException {
        tabelaUsuario.adicionaUsuario(login, enderecoIp);
        tabelaUsuario.setUsuarioOnline(login)   ;
        System.out.println("Tabela de usuarios: " + tabelaUsuario.toString());



        return tabelaUsuario.getUsuariosOnline();
    }

    
    public ArrayList<String> atualizaListaUsuariosOnline() throws RemoteException {
        ArrayList<String> listaUsuarios = tabelaUsuario.getUsuariosOnline();
        return listaUsuarios;
    }

}
