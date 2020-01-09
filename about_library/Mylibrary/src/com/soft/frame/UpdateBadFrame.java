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


public class UpdateBadFrame extends JFrame implements ActionListener{

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
	private JButton exitjButton = null;
	private Bad b=null;
	private BadDao dao=new BadDao();
	private BadPanel p=new BadPanel();
	private JButton updatejButton = null;
	private JLabel typejLabel = null;
	private JTextField typejTextField = null;
	/**
	 * This is the default constructor
	 */
	public UpdateBadFrame() {
		super();
		initialize();
	}
	public UpdateBadFrame(Bad b,BadPanel p) {
		this();
		this.b=b;
		this.p=p;
		if (b!=null) {
		    usernamejTextField.setText(b.getUsername());
			typejTextField.setText(b.getType());
			studentidjTextField.setText(b.getStudentid());
			phonejTextField.setText(b.getPhone());
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
		this.setTitle("�޸�Υ�ڹ����¼�");
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
			typejLabel.setBounds(new java.awt.Rectangle(426,44,86,35));
			typejLabel.setText("����:");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new java.awt.Rectangle(738,154,12,35));
			jLabel4.setText("*");
			jLabel4.setForeground(Color.red);
			jLabel3 = new JLabel();
			jLabel3.setBounds(new java.awt.Rectangle(355,153,17,33));
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
			phonejLabel = new JLabel();
			phonejLabel.setBounds(new java.awt.Rectangle(429,152,85,35));
			phonejLabel.setText("�绰���룺");
			studentidjLabel = new JLabel();
			studentidjLabel.setBounds(new java.awt.Rectangle(17,148,80,35));
			studentidjLabel.setText("ѧ�ţ�");
			usernamejLabel = new JLabel();
			usernamejLabel.setBounds(new java.awt.Rectangle(20,42,82,35));
			usernamejLabel.setText("�����ߣ�");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setSize(new java.awt.Dimension(718,277));
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
			jContentPane.add(getExitjButton(), null);
			jContentPane.add(getUpdatejButton(), null);
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
			usernamejTextField.setBounds(new java.awt.Rectangle(126,44,209,36));
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
			studentidjTextField.setBounds(new java.awt.Rectangle(128,150,201,36));
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
			phonejTextField.setBounds(new java.awt.Rectangle(530,155,181,32));
		}
		return phonejTextField;
	}
	/**
	 * This method initializes exitjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getExitjButton() {
		if (exitjButton == null) {
			exitjButton = new JButton();
			exitjButton.setBounds(new java.awt.Rectangle(460,234,93,45));
			exitjButton.setText("�˳�");
			exitjButton.addActionListener(this);
		}
		return exitjButton;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==updatejButton) {
			// ��ȡ4���ı��������
			String username=usernamejTextField.getText().trim();
			String type=typejTextField.getText().trim();
			String studentid=studentidjTextField.getText().trim();
			String phone=phonejTextField.getText().trim();
			// �ж��ֶ��Ƿ�Ϊ��
			if (!username.equals("")&&!type.equals("")
					&&!studentid.equals("")&&!phone.equals("")) {
				b.setUsername(username);
				b.setType(type);
				b.setStudentid(studentid);
				b.setPhone(phone);
				try {
					boolean flag=dao.updateOne(b);
					if (flag) {
						JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
						//ˢ�±������
						if (p!=null) {
							p.setDate();
						}
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "�޸�ʧ��");
						dispose();
					}
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "�뽫�����ֶ���д����");
				return;
			}
		}else if (e.getSource()==exitjButton) {
			int i=JOptionPane.showConfirmDialog(null, "���Ƿ�Ҫ�����ñ�����д��",
					"�˳�ȷ��", JOptionPane.YES_NO_OPTION);
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
			updatejButton.setBounds(new java.awt.Rectangle(163,235,106,43));
			updatejButton.setText("�޸�");
			updatejButton.addActionListener(this);
		}
		return updatejButton;
	}
	/**
	 * This method initializes typejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTypejTextField() {
		if (typejTextField == null) {
			typejTextField = new JTextField();
			typejTextField.setBounds(new java.awt.Rectangle(526,45,179,35));
		}
		return typejTextField;
	}
}
