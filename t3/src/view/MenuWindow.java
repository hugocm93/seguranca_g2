package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
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

public class MenuWindow {

	private JFrame frmMenu;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWindow window = new MenuWindow();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setResizable(false);
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 600, 400);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel header = new JPanel();
		header.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel body1 = new JPanel();
		body1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel body2 = new JPanel();
		body2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout groupLayout = new GroupLayout(frmMenu.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(body2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
						.addComponent(header, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
						.addComponent(body1, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(header, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(body1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(body2, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addContainerGap())
		);
		body2.setLayout(new CardLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		body2.add(panel_5, "name_130704517751394");
		
		JLabel lblCaminhoDaPasta = new JLabel("Caminho da pasta:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("Voltar ao menu");
		
		JButton button_2 = new JButton("Localizar");
		
		JButton btnListar = new JButton("Listar");
		
		table = new JTable();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(8)
							.addComponent(lblCaminhoDaPasta)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
							.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_panel_5.createSequentialGroup()
									.addGap(6)
									.addComponent(table, GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addComponent(button_1)
									.addPreferredGap(ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
									.addComponent(btnListar)))
							.addGap(275))))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCaminhoDaPasta)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(btnListar)))
		);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_2 = new JPanel();
		body2.add(panel_2, "name_130069326585595");
		
		JLabel lblChavePrivada = new JLabel("Chave privada:");
		
		JButton button = new JButton("Voltar ao menu");
		
		JLabel lblCertificado = new JLabel("Certificado:");
		
		JTextPane txtpnPlaceholder = new JTextPane();
		txtpnPlaceholder.setEditable(false);
		txtpnPlaceholder.setText("Placeholder");
		
		JTextPane txtpnPlaceholder_1 = new JTextPane();
		txtpnPlaceholder_1.setEditable(false);
		txtpnPlaceholder_1.setText("Placeholder");
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.LIGHT_GRAY);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addComponent(txtpnPlaceholder, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblChavePrivada)))
					.addGap(13)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCertificado, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnPlaceholder_1, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(287, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChavePrivada)
						.addComponent(lblCertificado))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(txtpnPlaceholder, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addComponent(button))
						.addComponent(txtpnPlaceholder_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(8, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_1 = new JPanel();
		body2.add(panel_1, "name_129271784350853");
		
		JLabel lblFormularioDeCadastro = new JLabel("Formulário de Cadastro:");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		JLabel lblCaminhoDoArquivo = new JLabel("Caminho do arquivo do certificado digital:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnLocalizar = new JButton("Localizar");
		
		JLabel lblGrupo = new JLabel("Grupo:");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblSenhaPessoal = new JLabel("Senha pessoal:");
		
		JLabel lblConfirmacaoDaSenha = new JLabel("Confirmação da senha pessoal:");
		
		passwordField = new JPasswordField();
		
		JButton btnVoltarAoMenu = new JButton("Voltar ao menu");
		
		passwordField_1 = new JPasswordField();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblCaminhoDoArquivo)
											.addGap(12)
											.addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
										.addComponent(btnVoltarAoMenu))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnLocalizar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnCadastrar))
									.addGap(283))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblSenhaPessoal)
									.addGap(18)
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addGap(114)
									.addComponent(lblGrupo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblConfirmacaoDaSenha, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(237)
							.addComponent(lblFormularioDeCadastro)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(13)
					.addComponent(lblFormularioDeCadastro)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCaminhoDoArquivo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLocalizar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenhaPessoal)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGrupo)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmacaoDaSenha)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltarAoMenu)
						.addComponent(btnCadastrar))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		body2.add(panel, "name_128964056480967");
		
		JLabel lblMenuPrincipal = new JLabel("Menu Principal:");
		
		JButton btnNewButton = new JButton("Cadastrar um novo usuário");
		
		JButton btnListarChavePrivada = new JButton("Listar chave privada e certificado digital do usuário");
		
		JButton btnConsultarPastaDe = new JButton("Consultar pasta de arquivos secretos do usuário");
		
		JButton btnSairDoSistema = new JButton("Sair do Sistema");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnListarChavePrivada)
						.addComponent(btnNewButton)
						.addComponent(btnConsultarPastaDe)
						.addComponent(btnSairDoSistema))
					.addContainerGap(451, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(255, Short.MAX_VALUE)
					.addComponent(lblMenuPrincipal)
					.addGap(239))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(13)
					.addComponent(lblMenuPrincipal)
					.addGap(18)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListarChavePrivada)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConsultarPastaDe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSairDoSistema)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		body1.setLayout(new CardLayout(0, 0));
		
		JPanel consultasJPanel = new JPanel();
		body1.add(consultasJPanel, "name_128809415281247");
		
		JLabel lblTotalDeUsuarios = new JLabel("Total de usuários do sistema:");
		
		JLabel label_1 = new JLabel("placeholder");
		GroupLayout gl_consultasJPanel = new GroupLayout(consultasJPanel);
		gl_consultasJPanel.setHorizontalGroup(
			gl_consultasJPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 584, Short.MAX_VALUE)
				.addGroup(gl_consultasJPanel.createSequentialGroup()
					.addGap(32)
					.addComponent(lblTotalDeUsuarios)
					.addGap(18)
					.addComponent(label_1)
					.addGap(281))
		);
		gl_consultasJPanel.setVerticalGroup(
			gl_consultasJPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGroup(gl_consultasJPanel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_consultasJPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalDeUsuarios)
						.addComponent(label_1))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		consultasJPanel.setLayout(gl_consultasJPanel);
		
		JPanel panel_3 = new JPanel();
		
		JLabel lblPlaceholder = new JLabel("placeholder");
		
		JLabel lblNewLabel_1 = new JLabel("Total de acessos do usuário:");
		body1.add(panel_3, "name_128623681557462");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(lblPlaceholder)
					.addGap(281))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblPlaceholder))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblLogin = new JLabel("Login:");
		
		JLabel lblNewLabel = new JLabel("Grupo:");
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblLoginplaceholder = new JLabel("loginPlaceholder");
		
		JLabel lblGrupoplaceholder = new JLabel("grupoPlaceholder");
		
		JLabel lblNomeplaceholder = new JLabel("nomePlaceholder");
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_header.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNome)
						.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
							.addComponent(lblLogin)
							.addComponent(lblNewLabel)))
					.addGap(24)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLoginplaceholder)
						.addComponent(lblGrupoplaceholder)
						.addComponent(lblNomeplaceholder))
					.addContainerGap(374, Short.MAX_VALUE))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_header.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(lblLoginplaceholder))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_header.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblGrupoplaceholder))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_header.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(lblNomeplaceholder))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		header.setLayout(gl_header);
		frmMenu.getContentPane().setLayout(groupLayout);
	}
}
