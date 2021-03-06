package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presenter.ConfirmationPresenterListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ConfirmationDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton _okButton;
	private JButton _cancelButton;
	
	private ConfirmationPresenterListener _listener;
	private JScrollPane scrollPane;
	public JTextArea _certificateArea;
	
	
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
		scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		{
			_certificateArea = new JTextArea();
			_certificateArea.setLineWrap(true);
			_certificateArea.setWrapStyleWord(true);
			_certificateArea.setColumns(60);
			_certificateArea.setEditable(false);
			scrollPane.setViewportView(_certificateArea);
		}
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
				_cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						_listener.CancelButtonPressed();
					}
				});
				_cancelButton.setActionCommand("Cancel");
				buttonPane.add(_cancelButton);
			}
		}
	}

}
