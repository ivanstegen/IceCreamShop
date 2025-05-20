package com.icecreamshop.model;

import com.icecreamshop.decorator.IceCream;

public class ChocolateIceCream implements IceCream {
    private static final double PRICE = 5.5;
    
    @Override
    public String getDescription() {
        return "Шоколадов сладолед";
    }
    
    @Override
    public double getPrice() {
        return PRICE;
    }
}