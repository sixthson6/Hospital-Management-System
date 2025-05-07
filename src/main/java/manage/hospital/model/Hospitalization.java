package manage.hospital.model;

import java.time.LocalDate;

public class Hospitalization {
    private int hospitalizationId;
    private int patientId;
    private int wardId;
    private int bedNumber;
    private String diagnosis;
    private int doctorId;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;

    public Hospitalization(int hospitalizationId, int patientId, int wardId, int bedNumber, String diagnosis,
                           int doctorId, LocalDate admissionDate, LocalDate dischargeDate) {
        this.hospitalizationId = hospitalizationId;
        this.patientId = patientId;
        this.wardId = wardId;
        this.bedNumber = bedNumber;
        this.diagnosis = diagnosis;
        this.doctorId = doctorId;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
    }

    public int getHospitalizationId() { return hospitalizationId; }
    public void setHospitalizationId(int hospitalizationId) { this.hospitalizationId = hospitalizationId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public int getWardId() { return wardId; }
    public void setWardId(int wardId) { this.wardId = wardId; }

    public int getBedNumber() { return bedNumber; }
    public void setBedNumber(int bedNumber) { this.bedNumber = bedNumber; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public LocalDate getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(LocalDate admissionDate) { this.admissionDate = admissionDate; }

    public LocalDate getDischargeDate() { return dischargeDate; }
    public void setDischargeDate(LocalDate dischargeDate) { this.dischargeDate = dischargeDate; }
}
