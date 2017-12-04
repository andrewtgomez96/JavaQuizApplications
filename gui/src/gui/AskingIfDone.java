package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AskingIfDone extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuizMakerPro;
	public Quiz daQuiz;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AskingIfDone frame = new AskingIfDone();
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
	
	public void saveToBinary(String fileName) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName+".bin"));
			os.writeObject(daQuiz);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public AskingIfDone() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Main Menu\r\n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idk window = new idk();
				window.getjFrame().setVisible(true);
				
				dispose();
			}
		});
		btnNewButton.setBounds(0, -1, 106, 25);
		contentPane.add(btnNewButton);
		
		JButton btnLoadquiz = new JButton("LoadQuiz");
		btnLoadquiz.setBounds(103, -1, 97, 25);
		contentPane.add(btnLoadquiz);
		
		txtQuizMakerPro = new JTextField();
		txtQuizMakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizMakerPro.setText("  Quiz Maker Pro");
		txtQuizMakerPro.setBounds(199, -1, 155, 25);
		contentPane.add(txtQuizMakerPro);
		txtQuizMakerPro.setColumns(10);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setIcon(new ImageIcon(AskingIfDone.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		mntmNewMenuItem.setBounds(353, 0, 76, 56);
		contentPane.add(mntmNewMenuItem);
		
		JLabel lblNewLabel = new JLabel("Would you like to save your quiz?");
		lblNewLabel.setBounds(113, 63, 200, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("or add another question?");
		lblNewLabel_1.setBounds(136, 82, 155, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSaveQuiz = new JButton("Save Quiz");
		btnSaveQuiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String fileName=textField.getText();
				saveToBinary(fileName);
				idk window = new idk();
				window.getjFrame().setVisible(true);
				dispose();
			}
		});
		btnSaveQuiz.setBounds(50, 111, 111, 25);
		contentPane.add(btnSaveQuiz);
		
		JButton btnAddAnother = new JButton("Add another");
		btnAddAnother.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateQuizWindow frame = new CreateQuizWindow();
				frame.setQuiz(daQuiz);
				frame.setVisible(true);
				dispose();
			}
		});
		btnAddAnother.setBounds(150, 165, 118, 25);
		contentPane.add(btnAddAnother);
		
		textField = new JTextField();
		textField.setBounds(230, 111, 135, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Filename:");
		lblNewLabel_2.setBounds(166, 111, 76, 25);
		contentPane.add(lblNewLabel_2);
	}

}
