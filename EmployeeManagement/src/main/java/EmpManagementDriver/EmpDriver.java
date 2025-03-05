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
			
		case 2:
			int res1 = e1.update();
			if(res1!=0) System.out.println("Data updated sucessfully.");
			else System.out.println("Data not updated");
			break;
			
		case 3:
			int res2 = e1.delete();
			if(res2!=0) System.out.println("Data deleted sucessfully.");
			else System.out.println("Data not deleted.");

		default:
			break;
		}
				
	}

}