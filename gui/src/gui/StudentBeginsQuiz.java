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

public class StudentBeginsQuiz extends JFrame {

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
					StudentBeginsQuiz frame = new StudentBeginsQuiz(Quiz daQuiz());
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
	
	public StudentBeginsQuiz(Quiz daQuiz) {
		setQuiz(daQuiz);
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentBeginsQuiz.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
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
		menuItem.setIcon(new ImageIcon(StudentBeginsQuiz.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		menuItem.setBounds(353, 0, 76, 56);
		contentPane.add(menuItem);
		
		txtQuizTakerPro = new JTextField();
		txtQuizTakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizTakerPro.setText("  Quiz Taker Pro");
		txtQuizTakerPro.setBounds(199, -1, 155, 25);
		contentPane.add(txtQuizTakerPro);
		txtQuizTakerPro.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(149, 152, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAnswer = new JLabel("answer(s):");
		lblAnswer.setBounds(81, 155, 68, 16);
		contentPane.add(lblAnswer);
		
		String question="";
		String htmlQuestion="<html>";
		question=daQuiz.toStringElem();
		htmlQuestion+=question;
		htmlQuestion+="</html>";
		
		JLabel lblNewLabel = new JLabel(htmlQuestion);
		lblNewLabel.setBounds(113, 37, 279, 102);
		contentPane.add(lblNewLabel);
		
		JLabel lblIfMultipleChoice = new JLabel("If multiple choice");
		lblIfMultipleChoice.setBounds(286, 155, 106, 16);
		contentPane.add(lblIfMultipleChoice);
		
		JLabel lblPleaseInputThe = new JLabel("please input the number");
		lblPleaseInputThe.setBounds(286, 169, 143, 16);
		contentPane.add(lblPleaseInputThe);
		
		JLabel lblAnswerNotA = new JLabel("answer not text");
		lblAnswerNotA.setBounds(286, 184, 131, 16);
		contentPane.add(lblAnswerNotA);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean isCorr=daQuiz.checkElem(textField.getText());
				String answer=daQuiz.getElemAnswer();
				StudentSeesAnswer frame = new StudentSeesAnswer(daQuiz,isCorr,answer);
				
				frame.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setBounds(159, 191, 97, 25);
		contentPane.add(btnSubmit);
		
		JLabel lblExample = new JLabel("EXAMPLE:1");
		lblExample.setBounds(286, 203, 82, 16);
		contentPane.add(lblExample);
		
		JLabel lblExample_1 = new JLabel("EXAMPLE2:1,3");
		lblExample_1.setBounds(286, 224, 106, 16);
		contentPane.add(lblExample_1);
		
	}

}
