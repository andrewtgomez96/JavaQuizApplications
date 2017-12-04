package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoadRearrangeQFrame extends JFrame {

	private JPanel contentPane;
	public Quiz daQuiz;
	private JTextField txtQuizMakerPro;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadRearrangeQFrame frame = new LoadRearrangeQFrame();
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
	public LoadRearrangeQFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoadRearrangeQFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
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
		mntmNewMenuItem.setIcon(new ImageIcon(LoadRearrangeQFrame.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		mntmNewMenuItem.setBounds(355, 0, 76, 56);
		contentPane.add(mntmNewMenuItem);
		
		JLabel lblWhatNumberQuestion = new JLabel("What number question would you like to move?");
		lblWhatNumberQuestion.setBounds(85, 71, 271, 16);
		contentPane.add(lblWhatNumberQuestion);
		
		JLabel lblWhatDoYou = new JLabel("Into what number spot should it be placed?");
		lblWhatDoYou.setBounds(103, 150, 247, 16);
		contentPane.add(lblWhatDoYou);
		
		txtQuizMakerPro = new JTextField();
		txtQuizMakerPro.setBackground(UIManager.getColor("CheckBox.background"));
		txtQuizMakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizMakerPro.setText("  Quiz Maker Pro");
		txtQuizMakerPro.setBounds(201, -1, 155, 25);
		contentPane.add(txtQuizMakerPro);
		txtQuizMakerPro.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(158, 101, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 180, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNoteIfThe = new JLabel("Note: the spot");
		lblNoteIfThe.setBounds(0, 150, 94, 16);
		contentPane.add(lblNoteIfThe);
		
		JLabel lblToMoveInto = new JLabel("you move into");
		lblToMoveInto.setBounds(0, 166, 94, 16);
		contentPane.add(lblToMoveInto);
		
		JLabel lblWillMoveAll = new JLabel("will move that question");
		lblWillMoveAll.setBounds(0, 183, 132, 16);
		contentPane.add(lblWillMoveAll);
		
		JLabel lblQuestionsForward = new JLabel("into your spot");
		lblQuestionsForward.setBounds(0, 200, 106, 16);
		contentPane.add(lblQuestionsForward);
		
		JLabel lblPleaseInputA = new JLabel("Please input a valid position for the Quiz that is already defined");
		lblPleaseInputA.setBounds(34, 123, 370, 16);
		contentPane.add(lblPleaseInputA);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedQuestion=textField.getText();
				String selectedSpot=textField_1.getText();
				daQuiz.rearrangeQuestion(Integer.parseInt(selectedQuestion),Integer.parseInt(selectedSpot));
				LoadDoneEditing frame = new LoadDoneEditing();
				frame.setQuiz(daQuiz);
				frame.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setBounds(168, 215, 97, 25);
		contentPane.add(btnSubmit);
	}

	}
