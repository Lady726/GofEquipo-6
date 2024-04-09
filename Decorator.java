public class Decorator {
    public static void main(String[] args) {
        Pizza pizza = new BasicPizza();
        pizza = new CheeseDecorator(pizza);
        pizza = new PepperoniDecorator(pizza);

        System.out.println("Descripción: " + pizza.getDescription());
        System.out.println("Costo: $" + pizza.cost());
    }
}

interface Pizza {
    String getDescription();
    double cost();
}


class BasicPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Pizza básica";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}


abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double cost() {
        return pizza.cost();
    }
}


class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", con queso";
    }

    @Override
    public double cost() {
        return pizza.cost() + 1.0;
    }
}


class PepperoniDecorator extends PizzaDecorator {
    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", con pepperoni";
    }

    @Override
    public double cost() {
        return pizza.cost() + 2.0;
    }
}
