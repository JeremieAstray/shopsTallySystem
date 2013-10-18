package com.jeremie.shopsTallySystem.form;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jeremie.shopsTallySystem.context.CashContext;

public class form {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	private JTextField textField;
	private JTextField textField_1;
	
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	private JComboBox comboBox;
	
	private JLabel lblNewLabel_3;
	private JLabel lblTotal;
	private List list;
	Double total = 0.0d;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form window = new form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("单价：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel.setBounds(12, 15, 41, 15);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("数量：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(12, 45, 60, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("计算方式：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(12, 76, 66, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"正常收费", "满300返100", "打8折"}));
		comboBox.setBounds(82, 73, 100, 21);
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 12));
		textField.setBounds(82, 15, 100, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(82, 45, 100, 21);
		frame.getContentPane().add(textField_1);
		
		btnNewButton = new JButton("确定");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton.setBounds(192, 14, 82, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_1.setBounds(192, 44, 82, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("总计：");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(24, 228, 54, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblTotal = new JLabel("0.00");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("宋体", Font.PLAIN, 36));
		lblTotal.setBounds(65, 216, 168, 53);
		frame.getContentPane().add(lblTotal);
		
		list = new List();
		list.setFont(new Font("宋体", Font.PLAIN, 12));
		list.setBounds(12, 109, 262, 99);
		frame.getContentPane().add(list);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CashContext csuper = new CashContext(comboBox.getSelectedItem().toString());
	            double totalPrices = 0d;
	            totalPrices = csuper.GetResult(Double.parseDouble(textField.getText()) * Double.parseDouble(textField_1.getText()));
	            total = total + totalPrices;
	            list.add("单价：" + textField.getText() + " 数量：" + textField_1.getText() + " "
		                + comboBox.getSelectedItem() + " 合计：" + totalPrices);
	            lblTotal.setText(total.toString());
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				total = 0.0;
				lblTotal.setText("0.00");
				textField.setText(null);
				textField_1.setText(null);
				list.removeAll();
			}
		});
	}

}
