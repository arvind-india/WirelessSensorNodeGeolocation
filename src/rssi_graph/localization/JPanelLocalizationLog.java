/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPanelLocalizationLog.java
 *
 * Created on Apr 3, 2011, 8:48:21 PM
 */

package rssi_graph.localization;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import rssi_graph.JPannelLoggerLogElement;
import rssi_graph.RSSI_graphApp;

/**
 *
 * @author ph4r05
 */
public class JPanelLocalizationLog extends javax.swing.JPanel {
    private Date date;
    private DateFormat dateFormat;

    /** Creates new form JPanelLocalizationLog */
    public JPanelLocalizationLog() {
        initComponents();
        this.dateFormat = new SimpleDateFormat("HH:mm:ss");
        this.date = new Date();
    }

        /**
     * Appends log element to text area in given format
     * @param a
     */
    public synchronized void appendLog(JPannelLoggerLogElement a){
        // get date string from time
        // this could call jPannelLoggerLogElement method to be polymorphic
        // adding this class to linked list should be allowed
        this.date.setTime(a.getTime());
        this.append("[" + this.dateFormat.format(this.date) + "; " + a.getTypeString() + "]: " + a.getText());
    }


    /**
     * Add specified log entry to log window and to linked list
     * @param a
     */
    public void addLogEntry(JPannelLoggerLogElement a){
        this.appendLog(a);
        this.jTextAreaLocLog.repaint();
    }

    /**
     * Builds log entry element and add it
     * @param s
     */
    public void addLogEntry(String s){
        this.addLogEntry(s, 0, "Default", 0, System.currentTimeMillis());
    }

    public void addLogEntry(String s, int type, String typeString, int subtype, int code,  int severity){
        JPannelLoggerLogElement tmp = new JPannelLoggerLogElement(System.currentTimeMillis(), typeString, type, subtype, code, severity, s);
        this.addLogEntry(tmp);
    }

    public void addLogEntry(String s, int type, String typeString, int severity){
        this.addLogEntry(s, type, typeString, severity, System.currentTimeMillis());
    }

    public void addLogEntry(String s, int type, String typeString, int severity, long time){
        JPannelLoggerLogElement tmp = new JPannelLoggerLogElement(time, typeString, type, 0, 0, severity, s);
        this.addLogEntry(tmp);
    }

    /**
     * Append string to log window with line separator
     * @param s
     */
    public synchronized void append(String s){
        this.appendStr(s + RSSI_graphApp.getLineSeparator());
    }

    /**
     * Append string to log window without separator
     * @param s
     */
    public synchronized void appendStr(String s){
        this.jTextAreaLocLog.append(s);

        // autoscroll
        if (true){ //this.isAutoscroll()){
            this.jTextAreaLocLog.setCaretPosition(this.jTextAreaLocLog.getText().length());
        }
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaLocLog = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();

        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextAreaLocLog.setColumns(20);
        jTextAreaLocLog.setEditable(false);
        jTextAreaLocLog.setRows(5);
        jTextAreaLocLog.setName("jTextAreaLocLog"); // NOI18N
        jScrollPane1.setViewportView(jTextAreaLocLog);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(rssi_graph.RSSI_graphApp.class).getContext().getResourceMap(JPanelLocalizationLog.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jButtonClear.setText(resourceMap.getString("jButtonClear.text")); // NOI18N
        jButtonClear.setName("jButtonClear"); // NOI18N
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButtonClear});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClear)
                    .addComponent(jButton1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
        this.jTextAreaLocLog.setText("");
    }//GEN-LAST:event_jButtonClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaLocLog;
    // End of variables declaration//GEN-END:variables

}
