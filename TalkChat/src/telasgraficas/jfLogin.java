package telasgraficas;

import cliente.Usuario;
import servidorcliente.ServidorCliente;

/**
 *
 * @author aluno
 */
public class jfLogin extends javax.swing.JFrame {

    /**
     * Creates new form jfLogin
     */
    public jfLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpLogin = new javax.swing.JPanel();
        jlTalkChat = new javax.swing.JLabel();
        jlLogin = new javax.swing.JLabel();
        jtInsereLogin = new javax.swing.JTextField();
        jbLogar = new javax.swing.JButton();
        jbVoltarTelaInicial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlTalkChat.setFont(new java.awt.Font("Abyssinica SIL", 1, 36)); // NOI18N
        jlTalkChat.setText("TalkChat");

        jlLogin.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jlLogin.setText("Login");

        jtInsereLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtInsereLoginActionPerformed(evt);
            }
        });

        jbLogar.setText("Logar");
        jbLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLogarActionPerformed(evt);
            }
        });

        jbVoltarTelaInicial.setText("Voltar");
        jbVoltarTelaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVoltarTelaInicialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpLoginLayout = new javax.swing.GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jlTalkChat))
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlLogin)
                            .addComponent(jtInsereLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbVoltarTelaInicial)
                .addGap(18, 18, 18)
                .addComponent(jbLogar)
                .addGap(25, 25, 25))
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jlTalkChat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtInsereLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLogar)
                    .addComponent(jbVoltarTelaInicial))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtInsereLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtInsereLoginActionPerformed

    }//GEN-LAST:event_jtInsereLoginActionPerformed

    private void jbLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLogarActionPerformed
        // TODO add your handling code here:
        ServidorCliente servidorCliente = new ServidorCliente();
        servidorCliente.iniciaCliente();
        Usuario usuario = Usuario.getInstance();

        usuario.login(getLogin());

        this.setVisible(false);
        jfTalkChat jfTalkChat = new jfTalkChat();
        jfTalkChat.setVisible(true);
    }//GEN-LAST:event_jbLogarActionPerformed

    private void jbVoltarTelaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarTelaInicialActionPerformed
        this.setVisible(false);

        jfTelaInicial jfTelaInicial = new jfTelaInicial();
        jfTelaInicial.setVisible(true);
    }//GEN-LAST:event_jbVoltarTelaInicialActionPerformed

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
            java.util.logging.Logger.getLogger(jfLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbLogar;
    private javax.swing.JButton jbVoltarTelaInicial;
    private javax.swing.JLabel jlLogin;
    private javax.swing.JLabel jlTalkChat;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JTextField jtInsereLogin;
    // End of variables declaration//GEN-END:variables

    public String getLogin() {
        String login = jtInsereLogin.getText();
        return login;
    }

}