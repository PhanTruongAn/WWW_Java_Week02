
<%@ page import="java.util.List" %>
<%@ page import="com.example.service.EmployeeServices" %>
<%@ page import="com.example.models.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<html>
<head>
    <style>
        .btn btn-success{
            background-color: green;
            top: 10px;
            right: 10px;
            border-radius: 3px;
            cursor: pointer;
            border: none;
            color: #fff;
        }
        .btn btn-success:hover{
            background-color: #e74c3c;
        }
        a{
            color: #f4f4f4;
        }
        a:hover{
            color: #f4f4f4;
        }
    </style>
</head>
<body style="background: cadetblue">

<div class="container">
    <div class="row">
        <div class="col-12 mt-4">
            <table class="table table-hover">
                <thead class="table-light">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Address</th>
                    <th scope="col">Dob</th>
                    <th scope="col">Email</th>
                    <th scope="col">FullName</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Status</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <%
                    EmployeeServices services = new EmployeeServices();
                    List<Employee> list = services.getAllEmp();
                    for (Employee dsEmp: list) {
                %>
                <tbody style="background: #f4f4f4">
                <tr>
                    <td><%=dsEmp.getEmpIp()%>
                    </td>
                    <td><%=dsEmp.getAddress()%>
                    </td>
                    <td><%=dsEmp.getDob()%>
                    </td>
                    <td><%=dsEmp.getEmail()%>
                    </td>
                    <td>
                        <%=dsEmp.getFullname()%>
                    </td>
                    <td><%=dsEmp.getPhone()%>
                    </td>
                    <td><%=dsEmp.getStatus()%>
                    </td>
                    <td>
                        <button class="btn btn-primary bi bi-trash"
                                name="delete"><a style="text-decoration: none" href="deleteEmployee?idEmployee=<%=dsEmp.getEmpIp()%>">Delete</a>
                        </button>
                        <button class="btn btn-warning bi bi-pencil-square"
                                name="update"><a style="text-decoration: none" href="loadInfEmpIntoUpdateForm?employeeID=<%=dsEmp.getEmpIp()%>">Update</a></button>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

    <button class="btn btn-success" ><a style="text-decoration: none" class="corner-link" href="insertEmployee.jsp">Thêm employee</a></button>
    <button class="btn btn-success"><a style="text-decoration: none" class="corner-link" href="index.jsp">Quay lại menu</a></button>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
</div>
</body>
</html>
