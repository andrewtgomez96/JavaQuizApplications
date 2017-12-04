package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;
import javax.swing.JComboBox;
import java.awt.List;
import java.awt.Choice;

public class CreateQuizWindow extends JFrame {

	public JPanel contentPaneOrig;
	private JTextField txtQuizMakerPro;
	private JComboBox comboBoxQuestions;
	public Quiz daQuiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateQuizWindow frame = new CreateQuizWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setQuiz(Quiz daQuiz) {
		this.daQuiz=daQuiz;
	}
	
	public void fillcomboBoxQuestions() {
		comboBoxQuestions.addItem("Multiple Choice Question");
		comboBoxQuestions.addItem("Short Answer Question");
		comboBoxQuestions.addItem("Multiple Answer Question");
	}

	/**
	 * Create the frame.
	 */
	public CreateQuizWindow() {
		setTitle("Quiz Maker Pro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreateQuizWindow.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPaneOrig = new JPanel();
		contentPaneOrig.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneOrig);
		contentPaneOrig.setLayout(null);
		
		txtQuizMakerPro = new JTextField();
		txtQuizMakerPro.setBackground(UIManager.getColor("CheckBox.background"));
		txtQuizMakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizMakerPro.setText("  Quiz Maker Pro");
		txtQuizMakerPro.setBounds(199, -1, 155, 25);
		contentPaneOrig.add(txtQuizMakerPro);
		txtQuizMakerPro.setColumns(10);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				idk window = new idk();
				window.getjFrame().setVisible(true);
				//createQuiz.setSize(400, 400);
				dispose();
			}
		});
		btnNewButton.setBounds(0, -1, 106, 25);
		contentPaneOrig.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Load Quiz");
		btnNewButton_1.setBounds(103, -1, 97, 25);
		contentPaneOrig.add(btnNewButton_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setIcon(new ImageIcon(CreateQuizWindow.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		mntmNewMenuItem.setBounds(353, 0, 76, 56);
		contentPaneOrig.add(mntmNewMenuItem);
		
		Label label = new Label("What kind of Question is this?");
		label.setBounds(132, 80, 180, 24);
		contentPaneOrig.add(label);
		
		comboBoxQuestions = new JComboBox();
		comboBoxQuestions.setBounds(132, 110, 180, 22);
		contentPaneOrig.add(comboBoxQuestions);
		fillcomboBoxQuestions();
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addMouseListener(new MouseAdapter() {
			//JComboBox cb = (JComboBox)e.getSource();
	        //String petName = (String)cb.getSelectedItem()
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String answer = (String)comboBoxQuestions.getEditor().getItem();
				
				if(answer.equals("Multiple Choice Question")) {
					MultipleCQFrame frame = new MultipleCQFrame();
					frame.setQuiz(daQuiz);
					frame.setVisible(true);
					dispose();
				}
				if(answer.equals("Short Answer Question")) {
					ShortAFrame frame = new ShortAFrame();
					frame.setQuiz(daQuiz);
					frame.setVisible(true);
					dispose();
				}
				if(answer.equals("Multiple Answer Question")) {
					MultipleAFrame frame = new MultipleAFrame();
					frame.setQuiz(daQuiz);
					frame.setVisible(true);
					
					dispose();
				}
			}
		});
		btnSelect.setBounds(172, 145, 97, 25);
		contentPaneOrig.add(btnSelect);
	}
}
