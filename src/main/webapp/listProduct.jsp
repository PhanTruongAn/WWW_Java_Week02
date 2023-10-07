
<%@ page import="com.example.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.service.ProductServices" %>
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
                    <th scope="col">Name</th>
                    <th scope="col">ManufacturerName</th>
                    <th scope="col">Description</th>
                    <th scope="col">Status</th>
                    <th scope="col">Unit</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <%
                    ProductServices services = new ProductServices();
                    List<Product> list = services.getAllPro();
                    for (Product dsPro: list) {
                %>
                <tbody style="background: #f4f4f4">
                <tr>
                    <td><%=dsPro.getProductId()%>
                    </td>
                    <td><%=dsPro.getName()%>
                    </td>
                    <td><%=dsPro.getManufacturerName()%>
                    </td>
                    <td><%=dsPro.getDescription()%>
                    </td>
                    <td><%=dsPro.getStatus()%>
                    </td>
                    <td><%=dsPro.getUnit()%>
                    </td>
                    <td>
                        <button class="btn btn-primary bi bi-trash"
                                name="delete"><a style="text-decoration: none" href="deleteProduct?idProduct=<%=dsPro.getProductId()%>">Delete</a>
                        </button>
                        <button class="btn btn-warning bi bi-pencil-square"
                                name="update"><a style="text-decoration: none" href="loadInfProIntoUpdateForm?productID=<%=dsPro.getProductId()%>">Update</a></button>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

    <button class="btn btn-success" ><a style="text-decoration: none" class="corner-link" href="insertProduct.jsp">Thêm product</a></button>
    <button class="btn btn-success"><a style="text-decoration: none" class="corner-link" href="index.jsp">Quay lại menu</a></button>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
</div>
</body>
</html>
