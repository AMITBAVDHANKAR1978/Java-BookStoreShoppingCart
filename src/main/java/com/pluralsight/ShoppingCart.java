package com.pluralsight;

import java.io.IOException;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCart {
 @Inject
 private ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
 private double dblOrderTotal ;

 public int getLineItemCount() {
  return cartItems.size();
 }

 public void addCartItem(Book book, int quantity) {
   CartItem cartItem = new CartItem(book, quantity);
   cartItems.add(cartItem);
   calculateOrderTotal();
 }

 public void addCartItem(CartItem cartItem) {
  cartItems.add(cartItem);
 }
 
 protected void deleteCartItem(int index) {
	  try {			
			 cartItems.remove(index);
		 }
		 catch(IndexOutOfBoundsException e)
		 {
			 e.printStackTrace();
		 }	  
} 

 public CartItem getCartItem(int iItemIndex) {
  CartItem cartItem = null;
  if(cartItems.size()>iItemIndex) {
   cartItem = cartItems.get(iItemIndex);
  }
  return cartItem;
 }

 public ArrayList<CartItem> getCartItems() {
  return cartItems;
 }
 public void setCartItems(ArrayList<CartItem> cartItems) {
  this.cartItems = cartItems;
 }
 public double getOrderTotal() {
  return dblOrderTotal;
 }
 public void setOrderTotal(double dblOrderTotal) {
  this.dblOrderTotal = dblOrderTotal;
 }

 protected void calculateOrderTotal() {
  double dblTotal = 0;
  for(int counter=0;counter<cartItems.size();counter++) {
   CartItem cartItem = cartItems.get(counter);
   dblTotal+=cartItem.getTotalCost();

  }
  setOrderTotal(dblTotal);
 }

}
