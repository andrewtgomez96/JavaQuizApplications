package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoadDeleteQuestionFrame extends JFrame {

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
					LoadDeleteQuestionFrame frame = new LoadDeleteQuestionFrame();
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
	public LoadDeleteQuestionFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoadDeleteQuestionFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		setTitle("Quiz Maker Pro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.setBounds(0, -1, 106, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Quiz");
		btnNewButton_1.setBounds(103, -1, 99, 25);
		contentPane.add(btnNewButton_1);
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setIcon(new ImageIcon(LoadDeleteQuestionFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		mntmNewMenuItem.setBounds(355, 0, 76, 56);
		contentPane.add(mntmNewMenuItem);
		
		txtQuizMakerPro = new JTextField();
		txtQuizMakerPro.setBackground(UIManager.getColor("CheckBox.background"));
		txtQuizMakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizMakerPro.setText("  Quiz Maker Pro");
		txtQuizMakerPro.setBounds(201, -1, 155, 25);
		contentPane.add(txtQuizMakerPro);
		txtQuizMakerPro.setColumns(10);
		
		JLabel lblWhatQuestionNumber = new JLabel("What question number would you like to delete?");
		lblWhatQuestionNumber.setBounds(79, 73, 277, 16);
		contentPane.add(lblWhatQuestionNumber);
		
		textField = new JTextField();
		textField.setBounds(160, 102, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String questionNumber=textField.getText();
				daQuiz.deleteQuestion(Integer.parseInt(questionNumber));
				LoadDoneEditing frame = new LoadDoneEditing();
				frame.setQuiz(daQuiz);
				frame.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setBounds(170, 147, 97, 25);
		contentPane.add(btnSubmit);
	}
	}

