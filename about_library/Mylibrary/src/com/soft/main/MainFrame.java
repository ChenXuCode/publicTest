package com.soft.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;

import com.soft.bean.User;
import com.soft.panel.AdministratorPanel;
import com.soft.panel.BackgroundPanel;
import com.soft.panel.BadPanel;
import com.soft.panel.CalendarPanel;
import com.soft.panel.ClockPanel;
import com.soft.panel.SjglPanel;
import com.soft.panel.TsylPanel;

import javax.swing.JButton;

public class MainFrame extends JFrame implements ActionListener{

	private BackgroundPanel  jContentPane = null;
	private User user=null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	private ClockPanel clock=null;
	private CalendarPanel calendar=null;
	private JPanel changejPanel = null;
	/**
	 * This is the default constructor
	 */
	public MainFrame() {
		super();
		initialize();
	}
	public MainFrame(User u) {
		this();
		if (u!=null) {
			this.user=u;
			//usernamejLabel.setText(u.getUserName());
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(924, 612);
		this.setContentPane(getJContentPane());
		this.setTitle("图书管理系统");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);     //关闭
		this.setResizable(false);      //不能改变大小
		this.setVisible(true);    //可视化
		this.setLocationRelativeTo(null);    //居中
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private BackgroundPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new BackgroundPanel("/com/soft/icons/bg_mainback.jpg");
			jContentPane.setLayout(null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton3(), null);
			jContentPane.add(getJButton4(), null);
			clock=new ClockPanel();
			clock.setBounds(58, 163, 161, 139);
			jContentPane.add(clock);
			calendar=new CalendarPanel();
			calendar.setBounds(9, 367, 262, 210);
			jContentPane.add(calendar);
			jContentPane.add(getChangejPanel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new java.awt.Rectangle(255,23,104,65));
			jButton1.setIcon(new ImageIcon(getClass().getResource("/com/soft/icons/tsyl.png")));//设置图片
			jButton1.setBorder(null);//去边框
			jButton1.setRolloverIcon(new ImageIcon(getClass().getResource("/com/soft/icons/tsyl2.png")));//设置第二张图片
			jButton1.setContentAreaFilled(false);//透明化
			jButton1.addActionListener(this); //注册监听器
		}
		return jButton1;
	}
	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new java.awt.Rectangle(355,26,109,65));
			jButton2.setIcon(new ImageIcon(getClass().getResource("/com/soft/icons/sjgl.png")));
			jButton2.setBorder(null);
			jButton2.setRolloverIcon(new ImageIcon(getClass().getResource("/com/soft/icons/sjgl2.png")));
			jButton2.setContentAreaFilled(false);
			jButton2.addActionListener(this);
		}
		return jButton2;
	}
	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new java.awt.Rectangle(461,23,112,68));
			jButton3.setIcon(new ImageIcon(getClass().getResource("/com/soft/icons/kcgl.png")));
			jButton3.setBorder(null);
			jButton3.setRolloverIcon(new ImageIcon(getClass().getResource("/com/soft/icons/kcgl2.png")));
			jButton3.setContentAreaFilled(false);
			jButton3.addActionListener(this);
		}
		return jButton3;
	}
	/**
	 * This method initializes jButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new java.awt.Rectangle(572,24,107,67));
			jButton4.setIcon(new ImageIcon(getClass().getResource("/com/soft/icons/wqgl.png")));
			jButton4.setBorder(null);
			jButton4.setRolloverIcon(new ImageIcon(getClass().getResource("/com/soft/icons/wqgl2.png")));
			jButton4.setContentAreaFilled(false);
			jButton4.addActionListener(this);
		}
		return jButton4;
	}

    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==jButton1) {
			TsylPanel tp=new TsylPanel();
			changejPanel.removeAll();
			changejPanel.add(tp);
			changejPanel.repaint();
		}
		else if (e.getSource()==jButton2) {
			SjglPanel sp=new SjglPanel();
			changejPanel.removeAll();
			changejPanel.add(sp);
			changejPanel.repaint();
		}else if (e.getSource()==jButton3) {
			AdministratorPanel ap=new AdministratorPanel();
			changejPanel.removeAll();
			changejPanel.add(ap);
			changejPanel.repaint();
		}else if (e.getSource()==jButton4) {
			BadPanel bp=new BadPanel();
			changejPanel.removeAll();
			changejPanel.add(bp);
			changejPanel.repaint();
		}
	}
	/**
	 * This method initializes changejPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getChangejPanel() {
		if (changejPanel == null) {
			changejPanel = new JPanel();
			changejPanel.setBounds(new java.awt.Rectangle(280,147,624,426));
			changejPanel.setLayout(null);
			changejPanel.setOpaque(false);
		}
		return changejPanel;
	}
}
