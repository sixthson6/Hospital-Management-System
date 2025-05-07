CREATE DATABASE IF NOT EXISTS hospital_db;
USE hospital_db;

-- EMPLOYEE TABLE (Superclass)
CREATE TABLE Employee (
    id INT PRIMARY KEY,
    surname VARCHAR(50),
    first_name VARCHAR(50),
    address VARCHAR(100),
    phone VARCHAR(20)
);

-- DOCTOR TABLE (inherits from Employee)
CREATE TABLE Doctor (
    employee_id INT PRIMARY KEY,
    speciality VARCHAR(100),
    FOREIGN KEY (employee_id) REFERENCES Employee(id)
);

-- NURSE TABLE (inherits from Employee)
CREATE TABLE Nurse (
    employee_id INT PRIMARY KEY,
    rotation VARCHAR(50),
    salary DECIMAL(10, 2),
    department_code INT,
    FOREIGN KEY (employee_id) REFERENCES Employee(id)
);

-- DEPARTMENT TABLE
CREATE TABLE Department (
    code INT PRIMARY KEY,
    name VARCHAR(100),
    building VARCHAR(100),
    director_id INT,
    FOREIGN KEY (director_id) REFERENCES Doctor(employee_id)
);

-- WARD TABLE
CREATE TABLE Ward (
    number INT,
    department_code INT,
    number_of_beds INT,
    supervisor_id INT,
    PRIMARY KEY (number, department_code),
    FOREIGN KEY (department_code) REFERENCES Department(code),
    FOREIGN KEY (supervisor_id) REFERENCES Nurse(employee_id)
);

-- PATIENT TABLE
CREATE TABLE IF NOT EXISTS Patient (
    id INT PRIMARY KEY,
    surname VARCHAR(50),
    first_name VARCHAR(50),
    address VARCHAR(100),
    phone VARCHAR(20)
);

-- HOSPITALIZATION TABLE (for admitting patients to wards)
CREATE TABLE Hospitalization (
    patient_id INT,
    ward_number INT,
    department_code INT,
    bed_number INT,
    diagnosis VARCHAR(255),
    doctor_id INT,
    PRIMARY KEY (patient_id),
    FOREIGN KEY (patient_id) REFERENCES Patient(id),
    FOREIGN KEY (ward_number, department_code) REFERENCES Ward(number, department_code),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(employee_id)
);
