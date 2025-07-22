<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.OrderItem,com.tap.model.Order,com.tap.dao.OrderDAO,com.tap.dao.impl.OrderDAOImpl" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Your Orders</title>
  <style>
    body {
      font-family: 'Segoe UI', sans-serif;
      background: #eef2f3;
      margin: 0;
      padding: 20px;
    }

    h2 {
      color: #2c3e50;
      text-align: center;
      margin-bottom: 30px;
    }

    .order-detail {
      background-color: #fff;
      padding: 20px;
      margin: 0 auto 30px;
      max-width: 700px;
      border-radius: 12px;
      box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
      transition: transform 0.3s ease, box-shadow 0.3s ease;
      display: flex;
      flex-direction: column;
      gap: 15px;
    }

    .order-detail:hover {
      transform: scale(1.02);
      box-shadow: 0 12px 32px rgba(0, 0, 0, 0.15);
    }

    .order-info {
      border-bottom: 1px solid #ccc;
      padding-bottom: 10px;
    }

    .order-info h3 {
      margin: 0 0 10px;
      font-size: 20px;
      color: #2c3e50;
    }

    .order-info p {
      margin: 4px 0;
      font-size: 15px;
      color: #555;
    }

    .order-item {
      display: flex;
      align-items: center;
      gap: 15px;
      background: #f9f9f9;
      padding: 10px;
      border-radius: 8px;
    }

    .order-img {
      flex-shrink: 0;
      width: 100px;
      height: 100px;
      object-fit: cover;
      border-radius: 8px;
      box-shadow: 0 2px 6px rgba(0, 0, 0, 0.15);
      transition: transform 0.3s ease;
    }

    .order-detail:hover .order-img {
      transform: rotate(-1deg) scale(1.05);
    }

    .order-item-info h3 {
      margin: 0;
      font-size: 17px;
      color: #333;
    }

    .order-item-info p {
      margin: 4px 0;
      font-size: 14px;
      color: #666;
    }

    button {
      margin-top: 10px;
      padding: 8px 16px;
      background-color: #27ae60;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-weight: bold;
      transition: background-color 0.3s ease;
    }

    button:hover {
      background-color: #219150;
    }
  </style>
</head>
<body>

<%
  Integer userId = (Integer) session.getAttribute("user_id");
  if (userId != null) {
    OrderDAOImpl impl = new OrderDAOImpl();
    List<Order> orders = impl.getOrdersByUserId(userId);
%>

<h2>Your Order History</h2>

<%
    if (orders != null && !orders.isEmpty()) {
      for (Order order : orders) {
        List<OrderItem> items = order.getItems();
%>
<div class="order-detail" style="flex-direction: column; align-items: flex-start;">
  <div class="order-info">
    <h3>Order ID: <%= order.getOrderId() %></h3>
    <p>Date: <%= order.getOrderDate() %></p>
    <p>Status: <%= order.getStatus() %></p>
    <p>Total: ₹<%= order.getTotalAmount() %></p>
  </div>

  <% for (OrderItem item : items) { %>
    <div class="order-item">
      <img src="<%= item.getImage() %>" alt="Food Image" class="order-img">
      <div class="order-item-info">
        <h3><%= item.getName() %></h3>
        <p>Qty: <%= item.getQuantity() %></p>
        <p>Price: ₹<%= item.getPrice() %></p>
        <p>Subtotal: ₹<%= item.getQuantity() * item.getPrice() %></p>
      </div>
    </div>
  <% } %>

</div> <!-- This closes the entire order container -->


<%
      }
    } else {
%>
  <p style="text-align: center;">No orders found for your account.</p>
<%
    }
  } else {
%>
  <p style="color:red; text-align: center;">User not logged in. Please <a href="login.html">log in</a>.</p>
<%
  }
%>

</body>
</html>
