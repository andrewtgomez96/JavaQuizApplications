package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ShortAFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuizMakerPro;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public Quiz daQuiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShortAFrame frame = new ShortAFrame();
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
	
	public ShortAFrame() {
		setTitle("Quiz Maker Pro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShortAFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idk window = new idk();
				window.getjFrame().setVisible(true);
				dispose();
			}
		});
		btnMainMenu.setBounds(0, -1, 106, 25);
		contentPane.add(btnMainMenu);
		
		JButton btnLoadQuiz = new JButton("Load Quiz");
		btnLoadQuiz.setBounds(103, -1, 97, 25);
		contentPane.add(btnLoadQuiz);
		
		txtQuizMakerPro = new JTextField();
		txtQuizMakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizMakerPro.setBackground(UIManager.getColor("CheckBox.background"));
		txtQuizMakerPro.setText("  Quiz Maker Pro");
		txtQuizMakerPro.setBounds(199, -1, 155, 25);
		contentPane.add(txtQuizMakerPro);
		txtQuizMakerPro.setColumns(10);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setIcon(new ImageIcon(ShortAFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		mntmNewMenuItem.setBounds(353, 0, 76, 56);
		contentPane.add(mntmNewMenuItem);
		
		JLabel lblEnterTheQuestion = new JLabel("Enter the question:");
		lblEnterTheQuestion.setBounds(157, 53, 126, 16);
		contentPane.add(lblEnterTheQuestion);
		
		textField = new JTextField();
		textField.setBounds(79, 72, 275, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(155, 107, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(155, 138, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Please enter");
		lblNewLabel.setBounds(25, 107, 81, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("two possible");
		lblNewLabel_1.setBounds(25, 124, 81, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("short answers:");
		lblNewLabel_2.setBounds(25, 141, 97, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String question= textField.getText();
				ArrayList<String> answers= new ArrayList<>();
				answers.add(textField_1.getText());
				answers.add(textField_2.getText());

				QuestionHmWk q= new QuestionHmWk(question,answers);
				daQuiz.addQuestion(q);
				
				AskingIfDone frame = new AskingIfDone();
				frame.setQuiz(daQuiz);
				frame.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setBounds(165, 183, 97, 25);
		contentPane.add(btnSubmit);
	}

}
