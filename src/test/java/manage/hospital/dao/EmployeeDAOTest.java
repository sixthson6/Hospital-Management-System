package manage.hospital.dao;

import manage.hospital.model.Employee;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDAOTest {

    private static final EmployeeDAO dao = new EmployeeDAO();
    private static final int TEST_ID = 999;

    @Test
    @Order(1)
    void testInsertEmployee() {
        Employee emp = new Employee(TEST_ID, "Test", "User", "123 Test St", "555-TEST");
        dao.insertEmployee(emp);

        Employee fetched = dao.getEmployeeById(TEST_ID);
        assertNotNull(fetched);
        assertEquals("Test", fetched.getSurname());
    }

    @Test
    @Order(2)
    void testGetAllEmployees() {
        List<Employee> employees = dao.getAllEmployees();
        assertNotNull(employees);
        assertTrue(employees.size() > 0);
    }

    @Test
    @Order(3)
    void testUpdateEmployee() {
        Employee emp = dao.getEmployeeById(TEST_ID);
        assertNotNull(emp);

        emp.setPhone("555-UPDATED");
        dao.updateEmployee(emp);

        Employee updated = dao.getEmployeeById(TEST_ID);
        assertEquals("555-UPDATED", updated.getPhone());
    }

    @Test
    @Order(4)
    void testDeleteEmployee() {
        dao.deleteEmployee(TEST_ID);
        Employee deleted = dao.getEmployeeById(TEST_ID);
        assertNull(deleted);
    }
}
