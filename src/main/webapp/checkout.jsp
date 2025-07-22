
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.tap.model.Cart" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Checkout</title>
  <link rel="stylesheet" href="checkout.css">
</head>
<body>
  <div class="checkout-container">
    <h2>Checkout</h2>

    <form action="checkout" method="post">
      <div class="user-info">
        <label>Name:</label>
        <input type="text" name="name" required>
        <label>Address:</label>
        <textarea name="address" required></textarea>
        <label>Payment Method:</label>
        <select name="payment">
          <option value="cod">Cash on Delivery</option>
          <option value="card">Credit/Debit Card</option>
        </select>
      </div>

      <div class="order-summary">
        <%
          Cart cart = (Cart) session.getAttribute("cart");
          if (cart != null) {
            double total = cart.getTotalPrice();
        %>
          <p>Total Amount: ₹<%= total %></p>
        <% } else { %>
          <p>Your cart is empty.</p>
        <% } %>
      </div>

      <button type="submit" class="confirm-button">Place Order</button>
    </form>
  </div>
</body>
</html>
