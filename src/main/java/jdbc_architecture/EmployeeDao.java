package jdbc_architecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeDao {

    Connection con = DBConnection.getConnection();

    // Save Employee
    public boolean saveEmployee(EmployeeEntity emp) {

        try {

            String query = "insert into employees values(?,?,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, emp.getEmpid());
            pstmt.setString(2, emp.getName());
            pstmt.setString(3, emp.getDeptartment());
            pstmt.setInt(4, emp.getSalary());
            pstmt.setInt(5, emp.getAge());

            int rows = pstmt.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update Employee
    public boolean updateEmployee(int empid, int salary) {

        try {

            String query = "update employees set salary=? where empid=?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, salary);
            pstmt.setInt(2, empid);

            int rows = pstmt.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete Employee
    public boolean deleteEmployee(int empid) {

        try {

            String query = "delete from employees where empid=?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, empid);

            int rows = pstmt.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
 // Fetch Employee By Id
    public EmployeeEntity fetchEmployeeById(int empid) {

        EmployeeEntity emp = null;

        try {

            String query = "select * from employees where empid=?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, empid);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {

                emp = new EmployeeEntity();

                emp.setEmpid(rs.getInt("empid"));
                emp.setName(rs.getString("name"));
                emp.setDeptartment(rs.getString("dept"));
                emp.setSalary(rs.getInt("salary"));
                emp.setAge(rs.getInt("age"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return emp;
    }


    // Fetch All Employees
    public ArrayList<EmployeeEntity> fetchAllEmployees() {

        ArrayList<EmployeeEntity> list = new ArrayList<>();

        try {

            String query = "select * from employees";

            PreparedStatement pstmt = con.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                EmployeeEntity emp = new EmployeeEntity();

                emp.setEmpid(rs.getInt("empid"));
                emp.setName(rs.getString("name"));
                emp.setDeptartment(rs.getString("dept"));
                emp.setSalary(rs.getInt("salary"));
                emp.setAge(rs.getInt("age"));

                list.add(emp);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}