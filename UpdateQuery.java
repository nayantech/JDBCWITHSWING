package program;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

//Layout have 4 types
//CardLayout
//FlowLayout
//BorderLayout
//GridLayout


public class UpdateQuery extends JFrame implements ActionListener {
	//JFrame is a class and ActionListener is a interface
	
	private static final long serialVersionUID = 1L;
	JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JButton btn1,btn2;
	public UpdateQuery()
	{
		
		//By Default is CardLayout
		setLayout(new FlowLayout());
		lb1=new JLabel("\nEnter Employees ID");
		lb2=new JLabel("\nEnter Employees Name");
		
		lb3=new JLabel("\nEnter Employees Department");
		lb4=new JLabel("\nEnter Employees Designation");
		lb5=new JLabel("\nEnter Employees Experience");
		lb6=new JLabel("\nEnter Employees Salary");
		lb=new JLabel("See Message Here");
		tf1=new JTextField(50);
		tf2=new JTextField(50);
		tf3=new JTextField(50);
		tf4=new JTextField(50);
		tf5=new JTextField(50);
		tf6=new JTextField(50);
		
		btn1=new JButton("Update");
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
		UpdateQuery obj = new UpdateQuery();
		obj.setTitle("Swing JDBC Project");
		obj.setSize(800,800);
		obj.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s=e.getActionCommand();
		if(s.equals("Update"))
		{
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quastech","root","Nayan@29112001");
//				Statement st=con.createStatement();
//				st.executeUpdate("update employees set name="+tf2.getText()+"where id="+tf1.getText());
				String query="update employes set sal=? where id=?";
				int salary=Integer.parseInt(tf6.getText());
				int id=Integer.parseInt(tf1.getText());
				PreparedStatement pst=con.prepareStatement(query);
				
				pst.setInt(1, salary);
				pst.setInt(2, id);
				pst.execute();
				lb.setText("Record updated");
//				st.close();
				con.close();
				
				//this for select query
//				ResultSet rs=st.executeQuery("select * from employees where age="+tf3.getText());
//				if(rs.next()==true) {
//					tf1.setText(rs.getString("id"));
//					tf2.setText(rs.getString("name"));
////					tf3.setText(rs.getString("age"));
//					tf4.setText(rs.getString("dept"));
//					tf5.setText(rs.getString("desg"));
//					tf6.setText(rs.getString("exp"));
//					tf7.setText(rs.getString("sal"));
//				}
//				lb.setText("Record Retrived");
//				st.close();
//				con.close();
				
			
				
			}
			catch(ClassNotFoundException obj) {
				lb.setText("Could Not load Mysql Driver");
			}
			catch(SQLException t) {
				lb.setText("Record Not Update");
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