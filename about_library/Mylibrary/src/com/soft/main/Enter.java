package com.soft.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import com.soft.bean.User;
import com.soft.dao.userDao;
import com.soft.panel.BackgroundPanel;

public class Enter extends JFrame implements ActionListener{

	private BackgroundPanel jContentPane = null;
	private JLabel namejLabel = null;
	private JLabel passjLabel = null;
	private JTextField namejTextField = null;
	private JButton loginjButton = null;
	private JPasswordField passjPasswordField = null;

	/**
	 * This is the default constructor
	 */
	public Enter() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(357, 270);//357 270
		this.setContentPane(getJContentPane());
		this.setTitle("图书管理系统");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private BackgroundPanel getJContentPane() {
		if (jContentPane == null) {
			passjLabel = new JLabel();
			passjLabel.setBounds(new java.awt.Rectangle(23,107,77,28));
			passjLabel.setText("密码：");
			namejLabel = new JLabel();
			namejLabel.setBounds(new java.awt.Rectangle(19,41,71,33));
			namejLabel.setText("用户名：");
			jContentPane = new BackgroundPanel("/com/soft/icons/bg_login.png");
			jContentPane.setLayout(null);
			jContentPane.add(namejLabel, null);
			jContentPane.add(passjLabel, null);
			jContentPane.add(getNamejTextField(), null);
			jContentPane.add(getLoginjButton(), null);
			jContentPane.add(getPassjPasswordField(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes namejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNamejTextField() {
		if (namejTextField == null) {
			namejTextField = new JTextField();
			namejTextField.setBounds(new java.awt.Rectangle(121,41,199,30));
			namejTextField.setText("czx");
		}
		return namejTextField;
	}

	/**
	 * This method initializes loginjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getLoginjButton() {
		if (loginjButton == null) {
			loginjButton = new JButton();
			loginjButton.setBounds(new java.awt.Rectangle(133,162,73,58));
			loginjButton.setIcon(new ImageIcon(getClass().getResource("/com/soft/icons/login.png")));
			loginjButton.setContentAreaFilled(false);
			loginjButton.setBorder(null);
			loginjButton.addActionListener(this);
			//loginjButton.setText("登录");
		}
		return loginjButton;
	}

	/**
	 * This method initializes passjPasswordField	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getPassjPasswordField() {
		if (passjPasswordField == null) {
			passjPasswordField = new JPasswordField();
			passjPasswordField.setBounds(new java.awt.Rectangle(124,108,194,29));
			passjPasswordField.setText("123456");
		}
		return passjPasswordField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==loginjButton) {
			String name=namejTextField.getText();
			String pass=new String(passjPasswordField.getPassword());
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "用户名不能为空");
				return;
			}
			if (pass.equals("")) {
				JOptionPane.showMessageDialog(null, "密码不能为空");
				return;
			}
			userDao dao=new userDao();
			try {
				User u=dao.getoneUser(name, pass);
				if (u==null) {
					JOptionPane.showMessageDialog(null, "用户名或密码不正确，请重新输入");
					return;
				}else {
					MainFrame m=new MainFrame(u);
					dispose();
				}
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "驱动找不到");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "SQLException");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "IOException");
			}
		}
	}
	public static void main(String[] args) {
		new Enter();
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
