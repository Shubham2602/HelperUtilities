package SwingLoginApp;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		final JFrame frame = new JFrame("Rally Uploader");
		final JButton btnLogin = new JButton("Click to login");
		final JButton btnPanel = new JButton();
		final JTextArea btnText = new JTextArea();
		
		LoginDialog loginDlg = new LoginDialog(frame);
		loginDlg.setVisible(true);

		// if logon successfully
		if (loginDlg.isSucceeded()) {
			btnLogin.setVisible(false);
			btnText.setText("Hi " + loginDlg.getUsername() + "! Enter the following details : ");
			frame.getContentPane().add(btnPanel);
		}

		btnPanel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel label = new JLabel("Logged user is: " + loginDlg.getUser().getUsername());
				JDialog mydialog = new JDialog();
				mydialog.setSize(new Dimension(600, 300));
				mydialog.setTitle("Another frame");
				mydialog.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
				mydialog.add(label);
				mydialog.setVisible(true);
			}

		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(btnLogin);
		frame.setVisible(true);

	}
}