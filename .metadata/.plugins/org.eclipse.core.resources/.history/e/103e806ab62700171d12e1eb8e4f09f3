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

public class LoginWindow {

	private JFrame frame;
	private JTextField loginNameTextField;

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
		
		JLabel label_1 = new JLabel("login name:");
		
		loginNameTextField = new JTextField();
		loginNameTextField.setColumns(10);
		
		JButton sendButton = new JButton("Enter");
		
		JLabel warningLabel = new JLabel("Warning placeholder");
		warningLabel.setForeground(Color.RED);
		GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
		gl_loginPanel.setHorizontalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGap(108)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(loginNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGap(180)
							.addComponent(sendButton))
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(warningLabel)
								.addComponent(label))))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		gl_loginPanel.setVerticalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 278, Short.MAX_VALUE)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(79)
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(loginNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sendButton)
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addComponent(warningLabel)
					.addGap(41))
		);
		loginPanel.setLayout(gl_loginPanel);
		
		JPanel passwordPanel = new JPanel();
		frame.getContentPane().add(passwordPanel, "name_122141787324933");
		
		JLabel lblEtapa = new JLabel("Segunda etapa");
		
		JLabel lblLoginName = new JLabel("Senha:");
		
		JLabel lblWarningPlaceholder = new JLabel("Warning placeholder");
		lblWarningPlaceholder.setForeground(Color.RED);
		GroupLayout gl_passwordPanel = new GroupLayout(passwordPanel);
		gl_passwordPanel.setHorizontalGroup(
			gl_passwordPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_passwordPanel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_passwordPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWarningPlaceholder)
						.addComponent(lblEtapa))
					.addContainerGap(229, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_passwordPanel.createSequentialGroup()
					.addContainerGap(206, Short.MAX_VALUE)
					.addComponent(lblLoginName)
					.addGap(203))
		);
		gl_passwordPanel.setVerticalGroup(
			gl_passwordPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_passwordPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEtapa)
					.addGap(25)
					.addComponent(lblLoginName)
					.addPreferredGap(ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
					.addComponent(lblWarningPlaceholder)
					.addGap(41))
		);
		passwordPanel.setLayout(gl_passwordPanel);
	}
}
