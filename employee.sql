CREATE DATABASE employee_form;

USE employee_form;

CREATE TABLE employees (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  gender VARCHAR(10),
  dob DATE,
  address VARCHAR(255),
  phone VARCHAR(20),
  email VARCHAR(100),
  employee_id VARCHAR(50),
  job_title VARCHAR(100),
  department VARCHAR(100),
  supervisor VARCHAR(100),
  employee_type VARCHAR(50)
);
