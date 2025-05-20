package com.icecreamshop.decorator;

public class ChocolateSticksDecorator extends IceCreamDecorator {
    private static final double PRICE = 2.0;
    
    public ChocolateSticksDecorator(IceCream decoratedIceCream) {
        super(decoratedIceCream);
    }
    
    @Override
    public String getDescription() {
        return decoratedIceCream.getDescription() + " с шоколадови пръчици";
    }
    
    @Override
    public double getPrice() {
        return decoratedIceCream.getPrice() + PRICE;
    }
}