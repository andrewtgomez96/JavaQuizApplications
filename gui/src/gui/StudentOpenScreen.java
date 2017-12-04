package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentOpenScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuizTakerPro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentOpenScreen frame = new StudentOpenScreen();
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
	public StudentOpenScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentOpenScreen.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
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
		
		txtQuizTakerPro = new JTextField();
		txtQuizTakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizTakerPro.setText("  Quiz Taker Pro");
		txtQuizTakerPro.setBounds(199, -1, 155, 25);
		contentPane.add(txtQuizTakerPro);
		txtQuizTakerPro.setColumns(10);
		
		JMenuItem menuItem = new JMenuItem("");
		menuItem.setIcon(new ImageIcon(StudentOpenScreen.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		menuItem.setBounds(353, 0, 76, 56);
		contentPane.add(menuItem);
		
		JLabel lblWelcomeToQuiz = new JLabel("Welcome to Quiz Taker Pro");
		lblWelcomeToQuiz.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblWelcomeToQuiz.setBounds(58, 78, 322, 84);
		contentPane.add(lblWelcomeToQuiz);
	}

}
