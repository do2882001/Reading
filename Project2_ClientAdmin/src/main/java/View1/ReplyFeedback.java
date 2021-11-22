/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View1;

import Admin.InterfaceAdmin.IReading;
import Model.DTO.FeedbackDTO;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.AccountInfo;

/**
 *
 * @author Do_Do
 */
public class ReplyFeedback extends javax.swing.JFrame {
    IReading adminrIReadingeading;
    FeedbackDTO fdto;
    AccountInfo accountInfo;
    /**
     * Creates new form ReplyFeedback
     */
    public ReplyFeedback(AccountInfo a,FeedbackDTO feedbackDTO) throws NotBoundException, MalformedURLException, RemoteException {
        fdto=feedbackDTO;
        accountInfo = a;
        System.out.println("Content: "+fdto.getContent());
        adminrIReadingeading = (IReading) Naming.lookup("rmi://localhost:7898/reading");
        initComponents();
        load();
    }

    private ReplyFeedback() {
       
    }
    void load(){
        txtContent.setText(fdto.getContent());
        txtUserId.setText(String.valueOf(fdto.getUserId()));
        txtDate.setText(fdto.getFeedBackDate().toString());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserId = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        txtContent = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReply = new javax.swing.JTextArea();
        btnReply = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(22, 39, 55));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jLabel1.setText("READ BOOK");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 11, 12, 367);
        jPanel1.add(jLabel1, gridBagConstraints);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 649, -1));

        jLabel2.setText("UserId:");
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 122, 106, 28));

        jLabel3.setText("Content:");
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 168, 106, 28));

        jLabel4.setText("Date:");
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 214, 106, 28));

        jLabel5.setText("Reply:");
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 106, 28));

        txtUserId.setText("jLabel6");
        txtUserId.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(txtUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 122, 165, 28));

        txtDate.setText("jLabel6");
        txtDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 214, 165, 28));

        txtContent.setText("jLabel6");
        txtContent.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(txtContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 168, 165, 30));

        txtReply.setColumns(20);
        txtReply.setRows(5);
        txtReply.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(txtReply);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 337, 228));

        btnReply.setText("Submit");
        btnReply.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplyActionPerformed(evt);
            }
        });
        getContentPane().add(btnReply, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, -1, -1));

        btnBack.setText("Back");
        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnReplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplyActionPerformed
        try {
            StringBuilder sb = new StringBuilder();
            if (txtReply.getText().isEmpty()) {    
                return;
            }    
            fdto.setDescription(txtReply.getText());
            adminrIReadingeading.replyFeedback(fdto);
            this.setVisible(false);
            HomePageAdmin homePageAdmin = new HomePageAdmin(accountInfo);
            homePageAdmin.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(ReplyFeedback.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ReplyFeedback.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ReplyFeedback.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnReplyActionPerformed

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
            java.util.logging.Logger.getLogger(ReplyFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReplyFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReplyFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReplyFeedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReplyFeedback().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReply;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtContent;
    private javax.swing.JLabel txtDate;
    private javax.swing.JTextArea txtReply;
    private javax.swing.JLabel txtUserId;
    // End of variables declaration//GEN-END:variables
}
