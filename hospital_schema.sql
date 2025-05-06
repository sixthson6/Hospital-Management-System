-- Employee (Superclass)
CREATE TABLE Employee (
    employee_id SERIAL PRIMARY KEY,
    surname VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    address TEXT,
    phone VARCHAR(20)
);

-- Doctor (Subclass of Employee)
CREATE TABLE Doctor (
    employee_id INT PRIMARY KEY,
    speciality VARCHAR(100),
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

-- Nurse (Subclass of Employee)
CREATE TABLE Nurse (
    employee_id INT PRIMARY KEY,
    rotation VARCHAR(50),
    salary DECIMAL(10,2),
    department_code INT,
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id),
    FOREIGN KEY (department_code) REFERENCES Department(department_code)
);

-- Department
CREATE TABLE Department (
    department_code SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    building VARCHAR(50),
    director_id INT,
    FOREIGN KEY (director_id) REFERENCES Doctor(employee_id)
);

-- Ward
CREATE TABLE Ward (
    ward_id SERIAL PRIMARY KEY,
    ward_number INT NOT NULL,
    department_code INT NOT NULL,
    number_of_beds INT,
    supervisor_id INT,
    FOREIGN KEY (department_code) REFERENCES Department(department_code),
    FOREIGN KEY (supervisor_id) REFERENCES Nurse(employee_id)
);

-- Patient
CREATE TABLE Patient (
    patient_id SERIAL PRIMARY KEY,
    surname VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    address TEXT,
    phone VARCHAR(20)
);

-- Hospitalization
CREATE TABLE Hospitalization (
    hospitalization_id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL,
    ward_id INT NOT NULL,
    bed_number INT,
    diagnosis TEXT,
    doctor_id INT NOT NULL,
    admission_date DATE,
    discharge_date DATE,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (ward_id) REFERENCES Ward(ward_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(employee_id)
);
