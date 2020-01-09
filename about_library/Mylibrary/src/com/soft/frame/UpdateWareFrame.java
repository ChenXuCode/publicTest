package com.soft.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.soft.bean.Tsyl;
import com.soft.dao.TsylDao;
import com.soft.panel.Tsyl_changePanel;
import com.soft.util.NumLimit;

public class UpdateWareFrame extends JFrame implements ActionListener {

	private JPanel jContentPane = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JButton exitjButton = null;
	private JLabel booknamejLabel = null;
	private JTextField booknamejTextField = null;
	private JLabel authorjLabel = null;
	private JTextField authorjTextField = null;
	private JLabel pricejLabel = null;
	private JTextField pricejTextField = null;
	private JLabel pressjLabel = null;
	private JTextField pressjTextField = null;
	private JLabel typejLabel = null;
	private JTextField typejTextField = null;
	private JLabel locationjLabel = null;
	private JTextField locationjTextField = null;
	private Tsyl t=new Tsyl();
	private TsylDao dao=new TsylDao();
	private Tsyl_changePanel p=null;
	private JButton updatejButton = null;
	private JLabel numberjLabel = null;
	private JTextField numberjTextField = null;
	private JLabel havejLabel = null;
	private JLabel unhavejLabel = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel9 = null;
	private JTextField havejTextField = null;
	private JTextField unhavejTextField = null;
	/**
	 * This is the default constructor
	 */
	public UpdateWareFrame() {
		super();
		initialize();
	}
	public UpdateWareFrame(Tsyl t,Tsyl_changePanel p){
		this();
		this.t=t;
		this.p=p;
		if (t!=null) {
			booknamejTextField.setText(t.getBook());
			authorjTextField.setText(t.getAuthor());
			pricejTextField.setText(t.getPrice()+"");
			pressjTextField.setText(t.getPress());
			typejTextField.setText(t.getType());
			numberjTextField.setText(t.getNumber()+"");
			havejTextField.setText(t.getHave()+"");
			unhavejTextField.setText(t.getUnhave()+"");
			locationjTextField.setText(t.getLocation());
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
		this.setTitle("修改书籍窗体");
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
			jLabel9 = new JLabel();
			jLabel9.setBounds(new java.awt.Rectangle(330,257,29,30));
			jLabel9.setText("*");
			jLabel9.setForeground(Color.red);
			jLabel8 = new JLabel();
			jLabel8.setBounds(new java.awt.Rectangle(736,197,25,30));
			jLabel8.setText(" *");
			jLabel8.setForeground(Color.red);
			jLabel7 = new JLabel();
			jLabel7.setBounds(new java.awt.Rectangle(327,190,35,34));
			jLabel7.setText("*");
			jLabel7.setForeground(Color.red);
			unhavejLabel = new JLabel();
			unhavejLabel.setBounds(new java.awt.Rectangle(404,195,103,31));
			unhavejLabel.setText("缺少：");
			havejLabel = new JLabel();
			havejLabel.setBounds(new java.awt.Rectangle(19,192,76,31));
			havejLabel.setText("剩余：");
			numberjLabel = new JLabel();
			numberjLabel.setBounds(new java.awt.Rectangle(405,140,97,32));
			numberjLabel.setText("数量：");
			locationjLabel = new JLabel();
			locationjLabel.setBounds(new java.awt.Rectangle(9,251,88,32));
			locationjLabel.setText("摆放位置：");
			typejLabel = new JLabel();
			typejLabel.setBounds(new java.awt.Rectangle(16,125,70,32));
			typejLabel.setText(" 类型：");
			pressjLabel = new JLabel();
			pressjLabel.setBounds(new java.awt.Rectangle(404,75,86,31));
			pressjLabel.setText("出版社：");
			pricejLabel = new JLabel();
			pricejLabel.setBounds(new java.awt.Rectangle(13,69,84,35));
			pricejLabel.setText("价格：");
			authorjLabel = new JLabel();
			authorjLabel.setBounds(new java.awt.Rectangle(402,17,85,35));
			authorjLabel.setText("作者：");
			booknamejLabel = new JLabel();
			booknamejLabel.setBounds(new java.awt.Rectangle(14,15,84,37));
			booknamejLabel.setText(" 书籍名称：");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new java.awt.Rectangle(739,140,17,25));
			jLabel6.setText("*");
			jLabel6.setForeground(Color.red);
			jLabel6.setHorizontalAlignment(jLabel1.CENTER);
			jLabel5 = new JLabel();
			jLabel5.setBounds(new java.awt.Rectangle(327,135,30,27));
			jLabel5.setText("*");
			jLabel5.setForeground(Color.red);
			jLabel5.setHorizontalAlignment(jLabel1.CENTER);
			jLabel4 = new JLabel();
			jLabel4.setBounds(new java.awt.Rectangle(733,71,26,34));
			jLabel4.setText("*");
			jLabel4.setForeground(Color.red);
			jLabel4.setHorizontalAlignment(jLabel1.CENTER);
			jLabel3 = new JLabel();
			jLabel3.setBounds(new java.awt.Rectangle(331,73,24,30));
			jLabel3.setText("*");
			jLabel3.setForeground(Color.red);
			jLabel3.setHorizontalAlignment(jLabel1.CENTER);
			jLabel2 = new JLabel();
			jLabel2.setBounds(new java.awt.Rectangle(739,21,18,29));
			jLabel2.setText("*");
			jLabel2.setForeground(Color.red);
			jLabel2.setHorizontalAlignment(jLabel1.CENTER);
			jLabel1 = new JLabel();
			jLabel1.setBounds(new java.awt.Rectangle(330,17,21,24));
			jLabel1.setText("*");
			jLabel1.setForeground(Color.red);
			jLabel1.setHorizontalAlignment(jLabel1.CENTER);
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(getExitjButton(), null);
			jContentPane.add(booknamejLabel, null);
			jContentPane.add(getBooknamejTextField(), null);
			jContentPane.add(authorjLabel, null);
			jContentPane.add(getAuthorjTextField(), null);
			jContentPane.add(pricejLabel, null);
			jContentPane.add(getPricejTextField(), null);
			jContentPane.add(pressjLabel, null);
			jContentPane.add(getPressjTextField(), null);
			jContentPane.add(typejLabel, null);
			jContentPane.add(getTypejTextField(), null);
			jContentPane.add(locationjLabel, null);
			jContentPane.add(getLocationjTextField(), null);
			jContentPane.add(getUpdatejButton(), null);
			jContentPane.add(numberjLabel, null);
			jContentPane.add(getNumberjTextField(), null);
			jContentPane.add(havejLabel, null);
			jContentPane.add(unhavejLabel, null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(jLabel8, null);
			jContentPane.add(jLabel9, null);
			jContentPane.add(getHavejTextField(), null);
			jContentPane.add(getUnhavejTextField(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes exitjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getExitjButton() {
		if (exitjButton == null) {
			exitjButton = new JButton();
			exitjButton.setBounds(new java.awt.Rectangle(600,248,144,37));
			exitjButton.setText("退出");
			exitjButton.addActionListener(this);
		}
		return exitjButton;
	}

	/**
	 * This method initializes booknamejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getBooknamejTextField() {
		if (booknamejTextField == null) {
			booknamejTextField = new JTextField();
			booknamejTextField.setBounds(new java.awt.Rectangle(117,13,185,38));
		}
		return booknamejTextField;
	}

	/**
	 * This method initializes authorjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAuthorjTextField() {
		if (authorjTextField == null) {
			authorjTextField = new JTextField();
			authorjTextField.setBounds(new java.awt.Rectangle(514,16,198,40));
		}
		return authorjTextField;
	}

	/**
	 * This method initializes pricejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPricejTextField() {
		if (pricejTextField == null) {
			pricejTextField = new JTextField();
			pricejTextField.setBounds(new java.awt.Rectangle(113,70,177,38));
			pricejTextField.addKeyListener(new NumLimit());
		}
		return pricejTextField;
	}

	/**
	 * This method initializes pressjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPressjTextField() {
		if (pressjTextField == null) {
			pressjTextField = new JTextField();
			pressjTextField.setBounds(new java.awt.Rectangle(515,70,194,36));
		}
		return pressjTextField;
	}

	/**
	 * This method initializes typejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTypejTextField() {
		if (typejTextField == null) {
			typejTextField = new JTextField();
			typejTextField.setBounds(new java.awt.Rectangle(119,130,164,34));
		}
		return typejTextField;
	}

	/**
	 * This method initializes locationjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLocationjTextField() {
		if (locationjTextField == null) {
			locationjTextField = new JTextField();
			locationjTextField.setBounds(new java.awt.Rectangle(105,247,183,40));
		}
		return locationjTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==updatejButton) {
			//获取文本框的数据
			String bookname=booknamejTextField.getText().trim();
			String author=authorjTextField.getText().trim();
			String price=pricejTextField.getText().trim();
			String press=pressjTextField.getText().trim();
			String type=typejTextField.getText().trim();
			String number=numberjTextField.getText().trim();
			String have=havejTextField.getText().trim();
			String unhave=unhavejTextField.getText().trim();
			String location=locationjTextField.getText().trim();
			//判断字段是否为空
			if (!bookname.equals("")&&!author.equals("")
					&&!price.equals("")&&!press.equals("")
					&&!type.equals("")&&!number.equals("")&&!have.equals("")
					&&!unhave.equals("")&&!location.equals("")) {
				  //价格字符要进行数值处理（0-9 . ）字符限制，数值限制
				try {
					int Price=Integer.parseInt(price);
					int Number=Integer.parseInt(number);
					int Have=Integer.parseInt(have);
					int Unhave=Integer.parseInt(unhave);
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请在价格文本框中填写正确的值");
					return;
				}
				//生成一个Tsyl t，封装9个字段
				t.setBook(bookname);
				t.setAuthor(author);
				t.setPrice(Integer.parseInt(price));
				t.setPress(press);
				t.setType(type);
				t.setNumber(Integer.parseInt(number));
				t.setHave(Integer.parseInt(have));
				t.setUnhave(Integer.parseInt(unhave));
				t.setLocation(location);
				try {
					if (dao.updateOneWare(t)) {
						//提示添加成功，注销当前面板，刷新数据
						JOptionPane.showMessageDialog(null, "修改成功");
						//刷新表格内容
						if (p!=null) {
							p.setDate();
						}
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "修改失败");
						dispose();
					}
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		      }else {
				 JOptionPane.showMessageDialog(null, "请将带星号的文本填写完整");
				 return;
		      }
		}else if (e.getSource()==exitjButton){
			int i=JOptionPane.showConfirmDialog(null, "您是否要放弃该表单的填写？",
					"退出确认", JOptionPane.YES_NO_OPTION);
			if (i==JOptionPane.YES_NO_OPTION) {
				dispose();
			}
			//System.exit(0);
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
			updatejButton.setBounds(new java.awt.Rectangle(371,249,135,41));
			updatejButton.setText("修改");
			updatejButton.addActionListener(this);
		}
		return updatejButton;
	}
	/**
	 * This method initializes numberjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNumberjTextField() {
		if (numberjTextField == null) {
			numberjTextField = new JTextField();
			numberjTextField.setBounds(new java.awt.Rectangle(519,136,192,34));
			numberjTextField.addKeyListener(new NumLimit());
		}
		return numberjTextField;
	}
	/**
	 * This method initializes havejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getHavejTextField() {
		if (havejTextField == null) {
			havejTextField = new JTextField();
			havejTextField.setBounds(new java.awt.Rectangle(116,189,177,34));
			havejTextField.addKeyListener(new NumLimit());
		}
		return havejTextField;
	}
	/**
	 * This method initializes unhavejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getUnhavejTextField() {
		if (unhavejTextField == null) {
			unhavejTextField = new JTextField();
			unhavejTextField.setBounds(new java.awt.Rectangle(529,195,184,33));
			unhavejTextField.addKeyListener(new NumLimit());
		}
		return unhavejTextField;
	}
}