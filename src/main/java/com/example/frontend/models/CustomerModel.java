package com.example.frontend.models;

import com.example.models.Customer;
import com.example.service.CustomerServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {
    private final CustomerServices services = new CustomerServices();

    public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         long idCus = Long.parseLong(request.getParameter("idCustomer"));
         boolean rs = services.deleteCus(idCus);
         PrintWriter out = response.getWriter();
        if (rs) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Delete Success!');");
            out.println("location='listCustomer.jsp';");
            out.println("</script>");
        }
    }
}
