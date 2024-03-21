abstract class AbstractClass {
    // Template method
    public final void templateMethod() {
        commonMethod();
        abstractMethod();
        concreteMethod();
    }

    // Common method shared by subclasses
    private void commonMethod() {
        System.out.println("Executing commonMethod");
    }

    // Abstract method to be implemented by subclasses
    protected abstract void abstractMethod();

    // Concrete method with default implementation
    private void concreteMethod() {
        System.out.println("Executing concreteMethod");
    }
}

class ConcreteClass extends AbstractClass {
    @Override
    protected void abstractMethod() {
        System.out.println("Executing overridden abstractMethod in ConcreteClass");
    }
}

public class TemplateMethodD {
    public static void main(String[] args) {
        AbstractClass abstractObject = new ConcreteClass();
        abstractObject.templateMethod();
    }
}

