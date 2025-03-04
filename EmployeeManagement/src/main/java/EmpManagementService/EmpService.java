package EmpManagementService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class EmpService {
	private static Connection con;
	private static String url = "jdbc:postgresql://localhost:5432/employeemanagement?user=postgres&password=123";
	private static Scanner sc = new Scanner(System.in);
	static {
		try {
			Class.forName("org.postgresql.Driver");
			DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public save() {
		int res = 0;
		System.out.println("Enter the employee id: ");
		int id = sc.nextInt();
		System.out.println("Enter the employee name: ");
		String name = sc.next();
		System.out.println("Entetr the employee age: ");
		int age = sc.nextInt();
		
	}

}
