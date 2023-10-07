package com.example.frontend.models;

import com.example.enums.EmployeeStatus;
import com.example.models.Employee;
import com.example.service.EmployeeServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class EmployeeModel {
    private final EmployeeServices services = new EmployeeServices();
    public void deleteEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long idEmp = Long.parseLong(request.getParameter("idEmployee"));
        boolean rs = services.deleteEmp(idEmp);
        PrintWriter out = response.getWriter();
        if (rs) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Delete Success!');");
            out.println("location='listEmployee.jsp';");
            out.println("</script>");
        }
    }
    public void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String date = request.getParameter("date");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(date, formatter);
        Employee em = new Employee(address,dob,email,fullName,phone, EmployeeStatus.ACTIVE);
        boolean rs = services.insertEmp(em);
        PrintWriter out = response.getWriter();
        if(rs){
            out.println("<script type\"text/javascript\">");
            out.println("alert('Insert Success!');");
            out.println("location='listEmployee.jsp';");
            out.println("</script>");
        }
    }
    public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        long id =Long.parseLong(request.getParameter("ID"));
        String fullName = request.getParameter("fullNameUp");
        String phone = request.getParameter("phoneUp");
        String email = request.getParameter("emailUp");
        String address = request.getParameter("addressUp");
        String date = request.getParameter("dateUp");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(date, formatter);
        String status = request.getParameter("statusUp");
        EmployeeStatus statusEm;

        if ("ACTIVE".equals(status)) {
            statusEm = EmployeeStatus.ACTIVE;
        } else if ("INACTIVE".equals(status)) {
            statusEm = EmployeeStatus.IN_ACTIVE;
        } else {
            statusEm = null;
        }
        Employee emUp = new Employee(id,address,dob,email,fullName,phone,statusEm);
        boolean rs = services.updateEmp(emUp);
        PrintWriter out = response.getWriter();
        if(rs){
            out.println("<script type\"text/javascript\">");
            out.println("alert('Update Success!');");
            out.println("location='listEmployee.jsp';");
            out.println("</script>");
        }
    }

    public void loadInfIntoUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        long id =Long.parseLong(request.getParameter("employeeID"));
        Optional<Employee> em = services.findById(id);
        request.setAttribute("employee",em);
        request.getRequestDispatcher("updateEmployee.jsp").forward(request,response);
    }
}
