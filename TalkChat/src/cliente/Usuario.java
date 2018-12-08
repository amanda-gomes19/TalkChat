package cliente;

import Interface.Constant;
import java.util.Scanner;
import modelos.Mensagem;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import Interface.InterfaceServidor;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidorcliente.ServidorCliente;

public class Usuario {

    ArrayList<String> usuariosOnline = new ArrayList<String>();
    InterfaceServidor remote;
    Mensagem mensagem;
    String conteudoMensagem;
    InetAddress localhost;
    private static Usuario uniqueInstance;

    public Usuario() {

    }

    public static synchronized Usuario getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Usuario();
        }
        return uniqueInstance;

    }

    public ArrayList<String> getArrayUsuariosOnline() {
        return usuariosOnline;
        
    }

    public InterfaceServidor getRemote() {
        return remote;
    }
    
    

    
    
    public void login(String login) {

        try {

            //IP do Servidor
            Registry registry = LocateRegistry.getRegistry("172.16.0.89", Constant.RMI_PORT);
            this.remote = (InterfaceServidor) registry.lookup(Constant.RMI_ID);
            Scanner scanner = new Scanner(System.in);

            //String login = JOptionPane.showInputDialog("Digite o login ");
            localhost = InetAddress.getLocalHost();
            //System.out.print(localhost.getHostAddress());
            usuariosOnline = remote.autentica(login, localhost.getHostAddress());
            
            //System.out.println("Usuarios online: " + usuariosOnline.toString());
            atualizaListaUsuariosOnlineLocal(remote);

            //remote.enviarMensagem(mensagem);//manda pro servidor
            //enviaMensagemLocal(remote);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

    }

    public void enviaMensagemLocal(InterfaceServidor remote) throws RemoteException {

        while (true) {
            mensagem = new Mensagem();
            mensagem.setDestinatario(JOptionPane.showInputDialog("Nome do destinatário:"));
            conteudoMensagem = JOptionPane.showInputDialog("Mensagem");//recebe o digitado
            mensagem.setConteudoMensagem(conteudoMensagem);
            mensagem.setIpRemetente(localhost.getHostAddress());
            remote.enviarMensagem(mensagem);
            atualizaListaUsuariosOnlineLocal(remote);
        }

    }

    public void atualizaListaUsuariosOnlineLocal(InterfaceServidor remote) {

        // atualiza lista de usuarios online
        Thread threadName = new Thread() {
            public void run() {
                try {
                    // metodo para atualizacao
                    usuariosOnline.clear();
                    usuariosOnline = remote.atualizaListaUsuariosOnline();
                    System.out.println("Usuários online: " + usuariosOnline.toString());
                } catch (RemoteException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        threadName.start();

    }

//    public static void main(String[] args) {
//
//        ServidorCliente servidorCliente = new ServidorCliente();
//        Usuario usuario = new Usuario();
//
//        servidorCliente.iniciaCliente();
//        usuario.login(login);
//
//    }
}
