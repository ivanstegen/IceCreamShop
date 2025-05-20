package com.icecreamshop.model;

import com.icecreamshop.decorator.IceCream;

public class VanillaIceCream implements IceCream {
    private static final double PRICE = 5.0;
    
    @Override
    public String getDescription() {
        return "Ванилов сладолед";
    }
    
    @Override
    public double getPrice() {
        return PRICE;
    }
}
