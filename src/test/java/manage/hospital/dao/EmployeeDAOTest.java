package manage.hospital.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import manage.hospital.model.Employee;

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
    void testDuplicateInsertEmployee() {
        Employee duplicate = new Employee(TEST_ID, "Duplicate", "User", "456 Main St", "555-DUPL");
        dao.insertEmployee(duplicate);  // Should trigger primary key violation or fail silently
        Employee fetched = dao.getEmployeeById(TEST_ID);

        // Should still have the original data
        assertNotEquals("Duplicate", fetched.getSurname());
    }

    @Test
    @Order(3)
    void testInsertWithNullValues() {
        Employee invalidEmp = new Employee(1000, null, "NullName", null, null);
        dao.insertEmployee(invalidEmp);  // Should fail if surname is NOT NULL in schema

        Employee fetched = dao.getEmployeeById(1000);
        // Should be null if insertion failed, or not null if schema allows nulls
        assertTrue(fetched == null || fetched.getSurname() == null);
    }

    @Test
    @Order(4)
    void testInvalidIdLookup() {
        Employee notFound = dao.getEmployeeById(-1); // Nonexistent ID
        assertNull(notFound);
    }

    @Test
    @Order(5)
    void testUpdateEmployee() {
        Employee emp = dao.getEmployeeById(TEST_ID);
        assertNotNull(emp);

        emp.setPhone("555-UPDATED");
        dao.updateEmployee(emp);

        Employee updated = dao.getEmployeeById(TEST_ID);
        assertEquals("555-UPDATED", updated.getPhone());
    }

    @Test
    @Order(6)
    void testDeleteEmployee() {
        dao.deleteEmployee(TEST_ID);
        Employee deleted = dao.getEmployeeById(TEST_ID);
        assertNull(deleted);
    }

    
}
