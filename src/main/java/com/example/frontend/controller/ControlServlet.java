package com.example.frontend.controller;

import com.example.frontend.models.CustomerModel;
import com.example.frontend.models.EmployeeModel;
import com.example.frontend.models.ProductModel;
import com.example.models.Customer;
import com.example.repositories.CustomerRepository;
import com.example.service.CustomerServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class ControlServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductModel productModel = new ProductModel();
        EmployeeModel employeeModel = new EmployeeModel();
        CustomerModel customerModel = new CustomerModel();
        String action = request.getServletPath();
             switch (action){
                 case "/deleteCustomer":
                     customerModel.deleteCustomer(request,response);
                     break;
                 case "/insertCustomer":
                     customerModel.insertCustomer(request,response);
                     break;
                 case "/loadInfIntoUpdateForm":
                     customerModel.loadInfIntoUpdateForm(request,response);
                     break;
                 case "/updateCustomer":
                     customerModel.updateCustomer(request,response);
                     break;
                 case "/deleteEmployee":
                     employeeModel.deleteEmp(request,response);
                     break;
                 default:
                     break;
             }
    }

}
