package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class LoadQuizOptionsFrame extends JFrame {

	private JPanel contentPane;
	public Quiz daQuiz;
	private JTextField txtQuizMakerPro;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadQuizOptionsFrame frame = new LoadQuizOptionsFrame();
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
	
	public void fillComboBox() {
		comboBox.addItem("Add more questions");
		comboBox.addItem("Delete a question");
		comboBox.addItem("Rearrange questions");
		comboBox.addItem("Modify a question");
	}


	public void setQuiz(Quiz daQuiz) {
		this.daQuiz=daQuiz;
	}
	public LoadQuizOptionsFrame() {
		setTitle("Quiz Maker Pro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoadQuizOptionsFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
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
		txtQuizMakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizMakerPro.setText("  Quiz Maker Pro");
		txtQuizMakerPro.setBounds(201, -1, 155, 25);
		contentPane.add(txtQuizMakerPro);
		txtQuizMakerPro.setColumns(10);
		
		JMenuItem menuItem = new JMenuItem("");
		menuItem.setIcon(new ImageIcon(LoadQuizOptionsFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		menuItem.setBounds(355, 0, 76, 56);
		contentPane.add(menuItem);
		
		JLabel lblWhatDoYou = new JLabel("What do you wish to do to your quiz?");
		lblWhatDoYou.setBounds(103, 81, 212, 16);
		contentPane.add(lblWhatDoYou);
		
		comboBox = new JComboBox();
		comboBox.setBounds(113, 116, 200, 22);
		contentPane.add(comboBox);
		fillComboBox();
		
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addMouseListener(new MouseAdapter() {
			//JComboBox cb = (JComboBox)e.getSource();
	        //String petName = (String)cb.getSelectedItem()
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String answer = (String)comboBox.getEditor().getItem();
				
				if(answer.equals("Add more questions")) {
					CreateQuizWindow frame = new CreateQuizWindow();
					frame.setQuiz(daQuiz);
					frame.setVisible(true);
					dispose();
				}
				if(answer.equals("Delete a question")) {
					LoadDeleteQuestionFrame frame = new LoadDeleteQuestionFrame();
					frame.setQuiz(daQuiz);
					frame.setVisible(true);
					dispose();
				}
				if(answer.equals("Rearrange questions")) {
					LoadRearrangeQFrame frame = new LoadRearrangeQFrame();
					frame.setQuiz(daQuiz);
					frame.setVisible(true);
					dispose();
				}
				if(answer.equals("Modify a question")) {
					LoadModifyQuestionFrame frame = new LoadModifyQuestionFrame();
					frame.setQuiz(daQuiz);
					frame.setVisible(true);
					dispose();
				}
			}
		});
		btnSelect.setBounds(175, 180, 97, 25);
		contentPane.add(btnSelect);
	}

}
