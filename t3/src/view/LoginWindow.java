package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.Register;
import presenter.LoginPresenterListener;
import structures.Pair;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LoginWindow {

	// Primeira Etapa
	public JTextField _loginNameTextField;
	public JLabel _firstWarningLabel;
	
	// Segunda Etapa
	public JLabel _secondWarningLabel;
	public JButton _confirmButton;
	public JLabel _passwordDummyLabel;
	private JButton _b1JButton;
	private JButton _b2JButton;
	private JButton _b3JButton;
	private JButton _b4JButton;
	private JButton _b5JButton;
	
	// Terceira Etapa
	public JLabel _thirdWarningLabel;
	public JTextField _binPathJTextField;
	public JTextField _secretPhraseJTextField;
	private JButton _sendButton;
	
	private JFrame _frmLogin;
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
	
	public void loginWithErrorMessage(String str){
		login();
		_firstWarningLabel.setText(str);
		_firstWarningLabel.setVisible(true);
	}
	
	/**
	 * Volta para a tela de login
	 */
	public void login(){
		resetFirstLoginStep();
		resetSecondLoginStep();
		resetThirdLoginStep();
		
		Container mainContainer = _frmLogin.getContentPane();
		CardLayout cardsLayout = (CardLayout)(mainContainer.getLayout());
		cardsLayout.show(mainContainer, "loginPanel");
	}
	
	/**
	 * Avança para a tela de senha
	 */
	public void loginNameSucceded(){
		resetFirstLoginStep();
		resetSecondLoginStep();
		resetThirdLoginStep();
		
		Container mainContainer = _frmLogin.getContentPane();
		CardLayout cardsLayout = (CardLayout)(mainContainer.getLayout());
		cardsLayout.show(mainContainer, "passwordPanel");
	}
	
	/**
	 * Avança para a tela de chave privada
	 */
	public void passwordSucceded(){
		resetFirstLoginStep();
		resetSecondLoginStep();
		resetThirdLoginStep();
		
		Container mainContainer = _frmLogin.getContentPane();
		CardLayout cardsLayout = (CardLayout)(mainContainer.getLayout());
		cardsLayout.show(mainContainer, "privateKeyPanel");
	}
	
	private void resetFirstLoginStep()
	{
		_loginNameTextField.setText("");;
		_firstWarningLabel.setText("");
		_firstWarningLabel.setVisible(false);
	}
	
	private void resetSecondLoginStep()
	{
		_secondWarningLabel.setVisible(false);
		_passwordDummyLabel.setText("");
		enableVirtualButtons(true);
		_confirmButton.setEnabled(false);
	}
	
	private void resetThirdLoginStep()
	{
		 _binPathJTextField.setText("");
		 _secretPhraseJTextField.setText("");
		_thirdWarningLabel.setText("");
		_thirdWarningLabel.setVisible(false);
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
		_frmLogin.getContentPane().add(loginPanel, "loginPanel");
		
		JLabel firstWarningLabel = new JLabel("Primeira etapa");
		
		JLabel lblLogin = new JLabel("Login:");
		
		_loginNameTextField = new JTextField();
		_loginNameTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.loginButtonPressed();
			}
		});
		_loginNameTextField.setColumns(10);
		
		_sendButton = new JButton("Enviar");
		_sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.loginButtonPressed();
			}
		});
		
		_firstWarningLabel = new JLabel("Warning placeholder");
		_firstWarningLabel.setForeground(Color.RED);
		_firstWarningLabel.setVisible(false);
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
		
		_secondWarningLabel = new JLabel("Warning placeholder");
		_secondWarningLabel.setForeground(Color.RED);
		
		_b1JButton = new JButton("b1");
		_b1JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.passwordButtonPressed(_b1JButton.getText());
			}
		});
		
		_b2JButton = new JButton("b2");
		_b2JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.passwordButtonPressed(_b2JButton.getText());
			}
		});
		
		_b3JButton = new JButton("b3");
		_b3JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.passwordButtonPressed(_b3JButton.getText());
			}
		});
		
		_b4JButton = new JButton("b4");
		_b4JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.passwordButtonPressed(_b4JButton.getText());
			}
		});
		
		_b5JButton = new JButton("b5");
		_b5JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.passwordButtonPressed(_b5JButton.getText());
			}
		});
		
		_passwordDummyLabel = new JLabel("");
		
		_confirmButton = new JButton("Confirmar");
		_confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.confirmPasswordButtonPressed();
			}
		});
		GroupLayout gl_passwordPanel = new GroupLayout(passwordPanel);
		gl_passwordPanel.setHorizontalGroup(
			gl_passwordPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_passwordPanel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_passwordPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_passwordPanel.createSequentialGroup()
							.addGroup(gl_passwordPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEtapa)
								.addGroup(gl_passwordPanel.createSequentialGroup()
									.addGroup(gl_passwordPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_passwordPanel.createSequentialGroup()
											.addGap(38)
											.addComponent(_b1JButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(_b2JButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED))
										.addGroup(Alignment.TRAILING, gl_passwordPanel.createSequentialGroup()
											.addComponent(senhaLabel)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_passwordPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_passwordPanel.createSequentialGroup()
											.addComponent(_b3JButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(_b4JButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(_b5JButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
										.addComponent(_passwordDummyLabel))))
							.addContainerGap(56, Short.MAX_VALUE))
						.addGroup(gl_passwordPanel.createSequentialGroup()
							.addComponent(_secondWarningLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
							.addComponent(_confirmButton)
							.addGap(16))))
		);
		gl_passwordPanel.setVerticalGroup(
			gl_passwordPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_passwordPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEtapa)
					.addGap(49)
					.addGroup(gl_passwordPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(senhaLabel)
						.addComponent(_passwordDummyLabel))
					.addGap(18)
					.addGroup(gl_passwordPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(_b5JButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(_b4JButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(_b3JButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(_b2JButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(_b1JButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addGap(81)
					.addGroup(gl_passwordPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(_secondWarningLabel)
						.addComponent(_confirmButton))
					.addGap(23))
		);
		passwordPanel.setLayout(gl_passwordPanel);
		
		JPanel privateKeyPanel = new JPanel();
		_frmLogin.getContentPane().add(privateKeyPanel, "privateKeyPanel");
		
		_thirdWarningLabel = new JLabel("Warning placeholder");
		_thirdWarningLabel.setForeground(Color.RED);
		
		JLabel lblTerceiraEtapa = new JLabel("Terceira etapa");
		
		JLabel lblCami = new JLabel("Caminho para o arquivo binário:");
		
		_binPathJTextField = new JTextField();
		_binPathJTextField.setColumns(10);
		
		JButton browseJButton = new JButton("Localizar");
		browseJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				
				int result = fileChooser.showOpenDialog(_frmLogin);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					_binPathJTextField.setText(selectedFile.getPath());
				}
			}
		});
		
		JLabel lblFraseSecreta = new JLabel("Frase secreta:");
		
		_secretPhraseJTextField = new JTextField();
		_secretPhraseJTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_listener.authenticateButtonPressed();
			}
		});
		_secretPhraseJTextField.setColumns(10);
		
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
					.addGap(16)
					.addGroup(gl_privateKeyPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTerceiraEtapa)
						.addGroup(gl_privateKeyPanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_privateKeyPanel.createSequentialGroup()
								.addGroup(gl_privateKeyPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblCami)
									.addComponent(_thirdWarningLabel))
								.addGroup(gl_privateKeyPanel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_privateKeyPanel.createSequentialGroup()
										.addGap(70)
										.addComponent(authenticateJButton))
									.addGroup(Alignment.TRAILING, gl_privateKeyPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(browseJButton)
										.addGap(13))))
							.addGroup(gl_privateKeyPanel.createSequentialGroup()
								.addComponent(lblFraseSecreta)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(_secretPhraseJTextField, 289, 289, 289)))
						.addComponent(_binPathJTextField))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_privateKeyPanel.setVerticalGroup(
			gl_privateKeyPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_privateKeyPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTerceiraEtapa)
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(gl_privateKeyPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCami)
						.addComponent(browseJButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(_binPathJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_privateKeyPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFraseSecreta)
						.addComponent(_secretPhraseJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_privateKeyPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(_thirdWarningLabel)
						.addComponent(authenticateJButton))
					.addGap(28))
		);
		privateKeyPanel.setLayout(gl_privateKeyPanel);
		
		_frmLogin.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Register r = new Register(1002, -1, null, null);
				r.Log();
		    	System.exit(0);
		    }
		});
	}

	public void populatePasswordButtons(ArrayList<Pair<String, String>> buttons) {
		_b1JButton.setText(buttons.get(0).first + "-" + buttons.get(0).second);
		_b2JButton.setText(buttons.get(1).first + "-" + buttons.get(1).second);
		_b3JButton.setText(buttons.get(2).first + "-" + buttons.get(2).second);
		_b4JButton.setText(buttons.get(3).first + "-" + buttons.get(3).second);
		_b5JButton.setText(buttons.get(4).first + "-" + buttons.get(4).second);
	}

	public void enableVirtualButtons(boolean enable) {
		_b1JButton.setEnabled(enable);
		_b2JButton.setEnabled(enable);
		_b3JButton.setEnabled(enable);
		_b4JButton.setEnabled(enable);
		_b5JButton.setEnabled(enable);
	}

}
