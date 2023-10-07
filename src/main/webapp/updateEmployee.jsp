<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.service.CustomerServices" %>
<%@ page import="com.example.models.Customer" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.example.models.Employee" %>
<html>
<head>
    <title>Thêm Account</title>
</head>
<body>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
    }

    header {
        background-color: #007bff;
        color: #fff;
        padding: 20px;
        text-align: center;
    }

    h1 {
        margin: 0;
    }

    .container {
        max-width: 600px;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 5px;
    }

    label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
    }

    input[type="text"], input[type="password"], select {
        width: 100%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    button {
        background-color: #007bff;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    button.cancel {
        background-color: #ccc;
    }

    button:hover {
        background-color: #0056b3;
    }
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
<header>
    <h1>Update Employee</h1>
</header>
<div class="container">
    <%
        Optional<Employee> em = (Optional<Employee>) request.getAttribute("employee") ;
    %>
    <form action="updateEmployee" method="post">
        <label>ID:</label>
        <input type="text" name="ID" class="text" value="<%=em.get().getEmpIp()%>" required>

        <label>Họ và Tên:</label>
        <input type="text" name="fullNameUp" class="text" value="<%=em.get().getFullname()%>" required>

        <label>Số điện thoại:</label>
        <input type="text" name="phoneUp" class="text" value="<%=em.get().getPhone()%>"required>

        <label>Địa chỉ:</label>
        <input type="text" name="addressUp" class="text" value="<%=em.get().getAddress()%>" required>

        <label>Email:</label>
        <input type="text" name="emailUp" class="text"  value="<%=em.get().getEmail()%>" required>

        <label>Date of birth:</label>
        <input type="date" name="dateUp" class="text" value="<%=em.get().getDob()%>" required>

        <label>Status:</label>
        <select name="statusUp" class="text" required>
            <option value="<%=em.get().getEmpIp()%>>">ACTIVE</option>
            <option value="INACTIVE">INACTIVE</option>
        </select>

        <button type="submit" name="submit" value="submit">Xác nhận</button>

    </form>
    <button class="btn btn-success"><a style="text-decoration: none" class="corner-link" href="listEmployee.jsp">Quay lại danh sách</a></button>
</div>
</body>
</html>
