package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;

public class StudentSeesAnswer extends JFrame {

	private JPanel contentPane;
	public Quiz daQuiz;
	public String setCorr;
	public String corrAnswer="";
	private JTextField txtQuizTakerPro;
	private JMenuItem menuItem;
	private JLabel lblAsdasd;
	private JLabel lblTheCorrectAnswer;
	private JLabel lblAnswer;
	private JButton btnNext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSeesAnswer frame = new StudentSeesAnswer();
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
	public void setCorr(boolean setCorr) {
		if(setCorr)
			this.setCorr="CORRECT";
		else
			this.setCorr="WRONG";
	}
	public void setCorrAnswer(String corrAnswer) {
		this.corrAnswer=corrAnswer;
	}
	public StudentSeesAnswer(Quiz daQuiz, boolean isCorr, String answer) {
		setQuiz(daQuiz);
		setCorr(isCorr);
		setCorrAnswer(answer);
		setTitle("Quiz Taker Pro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentSeesAnswer.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtQuizTakerPro = new JTextField();
		txtQuizTakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizTakerPro.setText("  Quiz Taker Pro");
		txtQuizTakerPro.setBounds(199, -1, 155, 25);
		contentPane.add(txtQuizTakerPro);
		txtQuizTakerPro.setColumns(10);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(0, -1, 106, 25);
		contentPane.add(btnMainMenu);
		
		JButton btnNewButton_1 = new JButton("Load Quiz");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentLoadQuizFrame frame= new StudentLoadQuizFrame();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(103, -1, 97, 25);
		contentPane.add(btnNewButton_1);
		
		menuItem = new JMenuItem("");
		menuItem.setIcon(new ImageIcon(StudentSeesAnswer.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		menuItem.setBounds(353, 0, 76, 56);
		contentPane.add(menuItem);
		
		lblAsdasd = new JLabel(setCorr);
		lblAsdasd.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAsdasd.setBounds(157, 83, 123, 25);
		contentPane.add(lblAsdasd);
		
		lblTheCorrectAnswer = new JLabel("The correct answer was:");
		lblTheCorrectAnswer.setBounds(36, 138, 144, 16);
		contentPane.add(lblTheCorrectAnswer);
		
		lblAnswer = new JLabel(corrAnswer);
		lblAnswer.setBounds(192, 138, 228, 16);
		contentPane.add(lblAnswer);
		
		btnNext = new JButton("Next");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(daQuiz.canContinue()) {
				StudentBeginsQuiz frame= new StudentBeginsQuiz(daQuiz);
				frame.setQuiz(daQuiz);
				frame.setVisible(true);
				dispose();
				}
				else {
					StudentQuizScore frame= new StudentQuizScore(daQuiz);

					frame.setVisible(true);
					dispose();
				}
			}
		});
		btnNext.setBounds(157, 183, 97, 25);
		contentPane.add(btnNext);
	}

}
