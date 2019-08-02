import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class LogIn extends javax.swing.JFrame {
   
    private javax.swing.JTextField L_IDTextField;
    private javax.swing.JLabel L_IDlabel;
    private javax.swing.JButton L_Loginbtn;
    private javax.swing.JPanel jPanel1;
   
    Client client;
    
    public LogIn(Client client) {
        super("로그인");
        this.client = client;
        initComponents();
    }
    public void windowClosing(WindowEvent e) {
                System.exit(0);
        }
    
    public void showMessage(String title, String content) {
		JOptionPane.showMessageDialog(null, content, title, JOptionPane.ERROR_MESSAGE);	
	}
    
    
    
    public void createChatRoom() {
    	String name = L_IDTextField.getText();
		if (name.isEmpty()) {
			showMessage("오류", "이름을 입력하세요.");
		} else {
			client.setName(name);
			//client.threadStart();
			//client.sendName();
			
			ChatRoom chatroom = new ChatRoom(name,client);				
			chatroom.show();
			this.hide();		
		}
	}

	private void L_LoginbtnActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
		// LogIn login = new LogIn();
		
		if (evt.getSource() == L_Loginbtn) {
			createChatRoom();
		}
	}

    
	private void L_IDTextFieldKeyPressed(KeyEvent evt) {
		// TODO add your handling code here:
		// LogIn login = new LogIn();
		
		if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
			createChatRoom();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        L_Loginbtn = new javax.swing.JButton();
        L_IDlabel = new javax.swing.JLabel();
        L_IDTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        L_Loginbtn.setText("로그인");
        L_Loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_LoginbtnActionPerformed(evt);
            }
        });

        L_IDlabel.setText("아이디");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(L_IDlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(L_Loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(L_IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        L_IDTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
               L_IDTextFieldKeyPressed(evt);
            }
        });
        
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_IDlabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(L_IDTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(L_Loginbtn)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }     
}