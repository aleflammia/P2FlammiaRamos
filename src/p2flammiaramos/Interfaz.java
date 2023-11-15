/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package p2flammiaramos;

public class Interfaz extends javax.swing.JFrame {


    public Interfaz() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Queue = new javax.swing.JButton();
        spZE1 = new javax.swing.JScrollPane();
        taZE1 = new javax.swing.JTextArea();
        spZE2 = new javax.swing.JScrollPane();
        taZE2 = new javax.swing.JTextArea();
        spZE3 = new javax.swing.JScrollPane();
        taZE3 = new javax.swing.JTextArea();
        spZE4 = new javax.swing.JScrollPane();
        taZE4 = new javax.swing.JTextArea();
        spSF1 = new javax.swing.JScrollPane();
        taSF1 = new javax.swing.JTextArea();
        spSF2 = new javax.swing.JScrollPane();
        taSF2 = new javax.swing.JTextArea();
        spSF3 = new javax.swing.JScrollPane();
        taSF3 = new javax.swing.JTextArea();
        spSF4 = new javax.swing.JScrollPane();
        taSF4 = new javax.swing.JTextArea();
        lblSelected = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Queue.setText("jButton1");
        Queue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QueueActionPerformed(evt);
            }
        });
        getContentPane().add(Queue, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        taZE1.setColumns(20);
        taZE1.setLineWrap(true);
        taZE1.setRows(5);
        taZE1.setWrapStyleWord(true);
        spZE1.setViewportView(taZE1);

        getContentPane().add(spZE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        taZE2.setColumns(20);
        taZE2.setLineWrap(true);
        taZE2.setRows(5);
        taZE2.setWrapStyleWord(true);
        spZE2.setViewportView(taZE2);

        getContentPane().add(spZE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        taZE3.setColumns(20);
        taZE3.setLineWrap(true);
        taZE3.setRows(5);
        taZE3.setWrapStyleWord(true);
        spZE3.setViewportView(taZE3);

        getContentPane().add(spZE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        taZE4.setColumns(20);
        taZE4.setLineWrap(true);
        taZE4.setRows(5);
        taZE4.setWrapStyleWord(true);
        spZE4.setViewportView(taZE4);

        getContentPane().add(spZE4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        taSF1.setColumns(20);
        taSF1.setLineWrap(true);
        taSF1.setRows(5);
        taSF1.setWrapStyleWord(true);
        spSF1.setViewportView(taSF1);

        getContentPane().add(spSF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        taSF2.setColumns(20);
        taSF2.setLineWrap(true);
        taSF2.setRows(5);
        taSF2.setWrapStyleWord(true);
        spSF2.setViewportView(taSF2);

        getContentPane().add(spSF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        taSF3.setColumns(20);
        taSF3.setLineWrap(true);
        taSF3.setRows(5);
        taSF3.setWrapStyleWord(true);
        spSF3.setViewportView(taSF3);

        getContentPane().add(spSF3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, -1, -1));

        taSF4.setColumns(20);
        taSF4.setLineWrap(true);
        taSF4.setRows(5);
        taSF4.setWrapStyleWord(true);
        spSF4.setViewportView(taSF4);

        getContentPane().add(spSF4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, -1, -1));
        getContentPane().add(lblSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 210, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QueueActionPerformed
        //Personaje p = new Personaje("Nintendo");
    }//GEN-LAST:event_QueueActionPerformed

    public void updateQueues(Queue ZE1, Queue ZE2, Queue ZE3, Queue ZE4, Queue SF1, Queue SF2, Queue SF3, Queue SF4){
        this.updateQueue(taSF1, SF1);
        this.updateQueue(taSF2, SF2);
        this.updateQueue(taSF3, SF3);
        this.updateQueue(taSF4, SF4);
        
        this.updateQueue(taZE1, ZE1);
        this.updateQueue(taZE2, ZE2);
        this.updateQueue(taZE3, ZE3);
        this.updateQueue(taZE4, ZE4);

    }
    
    private void updateQueue(javax.swing.JTextArea ta, Queue q){
        ta.setText("");
        if (q.isEmpty()){return;}
        Personaje head = q.getHead();
        ta.append(head.id);
        head = head.getNext();
        while (head!=null){
            ta.append("  -  " + head.id);
            head = head.getNext();
        }
    }
    
    public void updateSelected(String string){
        this.lblSelected.setText(string);
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Queue;
    private javax.swing.JLabel lblSelected;
    private javax.swing.JScrollPane spSF1;
    private javax.swing.JScrollPane spSF2;
    private javax.swing.JScrollPane spSF3;
    private javax.swing.JScrollPane spSF4;
    private javax.swing.JScrollPane spZE1;
    private javax.swing.JScrollPane spZE2;
    private javax.swing.JScrollPane spZE3;
    private javax.swing.JScrollPane spZE4;
    private javax.swing.JTextArea taSF1;
    private javax.swing.JTextArea taSF2;
    private javax.swing.JTextArea taSF3;
    private javax.swing.JTextArea taSF4;
    private javax.swing.JTextArea taZE1;
    private javax.swing.JTextArea taZE2;
    private javax.swing.JTextArea taZE3;
    private javax.swing.JTextArea taZE4;
    // End of variables declaration//GEN-END:variables
}
