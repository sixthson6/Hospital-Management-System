package manage.hospital.model;

public class Doctor extends Employee {
    private String speciality;

    public Doctor(int employeeId, String surname, String firstName, String address, String phone, String speciality) {
        super(employeeId, surname, firstName, address, phone);
        this.speciality = speciality;
    }

    public String getSpeciality() { return speciality; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }
}
