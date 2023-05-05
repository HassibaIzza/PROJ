/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CLINIC PC
 */
public class facteur extends javax.swing.JFrame {
    
    DefaultTableModel modele = new DefaultTableModel();
    Connection conn;
    Statement stm;
    ResultSet Rs;
 PreparedStatement insert;
    
    public facteur() {
        initComponents();
        modele.addColumn("N°");
        modele.addColumn("Désignation");
        modele.addColumn("Quantité");
        modele.addColumn("P.U");
        modele.addColumn("Montants:");
             
                try{
            connect();
            stm=conn.createStatement();
            ResultSet Rs = stm.executeQuery("SELECT * FROM facteur");
            while(Rs.next()){
                modele.addRow(new Object[] {Rs.getInt("N"),Rs.getString("des")
                    ,Rs.getString("qua"),Rs.getInt("pu"),Rs.getString("mon")});
            }
        }catch(Exception e){
            System.err.println(e);
        }
         tab.setModel(modele);
    }
     public void connect (){
      try{
          conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/nrbdd" ,"root","");
          System.out.println("connection Etablie");
          
      }catch (Exception e) {
            System.out.println(""+e);
        }
  }
    public void afficher_tab() {
    try{
    connect();
    modele.setRowCount(0);
    stm= conn.createStatement();
    ResultSet Rs = stm.executeQuery("SELECT * FROM stock");
    while(Rs.next()){
        
        modele.addRow(new Object[] {Rs.getInt("N"),Rs.getString("des")
                    ,Rs.getString("qua"),Rs.getInt("pu"),Rs.getString("mon")});

    }
    }catch(Exception e){
        System.err.println(e);
    } 
      tab.setModel(modele);
      }
  
      
       // initComponents();
        

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
     
     
      private void deplace_et(int i){
           
           
           try{
                  connect();
                  stm= conn.createStatement();
                    
                  int selectioner = tab.getSelectedRow();
                 DefaultTableModel model =(DefaultTableModel)tab.getModel();
                 jn.setText(model.getValueAt(selectioner,0).toString());
                 jd.setText(model.getValueAt(selectioner,1).toString());
                jq.setText(model.getValueAt(selectioner,2).toString());
                 jpu.setText(model.getValueAt(selectioner,3).toString());
                 jm.setText(model.getValueAt(selectioner,4).toString());

                 
                 
              }catch(Exception e){
                  JOptionPane.showMessageDialog(null, "erreur de depalcemente"+e.getLocalizedMessage());
              }
      }
     
      
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jd = new javax.swing.JTextField();
        jpu = new javax.swing.JTextField();
        jq = new javax.swing.JTextField();
        jm = new javax.swing.JTextField();
        jn = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("facteur ");

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel1.setText("Service des moiyen Générau");

