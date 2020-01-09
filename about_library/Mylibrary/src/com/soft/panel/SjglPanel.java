package com.soft.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.soft.bean.Sjgl;
import com.soft.dao.SjglDao;
import com.soft.frame.InsertSjglFrame;
import com.soft.frame.UpdateSjglFrame;

public class SjglPanel extends JPanel implements ActionListener {

	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JComboBox jComboBox = null;
	private JTextField jTextField = null;
	private JButton selectjButton = null;
	private JButton addjButton = null;
	private JButton updatejButton = null;
	private JButton deletejButton = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private ArrayList<Sjgl> list=null;
	private DefaultTableModel model=new DefaultTableModel();
	private Vector<String> title=null;
	private SjglDao dao=new SjglDao();
	private DefaultComboBoxModel<String> Commodel=null;
	private String [] comitem=null;

	/**
	 * This is the default constructor
	 */
	public SjglPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel3 = new JLabel();
		jLabel3.setBounds(new java.awt.Rectangle(36,62,69,26));
		jLabel3.setText("��ѯ������");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new java.awt.Rectangle(149,23,78,28));
		jLabel2.setText("�鼮����");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new java.awt.Rectangle(13,25,117,25));
		jLabel1.setText("����ǰ��λ���ǣ�");
		this.setSize(627, 423);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createTitledBorder("�鼮����"));
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(jLabel3, null);
		this.add(getJComboBox(), null);
		this.add(getJTextField(), null);
		this.add(getSelectjButton(), null);
		this.add(getAddjButton(), null);
		this.add(getUpdatejButton(), null);
		this.add(getDeletejButton(), null);
		this.add(getJScrollPane(), null);
		
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new java.awt.Rectangle(126,63,119,27));
			comitem=new String[]{"����","ѧ��","����ʱ��"};
			Commodel=new DefaultComboBoxModel<>(comitem);
			jComboBox.setModel(Commodel);
		}
		return jComboBox;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new java.awt.Rectangle(271,61,174,29));
		}
		return jTextField;
	}

	/**
	 * This method initializes selectjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSelectjButton() {
		if (selectjButton == null) {
			selectjButton = new JButton();
			selectjButton.setBounds(new java.awt.Rectangle(489,58,68,32));
			selectjButton.setText("����");
			selectjButton.addActionListener(this);
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
			addjButton.setBounds(new java.awt.Rectangle(22,379,98,36));
			addjButton.setText("���");
			addjButton.addActionListener(this);
		}
		return addjButton;
	}

	/**
	 * This method initializes updatejButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getUpdatejButton() {
		if (updatejButton == null) {
			updatejButton = new JButton();
			updatejButton.setBounds(new java.awt.Rectangle(203,380,102,35));
			updatejButton.setText("�޸�");
			updatejButton.addActionListener(this);
		}
		return updatejButton;
	}

	/**
	 * This method initializes deletejButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getDeletejButton() {
		if (deletejButton == null) {
			deletejButton = new JButton();
			deletejButton.setBounds(new java.awt.Rectangle(398,382,90,34));
			deletejButton.setText("ɾ��");
			deletejButton.addActionListener(this);
		}
		return deletejButton;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new java.awt.Rectangle(24,96,598,276));
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
			title=new Vector<>();
			title.add("���");
			title.add("������");
			title.add("����");
			title.add("ѧ��");
			title.add("�绰����");
			title.add("����ʱ��");
			title.add("��������");
			model=new DefaultTableModel(title, 0);
			setDate();
			jTable.setModel(model);
			//jTable.getTableHeader().setResizingAllowed(false);
		}
		return jTable;
	}
	public void setDate()
	{
		model.setRowCount(0);
		try {
			list=dao.getAll();
			for (int i = 0; i < list.size(); i++) {
				Sjgl s=list.get(i);
				model.addRow(new Object[]{s.getId(),s.getUsername(),
						s.getBookname(),s.getStudentid(),s.getPhone(),
						s.getTime(),s.getNumber()});
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==selectjButton) {
			String type=jComboBox.getSelectedItem().toString();
			String value=jTextField.getText().trim();
			String typeCode="";
			if ("����".equals(type))
				typeCode="bookname";
			else if ("ѧ��".equals(type))
				typeCode="studentid";
			else if ("����ʱ��".equals(type))
				typeCode="time";
			try {
				if("".equals(value))
				{
				JOptionPane.showMessageDialog(null, "�������ѯ����");
				setDate();
				}
				list=dao.getbycondition(typeCode, value);
				model.setRowCount(0);
				for (int i = 0; i < list.size(); i++) {
					Sjgl s = list.get(i);
					model.addRow(new Object[] { s.getId(), s.getUsername(),
							s.getBookname(), s.getStudentid(),
							s.getPhone(), s.getTime(), s.getNumber() });					
				}
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getSource()==addjButton) {
			InsertSjglFrame f=new InsertSjglFrame(this);
			f.setVisible(true);
		}else if (e.getSource()==updatejButton) {
			int selectRow=jTable.getSelectedRow();
			if (selectRow<0) {
				JOptionPane.showMessageDialog(null, "��ѡ��һ��Ҫ�޸ĵļ�¼ ");
			}else {
				Sjgl s=list.get(selectRow);
				UpdateSjglFrame update=new UpdateSjglFrame(s,this);
				update.setVisible(true);
			}
		}else if (e.getSource()==deletejButton) {
			int selectRow = jTable.getSelectedRow();
			if (selectRow < 0) {
				JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ���ļ�¼��");
			} else {
				int i = JOptionPane.showConfirmDialog(null, "���Ƿ�Ҫɾ���ü�¼��",
						"ɾ��ȷ��", JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					// ɾ������
					Sjgl s= list.get(selectRow);
					try {
						boolean flag = dao.deleteOne(s.getId());
						if (flag) {
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
							setDate();
						} else {
							JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
						}
					} catch (ClassNotFoundException | SQLException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}
}
