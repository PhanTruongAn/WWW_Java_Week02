package com.example.frontend.models;

import com.example.models.Customer;
import com.example.service.CustomerServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

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

    public void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        Customer customer = new Customer(address, email, name, phone);
        boolean rs = services.insertCus(customer);
        PrintWriter out = response.getWriter();
        if (rs) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Insert Success!');");
            out.println("location='listCustomer.jsp';");
            out.println("</script>");
        }
    }

    public void loadInfIntoUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("cutomerID"));
        Optional<Customer> cus = services.findById(id);
        request.setAttribute("loadInfo", cus);
        request.getRequestDispatcher("updateCustomer.jsp").forward(request, response);
    }

    public void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id =Long.parseLong(request.getParameter("idCustomer"));
        String name = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        Customer customer = new Customer(id,address, email, name, phone);
        boolean rs = services.updateCus(customer);
        PrintWriter out = response.getWriter();
        if (rs) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Update Success!');");
            out.println("location='listCustomer.jsp';");
            out.println("</script>");
        }
    }

}
