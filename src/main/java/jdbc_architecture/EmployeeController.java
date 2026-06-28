package jdbc_architecture;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDao dao = new EmployeeDao();

        while (true) {

            System.out.println("\n========== EMPLOYEE MANAGEMENT SYSTEM ==========");
            System.out.println("1. Save Employee");
            System.out.println("2. Update Employee Salary");
            System.out.println("3. Delete Employee");
            System.out.println("4. Fetch Employee By Id");
            System.out.println("5. Fetch All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                EmployeeEntity emp = new EmployeeEntity();

                System.out.print("Enter Employee Id : ");
                emp.setEmpid(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Employee Name : ");
                emp.setName(sc.nextLine());

                System.out.print("Enter Department : ");
                emp.setDeptartment(sc.nextLine());

                System.out.print("Enter Salary : ");
                emp.setSalary(sc.nextInt());

                System.out.print("Enter Age : ");
                emp.setAge(sc.nextInt());

                boolean save = dao.saveEmployee(emp);

                if (save)
                    System.out.println("Employee Saved Successfully.");
                else
                    System.out.println("Failed to Save Employee.");

                break;

            case 2:

                System.out.print("Enter Employee Id : ");
                int id = sc.nextInt();

                System.out.print("Enter New Salary : ");
                int salary = sc.nextInt();

                boolean update = dao.updateEmployee(id, salary);

                if (update)
                    System.out.println("Employee Updated Successfully.");
                else
                    System.out.println("Employee Not Found.");

                break;

            case 3:

                System.out.print("Enter Employee Id : ");
                int deleteId = sc.nextInt();

                boolean delete = dao.deleteEmployee(deleteId);

                if (delete)
                    System.out.println("Employee Deleted Successfully.");
                else
                    System.out.println("Employee Not Found.");

                break;

            case 4:

                System.out.print("Enter Employee Id : ");
                int fetchId = sc.nextInt();

                EmployeeEntity employee = dao.fetchEmployeeById(fetchId);

                if (employee != null) {

                    System.out.println("\nEmployee Details");
                    System.out.println("--------------------------");
                    System.out.println("Employee Id : " + employee.getEmpid());
                    System.out.println("Name        : " + employee.getName());
                    System.out.println("Department  : " + employee.getDeptartment());
                    System.out.println("Salary      : " + employee.getSalary());
                    System.out.println("Age         : " + employee.getAge());

                } else {
                    System.out.println("Employee Not Found.");
                }

                break;

            case 5:

                ArrayList<EmployeeEntity> list = dao.fetchAllEmployees();

                if (list.isEmpty()) {

                    System.out.println("No Employee Records Found.");

                } else {

                    System.out.println("\nEmployee Records");
                    System.out.println("------------------------------------------------------");

                    for (EmployeeEntity e : list) {

                        System.out.println(
                                e.getEmpid() + " | " +
                                e.getName() + " | " +
                                e.getDeptartment() + " | " +
                                e.getSalary() + " | " +
                                e.getAge());

                    }
                }

                break;

            case 6:

                System.out.println("Thank You...");
                sc.close();
                System.exit(0);

            default:

                System.out.println("Invalid Choice.");
            }
        }
    }
}