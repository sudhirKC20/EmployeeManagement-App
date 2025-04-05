package EmpManagementService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class EmpService {
	private static Connection con;
	private static String url = "jdbc:postgresql://localhost:5432/employeemanagement?user=postgres&password=123";
	private static Scanner sc = new Scanner(System.in);
	static {
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int save() {
		int res = 0;
		System.out.println("Enter the employee id: ");
		int id = sc.nextInt();
		System.out.println("Enter the employee name: ");
		String name = sc.next();
		System.out.println("Entetr the employee age: ");
		int age = sc.nextInt();
		System.out.println("Enter the employee salary: ");
		int salary = sc.nextInt();
		
		String sql = "INSERT into employee values(?,?,?,?)";
		
		PreparedStatement pstm;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setInt(3, age);
			pstm.setInt(4, salary);
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}	
	
	public int update() {
		int res =0;
		System.out.println("Enter the id to be updated: ");
		int id = sc.nextInt();
		System.out.println("Enter the salary to be updated");
		int salary = sc.nextInt();
		String sql = "UPDATE employee set salary = ? where id = ?";
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, salary);
			pstm.setInt(2, id);
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public int delete() {
		int res = 0;
		System.out.println("Enter the id to be deleted: ");
		int id = sc.nextInt();
		String sql = "DELETE from employee where id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public List<Employee> fetchAll(){
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT * from employee";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				int salary = rs.getInt(4);
				
				Employee e1 = new Employee(id, name, age, salary);
				emp.add(e1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public boolean close() {
		boolean flag = false;
			try {
				con.close();
				flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return flag;
	}	
}
