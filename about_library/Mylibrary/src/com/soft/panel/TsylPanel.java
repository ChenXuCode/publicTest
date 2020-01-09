package com.soft.panel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class TsylPanel extends JPanel implements TreeSelectionListener {

	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JTree jTree = null;
	private DefaultMutableTreeNode root=null;
	private DefaultMutableTreeNode node1=null;
	private DefaultMutableTreeNode node2=null;
	private DefaultMutableTreeNode node3=null;
	private DefaultMutableTreeNode node4=null;
	private DefaultMutableTreeNode node5=null;
	private DefaultMutableTreeNode node6=null;
	private JPanel jPanel = null;
	/**
	 * This is the default constructor
	 */
	public TsylPanel() {
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
		jLabel2.setBounds(new java.awt.Rectangle(162,29,103,31));
		jLabel2.setText("图书一览");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new java.awt.Rectangle(19,28,119,31));
		jLabel1.setText("您当前的位置是：");
		this.setSize(627, 423);
		this.setLayout(null);
		this.setOpaque(false);
		//this.setBackground(new Color(253,248,242));
		this.setBorder(BorderFactory.createTitledBorder("图书一览"));
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(getJTree(), null);
		this.add(getJPanel(), null);
		
	}

	/**
	 * This method initializes jTree	
	 * 	
	 * @return javax.swing.JTree	
	 */
	private JTree getJTree() {
		if (jTree == null) {
			root=new DefaultMutableTreeNode("图书一览");
			node1=new DefaultMutableTreeNode("计算机类");
			node2=new DefaultMutableTreeNode("科学类");
			node3=new DefaultMutableTreeNode("小说类");
			node4=new DefaultMutableTreeNode("儿童读物");
			node5=new DefaultMutableTreeNode("杂志类");
			node6=new DefaultMutableTreeNode("全部书籍");
			root.add(node1);
			root.add(node2);
			root.add(node3);
			root.add(node4);
			root.add(node5);
			root.add(node6);
			jTree = new JTree(root);
			jTree.setBounds(new java.awt.Rectangle(20,79,130,244));
			jTree.addTreeSelectionListener(this);
		}
		return jTree;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setBounds(new java.awt.Rectangle(154,69,469,346));
			jPanel.setOpaque(false);
			jPanel.setLayout(null);
		}
		return jPanel;
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode selectednode=
				(DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
		if (selectednode==node1) {
			Tsyl_change1Panel tp1=new Tsyl_change1Panel();
			jPanel.removeAll();
			jPanel.add(tp1);
			jPanel.repaint();
			jLabel2.setText("计算机类书籍");
		}
		if (selectednode==node2) {
			
		}
		if (selectednode==node3) {
			
		}
		if (selectednode==node4) {
			
		}
		if (selectednode==node5) {
			
		}
		if (selectednode==node6) {
			Tsyl_changePanel tp=new Tsyl_changePanel();
			jPanel.removeAll();
			jPanel.add(tp);
			jPanel.repaint();
			jLabel2.setText("全部书籍");
		}
	}

}
