package com.soft.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.soft.bean.Bad;
import com.soft.dao.BadDao;
import com.soft.panel.BadPanel;

public class InsertBadFrame extends JFrame implements ActionListener {

	private JPanel jContentPane = null;
	private JLabel usernamejLabel = null;
	private JTextField usernamejTextField = null;
	private JLabel studentidjLabel = null;
	private JTextField studentidjTextField = null;
	private JLabel phonejLabel = null;
	private JTextField phonejTextField = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JButton addjButton = null;
	private JButton exitjButton = null;
	//private Bad b = new Bad();
	private BadDao dao = new BadDao();
	private BadPanel p = new BadPanel();
	private JLabel typejLabel = null;
	private JTextField typejTextField = null;

	/**
	 * This is the default constructor
	 */
	public InsertBadFrame() {
		super();
		initialize();
	}

	public InsertBadFrame(BadPanel p) {
		this();
		this.p = p;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 350);
		this.setContentPane(getJContentPane());
		this.setTitle("添加违期管理事件");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			typejLabel = new JLabel();
			typejLabel.setBounds(new java.awt.Rectangle(427, 47, 84, 38));
			typejLabel.setText("类型");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new java.awt.Rectangle(738, 143, 12, 35));
			jLabel4.setText("*");
			jLabel4.setForeground(Color.red);
			jLabel3 = new JLabel();
			jLabel3.setBounds(new java.awt.Rectangle(357, 142, 17, 33));
			jLabel3.setText("*");
			jLabel3.setForeground(Color.red);
			jLabel2 = new JLabel();
			jLabel2.setBounds(new java.awt.Rectangle(732, 47, 18, 37));
			jLabel2.setText("*");
			jLabel2.setForeground(Color.red);
			jLabel1 = new JLabel();
			jLabel1.setBounds(new java.awt.Rectangle(354, 45, 19, 32));
			jLabel1.setText("*");
			jLabel1.setForeground(Color.red);
			phonejLabel = new JLabel();
			phonejLabel.setBounds(new java.awt.Rectangle(423, 143, 85, 35));
			phonejLabel.setText("电话号码：");
			studentidjLabel = new JLabel();
			studentidjLabel.setBounds(new java.awt.Rectangle(13, 141, 80, 35));
			studentidjLabel.setText("学号：");
			usernamejLabel = new JLabel();
			usernamejLabel.setBounds(new java.awt.Rectangle(20, 42, 82, 35));
			usernamejLabel.setText("违规借阅者：");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setSize(new java.awt.Dimension(718, 277));
			jContentPane.add(usernamejLabel, null);
			jContentPane.add(getUsernamejTextField(), null);
			jContentPane.add(studentidjLabel, null);
			jContentPane.add(getStudentidjTextField(), null);
			jContentPane.add(phonejLabel, null);
			jContentPane.add(getPhonejTextField(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getAddjButton(), null);
			jContentPane.add(getExitjButton(), null);
			jContentPane.add(typejLabel, null);
			jContentPane.add(getTypejTextField(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes usernamejTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getUsernamejTextField() {
		if (usernamejTextField == null) {
			usernamejTextField = new JTextField();
			usernamejTextField.setBounds(new java.awt.Rectangle(126, 44, 209,
					36));
		}
		return usernamejTextField;
	}

	/**
	 * This method initializes studentidjTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getStudentidjTextField() {
		if (studentidjTextField == null) {
			studentidjTextField = new JTextField();
			studentidjTextField.setBounds(new java.awt.Rectangle(129, 140, 201,
					36));
		}
		return studentidjTextField;
	}

	/**
	 * This method initializes phonejTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getPhonejTextField() {
		if (phonejTextField == null) {
			phonejTextField = new JTextField();
			phonejTextField
					.setBounds(new java.awt.Rectangle(540, 143, 181, 32));
		}
		return phonejTextField;
	}

	/**
	 * This method initializes addjButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getAddjButton() {
		if (addjButton == null) {
			addjButton = new JButton();
			addjButton.setBounds(new java.awt.Rectangle(169, 226, 91, 44));
			addjButton.setText("添加");
			addjButton.addActionListener(this);
		}
		return addjButton;
	}

	/**
	 * This method initializes exitjButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getExitjButton() {
		if (exitjButton == null) {
			exitjButton = new JButton();
			exitjButton.setBounds(new java.awt.Rectangle(438, 225, 93, 45));
			exitjButton.setText("退出");
			exitjButton.addActionListener(this);
		}
		return exitjButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addjButton) {
			// 收集4个字段
			String username = usernamejTextField.getText().trim();
			String type = typejTextField.getText().trim();
			String studentid = studentidjTextField.getText().trim();
			String phone = phonejTextField.getText().trim();
			// 检查表单内容是否完整
			if (!username.equals("") && !type.equals("")
					&& !studentid.equals("") && !phone.equals("")) {
				Bad b = new Bad();
				b.setUsername(username);
				b.setType(type);
				b.setStudentid(studentid);
				b.setPhone(phone);
				try {
					boolean flag = dao.inserOne(b);
					if (flag) {
						JOptionPane.showMessageDialog(null, "添加成功");
						// 刷新表格内容
						p.setDate();
						dispose();
					}
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "请将所有文本填写完整");
				return;
			}
		} else if (e.getSource() == exitjButton) {
			int i = JOptionPane.showConfirmDialog(null, "您是否要放弃该表单的填写？",
					"退出确认", JOptionPane.YES_NO_OPTION);
			if (i == JOptionPane.YES_OPTION) {
				dispose();
			}
		}
	}

	/**
	 * This method initializes typejTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTypejTextField() {
		if (typejTextField == null) {
			typejTextField = new JTextField();
			typejTextField.setBounds(new java.awt.Rectangle(537, 49, 178, 34));
		}
		return typejTextField;
	}
}
