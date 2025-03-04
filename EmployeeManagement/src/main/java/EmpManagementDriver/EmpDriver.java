package EmpManagementDriver;
import java.util.*;
import EmpManagementService.EmpService;

public class EmpDriver {
	public static void main(String[] args) {
		
		System.out.println("Welcome to Employee Management Application");
		System.out.println("1.Register Employee ");
		System.out.println("2.Update Employee  ");
		System.out.println("3.Delete Employee ");
		System.out.println("4.Fetch all Employee Data ");
		System.out.println("5.Close the Connection ");
		
		Scanner sc = new Scanner(System.in);
		EmpService e1 = new EmpService();
		
		System.out.println("Choose any: ");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			int res = e1.save();
			if(res!=0) System.out.println("Data saved sucessfully.");
			else System.out.println("Data not saved.");
			break;

		default:
			break;
		}
				
	}

}