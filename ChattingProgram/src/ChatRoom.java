/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class ChatRoom extends javax.swing.JFrame {
   private JButton CR_SendBtn = new JButton();
   private JTextArea CR_TextArea = new JTextArea();
   private JTextField CR_TextField = new JTextField();
   private JPanel CR_jPanel1 = new JPanel();
   private JScrollPane CR_jScrollPane1 = new JScrollPane();
   private JButton CR_Closebtn = new JButton();
  
   String name;
   Client client;
   
    public ChatRoom(String name, Client client) {
    	this.name = name;
    	this.client = client;
    	client.setName(name);
    	client.setTextArea(CR_TextArea);
    	client.threadStart();
    	client.sendName();
    	 initComponents();
       
    }
    
    
    private void CR_TextFieldKeyPressed(KeyEvent evt) {                                        
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {

            String words = CR_TextField.getText();
            String msg = "[" + name + "] " + words +"\n"; 
            CR_jScrollPane1.getVerticalScrollBar().setValue(CR_jScrollPane1.getVerticalScrollBar().getMaximum());
            client.sendMessage(name,msg);
            CR_TextField.setText("");
        }
    }                                       

                                        

    private void CR_SendBtnActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
            if (evt.getSource() == CR_SendBtn) {
              //À§¶û °°Àº ¼Ò½º µé¾î°¥²¨
              //  String words = CR_TextField.getText();
              //  CR_TextArea.append(id + " : ");
              //  CR_TextArea.append(words + "\n");
              //  CR_TextField.setText("");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void CR_ClosebtnActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
       
        if (evt.getSource() == CR_Closebtn){
        	System.exit(0);
        }
    }   
    
    @SuppressWarnings("unchecked")                  
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CR_TextArea.setColumns(20);
        CR_TextArea.setRows(5);
        CR_TextArea.setEditable(false);
        

        CR_jScrollPane1.setViewportView(CR_TextArea);

        javax.swing.GroupLayout CR_jPanel1Layout = new javax.swing.GroupLayout(CR_jPanel1);
        CR_jPanel1.setLayout(CR_jPanel1Layout);
        CR_jPanel1Layout.setHorizontalGroup(
            CR_jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CR_jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CR_jScrollPane1)
                .addContainerGap())
        );
        CR_jPanel1Layout.setVerticalGroup(
            CR_jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CR_jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CR_jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
        );

        CR_SendBtn.setText("Àü¼Û");
        CR_SendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CR_SendBtnActionPerformed(evt);
            }
        });

        CR_TextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        CR_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CR_TextFieldKeyPressed(evt);
            }
        });

        CR_Closebtn.setText("´Ý±â");
        CR_Closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CR_ClosebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CR_jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CR_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CR_SendBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(CR_Closebtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CR_jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CR_SendBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CR_Closebtn))
                    .addComponent(CR_TextField))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>                        

}