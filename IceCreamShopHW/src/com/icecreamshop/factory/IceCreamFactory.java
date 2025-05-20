package com.icecreamshop.factory;

import java.util.Arrays;
import java.util.List;

import com.icecreamshop.decorator.ChocolateGlazeDecorator;
import com.icecreamshop.decorator.ChocolateSticksDecorator;
import com.icecreamshop.decorator.IceCream;
import com.icecreamshop.model.ChocolateIceCream;
import com.icecreamshop.model.StrawberryIceCream;
import com.icecreamshop.model.VanillaIceCream;

public class IceCreamFactory {
    private static final List<String> AVAILABLE_TYPES = Arrays.asList("ванилов", "шоколадов", "ягодов");
    
    public IceCream createIceCream(String type) {
        return switch (type.toLowerCase()) {
            case "ванилов" -> new VanillaIceCream();
            case "шоколадов" -> new ChocolateIceCream();
            case "ягодов" -> new StrawberryIceCream();
            default -> throw new IllegalArgumentException("Невалиден тип сладолед: " + type);
        };
    }
    
    public List<String> getAvailableTypes() {
        return AVAILABLE_TYPES;
    }
    
    public IceCream addChocolateGlaze(IceCream iceCream) {
        return new ChocolateGlazeDecorator(iceCream);
    }
    
    public IceCream addChocolateSticks(IceCream iceCream) {
        return new ChocolateSticksDecorator(iceCream);
    }
}