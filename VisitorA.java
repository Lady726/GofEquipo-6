// Visitor
interface Visitor {
    void visit(ConcreteElement1 element);
    void visit(ConcreteElement2 element);
}

// Concrete Visitor 1
class ConcreteVisitor1 implements Visitor {
    @Override
    public void visit(ConcreteElement1 element) {
        System.out.println("ConcreteVisitor1 visited ConcreteElement1");
    }

    @Override
    public void visit(ConcreteElement2 element) {
        System.out.println("ConcreteVisitor1 visited ConcreteElement2");
    }
}

// Concrete Visitor 2
class ConcreteVisitor2 implements Visitor {
    @Override
    public void visit(ConcreteElement1 element) {
        System.out.println("ConcreteVisitor2 visited ConcreteElement1");
    }

    @Override
    public void visit(ConcreteElement2 element) {
        System.out.println("ConcreteVisitor2 visited ConcreteElement2");
    }
}

// Element
interface Element {
    void accept(Visitor visitor);
}

// Concrete Element 1
class ConcreteElement1 implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Concrete Element 2
class ConcreteElement2 implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Client
public class VisitorA {
    public static void main(String[] args) {
        Visitor visitor1 = new ConcreteVisitor1();
        Visitor visitor2 = new ConcreteVisitor2();

        Element element1 = new ConcreteElement1();
        Element element2 = new ConcreteElement2();

        element1.accept(visitor1); // Output: ConcreteVisitor1 visited ConcreteElement1
        element1.accept(visitor2); // Output: ConcreteVisitor2 visited ConcreteElement1
        element2.accept(visitor1); // Output: ConcreteVisitor1 visited ConcreteElement2
        element2.accept(visitor2); // Output: ConcreteVisitor2 visited ConcreteElement2
    }
}
