package com.example.frontend.models;

import com.example.service.EmployeeServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

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
}
