package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentQuizScore extends JFrame {

	private JPanel contentPane;
	public Quiz daQuiz;
	private JTextField txtQuizTakerPro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentQuizScore frame = new StudentQuizScore();
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
	
	public StudentQuizScore(Quiz daQuiz) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentQuizScore.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		setTitle("Quiz Taker Pro");
		setQuiz(daQuiz);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourScore = new JLabel("Your Score:");
		lblYourScore.setBounds(70, 129, 85, 16);
		contentPane.add(lblYourScore);
		
		JLabel label = new JLabel(Double.toString(daQuiz.getScore()));
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(167, 81, 164, 107);
		contentPane.add(label);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentOpenScreen frame= new StudentOpenScreen();
				frame.setVisible(true);
				dispose();
			}
		});
		btnMainMenu.setBounds(0, -1, 106, 25);
		contentPane.add(btnMainMenu);
		
		JButton btnLoadQuiz = new JButton("Load Quiz");
		btnLoadQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentLoadQuizFrame frame= new StudentLoadQuizFrame();
				frame.setVisible(true);
				dispose();
			}
		});
		btnLoadQuiz.setBounds(103, -1, 97, 25);
		contentPane.add(btnLoadQuiz);
		
		txtQuizTakerPro = new JTextField();
		txtQuizTakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizTakerPro.setText("Quiz Taker Pro");
		txtQuizTakerPro.setBounds(199, -1, 155, 25);
		contentPane.add(txtQuizTakerPro);
		txtQuizTakerPro.setColumns(10);
		
		JMenuItem menuItem = new JMenuItem("");
		menuItem.setIcon(new ImageIcon(StudentQuizScore.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		menuItem.setBounds(354, -1, 78, 56);
		contentPane.add(menuItem);
	}

}
