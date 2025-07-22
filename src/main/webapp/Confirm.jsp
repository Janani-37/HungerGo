<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Order Confirmation</title>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet" />
  <style>
    body {
      margin: 0;
      font-family: 'Roboto', sans-serif;
      background: linear-gradient(135deg, #f0f4f8, #d9e2ec);
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .confirmation-card {
      background: white;
      padding: 40px;
      border-radius: 12px;
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
      text-align: center;
      max-width: 400px;
      animation: fadeIn 1s ease-in-out;
    }

    .checkmark {
      width: 80px;
      height: 80px;
      margin: 0 auto 20px;
      stroke: #4CAF50;
      stroke-width: 3;
      stroke-linecap: round;
      stroke-linejoin: round;
      animation: draw 1s ease-in-out forwards;
    }

    h1 {
      color: #333;
      font-size: 24px;
      margin-bottom: 10px;
    }

    p {
      color: #666;
      font-size: 16px;
      margin-bottom: 30px;
    }

    .btn {
      display: inline-block;
      padding: 12px 24px;
      border-radius: 6px;
      text-decoration: none;
      font-weight: bold;
      transition: transform 0.3s ease, background 0.3s ease;
    }

    .track-btn {
      background-color: #4CAF50;
      color: white;
      margin-right: 10px;
    }

    .shop-btn {
      background-color: #e0e0e0;
      color: #333;
    }

    .btn:hover {
      transform: scale(1.05);
    }

    @keyframes draw {
      0% { stroke-dasharray: 0, 100; }
      100% { stroke-dasharray: 100, 0; }
    }

    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(20px); }
      to { opacity: 1; transform: translateY(0); }
    }
  </style>
</head>
<body>
  <div class="confirmation-card">
    <svg class="checkmark" viewBox="0 0 52 52">
      <circle cx="26" cy="26" r="25" fill="none" stroke="#4CAF50"/>
      <path fill="none" stroke="#4CAF50" d="M14 27l7 7 16-16"/>
    </svg>
    <h1>Order Confirmed!</h1>
    <p>Your order has been placed successfully. We’ll notify you when it’s out for delivery.</p>
    <a href="#" class="btn track-btn">Track Order</a>
    <a href="restaurantList" class="btn shop-btn">Continue Shopping</a>
  </div>
</body>
</html>
