// Interfaces
interface AbstractProductA {
    void operationA();
}

interface AbstractProductB {
    void operationB();
}

interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}

// Concrete Products
class ConcreteProductA1 implements AbstractProductA {
    @Override
    public void operationA() {
        System.out.println("Operation A in Product A1");
    }
}

class ConcreteProductB1 implements AbstractProductB {
    @Override
    public void operationB() {
        System.out.println("Operation B in Product B1");
    }
}

// Concrete Factory
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}

// Client
public class AbstractFactor {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory1();
        AbstractProductA productA = factory.createProductA();
        AbstractProductB productB = factory.createProductB();

        productA.operationA();
        productB.operationB();
    }
}
