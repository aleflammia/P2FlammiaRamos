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
        jSlider1 = new javax.swing.JSlider();
        lblSliderValue = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        taZE1.setBackground(java.awt.SystemColor.info);
        taZE1.setColumns(20);
        taZE1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        taZE1.setLineWrap(true);
        taZE1.setRows(5);
        taZE1.setWrapStyleWord(true);
        spZE1.setViewportView(taZE1);

        getContentPane().add(spZE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 180, -1));

        taZE2.setBackground(java.awt.SystemColor.info);
        taZE2.setColumns(20);
        taZE2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        taZE2.setLineWrap(true);
        taZE2.setRows(5);
        taZE2.setWrapStyleWord(true);
        spZE2.setViewportView(taZE2);

        getContentPane().add(spZE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 180, -1));

        taZE3.setBackground(java.awt.SystemColor.info);
        taZE3.setColumns(20);
        taZE3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        taZE3.setLineWrap(true);
        taZE3.setRows(5);
        taZE3.setWrapStyleWord(true);
        spZE3.setViewportView(taZE3);

        getContentPane().add(spZE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 180, -1));

        taZE4.setBackground(java.awt.SystemColor.info);
        taZE4.setColumns(20);
        taZE4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        taZE4.setLineWrap(true);
        taZE4.setRows(5);
        taZE4.setWrapStyleWord(true);
        spZE4.setViewportView(taZE4);

        getContentPane().add(spZE4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 180, -1));

        taSF1.setBackground(java.awt.SystemColor.info);
        taSF1.setColumns(20);
        taSF1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        taSF1.setLineWrap(true);
        taSF1.setRows(5);
        taSF1.setWrapStyleWord(true);
        spSF1.setViewportView(taSF1);

        getContentPane().add(spSF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 180, -1));

        taSF2.setBackground(java.awt.SystemColor.info);
        taSF2.setColumns(20);
        taSF2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        taSF2.setLineWrap(true);
        taSF2.setRows(5);
        taSF2.setWrapStyleWord(true);
        spSF2.setViewportView(taSF2);

        getContentPane().add(spSF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 180, -1));

        taSF3.setBackground(java.awt.SystemColor.info);
        taSF3.setColumns(20);
        taSF3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        taSF3.setLineWrap(true);
        taSF3.setRows(5);
        taSF3.setWrapStyleWord(true);
        spSF3.setViewportView(taSF3);

        getContentPane().add(spSF3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 180, -1));

        taSF4.setBackground(java.awt.SystemColor.info);
        taSF4.setColumns(20);
        taSF4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        taSF4.setLineWrap(true);
        taSF4.setRows(5);
        taSF4.setWrapStyleWord(true);
        spSF4.setViewportView(taSF4);

        getContentPane().add(spSF4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 180, -1));
        getContentPane().add(lblSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 210, 40));

        jSlider1.setBackground(new java.awt.Color(0, 51, 51));
        jSlider1.setMaximum(15);
        jSlider1.setMinimum(5);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setValue(10);
        jSlider1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 255, 255), new java.awt.Color(255, 255, 204), new java.awt.Color(0, 51, 51), new java.awt.Color(0, 102, 102)));
        jSlider1.setOpaque(true);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        getContentPane().add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, -1, 50));

        lblSliderValue.setBackground(new java.awt.Color(0, 51, 51));
        lblSliderValue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSliderValue.setForeground(new java.awt.Color(255, 255, 255));
        lblSliderValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSliderValue.setText("10");
        lblSliderValue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102), null, new java.awt.Color(0, 153, 153)));
        lblSliderValue.setOpaque(true);
        getContentPane().add(lblSliderValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 200, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/fondo.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        lblSliderValue.setText(Integer.toString(jSlider1.getValue()));
        //this.duration = slider.getValue();
    }//GEN-LAST:event_jSlider1StateChanged

    public String getDuration(){
        return lblSliderValue.getText();
    }
            
            
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
    private javax.swing.JLabel fondo;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lblSelected;
    private javax.swing.JLabel lblSliderValue;
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
