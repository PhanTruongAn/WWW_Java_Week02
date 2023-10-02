<!DOCTYPE html>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .logout-button {
            position: absolute;
            top: 10px;
            right: 10px;
            background-color: darkred;
            color: #fff;
            padding: 5px 10px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .logout-button:hover {
            background-color: #e74c3c;
        }
        a{
            color: #f4f4f4;
            font-weight: bold;
        }
        .corner-links {
            position: absolute;
            top: 80px;
            left: 10px;
            display: flex;
            flex-direction: column;
        }

        .corner-link{
            text-align: center;
            margin-bottom: 10px;
            text-decoration: none;
            color: #fff;
            font-weight: bold;
            padding: 10px 20px;
            border-radius: 20px;
            background-color: green;
            transition: background-color 0.3s ease-in-out;
        }

        .corner-link:hover {
            background-color: #13d1f7;
        }

        .page-title {
            text-align: center;
            font-size: 24px;
            margin-top: 20px;
            color: #333;
        }
        .user-info-container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            padding: 20px;
            margin-top: 20px;
        }

        .user-info-label {
            font-weight: bold;
            color: #333;
            font-size: 16px;
        }

        .user-info-value {
            color: #555;
            font-size: 18px;
        }
    </style>
</head>
<body style="background: cadetblue">
<div class="container">
    <div class="corner-links">
        <a style="text-decoration: none" class="corner-link" href="listCustomer.jsp">Customer List</a>
        <a style="text-decoration: none" class="corner-link" href="listProduct.jsp">Product List</a>
        <a style="text-decoration: none" class="corner-link" href="listEmployee.jsp">Employee List</a>
        <a style="text-decoration: none" class="corner-link" href="listProductPrice.jsp">ProductPrice List</a>
        <a style="text-decoration: none" class="corner-link" href="listOrder.jsp">Order List</a>
    </div>
    <h1 class="page-title">Xin chào</h1>
</div>
</body>
</html>
