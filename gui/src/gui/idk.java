package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JFormattedTextField;
import java.awt.Toolkit;
import javax.swing.JEditorPane;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JLabel;

public class idk {

	private JFrame frmQuizMakerPro;
	private Quiz daQuiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					idk window = new idk();
					window.frmQuizMakerPro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public idk() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuizMakerPro = new JFrame();
		frmQuizMakerPro.setIconImage(Toolkit.getDefaultToolkit().getImage(idk.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		frmQuizMakerPro.setTitle("Quiz Maker Pro");
		frmQuizMakerPro.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
		frmQuizMakerPro.getContentPane().setBackground(SystemColor.menu);
		frmQuizMakerPro.getContentPane().setLayout(null);
		
		JFormattedTextField frmtdtxtfldQuizMakerPro = new JFormattedTextField();
		frmtdtxtfldQuizMakerPro.setBackground(UIManager.getColor("CheckBox.background"));
		frmtdtxtfldQuizMakerPro.setBounds(199, -1, 155, 25);
		frmQuizMakerPro.getContentPane().add(frmtdtxtfldQuizMakerPro);
		frmtdtxtfldQuizMakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frmtdtxtfldQuizMakerPro.setText("  Quiz Maker Pro");
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setIcon(new ImageIcon(idk.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		mntmNewMenuItem.setBounds(353, 0, 76, 56);
		frmQuizMakerPro.getContentPane().add(mntmNewMenuItem);
		
		JButton btnLoadQuiz = new JButton("Load Quiz");
		btnLoadQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoadQuizWindow loadQuiz= new LoadQuizWindow();
				loadQuiz.setVisible(true);
				frmQuizMakerPro.dispose();
			}
		});
		btnLoadQuiz.setBounds(103, -1, 97, 25);
		frmQuizMakerPro.getContentPane().add(btnLoadQuiz);
		
		JButton btnCreateQuiz = new JButton("Create Quiz");
		btnCreateQuiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CreateQuizWindow createQuiz= new CreateQuizWindow();
				daQuiz= new Quiz();
				createQuiz.setQuiz(daQuiz);
				createQuiz.setVisible(true);
				frmQuizMakerPro.dispose();
			}
		});
		btnCreateQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCreateQuiz.setBounds(-1, -1, 106, 25);
		frmQuizMakerPro.getContentPane().add(btnCreateQuiz);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblWelcome.setBounds(155, 96, 127, 33);
		frmQuizMakerPro.getContentPane().add(lblWelcome);
		frmQuizMakerPro.setBounds(100, 100, 450, 300);
		frmQuizMakerPro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JFrame getjFrame() {
		return frmQuizMakerPro;
	}
}
