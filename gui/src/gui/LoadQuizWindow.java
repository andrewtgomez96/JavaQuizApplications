package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoadQuizWindow extends JFrame {

	private JPanel contentPane;
	public Quiz daQuiz;
	private JTextField txtQuizMakerPro;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadQuizWindow frame = new LoadQuizWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void setQuiz(Quiz daQuiz) {
		this.daQuiz=daQuiz;
	}
	
	public void importFile(String fileName){
			try {
			ObjectInputStream is= new ObjectInputStream(new FileInputStream(fileName+".bin"));
			daQuiz=(Quiz) is.readObject();
			is.close();
			setQuiz(daQuiz);
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	public LoadQuizWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoadQuizWindow.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		setTitle("Quiz Maker Pro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(0, -1, 106, 25);
		contentPane.add(btnMainMenu);
		
		JButton btnCreateQuiz = new JButton("Create Quiz");
		btnCreateQuiz.setBounds(103, -1, 99, 25);
		contentPane.add(btnCreateQuiz);
		
		txtQuizMakerPro = new JTextField();
		txtQuizMakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizMakerPro.setText("Quiz Maker Pro");
		txtQuizMakerPro.setBounds(201, -1, 155, 25);
		contentPane.add(txtQuizMakerPro);
		txtQuizMakerPro.setColumns(10);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setIcon(new ImageIcon(LoadQuizWindow.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		mntmNewMenuItem.setBounds(355, 0, 76, 56);
		contentPane.add(mntmNewMenuItem);
		
		textField = new JTextField();
		textField.setBounds(167, 109, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the name of the quiz file:");
		lblPleaseEnterThe.setBounds(119, 69, 235, 16);
		contentPane.add(lblPleaseEnterThe);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				importFile(textField.getText());
				LoadQuizOptionsFrame frame= new LoadQuizOptionsFrame();
				System.out.println(daQuiz.toString());
				frame.setQuiz(daQuiz);
				frame.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setBounds(177, 152, 97, 25);
		contentPane.add(btnSubmit);
		
		JLabel lbldat = new JLabel(".bin");
		lbldat.setBounds(284, 112, 56, 16);
		contentPane.add(lbldat);
	}

}
