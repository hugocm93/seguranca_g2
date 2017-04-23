package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import presenter.LoginPresenterListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginWindow {

	private JFrame _frmLogin;
	
	private JTextField _loginNameTextField;
	private JTextField binPathJTextField;
	private JTextField secretPhraseJTextField;
	private JButton _sendButton;
	
	private LoginPresenterListener _listener;

	
	/**
	 * Cria a interface
	 */
	public LoginWindow(LoginPresenterListener listener) {
		_listener = listener;
		initialize();
	}
	
	/**
	 * Mostra a janela
	 */
	public void show(){
		_frmLogin.setVisible(true);
	}
	
	/**
	 * Avança para a tela de senha
	 */
	public void loginNameSucceded(){
		Container mainContainer = _frmLogin.getContentPane();
		CardLayout cardsLayout = (CardLayout)(mainContainer.getLayout());
		cardsLayout.show(mainContainer, "passwordPanel");
	}
	
	/**
	 * Avança para a tela de chave privada
	 */
	public void passwordSucceded(){
		Container mainContainer = _frmLogin.getContentPane();
		CardLayout cardsLayout = (CardLayout)(mainContainer.getLayout());
		cardsLayout.show(mainContainer, "privateKeyPanel");
	}
	
	/**
	 * @return Frame principal da janela
	 */
	public JFrame getFrame() {
		return _frmLogin;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_frmLogin = new JFrame();
		_frmLogin.setTitle("Login");
		_frmLogin.setResizable(false);
		_frmLogin.setBounds(100, 100, 450, 300);
		_frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frmLogin.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel loginPanel = new JPanel();
		_frmLogin.getContentPane().add(loginPanel, "name_122878281770506");
		
		JLabel firstWarningLabel = new JLabel("Primeira etapa");
		
		JLabel lblLogin = new JLabel("Login:");
		
		_loginNameTextField = new JTextField();
		_loginNameTextField.setColumns(10);
		
		_sendButton = new JButton("Enviar");
		_sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.loginButtonPressed();
			}
		});
		
		JLabel _firstWarningLabel = new JLabel("Warning placeholder");
		_firstWarningLabel.setForeground(Color.RED);
		GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
		gl_loginPanel.setHorizontalGroup(
			gl_loginPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGap(135)
							.addComponent(lblLogin)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(_loginNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(_firstWarningLabel)
								.addComponent(firstWarningLabel))))
					.addContainerGap(136, Short.MAX_VALUE))
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addContainerGap(197, Short.MAX_VALUE)
					.addComponent(_sendButton)
					.addGap(171))
		);
		gl_loginPanel.setVerticalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(firstWarningLabel)
					.addGap(79)
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(_loginNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLogin))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(_sendButton)
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addComponent(_firstWarningLabel)
					.addGap(26))
		);
		loginPanel.setLayout(gl_loginPanel);
		
		JPanel passwordPanel = new JPanel();
		_frmLogin.getContentPane().add(passwordPanel, "passwordPanel");
		
		JLabel lblEtapa = new JLabel("Segunda etapa");
		
		JLabel senhaLabel = new JLabel("Senha:");
		
		JLabel secondWarningLabel = new JLabel("Warning placeholder");
		secondWarningLabel.setForeground(Color.RED);
		
		JButton b1JButton = new JButton("b1");
		b1JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.passwordButtonPressed(b1JButton.getName());
			}
		});
		
		JButton b2JButton = new JButton("b2");
		b2JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.passwordButtonPressed(b2JButton.getName());
			}
		});
		
		JButton b3JButton = new JButton("b3");
		b3JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.passwordButtonPressed(b3JButton.getName());
			}
		});
		
		JButton b4JButton = new JButton("b4");
		b4JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.passwordButtonPressed(b4JButton.getName());
			}
		});
		
		JButton b5JButton = new JButton("b5");
		b5JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.passwordButtonPressed(b5JButton.getName());
			}
		});
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
		_frmLogin.getContentPane().add(privateKeyPanel, "privateKeyPanel");
		
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
		authenticateJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.authenticateButtonPressed();
			}
		});
		GroupLayout gl_privateKeyPanel = new GroupLayout(privateKeyPanel);
		gl_privateKeyPanel.setHorizontalGroup(
			gl_privateKeyPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_privateKeyPanel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_privateKeyPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_privateKeyPanel.createSequentialGroup()
							.addComponent(thirdWarningLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
							.addComponent(authenticateJButton))
						.addGroup(gl_privateKeyPanel.createSequentialGroup()
							.addComponent(lblFraseSecreta)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(secretPhraseJTextField, 289, 289, 289))
						.addComponent(lblTerceiraEtapa)
						.addGroup(gl_privateKeyPanel.createSequentialGroup()
							.addComponent(lblCami)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(browseJButton))
						.addComponent(binPathJTextField, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
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
					.addGap(56)
					.addGroup(gl_privateKeyPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_privateKeyPanel.createSequentialGroup()
							.addComponent(thirdWarningLabel)
							.addGap(24))
						.addGroup(gl_privateKeyPanel.createSequentialGroup()
							.addComponent(authenticateJButton)
							.addContainerGap())))
		);
		privateKeyPanel.setLayout(gl_privateKeyPanel);
	}
}
