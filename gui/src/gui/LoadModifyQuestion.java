package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoadModifyQuestion extends JFrame {

	private JPanel contentPane;
	public Quiz daQuiz;
	public int qIndex;
	private JTextField txtQuizMakerPro;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadModifyQuestion frame = new LoadModifyQuestion();
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
	public void setIndex(int index) {
		this.qIndex=index;
	}
	public LoadModifyQuestion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoadModifyQuestion.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		setTitle("Quiz Taker Pro");
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
		
		
		JMenuItem menuItem = new JMenuItem("");
		menuItem.setIcon(new ImageIcon(LoadModifyQuestion.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		menuItem.setBounds(353, 0, 76, 56);
		contentPane.add(menuItem);
		
		txtQuizMakerPro = new JTextField();
		txtQuizMakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizMakerPro.setText("Quiz Maker Pro");
		txtQuizMakerPro.setBounds(201, -1, 155, 25);
		contentPane.add(txtQuizMakerPro);
		txtQuizMakerPro.setColumns(10);
		
		JLabel lblPleaseInputThe = new JLabel("Please input the new question:");
		lblPleaseInputThe.setBounds(127, 81, 184, 16);
		contentPane.add(lblPleaseInputThe);
		
		textField = new JTextField();
		textField.setBounds(87, 121, 269, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnReplace = new JButton("Replace");
		btnReplace.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				daQuiz.replaceQuestion(qIndex,textField.getText());
				LoadDoneEditing frame = new LoadDoneEditing();
				frame.setQuiz(daQuiz);
				frame.setVisible(true);
				dispose();
			}
		});
		btnReplace.setBounds(171, 166, 97, 25);
		contentPane.add(btnReplace);
	}

}
