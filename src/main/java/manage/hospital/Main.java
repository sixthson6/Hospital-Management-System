package manage.hospital;

import manage.hospital.dao.PatientDAO;
import manage.hospital.model.Patient;

public class Main {
    public static void main(String[] args) {
        PatientDAO patient = new PatientDAO();

        // HospitalDataSeeder.seedData(); // Seed the database with initial data

        Patient p1 = new Patient(10113, "Foreman Joes", "Eric", "12 Clinic Way", "555-2001");
        Patient p2 = new Patient(11121, "Cameron Hall", "Allison", "98 Med St", "555-2002");
        Patient p3 = new Patient(121145, "Park Jun", "Chi", "77 Hospital Lane", "555-2003");

        patient.insertPatient(p1);
        patient.insertPatient(p2);
        patient.insertPatient(p3);

        Patient updated = new Patient(101133, "Cameron", "Allison", "Updated Address", "555-9999");
        patient.updatePatient(updated);

        Patient p = patient.getPatient(101133);
        System.out.println(p);

        patient.deletePatient(101133);
        
        System.out.println("Reading: " + patient.getAllPatients());



    }
}
