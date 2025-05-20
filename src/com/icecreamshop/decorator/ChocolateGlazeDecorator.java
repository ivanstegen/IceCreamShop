package com.icecreamshop.decorator;

public class ChocolateGlazeDecorator extends IceCreamDecorator {
    private static final double PRICE = 1.5;
    
    public ChocolateGlazeDecorator(IceCream decoratedIceCream) {
        super(decoratedIceCream);
    }
    
    @Override
    public String getDescription() {
        return decoratedIceCream.getDescription() + " с шоколадова глазура";
    }
    
    @Override
    public double getPrice() {
        return decoratedIceCream.getPrice() + PRICE;
    }
}