package manage.hospital.model;

public class Employee {
    protected int employeeId;
    protected String surname;
    protected String firstName;
    protected String address;
    protected String phone;

    public Employee(int employeeId, String surname, String firstName, String address, String phone) {
        this.employeeId = employeeId;
        this.surname = surname;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
    }

    // Getters and Setters
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}

