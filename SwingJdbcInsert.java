package program;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

//Perform JDBC Insert using Swing
//Home system program

public class SwingJdbcInsert extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	
	JButton btn1,btn2;
	public SwingJdbcInsert()
	{
		setLayout(new FlowLayout());
		lb1=new JLabel("Enter Employe ID");
		lb2=new JLabel("Enter Employe Name");
		lb3=new JLabel("Enter Employe Department");
		lb4=new JLabel("Enter Employe Designation");
		lb5=new JLabel("Enter Employe Experience");
		lb6=new JLabel("Enter Employe Salary");
		
		lb=new JLabel("See Message Here");
		tf1=new JTextField(50);
		tf2=new JTextField(50);
		tf3=new JTextField(50);
		tf4=new JTextField(50);
		tf5=new JTextField(50);
		tf6=new JTextField(50);
		
		btn1=new JButton("insert");
		btn2=new JButton("Reset");
		add(lb1);
		add(tf1);
		add(lb2);
		add(tf2);
		add(lb3);
		add(tf3);
		add(lb4);
		add(tf4);
		add(lb5);
		add(tf5);
		add(lb6);
		add(tf6);
		
		add(lb);
		add(btn1);
		add(btn2);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingJdbcInsert obj = new SwingJdbcInsert();
		obj.setTitle("Swing JDBC Project");
		obj.setSize(600,600);
		obj.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s=e.getActionCommand();
		if(s.equals("insert"))
		{
			String s1=tf1.getText();
			String s2=tf2.getText();
			String s3=tf3.getText();
			String s4=tf4.getText();
			String s5=tf5.getText();
			String s6=tf6.getText();
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quastech","root","Nayan@29112001");
				String query="insert into employes values(?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, s1);
				pst.setString(2, s2);
				pst.setString(3, s3);
				pst.setString(4, s4);
				pst.setString(5, s5);
				pst.setString(6, s6);
				
				pst.execute();
				lb.setText("Record Inserted Successfully");
				pst.close();
				con.close();
			
				
			}
			catch(ClassNotFoundException obj) {
				lb.setText("Could Not load Mysql Driver");
			}
			catch(SQLException t) {
				lb.setText("Record Not Inserted");
			}
		}
		if(s.equals("Reset"))
		{
			tf1.setText(null);
			tf2.setText(null);
			tf3.setText(null);
			tf4.setText(null);
			tf5.setText(null);
			tf6.setText(null);
			
			lb.setText("See Message Here");
		}
	}

}