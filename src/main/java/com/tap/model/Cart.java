package com.tap.model;

import java.util.HashMap;
import java.util.Map;
import com.tap.model.Menu;

public class Cart {
	
	
	private Map<Integer,CartItem> Items;
	
	public Cart() {
		this.Items=new HashMap<>();
	}
	
	public Map<Integer, CartItem> getItems() {
	    return Items;
	}
	
	public void addItemToCart(CartItem cart){
		int itemid=cart.getMenu_id();
		if(Items.containsKey(itemid)) {
			CartItem CartItem = Items.get(itemid);
			
			int newQuentity = cart.getQuantity();
			int oldQuentity = CartItem.getQuantity();
			
			int sumquantity= newQuentity + oldQuentity;
			CartItem.setQuantity(sumquantity);
		}
		else {
			Items.put(itemid, cart);
		}
		System.out.println(cart);
		System.out.println("menu  add to cartMethod" + itemid);
		
	}
	
	
	
	public void updateCarrItem(int Menu_id,int Quentity) {
		
		
		if(Items.containsKey(Menu_id)) {
			if(Quentity <=0) {
				Items.remove(Menu_id);
			}
			else {
				Items.get(Menu_id).setQuantity(Quentity);
			}
			
		}
		System.out.println("hii update " +Quentity);
		System.out.println("Trying to update item with ID: " + Menu_id);
//		System.out.println("Cart contains keys: " + menu.getItems().keySet());

	}
	
	
	public void deleteCartItem(int Menu_id) {
		Items.remove(Menu_id);
		
	}
	
	public double getTotalPrice() {
		
		return Items.values().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
	}
	
	public void clear() {
		Items.clear();
	}
	
}
