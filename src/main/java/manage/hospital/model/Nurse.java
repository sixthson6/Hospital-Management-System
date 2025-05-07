package manage.hospital.model;

public class Nurse extends Employee {
    private String rotation;
    private double salary;
    private int departmentCode;

    public Nurse(int employeeId, String surname, String firstName, String address, String phone, String rotation, double salary, int departmentCode) {
        super(employeeId, surname, firstName, address, phone);
        this.rotation = rotation;
        this.salary = salary;
        this.departmentCode = departmentCode;
    }

    public String getRotation() { return rotation; }
    public void setRotation(String rotation) { this.rotation = rotation; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public int getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode(int departmentCode) { this.departmentCode = departmentCode; }
}
