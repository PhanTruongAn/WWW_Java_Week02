<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.example.models.Customer" %>
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
    <h1>Thêm Account</h1>
</header>
<div class="container">
    <%
        Optional<Customer> cus = (Optional<Customer>) request.getAttribute("loadInfo");
    %>
    <form action="updateCustomer" method="post">
        <label>ID:</label>
        <input type="text" name="idCustomer" class="text" value="<%=cus.get().getCustId()%>" required>
        <label>Họ và Tên:</label>
        <input type="text" name="fullName" class="text" value="<%=cus.get().getCustName()%>" required>

        <label>Số điện thoại:</label>
        <input type="text" name="phone" class="text" value="<%=cus.get().getPhone()%>" required>

        <label>Địa chỉ:</label>
        <input type="text" name="address" class="text" value="<%=cus.get().getAddress()%>" required>

        <label>Email:</label>
        <input type="text" name="email" class="text" value="<%=cus.get().getEmail()%>" required>
        <button type="submit" name="submit" value="submit">Xác nhận</button>
    </form>
    <button class="btn btn-success"><a style="text-decoration: none" class="corner-link" href="listCustomer.jsp">Quay lại danh sách</a></button>
</div>
</body>
</html>
