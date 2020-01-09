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

import com.soft.bean.Sjgl;
import com.soft.dao.SjglDao;
import com.soft.panel.SjglPanel;

public class UpdateSjglFrame extends JFrame implements ActionListener{

	private JPanel jContentPane = null;
	private JLabel usernamejLabel = null;
	private JTextField usernamejTextField = null;
	private JLabel booknamejLabel = null;
	private JTextField booknamejTextField = null;
	private JLabel studentidjLabel = null;
	private JTextField studentidjTextField = null;
	private JLabel phonejLabel = null;
	private JTextField phonejTextField = null;
	private JLabel timejLabel = null;
	private JTextField timejTextField = null;
	private JLabel numberjLabel = null;
	private JTextField numberjTextField = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JButton exitjButton = null;
	private Sjgl s=null;
	private SjglDao dao=new SjglDao();
	private SjglPanel p=new SjglPanel();
	private JButton updatejButton = null;
	/**
	 * This is the default constructor
	 */
	public UpdateSjglFrame() {
		super();
		initialize();
	}
	public UpdateSjglFrame(Sjgl s,SjglPanel p) {
		this();
		this.s=s;
		this.p=p;
		if (s!=null) {
		    usernamejTextField.setText(s.getUsername());
			booknamejTextField.setText(s.getBookname());
			studentidjTextField.setText(s.getStudentid());
			phonejTextField.setText(s.getPhone());
			timejTextField.setText(s.getTime());
			numberjTextField.setText(s.getNumber());
		}
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 350);
		this.setContentPane(getJContentPane());
		this.setTitle("修改书籍管理事件");
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
			jLabel6 = new JLabel();
			jLabel6.setBounds(new java.awt.Rectangle(738,195,14,38));
			jLabel6.setText("*");
			jLabel6.setForeground(Color.red);
			jLabel5 = new JLabel();
			jLabel5.setBounds(new java.awt.Rectangle(357,193,16,34));
			jLabel5.setText("*");
			jLabel5.setForeground(Color.red);
			jLabel4 = new JLabel();
			jLabel4.setBounds(new java.awt.Rectangle(735,122,12,35));
			jLabel4.setText("*");
			jLabel4.setForeground(Color.red);
			jLabel3 = new JLabel();
			jLabel3.setBounds(new java.awt.Rectangle(356,120,17,33));
			jLabel3.setText("*");
			jLabel3.setForeground(Color.red);
			jLabel2 = new JLabel();
			jLabel2.setBounds(new java.awt.Rectangle(732,47,18,37));
			jLabel2.setText("*");
			jLabel2.setForeground(Color.red);
			jLabel1 = new JLabel();
			jLabel1.setBounds(new java.awt.Rectangle(354,45,19,32));
			jLabel1.setText("*");
			jLabel1.setForeground(Color.red);
			numberjLabel = new JLabel();
			numberjLabel.setBounds(new java.awt.Rectangle(429,195,84,36));
			numberjLabel.setText("借书数量：");
			timejLabel = new JLabel();
			timejLabel.setBounds(new java.awt.Rectangle(19,190,81,34));
			timejLabel.setText("借书时间：");
			phonejLabel = new JLabel();
			phonejLabel.setBounds(new java.awt.Rectangle(427,119,85,35));
			phonejLabel.setText("电话号码：");
			studentidjLabel = new JLabel();
			studentidjLabel.setBounds(new java.awt.Rectangle(16,113,80,35));
			studentidjLabel.setText("学号：");
			booknamejLabel = new JLabel();
			booknamejLabel.setBounds(new java.awt.Rectangle(421,47,83,36));
			booknamejLabel.setText("书名：");
			usernamejLabel = new JLabel();
			usernamejLabel.setBounds(new java.awt.Rectangle(20,42,82,35));
			usernamejLabel.setText("借阅者：");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setSize(new java.awt.Dimension(718,277));
			jContentPane.add(usernamejLabel, null);
			jContentPane.add(getUsernamejTextField(), null);
			jContentPane.add(booknamejLabel, null);
			jContentPane.add(getBooknamejTextField(), null);
			jContentPane.add(studentidjLabel, null);
			jContentPane.add(getStudentidjTextField(), null);
			jContentPane.add(phonejLabel, null);
			jContentPane.add(getPhonejTextField(), null);
			jContentPane.add(timejLabel, null);
			jContentPane.add(getTimejTextField(), null);
			jContentPane.add(numberjLabel, null);
			jContentPane.add(getNumberjTextField(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(getExitjButton(), null);
			jContentPane.add(getUpdatejButton(), null);
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
			usernamejTextField.setBounds(new java.awt.Rectangle(126,44,209,36));
		}
		return usernamejTextField;
	}
	/**
	 * This method initializes booknamejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getBooknamejTextField() {
		if (booknamejTextField == null) {
			booknamejTextField = new JTextField();
			booknamejTextField.setBounds(new java.awt.Rectangle(531,45,185,38));
		}
		return booknamejTextField;
	}
	/**
	 * This method initializes studentidjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getStudentidjTextField() {
		if (studentidjTextField == null) {
			studentidjTextField = new JTextField();
			studentidjTextField.setBounds(new java.awt.Rectangle(131,116,201,36));
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
			phonejTextField.setBounds(new java.awt.Rectangle(534,123,181,32));
		}
		return phonejTextField;
	}
	/**
	 * This method initializes timejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTimejTextField() {
		if (timejTextField == null) {
			timejTextField = new JTextField();
			timejTextField.setBounds(new java.awt.Rectangle(137,192,198,36));
		}
		return timejTextField;
	}

	/**
	 * This method initializes numberjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNumberjTextField() {
		if (numberjTextField == null) {
			numberjTextField = new JTextField();
			numberjTextField.setBounds(new java.awt.Rectangle(537,195,181,35));
		}
		return numberjTextField;
	}

	/**
	 * This method initializes exitjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getExitjButton() {
		if (exitjButton == null) {
			exitjButton = new JButton();
			exitjButton.setBounds(new java.awt.Rectangle(436,259,93,45));
			exitjButton.setText("退出");
			exitjButton.addActionListener(this);
		}
		return exitjButton;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==updatejButton) {
			// 获取六个文本框的数据
			String username=usernamejTextField.getText().trim();
			String bookname=booknamejTextField.getText().trim();
			String studentid=studentidjTextField.getText().trim();
			String phone=phonejTextField.getText().trim();
			String time=timejTextField.getText().trim();
			String number=numberjTextField.getText().trim();
			// 判断字段是否为空
			if (!username.equals("")&&!bookname.equals("")
					&&!studentid.equals("")&&!phone.equals("")
					&&!time.equals("")&&!number.equals("")) {
				//Sjgl s=new Sjgl();
				s.setUsername(username);
				s.setBookname(bookname);
				s.setStudentid(studentid);
				s.setPhone(phone);
				s.setTime(time);
				s.setNumber(number);
				try {
					boolean flag=dao.updateOne(s);
					if (flag) {
						JOptionPane.showMessageDialog(null, "修改成功");
						//刷新表格内容
						if (p!=null) {
							p.setDate();
						}
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "修改失败");
						dispose();
					}
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "请将所有字段填写完整");
				return;
			}
		}else if (e.getSource()==exitjButton) {
			int i=JOptionPane.showConfirmDialog(null, "您是否要放弃该表单的填写？",
					"退出确认", JOptionPane.YES_NO_OPTION);
			if (i==JOptionPane.YES_OPTION) {
				dispose();
			}
		}
	}
	/**
	 * This method initializes updatejButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getUpdatejButton() {
		if (updatejButton == null) {
			updatejButton = new JButton();
			updatejButton.setBounds(new java.awt.Rectangle(149,261,106,43));
			updatejButton.setText("修改");
			updatejButton.addActionListener(this);
		}
		return updatejButton;
	}
}
