package com.icecreamshop.decorator;

public abstract class IceCreamDecorator implements IceCream {
    protected IceCream decoratedIceCream;
    
    public IceCreamDecorator(IceCream decoratedIceCream) {
        this.decoratedIceCream = decoratedIceCream;
    }
    
    @Override
    public String getDescription() {
        return decoratedIceCream.getDescription();
    }
    
    @Override
    public double getPrice() {
        return decoratedIceCream.getPrice();
    }
}