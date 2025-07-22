<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.tap.model.Cart,com.tap.model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="cart.css">
</head>
<body>

<div class="cart-container">
  <h2>Your Cart</h2>

  <%
    Cart cart = (Cart) session.getAttribute("cart");
    Integer restaurantId =(Integer) session.getAttribute("restaurant_id");

    if (cart != null && !cart.getItems().isEmpty()) {
      for (CartItem item : cart.getItems().values()) {
  %>
    <div class="cart-item">
      <img src="<%= item.getImage() %>" alt="Item Image" class="item-image" />
      <div class="item-details">
        <h3><%= item.getName() %></h3>
        <p class="item-meta">Restaurant ID: <%= restaurantId %> | Item ID: <%= item.getMenu_id() %></p>
        <div class="price-control">
          <span class="price">₹<%= item.getPrice() %></span>
          <span class="price">Total: ₹<%= item.getPrice() * item.getQuantity() %></span>

          <div class="price-control">
            <!-- Quantity Increment -->
            <form action="cart" method="post">
              <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
              <input type="hidden" name="menuid" value="<%= item.getMenu_id() %>">
              <input type="hidden" name="action" value="update">
              <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
              <button>+</button>
            </form>

            <span><%= item.getQuantity() %></span>

            <!-- Quantity Decrement -->
            <form action="cart" method="post">
              <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
              <input type="hidden" name="menuid" value="<%= item.getMenu_id() %>">
              <input type="hidden" name="action" value="update">
              <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
              <button <% if(item.getQuantity() == 1){ %> disabled <% } %>> - </button>
            </form>
          </div>
        </div>

        <!-- Remove Button -->
        <form action="cart" method="post">
          <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
          <input type="hidden" name="menuid" value="<%= item.getMenu_id() %>">
          <input type="hidden" name="action" value="delete">
          <button>Remove</button>
        </form>
      </div>
    </div>
  <%
      } %>
      
   <%  }
  %>
</div>

		<div class="cart-actions">

    <a href="menu?restaurant_id=<%= restaurantId%>"><button class="action-button">Add More Items</button></a>


  <form action="checkout.jsp" method="post">
    <button class="action-button checkout-button">Proceed to Checkout</button>
  </form>
</div>
		
</body>
</html>