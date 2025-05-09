package manage.hospital.model;

public class Patient {
    private int id;
    private String surname;
    private String firstName;
    private String address;
    private String phone;

    public Patient(int id, String surname, String firstName, String address, String phone) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
    }

    public int getId() { return id; }
    public void setPatientId(int id) { this.id = id; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", lastName='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
