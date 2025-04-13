package EmpManagementDriver;

import java.util.*;
import EmpManagementService.EmpService;
import EmpManagementService.Employee;

public class EmpDriver {
	public static void main(String[] args) {

		System.out.println("Welcome to Employee Management Application");
		boolean flag = true;
		
		System.out.println("========================");
		System.out.println("1.Register Employee ");
		System.out.println("2.Update Employee  ");
		System.out.println("3.Delete Employee ");
		System.out.println("4.Fetch all Employee Data ");
		System.out.println("5.Close the Connection \n");
		Scanner sc = new Scanner(System.in);
		EmpService e1 = new EmpService();
		
		while (flag) {
			
			System.out.println("Select any option:");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				int res = e1.save();
				if (res != 0)
					System.out.println("Data saved sucessfully.");
				else
					System.out.println("Data not saved.");
				break;

			case 2:
				int res1 = e1.update();
				if (res1 != 0)
					System.out.println("Data updated sucessfully.");
				else
					System.out.println("Data not updated");
				
				break;

			case 3:
				int res2 = e1.delete();
				if (res2 != 0)
					System.out.println("Data deleted sucessfully.");
				else
					System.out.println("Data not deleted.");
				break;

			case 4:
				List<Employee> emp = e1.fetchAll();
				if (emp != null) {
					for (Employee e : emp) {
						System.out.println(e.id + " " + e.name + " " + e.age + " " + e.salary);
					}
				}
				
				break;

			case 5:
				boolean flag1 = e1.close();
				if (flag1) {
					System.out.println("Application closed");
					flag = false;
				}
				break;

			default:
				break;
			}
			
		}
	}

}