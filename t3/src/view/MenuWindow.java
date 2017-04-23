package view;

import presenter.MenuPresenterListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class MenuWindow {

	private JFrame _frmMenu;
	private JPanel _body2;
	private JPanel _body1;
	private JPanel _header;
	private JTextField filePath2JTextField;
	private JPasswordField passwordField;
	private JPasswordField password2JTextField;
	private JTextField filePath1JTextField;
	private JTable listarJButton;
	
	private MenuPresenterListener _listener;
	
	/**
	 * Create the application.
	 */
	public MenuWindow(MenuPresenterListener listener) {
		_listener = listener;
		initialize();
	}
	
	/**
	 * Shows the window
	 */
	public void show(){
		goToMenu();
		_frmMenu.setVisible(true);
	}
	
	/**
	 * Mostra o card de menu
	 */
	private void goToMenu(){
		CardLayout cardsLayout = (CardLayout)(_body2.getLayout());
		cardsLayout.show(_body2, "menuPanel");
		
		cardsLayout = (CardLayout)(_body1.getLayout());
		cardsLayout.show(_body1, "totalAcessosJPanel");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_frmMenu = new JFrame();
		_frmMenu.setResizable(false);
		_frmMenu.setTitle("Menu");
		_frmMenu.setBounds(100, 100, 600, 400);
		_frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		_header = new JPanel();
		_header.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		_body1 = new JPanel();
		_body1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		_body2 = new JPanel();
		_body2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout groupLayout = new GroupLayout(_frmMenu.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(_header, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
						.addComponent(_body1, GroupLayout.PREFERRED_SIZE, 588, Short.MAX_VALUE)
						.addComponent(_body2, GroupLayout.PREFERRED_SIZE, 588, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(_header, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(_body1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(_body2, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addContainerGap())
		);
		_body2.setLayout(new CardLayout(0, 0));
		
		JPanel sairPanel = new JPanel();
		_body2.add(sairPanel, "sairPanel");
		
		JButton sairJButton = new JButton("Sair");
		sairJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_frmMenu.dispatchEvent(new WindowEvent(_frmMenu, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		JLabel lblSaidaDoSistema = new JLabel("Saída do sistema:");
		
		JButton back1JButton = new JButton("Voltar ao menu");
		back1JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToMenu();
			}
		});
		
		JLabel lblPressioneOBotao = new JLabel("Pressione o botão Sair para confirmar.");
		GroupLayout gl_sairPanel = new GroupLayout(sairPanel);
		gl_sairPanel.setHorizontalGroup(
			gl_sairPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_sairPanel.createSequentialGroup()
					.addGroup(gl_sairPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_sairPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(back1JButton)
							.addPreferredGap(ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
							.addComponent(sairJButton))
						.addGroup(gl_sairPanel.createSequentialGroup()
							.addGap(243)
							.addComponent(lblSaidaDoSistema)))
					.addContainerGap())
				.addGroup(gl_sairPanel.createSequentialGroup()
					.addContainerGap(181, Short.MAX_VALUE)
					.addComponent(lblPressioneOBotao)
					.addGap(164))
		);
		gl_sairPanel.setVerticalGroup(
			gl_sairPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sairPanel.createSequentialGroup()
					.addGap(13)
					.addComponent(lblSaidaDoSistema)
					.addGap(51)
					.addComponent(lblPressioneOBotao)
					.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
					.addGroup(gl_sairPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(back1JButton)
						.addComponent(sairJButton))
					.addContainerGap())
		);
		sairPanel.setLayout(gl_sairPanel);
		
		JPanel arquivosPanel = new JPanel();
		_body2.add(arquivosPanel, "arquivosPanel");
		
		JLabel lblCaminhoDaPasta = new JLabel("Caminho da pasta:");
		
		filePath1JTextField = new JTextField();
		filePath1JTextField.setColumns(10);
		
		JButton back2JButton = new JButton("Voltar ao menu");
		back2JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToMenu();
			}
		});
		
		JButton browse1JButton = new JButton("Localizar");
		
		JButton listJButton = new JButton("Listar");
		
		listarJButton = new JTable();
		GroupLayout gl_arquivosPanel = new GroupLayout(arquivosPanel);
		gl_arquivosPanel.setHorizontalGroup(
			gl_arquivosPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_arquivosPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_arquivosPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_arquivosPanel.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_arquivosPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(listarJButton, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
								.addGroup(gl_arquivosPanel.createSequentialGroup()
									.addComponent(lblCaminhoDaPasta)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(filePath1JTextField, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(browse1JButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_arquivosPanel.createSequentialGroup()
							.addComponent(back2JButton)
							.addPreferredGap(ComponentPlacement.RELATED, 354, Short.MAX_VALUE)
							.addComponent(listJButton)))
					.addContainerGap())
		);
		gl_arquivosPanel.setVerticalGroup(
			gl_arquivosPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_arquivosPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_arquivosPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCaminhoDaPasta)
						.addComponent(filePath1JTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(browse1JButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listarJButton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_arquivosPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(back2JButton)
						.addComponent(listJButton)))
		);
		arquivosPanel.setLayout(gl_arquivosPanel);
		
		JPanel certificadoPanel = new JPanel();
		_body2.add(certificadoPanel, "certificadoPanel");
		
		JLabel lblChavePrivada = new JLabel("Chave privada:");
		
		JButton back3JButton = new JButton("Voltar ao menu");
		back3JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToMenu();
			}
		});
		
		JLabel lblCertificado = new JLabel("Certificado:");
		
		JTextPane privateKeyJTextPane = new JTextPane();
		privateKeyJTextPane.setEditable(false);
		privateKeyJTextPane.setText("Placeholder");
		
		JTextPane certificateJTextPane = new JTextPane();
		certificateJTextPane.setEditable(false);
		certificateJTextPane.setText("Placeholder");
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.LIGHT_GRAY);
		GroupLayout gl_certificadoPanel = new GroupLayout(certificadoPanel);
		gl_certificadoPanel.setHorizontalGroup(
			gl_certificadoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_certificadoPanel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_certificadoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(back3JButton)
						.addGroup(gl_certificadoPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(privateKeyJTextPane, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblChavePrivada)))
					.addGap(13)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_certificadoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCertificado, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addComponent(certificateJTextPane, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(287, Short.MAX_VALUE))
		);
		gl_certificadoPanel.setVerticalGroup(
			gl_certificadoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_certificadoPanel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_certificadoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChavePrivada)
						.addComponent(lblCertificado))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_certificadoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_certificadoPanel.createSequentialGroup()
							.addComponent(privateKeyJTextPane, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addComponent(back3JButton))
						.addComponent(certificateJTextPane, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(8, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_certificadoPanel.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		certificadoPanel.setLayout(gl_certificadoPanel);
		
		JPanel cadastroPanel = new JPanel();
		_body2.add(cadastroPanel, "cadastroPanel");
		
		JLabel lblFormularioDeCadastro = new JLabel("Formulário de Cadastro:");
		
		JButton signupJButton = new JButton("Cadastrar");
		
		JLabel lblCaminhoDoArquivo = new JLabel("Caminho do arquivo do certificado digital:");
		
		filePath2JTextField = new JTextField();
		filePath2JTextField.setColumns(10);
		
		JButton browse2JButton = new JButton("Localizar");
		
		JLabel lblGrupo = new JLabel("Grupo:");
		
		JComboBox groupJComboBox = new JComboBox();
		
		JLabel lblSenhaPessoal = new JLabel("Senha pessoal:");
		
		JLabel lblConfirmacaoDaSenha = new JLabel("Confirmação da senha pessoal:");
		
		passwordField = new JPasswordField();
		
		JButton back4JButton = new JButton("Voltar ao menu");
		back4JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToMenu();
			}
		});
		
		password2JTextField = new JPasswordField();
		GroupLayout gl_cadastroPanel = new GroupLayout(cadastroPanel);
		gl_cadastroPanel.setHorizontalGroup(
			gl_cadastroPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastroPanel.createSequentialGroup()
					.addGroup(gl_cadastroPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cadastroPanel.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_cadastroPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_cadastroPanel.createSequentialGroup()
									.addGroup(gl_cadastroPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_cadastroPanel.createSequentialGroup()
											.addComponent(lblCaminhoDoArquivo)
											.addGap(12)
											.addComponent(filePath2JTextField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
										.addComponent(back4JButton))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_cadastroPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(browse2JButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
										.addComponent(signupJButton))
									.addGap(283))
								.addGroup(gl_cadastroPanel.createSequentialGroup()
									.addComponent(lblSenhaPessoal)
									.addGap(18)
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addGap(114)
									.addComponent(lblGrupo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(groupJComboBox, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_cadastroPanel.createSequentialGroup()
									.addComponent(lblConfirmacaoDaSenha, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(password2JTextField, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_cadastroPanel.createSequentialGroup()
							.addGap(237)
							.addComponent(lblFormularioDeCadastro)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_cadastroPanel.setVerticalGroup(
			gl_cadastroPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadastroPanel.createSequentialGroup()
					.addGap(13)
					.addComponent(lblFormularioDeCadastro)
					.addGap(18)
					.addGroup(gl_cadastroPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCaminhoDoArquivo)
						.addComponent(filePath2JTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(browse2JButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cadastroPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenhaPessoal)
						.addComponent(groupJComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGrupo)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cadastroPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmacaoDaSenha)
						.addComponent(password2JTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadastroPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(back4JButton)
						.addComponent(signupJButton))
					.addContainerGap())
		);
		cadastroPanel.setLayout(gl_cadastroPanel);
		
		JPanel menuPanel = new JPanel();
		_body2.add(menuPanel, "menuPanel");
		
		JLabel lblMenuPrincipal = new JLabel("Menu Principal:");
		
		JButton cadastrarMenuJButton = new JButton("Cadastrar um novo usuário");
		cadastrarMenuJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardsLayout = (CardLayout)(_body2.getLayout());
				cardsLayout.show(_body2, "cadastroPanel");
				
				cardsLayout = (CardLayout)(_body1.getLayout());
				cardsLayout.show(_body1, "totalUsuariosJPanel");
			}
		});
		
		JButton listarMenuJButton = new JButton("Listar chave privada e certificado digital do usuário");
		listarMenuJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardsLayout = (CardLayout)(_body2.getLayout());
				cardsLayout.show(_body2, "certificadoPanel");
				
				cardsLayout = (CardLayout)(_body1.getLayout());
				cardsLayout.show(_body1, "totalListagemJPanel");
			}
		});
		
		JButton consultarMenuJButton = new JButton("Consultar pasta de arquivos secretos do usuário");
		consultarMenuJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardsLayout = (CardLayout)(_body2.getLayout());
				cardsLayout.show(_body2, "arquivosPanel");
				
				cardsLayout = (CardLayout)(_body1.getLayout());
				cardsLayout.show(_body1, "totalConsultasJPanel");
			}
		});
		
		JButton sairMenuJButton = new JButton("Sair do Sistema");
		sairMenuJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardsLayout = (CardLayout)(_body2.getLayout());
				cardsLayout.show(_body2, "sairPanel");
				
				cardsLayout = (CardLayout)(_body1.getLayout());
				cardsLayout.show(_body1, "totalAcessosJPanel");
			}
		});
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(
			gl_menuPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_menuPanel.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(listarMenuJButton)
								.addComponent(cadastrarMenuJButton)
								.addComponent(consultarMenuJButton)
								.addComponent(sairMenuJButton)))
						.addGroup(gl_menuPanel.createSequentialGroup()
							.addGap(243)
							.addComponent(lblMenuPrincipal)))
					.addContainerGap(469, Short.MAX_VALUE))
		);
		gl_menuPanel.setVerticalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addGap(13)
					.addComponent(lblMenuPrincipal)
					.addGap(18)
					.addComponent(cadastrarMenuJButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listarMenuJButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(consultarMenuJButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sairMenuJButton)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		menuPanel.setLayout(gl_menuPanel);
		_body1.setLayout(new CardLayout(0, 0));
		
		JPanel totalListagemJPanel = new JPanel();
		_body1.add(totalListagemJPanel, "totalListagemJPanel");
		
		JLabel totalListagemLabel = new JLabel("Total de listagem do usuário:");
		
		JLabel listagemLabel = new JLabel("placeholder");
		GroupLayout gl_totalListagemJPanel = new GroupLayout(totalListagemJPanel);
		gl_totalListagemJPanel.setHorizontalGroup(
			gl_totalListagemJPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 857, Short.MAX_VALUE)
				.addGap(0, 857, Short.MAX_VALUE)
				.addGroup(gl_totalListagemJPanel.createSequentialGroup()
					.addGap(32)
					.addComponent(totalListagemLabel)
					.addGap(18)
					.addComponent(listagemLabel)
					.addGap(281))
		);
		gl_totalListagemJPanel.setVerticalGroup(
			gl_totalListagemJPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGroup(gl_totalListagemJPanel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_totalListagemJPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(totalListagemLabel)
						.addComponent(listagemLabel))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		totalListagemJPanel.setLayout(gl_totalListagemJPanel);
		
		JPanel totalConsultasJPanel = new JPanel();
		_body1.add(totalConsultasJPanel, "totalConsultasJPanel");
		
		JLabel totalConsultasLabel = new JLabel("Total de consultas do usuário:");
		
		JLabel consultasLabel = new JLabel("placeholder");
		GroupLayout gl_totalConsultasJPanel = new GroupLayout(totalConsultasJPanel);
		gl_totalConsultasJPanel.setHorizontalGroup(
			gl_totalConsultasJPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 857, Short.MAX_VALUE)
				.addGroup(gl_totalConsultasJPanel.createSequentialGroup()
					.addGap(32)
					.addComponent(totalConsultasLabel)
					.addGap(18)
					.addComponent(consultasLabel)
					.addGap(281))
		);
		gl_totalConsultasJPanel.setVerticalGroup(
			gl_totalConsultasJPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGroup(gl_totalConsultasJPanel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_totalConsultasJPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(totalConsultasLabel)
						.addComponent(consultasLabel))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		totalConsultasJPanel.setLayout(gl_totalConsultasJPanel);
		
		JPanel totalUsuariosJPanel = new JPanel();
		_body1.add(totalUsuariosJPanel, "totalUsuariosJPanel");
		
		JLabel totalUsuariosLabel = new JLabel("Total de usuários do sistema:");
		
		JLabel usuariosLabel = new JLabel("placeholder");
		GroupLayout gl_totalUsuariosJPanel = new GroupLayout(totalUsuariosJPanel);
		gl_totalUsuariosJPanel.setHorizontalGroup(
			gl_totalUsuariosJPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 584, Short.MAX_VALUE)
				.addGroup(gl_totalUsuariosJPanel.createSequentialGroup()
					.addGap(32)
					.addComponent(totalUsuariosLabel)
					.addGap(18)
					.addComponent(usuariosLabel)
					.addGap(281))
		);
		gl_totalUsuariosJPanel.setVerticalGroup(
			gl_totalUsuariosJPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGroup(gl_totalUsuariosJPanel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_totalUsuariosJPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(totalUsuariosLabel)
						.addComponent(usuariosLabel))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		totalUsuariosJPanel.setLayout(gl_totalUsuariosJPanel);
		
		JPanel totalAcessosJPanel = new JPanel();
		
		JLabel acessosLabel = new JLabel("placeholder");
		
		JLabel totalAcessosLabel = new JLabel("Total de acessos do usuário:");
		_body1.add(totalAcessosJPanel, "totalAcessosJPanel");
		GroupLayout gl_totalAcessosJPanel = new GroupLayout(totalAcessosJPanel);
		gl_totalAcessosJPanel.setHorizontalGroup(
			gl_totalAcessosJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_totalAcessosJPanel.createSequentialGroup()
					.addGap(32)
					.addComponent(totalAcessosLabel)
					.addGap(18)
					.addComponent(acessosLabel)
					.addGap(281))
		);
		gl_totalAcessosJPanel.setVerticalGroup(
			gl_totalAcessosJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_totalAcessosJPanel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_totalAcessosJPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(totalAcessosLabel)
						.addComponent(acessosLabel))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		totalAcessosJPanel.setLayout(gl_totalAcessosJPanel);
		
		JLabel lblLogin = new JLabel("Login:");
		
		JLabel lblNewLabel = new JLabel("Grupo:");
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel loginLabel = new JLabel("loginPlaceholder");
		
		JLabel grupoLabel = new JLabel("grupoPlaceholder");
		
		JLabel nomeLabel = new JLabel("nomePlaceholder");
		GroupLayout gl__header = new GroupLayout(_header);
		gl__header.setHorizontalGroup(
			gl__header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl__header.createSequentialGroup()
					.addGap(33)
					.addGroup(gl__header.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNome)
						.addGroup(gl__header.createParallelGroup(Alignment.LEADING)
							.addComponent(lblLogin)
							.addComponent(lblNewLabel)))
					.addGap(24)
					.addGroup(gl__header.createParallelGroup(Alignment.LEADING)
						.addComponent(loginLabel)
						.addComponent(grupoLabel)
						.addComponent(nomeLabel))
					.addContainerGap(374, Short.MAX_VALUE))
		);
		gl__header.setVerticalGroup(
			gl__header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl__header.createSequentialGroup()
					.addGap(12)
					.addGroup(gl__header.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(loginLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl__header.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(grupoLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl__header.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(nomeLabel))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		_header.setLayout(gl__header);
		_frmMenu.getContentPane().setLayout(groupLayout);
	}
}
