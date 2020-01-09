package com.soft.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.soft.bean.Tsyl;
import com.soft.dao.TsylDao;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Tsyl_change1Panel extends JPanel implements ActionListener {

	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private DefaultTableModel model=null;
	private String[] title=null;
	private TsylDao dao=new TsylDao();
	private JTextField selectjTextField = null;
	private JLabel booknamejLabel = null;
	private JButton selectjButton = null;
	private JButton addjButton = null;
	private JButton dropButton = null;
	private JButton updatejButton = null;
	/**
	 * This is the default constructor
	 */
	public Tsyl_change1Panel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		booknamejLabel = new JLabel();
		booknamejLabel.setBounds(new java.awt.Rectangle(4,1,58,41));
		booknamejLabel.setText("书名：");
		this.setSize(469,346);
		this.setLayout(null);
		//this.setOpaque(false);
		this.add(getJScrollPane(), null);
		this.add(getSelectjTextField(), null);
		this.add(booknamejLabel, null);
		this.add(getSelectjButton(), null);
		this.add(getAddjButton(), null);
		this.add(getDropButton(), null);
		this.add(getUpdatejButton(), null);
		
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new java.awt.Rectangle(7,44,455,254));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			title=new String[]{"编号","书名","作者","价格","出版社","类型","数量","剩余","缺少","摆放位置"};
			model=new DefaultTableModel(title, 0);
			setDate();
			jTable.setModel(model);
			jTable.getTableHeader().setResizingAllowed(false);
		}
		return jTable;
	}
	public void setDate()
	{
		model.setRowCount(0);
		try {
			ArrayList<Tsyl> list=dao.getjsj();
			if (list!=null) {
				for (int i = 0; i < list.size(); i++) {
					Tsyl row=list.get(i);
					model.addRow(new Object[] { row.getId(),row.getBook(),
							row.getAuthor(),row.getPrice(),
							row.getPress(),row.getType(),row.getNumber(),
							row.getHave(),row.getUnhave(),row.getLocation() });
					
				}
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * This method initializes selectjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getSelectjTextField() {
		if (selectjTextField == null) {
			selectjTextField = new JTextField();
			selectjTextField.setBounds(new java.awt.Rectangle(68,9,259,26));
		}
		return selectjTextField;
	}

	/**
	 * This method initializes selectjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSelectjButton() {
		if (selectjButton == null) {
			selectjButton = new JButton();
			selectjButton.setBounds(new java.awt.Rectangle(344,7,84,32));
			selectjButton.setText("搜索");
		}
		return selectjButton;
	}

	/**
	 * This method initializes addjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAddjButton() {
		if (addjButton == null) {
			addjButton = new JButton();
			addjButton.setBounds(new java.awt.Rectangle(17,307,88,31));
			addjButton.setText("添加");
		}
		return addjButton;
	}

	/**
	 * This method initializes dropButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getDropButton() {
		if (dropButton == null) {
			dropButton = new JButton();
			dropButton.setBounds(new java.awt.Rectangle(175,306,93,34));
			dropButton.setText("删除");
		}
		return dropButton;
	}

	/**
	 * This method initializes updatejButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getUpdatejButton() {
		if (updatejButton == null) {
			updatejButton = new JButton();
			updatejButton.setBounds(new java.awt.Rectangle(330,306,90,34));
			updatejButton.setText("修改");
		}
		return updatejButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==selectjButton) {
			
		}
	}
}
