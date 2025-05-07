package manage.hospital.model;

public class Department {
    private int departmentCode;
    private String name;
    private String building;
    private int directorId; // A Doctor's employee ID

    public Department(int departmentCode, String name, String building, int directorId) {
        this.departmentCode = departmentCode;
        this.name = name;
        this.building = building;
        this.directorId = directorId;
    }

    public int getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode(int departmentCode) { this.departmentCode = departmentCode; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBuilding() { return building; }
    public void setBuilding(String building) { this.building = building; }

    public int getDirectorId() { return directorId; }
    public void setDirectorId(int directorId) { this.directorId = directorId; }
}
