package com.icecreamshop.singleton;

import java.util.HashMap;
import java.util.Map;

import com.icecreamshop.decorator.IceCream;
import com.icecreamshop.factory.IceCreamFactory;


public class IceCreamShop {
    private static IceCreamShop instance;
    private IceCreamFactory factory;
    private int salesCount;
    private Map<String, Integer> salesByType;
    

    private IceCreamShop() {
        this.factory = new IceCreamFactory();
        this.salesCount = 0;
        this.salesByType = new HashMap<>();
    }
    

    public static IceCreamShop getInstance() {
        if (instance == null) {
            instance = new IceCreamShop();
        }
        return instance;
    }

    public IceCream sellIceCream(String type, boolean withGlaze, boolean withSticks) {
        IceCream iceCream = factory.createIceCream(type);
        
        if (withGlaze) {
            iceCream = factory.addChocolateGlaze(iceCream);
        }
        
        if (withSticks) {
            iceCream = factory.addChocolateSticks(iceCream);
        }
        
        salesCount++;
        salesByType.put(type, salesByType.getOrDefault(type, 0) + 1);
        
        return iceCream;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public Map<String, Integer> getAllSalesByType() {
        return salesByType;
    }
}