package com.soft.panel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class AdministratorPanel extends JPanel {

	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JTextArea jTextArea = null;

	/**
	 * This is the default constructor
	 */
	public AdministratorPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel2 = new JLabel();
		jLabel2.setBounds(new java.awt.Rectangle(188,30,103,27));
		jLabel2.setText("管理员须知");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new java.awt.Rectangle(16,29,136,28));
		jLabel1.setText(" 您当前的位置是：");
		this.setSize(500,400);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createTitledBorder("管理员须知"));
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(getJTextArea(), null);
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setBounds(new java.awt.Rectangle(22,71,441,289));
			jTextArea.setText("暂无");
		}
		return jTextArea;
	}

}
