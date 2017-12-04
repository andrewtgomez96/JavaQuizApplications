package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StudentLoadQuizFrame extends JFrame {

	private JPanel contentPane;
	public Quiz daQuiz;
	private JTextField txtQuizTakerPro;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLoadQuizFrame frame = new StudentLoadQuizFrame();
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
	
	public StudentLoadQuizFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentLoadQuizFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
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
		
		
		JMenuItem menuItem = new JMenuItem("");
		menuItem.setIcon(new ImageIcon(StudentLoadQuizFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		menuItem.setBounds(353, 0, 76, 56);
		contentPane.add(menuItem);
		
		txtQuizTakerPro = new JTextField();
		txtQuizTakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizTakerPro.setText("  Quiz Taker Pro");
		txtQuizTakerPro.setBounds(199, -1, 155, 25);
		contentPane.add(txtQuizTakerPro);
		txtQuizTakerPro.setColumns(10);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the name of the quiz file:");
		lblPleaseEnterThe.setBounds(119, 69, 235, 16);
		contentPane.add(lblPleaseEnterThe);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				importFile(textField.getText());
				StudentBeginsQuiz frame= new StudentBeginsQuiz(daQuiz);
				System.out.println(daQuiz.toString());
				frame.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setBounds(177, 152, 97, 25);
		contentPane.add(btnSubmit);
		
		JLabel lbldat = new JLabel(".bin");
		lbldat.setBounds(284, 112, 56, 16);
		contentPane.add(lbldat);
		
		textField = new JTextField();
		textField.setBounds(162, 109, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}

	}

