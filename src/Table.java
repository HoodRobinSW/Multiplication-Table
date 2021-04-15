import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Table extends JFrame {

	private JPanel contentPane;
	private JLabel lblx;
	private JTextField textField;
	private List<JLabel> tags;
	private List<JTextField> field;
	private JButton btnCorregir,btnReset;
	int alea;
	private JTextField textField_1;
	
	public Table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tags=new ArrayList<>();
		field=new ArrayList<>();
		setVisible(true);
		definirVentana();
		definirEvento();
	}


	private void definirEvento() {
		// TODO Auto-generated method stub
		for (int x=0;x<10;x++) {
			field.get(x).addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent k) {
					if (k.getKeyChar() <'0' || k.getKeyChar()>'9')
						k.consume();
				}
			});
		}
		btnCorregir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int x=0;x<10;x++) {
					if (!field.get(x).getText().equals(String.valueOf(alea*(x+1))) || field.get(x).getText().equals(""))
						field.get(x).setBackground(Color.RED);
					else field.get(x).setBackground(Color.GREEN);
				}
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int x=0;x<10;x++) {
					field.get(x).setText("");
					field.get(x).setBackground(Color.WHITE);
				}
			}
		});
	}


	private void definirVentana() {
		// TODO Auto-generated method stub
		int y=0;alea=(int)Math.floor(Math.random()*10+1);
		for (int x=0;x<10;x++) {
			lblx = new JLabel(alea+"x"+(x+1));
			tags.add(lblx);
			lblx.setFont(new Font("Tahoma", Font.BOLD, 14));
			y+=35;
			lblx.setBounds(10, y, 50, 25);
			contentPane.add(lblx);
			lblx=null;
			
			textField = new JTextField();
			field.add(textField);
			textField.setBounds(80, y, 86, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			textField=null;
		}
		btnCorregir = new JButton("Corregir");
		btnCorregir.setBounds(190, 380, 89, 23);
		contentPane.add(btnCorregir);
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(302, 380, 89, 23);
		contentPane.add(btnReset);
	}
}
