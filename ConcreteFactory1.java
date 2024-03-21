// Abstract Factory
interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

// Concrete Factory 1
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}

// Concrete Factory 2
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB2();
    }
}

// Product A
interface ProductA {
    void operationA();
}

// Concrete Product A1
class ConcreteProductA1 implements ProductA {
    @Override
    public void operationA() {
        System.out.println("Operation A from Product A1");
    }
}

// Concrete Product A2
class ConcreteProductA2 implements ProductA {
    @Override
    public void operationA() {
        System.out.println("Operation A from Product A2");
    }
}

// Product B
interface ProductB {
    void operationB();
}

// Concrete Product B1
class ConcreteProductB1 implements ProductB {
    @Override
    public void operationB() {
        System.out.println("Operation B from Product B1");
    }
}

// Concrete Product B2
class ConcreteProductB2 implements ProductB {
    @Override
    public void operationB() {
        System.out.println("Operation B from Product B2");
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        AbstractFactory factory2 = new ConcreteFactory2();

        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();

        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();

        productA1.operationA(); // Output: Operation A from Product A1
        productB1.operationB(); // Output: Operation B from Product B1
        productA2.operationA(); // Output: Operation A from Product A2
        productB2.operationB(); // Output: Operation B from Product B2
    }
}
