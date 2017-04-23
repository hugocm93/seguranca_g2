package t3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginWindow {

	private JFrame frame;
	private JTextField loginNameTextField;
	private JTextField binPathJTextField;
	private JTextField secretPhraseJTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel loginPanel = new JPanel();
		frame.getContentPane().add(loginPanel, "name_122878281770506");
		
		JLabel label = new JLabel("Primeira etapa");
		
		JLabel lblLogin = new JLabel("Login:");
		
		loginNameTextField = new JTextField();
		loginNameTextField.setColumns(10);
		
		JButton sendButton = new JButton("Enviar");
		
		JLabel firstWarningLabel = new JLabel("Warning placeholder");
		firstWarningLabel.setForeground(Color.RED);
		GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
		gl_loginPanel.setHorizontalGroup(
			gl_loginPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGap(135)
							.addComponent(lblLogin)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(loginNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(firstWarningLabel)
								.addComponent(label))))
					.addContainerGap(136, Short.MAX_VALUE))
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addContainerGap(197, Short.MAX_VALUE)
					.addComponent(sendButton)
					.addGap(171))
		);
		gl_loginPanel.setVerticalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(79)
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLogin))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sendButton)
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addComponent(firstWarningLabel)
					.addGap(26))
		);
		loginPanel.setLayout(gl_loginPanel);
		
		JPanel passwordPanel = new JPanel();
		frame.getContentPane().add(passwordPanel, "name_122141787324933");
		
		JLabel lblEtapa = new JLabel("Segunda etapa");
		
		JLabel senhaLabel = new JLabel("Senha:");
		
		JLabel secondWarningLabel = new JLabel("Warning placeholder");
		secondWarningLabel.setForeground(Color.RED);
		
		JButton b1JButton = new JButton("b1");
		
		JButton b2JButton = new JButton("b2");
		
		JButton b3JButton = new JButton("b3");
		b3JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton b4JButton = new JButton("b4");
		
		JButton b5JButton = new JButton("b5");
		GroupLayout gl_passwordPanel = new GroupLayout(passwordPanel);
		gl_passwordPanel.setHorizontalGroup(
			gl_passwordPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_passwordPanel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_passwordPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(secondWarningLabel)
						.addComponent(lblEtapa)
						.addGroup(gl_passwordPanel.createSequentialGroup()
							.addGap(38)
							.addComponent(b1JButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(b2JButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_passwordPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(senhaLabel)
								.addGroup(gl_passwordPanel.createSequentialGroup()
									.addComponent(b3JButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(b4JButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(b5JButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_passwordPanel.setVerticalGroup(
			gl_passwordPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_passwordPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEtapa)
					.addGap(49)
					.addComponent(senhaLabel)
					.addGap(18)
					.addGroup(gl_passwordPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(b5JButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(b4JButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(b3JButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(b2JButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(b1JButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addGap(81)
					.addComponent(secondWarningLabel)
					.addGap(23))
		);
		passwordPanel.setLayout(gl_passwordPanel);
		
		JPanel privateKeyPanel = new JPanel();
		frame.getContentPane().add(privateKeyPanel, "name_124689972447600");
		
		JLabel thirdWarningLabel = new JLabel("Warning placeholder");
		thirdWarningLabel.setForeground(Color.RED);
		
		JLabel lblTerceiraEtapa = new JLabel("Terceira etapa");
		
		JLabel lblCami = new JLabel("Caminho para o arquivo binário:");
		
		binPathJTextField = new JTextField();
		binPathJTextField.setColumns(10);
		
		JButton browseJButton = new JButton("Localizar");
		
		JLabel lblFraseSecreta = new JLabel("Frase secreta:");
		
		secretPhraseJTextField = new JTextField();
		secretPhraseJTextField.setColumns(10);
		
		JButton authenticateJButton = new JButton("Autenticar");
		GroupLayout gl_privateKeyPanel = new GroupLayout(privateKeyPanel);
		gl_privateKeyPanel.setHorizontalGroup(
			gl_privateKeyPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_privateKeyPanel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_privateKeyPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_privateKeyPanel.createSequentialGroup()
							.addComponent(thirdWarningLabel)
							.addContainerGap())
						.addGroup(gl_privateKeyPanel.createSequentialGroup()
							.addGroup(gl_privateKeyPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_privateKeyPanel.createSequentialGroup()
									.addComponent(lblFraseSecreta)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(secretPhraseJTextField))
								.addComponent(authenticateJButton, Alignment.TRAILING)
								.addComponent(lblTerceiraEtapa)
								.addGroup(gl_privateKeyPanel.createSequentialGroup()
									.addComponent(lblCami)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(browseJButton))
								.addComponent(binPathJTextField, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(238, Short.MAX_VALUE))))
		);
		gl_privateKeyPanel.setVerticalGroup(
			gl_privateKeyPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_privateKeyPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTerceiraEtapa)
					.addGap(38)
					.addGroup(gl_privateKeyPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCami)
						.addComponent(browseJButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(binPathJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_privateKeyPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFraseSecreta)
						.addComponent(secretPhraseJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(authenticateJButton)
					.addGap(9)
					.addComponent(thirdWarningLabel)
					.addGap(24))
		);
		privateKeyPanel.setLayout(gl_privateKeyPanel);
	}
}