        jPanel3.setBackground(new java.awt.Color(51, 0, 51));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Désignation:");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Quantité:");

        jLabel4.setBackground(new java.awt.Color(204, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("P.U");

        jd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdActionPerformed(evt);
            }
        });
        jd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdKeyPressed(evt);
            }
        });

        jpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpuActionPerformed(evt);
            }
        });
        jpu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpuKeyPressed(evt);
            }
        });

        jq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jqActionPerformed(evt);
            }
        });
        jq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jqKeyPressed(evt);
            }
        });

        jm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmMouseClicked(evt);
            }
        });
        jm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmActionPerformed(evt);
            }
        });
        jm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jmKeyPressed(evt);
            }
        });

        jButton4.setText("Montants:");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jq, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jpu, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jm, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(jpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        tab.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N°", "Désignation  ", "Qualité", "P.U", "Montants"
            }
        ));
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Modifier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel5.setText("MOSTAGANEM ");

        jLabel6.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel6.setText("FACULTE DES SCIENCES EXACTS ET INFORMATIQUE");

        jLabel7.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 24)); // NOI18N
        jLabel7.setText("FACTURE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 28, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addGap(51, 51, 51)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(181, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpuActionPerformed

    private void jdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdActionPerformed

    private void jqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jqActionPerformed

    private void jdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdKeyPressed
 char c =evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
            //saiser juste les lettres
           jd.setEditable(true);
            // messge errur
            
            
            
        }else{
           jd.setEditable(false);
            // messge errur
            
            JOptionPane.showMessageDialog(null,"les lettres seulement");
        }     // TODO add your handling code here:
    }//GEN-LAST:event_jdKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        //insert dans bdd
        String des = jd.getText();
        String qt = jq.getText();
        String prix = jpu.getText();
        String mon= jm.getText();
        
        try {
             if (des.equals("") && qt.equals("") && prix.equals("") && mon.equals("")
                     ){
                  JOptionPane.showMessageDialog(null,"Sisaier vos information SVP");
             }else{
            System.out.println("dans le try");
          

           conn=DriverManager.getConnection("jdbc:mysql://localhost/nrbdd?" ,"root","");
           String query = ("INSERT INTO `stock`(`des`,`qua`,`pu`,`mon`)values(?,?,?,?)");
           PreparedStatement insert = conn.prepareStatement(query);
           insert.setString(1, des);
           insert.setString(2,qt);
           insert.setString(3, prix);
           insert.setString(4, mon);

           
           insert.execute();
           
           JOptionPane.showMessageDialog(null,"Article a bien ajouteé");
           afficher_tab();
        jd.setText("");
        jq.setText("");
        jpu.setText("");
        jm.setText("");
        jd.requestFocus();
        
       // sexe.setText("");
        
             }

        } catch (SQLException e) {
            System.out.println(""+e);
        }           
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        //modification ;
          try{
           connect();
            int ligne = tab.getSelectedRow();
            if(ligne!=-1){
            
           insert= conn.prepareStatement("UPDATE stock SET des=?, qua=?, pu=? ,"
                   + " mon=? WHERE N=?");
           
            insert.setString(1, jd.getText());
            insert.setString(2,jq.getText());
            insert.setString(3, jpu.getText());
            insert.setString(4, jm.getText());
            insert.setString(5, jn.getText());
            
            insert.execute();
            conn.close();
            JOptionPane.showMessageDialog(null,"Les information son bien modifier ");
            afficher_tab();
            }else{
               JOptionPane.showMessageDialog(null,"sélectionner une ligne svp ");
          }
           
           
           
        
      }catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        // TODO add your handling code here:
        
        //selection:
         try{
           
              int i = tab.getSelectedRow();
              deplace_et(i);
              
          }catch (Exception e) {
            System.out.println("null"+e);
         }
    }//GEN-LAST:event_tabMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         try{
        int ligne =tab.getSelectedRow();
        if(ligne!=-1){
            if(JOptionPane.showConfirmDialog(null,"vous etes sur veuillez supprimer ce Article? "
                ,"supprimer Article  ",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                /* DefaultTableModel modéle = (DefaultTableModel)jTable1.getModel();
            //int ligne =jTable1.getSelectedRow();
            modéle.removeRow(ligne);*/ 
                if(jn.getText().length()!=0){
                    stm.executeUpdate(" DELETE FROM  stock WHERE N='"+jn.getText()+"' ");
                    afficher_tab();
                    
                }
        }
        
        }else{
            JOptionPane.showMessageDialog(null,"sélectionner une ligne svp ");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        // calculer montans :
         double prix = Double.parseDouble(jpu.getText());
         double qua= Double.parseDouble(jq.getText());
             double montants= qua * prix;
             jm.setText(+montants+"DA");
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmMouseClicked
        // TODO add your handling code here:
        
        //  Afficher montans 
        JOptionPane.showMessageDialog(null,"Clicque sur montans svp!");
    }//GEN-LAST:event_jmMouseClicked

    private void jmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmKeyPressed
        // TODO add your handling code here:
        // msg 
        JOptionPane.showMessageDialog(null,"Clicque sur montans svp!");
    }//GEN-LAST:event_jmKeyPressed

    private void jqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jqKeyPressed
        // TODO add your handling code here:
        //condition 
         char c =evt.getKeyChar();
        if(Character.isLetter(c)){
            //saiser juste le nombre 
            jq.setEditable(false);
            // messge errur
             JOptionPane.showMessageDialog(null,"  que des nombre svp");
            
            
        }else{
            jq.setEditable(true);
            
        }
    }//GEN-LAST:event_jqKeyPressed

    private void jpuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpuKeyPressed
        // TODO add your handling code here:
        //condition 
         char c =evt.getKeyChar();
        if(Character.isLetter(c)){
            //saiser juste le nombre 
            jpu.setEditable(false);
            // messge errur
             JOptionPane.showMessageDialog(null,"que des nombre svp");
            
            
        }else{
            jpu.setEditable(true);
            
        }
    }//GEN-LAST:event_jpuKeyPressed

    private void jmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmActionPerformed

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
            java.util.logging.Logger.getLogger(facteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new facteur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jd;
    private javax.swing.JTextField jm;
    private javax.swing.JTextField jn;
    private javax.swing.JTextField jpu;
    private javax.swing.JTextField jq;
    private javax.swing.JTable tab;
    // End of variables declaration//GEN-END:variables

}
