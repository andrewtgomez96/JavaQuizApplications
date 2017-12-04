package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class LoadModifyQuestionFrame extends JFrame {

	private JPanel contentPane;
	public Quiz daQuiz;
	private JTextField txtQuizMakerPro;
	private JTextField textField;
	private JCheckBox checkBox2;
	private JCheckBox checkBox1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadModifyQuestionFrame frame = new LoadModifyQuestionFrame();
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
	
	public LoadModifyQuestionFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoadModifyQuestionFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
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
		
		txtQuizMakerPro = new JTextField();
		txtQuizMakerPro.setBackground(UIManager.getColor("CheckBox.background"));
		txtQuizMakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizMakerPro.setText("  Quiz Maker Pro");
		txtQuizMakerPro.setBounds(201, -1, 155, 25);
		contentPane.add(txtQuizMakerPro);
		txtQuizMakerPro.setColumns(10);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setIcon(new ImageIcon(LoadModifyQuestionFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		mntmNewMenuItem.setBounds(355, 0, 76, 56);
		contentPane.add(mntmNewMenuItem);
		
		JLabel lblWhatNumberQuestion = new JLabel("What number question would you like to modify?");
		lblWhatNumberQuestion.setBounds(70, 72, 286, 16);
		contentPane.add(lblWhatNumberQuestion);
		
		JLabel lblWhatDoYou = new JLabel("What do you wish to modify?");
		lblWhatDoYou.setBounds(131, 134, 175, 16);
		contentPane.add(lblWhatDoYou);
		
		textField = new JTextField();
		textField.setBounds(158, 101, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		checkBox1 = new JCheckBox("Question");
		checkBox1.setBounds(161, 159, 113, 25);
		contentPane.add(checkBox1);
		
		checkBox2 = new JCheckBox("Answer");
		checkBox2.setBounds(161, 189, 113, 25);
		contentPane.add(checkBox2);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String question= textField.getText();
				int index;
				index=Integer.parseInt(question);
				if(checkBox1.isSelected()) {
					LoadModifyQuestion frame = new LoadModifyQuestion();
					frame.setQuiz(daQuiz);
					frame.setIndex(index);
					frame.setVisible(true);
					dispose();
				}
				if (checkBox2.isSelected()) {
					LoadModifyAnswer frame = new LoadModifyAnswer();
					frame.setQuiz(daQuiz);
					frame.setIndex(index);
					frame.setVisible(true);
					dispose();
				}
				
			}
		});
		btnSubmit.setBounds(158, 215, 97, 25);
		contentPane.add(btnSubmit);
	}

}
