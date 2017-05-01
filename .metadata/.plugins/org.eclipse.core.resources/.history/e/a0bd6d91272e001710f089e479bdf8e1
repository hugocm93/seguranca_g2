package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presenter.ConfirmationPresenterListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmationDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton _okButton;
	private JButton _cancelButton;
	
	private ConfirmationPresenterListener _listener;
	
	
	public ConfirmationDialog(ConfirmationPresenterListener listener) {
		super();
		
		_listener = listener;
		initialize();
	}

	public void initialize() {
		setTitle("Confirmar cadastro");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JTextPane _infoTextPane = new JTextPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(_infoTextPane, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(_infoTextPane, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				_okButton = new JButton("Confirmar");
				_okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						_listener.OkButtonPressed();
					}
				});
				_okButton.setActionCommand("OK");
				buttonPane.add(_okButton);
				getRootPane().setDefaultButton(_okButton);
			}
			{
				_cancelButton = new JButton("Cancelar");
				_cancelButton.setActionCommand("Cancel");
				buttonPane.add(_cancelButton);
			}
		}
	}

}
