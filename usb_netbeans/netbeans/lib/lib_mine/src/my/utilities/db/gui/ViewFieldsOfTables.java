/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ViewFieldsOfTables.java
 *
 * Created on 2012/02/10, 22:41:41
 */
package my.utilities.db.gui;
import my.constants.*;
//import javax.swing.*;
import java.awt.Color;
//import java.util.*;

/**
 *
 * @author noriyuki
 */
public class ViewFieldsOfTables extends javax.swing.JFrame {


    //private javax.swing.JTree tree_of_tables;
    private javax.swing.JTree tree_of_tables;

    /** Creates new form ViewFieldsOfTables */
    public ViewFieldsOfTables() {
        initComponents();       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pane_main_tabbed = new javax.swing.JTabbedPane();
        pane_tables = new javax.swing.JScrollPane();
        btn_select_a_db_server = new javax.swing.JButton();
        btn_end = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View fields of tables");
        setName("frm_main"); // NOI18N

        pane_main_tabbed.setName("pane_main_tabbed"); // NOI18N

        pane_tables.setName("pane_tables"); // NOI18N
        pane_main_tabbed.addTab("tables", pane_tables);

        btn_select_a_db_server.setText("Select a db server");
        btn_select_a_db_server.setName("btn_select_a_db_server"); // NOI18N
        btn_select_a_db_server.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_select_a_db_serverMouseClicked(evt);
            }
        });

        btn_end.setText("end");
        btn_end.setName("btn_end"); // NOI18N
        btn_end.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_endMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btn_select_a_db_server)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_end, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(pane_main_tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(pane_main_tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_end)
                    .addComponent(btn_select_a_db_server))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_endMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_endMouseClicked
        // TODO add your handling code here:
        this.common_action_btn_end_clicked();
        
    }//GEN-LAST:event_btn_endMouseClicked

    private void btn_select_a_db_serverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_select_a_db_serverMouseClicked
        // TODO add your handling code here:
        this.common_action_btn_select_a_db_server_clicked();

    }//GEN-LAST:event_btn_select_a_db_serverMouseClicked
    //code 1

    private void common_action_btn_select_a_db_server_clicked(){
    
        my.db.classes.common.ParaSQLServer par_sqlserver=new my.db.classes.common.ParaSQLServer();
        javax.swing.JLabel label=new javax.swing.JLabel();
        
        //par_sqlserver=my.utilities.db.server_selector.ServerChooser.select();        
        par_sqlserver=(my.db.classes.common.ParaSQLServer)my.utilities.db.server_selector.ServerChooser.select();        
        if(my.db.utilities.Utilities.isEnableServer(par_sqlserver)){
            this.tree_of_tables=my.db.utilities.UtilitiesGUI.createTreeOfDatabase(par_sqlserver);
            if(this.tree_of_tables==null){
                label.setText("db have no tables.");
                label.setForeground(Color.RED);
                javax.swing.JOptionPane.showMessageDialog(this, label);
            }else{
                //this.tree_of_tables.addTreeSelectionListener(new my.db.gui.tree.listener.DatabaseListener());
                this.pane_tables.setViewportView(this.tree_of_tables);
            }
        }else{
            //failed connecting to db server
            //when failed
            label.setText("connecting db server is NG.");             
            label.setForeground(Color.RED);        
            javax.swing.JOptionPane.showMessageDialog(this, label);            
        }        
    }
    private void common_action_btn_end_clicked(){
        
        this.setVisible(false);
        System.exit(Constants.CS_SYSTEM_EXIT_OK);
        
    }
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
            java.util.logging.Logger.getLogger(ViewFieldsOfTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFieldsOfTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFieldsOfTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFieldsOfTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ViewFieldsOfTables().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_end;
    private javax.swing.JButton btn_select_a_db_server;
    private javax.swing.JTabbedPane pane_main_tabbed;
    private javax.swing.JScrollPane pane_tables;
    // End of variables declaration//GEN-END:variables
}
