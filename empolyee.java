// src/com/employee/EmployeeServlet.java
package com.employee;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "jdbc:mysql://localhost:3306/employee_form";
        String username = "root";
        String password = "your_mysql_password"; // Replace with your actual password

        // Fetch form data
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String employeeId = request.getParameter("employee_id");
        String jobTitle = request.getParameter("job_title");
        String department = request.getParameter("department");
        String supervisor = request.getParameter("supervisor");
        String employeeType = request.getParameter("employee_type");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO employees (first_name, last_name, gender, dob, address, phone, email, employee_id, job_title, department, supervisor, employee_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, gender);
            stmt.setString(4, dob);
            stmt.setString(5, address);
            stmt.setString(6, phone);
            stmt.setString(7, email);
            stmt.setString(8, employeeId);
            stmt.setString(9, jobTitle);
            stmt.setString(10, department);
            stmt.setString(11, supervisor);
            stmt.setString(12, employeeType);

            int rowsInserted = stmt.executeUpdate();

            conn.close();

            // Redirect on success
            if (rowsInserted > 0) {
                response.sendRedirect("submit.html");
            } else {
                response.getWriter().write("Failed to save employee.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
