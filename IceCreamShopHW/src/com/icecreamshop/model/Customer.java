package com.icecreamshop.model;

import com.icecreamshop.decorator.IceCream;
import com.icecreamshop.singleton.IceCreamShop;

public class Customer {
    private String name;
    private String favoriteIceCream;
    
    public Customer(String name, String favoriteIceCream) {
        this.name = name;
        this.favoriteIceCream = favoriteIceCream;
    }
    
    public IceCream buyIceCream(boolean withGlaze, boolean withSticks) {
        IceCreamShop shop = IceCreamShop.getInstance();
        System.out.println(name + " влиза в магазина и си поръчва " + favoriteIceCream + " сладолед.");
        return shop.sellIceCream(favoriteIceCream, withGlaze, withSticks);
    }
    
    public String getName() {
        return name;
    }
    
    public String getFavoriteIceCream() {
        return favoriteIceCream;
    }
}
