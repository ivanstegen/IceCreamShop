package com.icecreamshop.model;

import com.icecreamshop.decorator.IceCream;

public class StrawberryIceCream implements IceCream {
    private static final double PRICE = 6.0;
    
    @Override
    public String getDescription() {
        return "Ягодов сладолед";
    }
    
    @Override
    public double getPrice() {
        return PRICE;
    }
}