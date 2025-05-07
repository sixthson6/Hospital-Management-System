package manage.hospital.model;

public class Ward {
    private int wardId;
    private int wardNumber; // Local to department
    private int departmentCode;
    private int numberOfBeds;
    private int supervisorId; // A Nurse's employee ID

    public Ward(int wardId, int wardNumber, int departmentCode, int numberOfBeds, int supervisorId) {
        this.wardId = wardId;
        this.wardNumber = wardNumber;
        this.departmentCode = departmentCode;
        this.numberOfBeds = numberOfBeds;
        this.supervisorId = supervisorId;
    }

    public int getWardId() { return wardId; }
    public void setWardId(int wardId) { this.wardId = wardId; }

    public int getWardNumber() { return wardNumber; }
    public void setWardNumber(int wardNumber) { this.wardNumber = wardNumber; }

    public int getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode(int departmentCode) { this.departmentCode = departmentCode; }

    public int getNumberOfBeds() { return numberOfBeds; }
    public void setNumberOfBeds(int numberOfBeds) { this.numberOfBeds = numberOfBeds; }

    public int getSupervisorId() { return supervisorId; }
    public void setSupervisorId(int supervisorId) { this.supervisorId = supervisorId; }
}
