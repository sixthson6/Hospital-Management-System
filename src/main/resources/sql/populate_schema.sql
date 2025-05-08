-- Use the correct database
USE hospital_db;

-- Insert employees (Doctors and Nurses share this table)
INSERT INTO Employee (employee_id, surname, first_name, address, phone)
VALUES
(1, 'House', 'Gregory', '221B Baker Street', '555-1001'),
(2, 'Watson', 'John', '221B Baker Street', '555-1002'),
(3, 'Chase', 'Robert', '13 Hospital Ave', '555-1003'),
(4, 'Adams', 'Lisa', '42 Medicine Rd', '555-1004'),
(5, 'Wilson', 'James', '5 Oncology Dr', '555-1005');

-- Insert Doctors
INSERT INTO Doctor (employee_id, speciality)
VALUES
(1, 'Diagnostic Medicine'),
(2, 'Cardiology'),
(3, 'Surgery');

-- Insert Nurses
INSERT INTO Nurse (employee_id, department_code, rotation, salary)
VALUES
(4, 1, 'Night', 45000),
(5, 2, 'Day', 47000);

-- Insert Departments
INSERT INTO Department (code, name, building, director_id)
VALUES
(1, 'Diagnostics', 'A', 1),
(2, 'Oncology', 'B', 2);

-- Insert Wards
INSERT INTO Ward (number, department_code, number_of_beds, supervisor_id)
VALUES
(1, 1, 10, 4),  -- Ward 1 in Dept 1 supervised by Nurse 4
(2, 1, 0, 4),   -- Edge case: 0 beds
(1, 2, 8, 5);   -- Ward 1 in Dept 2 supervised by Nurse 5

-- Insert Patients
INSERT INTO Patient (patient_id, surname, first_name, address, phone)
VALUES
(101, 'Foreman', 'Eric', '12 Clinic Way', '555-2001'),
(102, 'Cameron', 'Allison', '98 Med St', '555-2002'),
(103, 'Park', 'Chi', '77 Hospital Lane', '555-2003');

-- Insert Hospitalization
INSERT INTO Hospitalization (patient_id, ward_number, department_code, bed_number, diagnosis, doctor_id)
VALUES
(101, 1, 1, 5, 'Lupus', 1),
(102, 1, 2, 2, 'Tumor', 2),
(103, 2, 1, 1, 'Infection', 3); -- Edge case: ward with 0 beds (logic validation test)
