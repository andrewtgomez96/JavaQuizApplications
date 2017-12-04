package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Toolkit;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MultipleAFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuizMakerPro;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public Quiz daQuiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultipleAFrame frame = new MultipleAFrame();
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
	
	public MultipleAFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MultipleAFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		setTitle("Quiz Maker Pro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtQuizMakerPro = new JTextField();
		txtQuizMakerPro.setBounds(199, -1, 155, 25);
		txtQuizMakerPro.setBackground(UIManager.getColor("CheckBox.background"));
		txtQuizMakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizMakerPro.setText("  Quiz Maker Pro\r\n");
		txtQuizMakerPro.setColumns(10);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idk window = new idk();
				window.getjFrame().setVisible(true);
				
				dispose();
			}
		});
		btnNewButton.setBounds(0, -1, 106, 25);
		
		JButton btnNewButton_1 = new JButton("Load Quiz");
		btnNewButton_1.setBounds(103, -1, 97, 25);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setBounds(353, 0, 76, 56);
		mntmNewMenuItem.setIcon(new ImageIcon(MultipleCQFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		
		JLabel lblNewLabel = new JLabel("Enter the Question:");
		lblNewLabel.setBounds(158, 37, 111, 25);
		
		textField = new JTextField();
		textField.setBounds(58, 69, 321, 25);
		textField.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(txtQuizMakerPro);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(mntmNewMenuItem);
		contentPane.add(lblNewLabel);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the 4 possible answers:");
		lblNewLabel_1.setBounds(129, 107, 170, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("A.");
		lblNewLabel_2.setBounds(127, 131, 25, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("B.");
		lblNewLabel_3.setBounds(127, 164, 25, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("C.");
		lblNewLabel_4.setBounds(127, 192, 25, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("D");
		lblNewLabel_5.setBounds(127, 224, 25, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel label = new JLabel("");
		label.setBounds(331, 131, 56, 16);
		contentPane.add(label);
		
		JLabel lblZxzxzx = new JLabel("Please signify ");
		lblZxzxzx.setBounds(12, 100, 89, 25);
		contentPane.add(lblZxzxzx);
		
		JLabel lblTheCorrect = new JLabel("the correct");
		lblTheCorrect.setBounds(12, 117, 77, 16);
		contentPane.add(lblTheCorrect);
		
		JLabel lblAnswer = new JLabel("answers:");
		lblAnswer.setBounds(12, 131, 56, 16);
		contentPane.add(lblAnswer);
		
		JCheckBox checkBox1 = new JCheckBox("New check box");
		checkBox1.setBounds(103, 127, 25, 25);
		contentPane.add(checkBox1);
		
		JCheckBox checkBox2 = new JCheckBox("New check box");
		checkBox2.setBounds(101, 157, 25, 25);
		contentPane.add(checkBox2);
		
		JCheckBox checkBox3 = new JCheckBox("");
		checkBox3.setBounds(103, 189, 25, 25);
		contentPane.add(checkBox3);
		
		JCheckBox checkBox4 = new JCheckBox("New check box");
		checkBox4.setBounds(103, 217, 25, 25);
		contentPane.add(checkBox4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(153, 128, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(153, 161, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(153, 193, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(153, 221, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String question= textField.getText();
				ArrayList<String> corrAnswers= new ArrayList<>();
				ArrayList<String> answers= new ArrayList<>();
				answers.add(textField_1.getText());
				answers.add(textField_2.getText());
				answers.add(textField_3.getText());
				answers.add(textField_4.getText());
				if(checkBox1.isSelected())
					corrAnswers.add("1");
				if (checkBox2.isSelected())
					corrAnswers.add("2");
				if (checkBox3.isSelected())
					corrAnswers.add("3");
				if (checkBox4.isSelected())
					corrAnswers.add("4");
				MultipleChoiceQuestion q= new MultipleChoiceQuestion(question,answers,corrAnswers);
				daQuiz.addQuestion(q);
				
				AskingIfDone frame = new AskingIfDone();
				frame.setQuiz(daQuiz);
				frame.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setBounds(301, 160, 97, 25);
		contentPane.add(btnSubmit);
		
	}
}
