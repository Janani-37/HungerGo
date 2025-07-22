<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List,com.tap.model.Menu" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Restaurant Menu</title>
  <link rel="stylesheet" href="stylemenu.css">
</head>
<body>
<h2>Explore Our Menu</h2>
  <section class="menu-section">
    <div class="menu-grid">
     
<%

List<Menu> menus= (List<Menu>)request.getAttribute("allmenu");
if(menus != null && !menus.isEmpty()){
for(Menu menu:menus){%>

    
 <div class="menu-item">
        <img src="<%=menu.getImagepath() %>" alt="Veggie Pizza">
        <h3><%=menu.getItem_name() %></h3>
        <p class="desc"><%=menu.getDescription() %></p>
        <p class="price">₹ <%=menu.getPrice() %></p>
        <p class="date">⭐ <%=menu.getRatings() %> | Updated: July 2025</p>
        
        <form action="cart" method="post">
        
        
        <input type="hidden" name="restaurantId" value="<%=menu.getRestaurant_id() %>">
        <input type="hidden" name="menuid" value="<%=menu.getMenu_id() %>">
        <input type="hidden" name="quantity" value="1">
        <input type="hidden" name="action" value="add">
        
        
  		<button class="add-to-cart" onclick="addToCart('<%=menu.getItem_name() %>', <%=menu.getPrice() %>)">Add to Cart</button>

        
       
        </form>
        </div>
        

 <% } 
     }else{	 
%>
 <p style="color: red;">No menu items found for this restaurant.</p>
 <%} %>


    </div>
  </section>
</body>
</html>
    