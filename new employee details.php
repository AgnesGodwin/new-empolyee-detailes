<?php
header('Content-Type: application/json');
header("Access-Control-Allow-Origin: *");

$host = 'localhost';
$user = 'root';
$password = ''; // Set your DB password
$dbname = 'employee_form';

$conn = new mysqli($host, $user, $password, $dbname);
if ($conn->connect_error) {
    echo json_encode(['success' => false, 'message' => 'Database connection failed']);
    exit();
}

$data = $_POST;

$sql = "INSERT INTO employees 
(first_name, last_name, gender, dob, address, phone, email, employee_id, job_title, department, supervisor, employee_type) 
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

$stmt = $conn->prepare($sql);
$stmt->bind_param("ssssssssssss",
    $data['first_name'],
    $data['last_name'],
    $data['gender'],
    $data['dob'],
    $data['address'],
    $data['phone'],
    $data['email'],
    $data['employee_id'],
    $data['job_title'],
    $data['department'],
    $data['supervisor'],
    $data['employee_type']
);

if ($stmt->execute()) {
    echo json_encode(['success' => true, 'message' => 'Employee added successfully!']);
} else {
    echo json_encode(['success' => false, 'message' => 'Error: ' . $stmt->error]);
}

$stmt->close();
$conn->close();
?>
