import dao.EmployeeDAO;
import model.Employee;
import java.util.List;

public class SelectEmployeesNew {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employeeList = employeeDAO.findAll();

        for (Employee employee : employeeList) {
            System.out.println("Employee ID: " + employee.getId() + ", Name: " + employee.getName() + ", Age: "
                    + employee.getAge());
        }

    }
}