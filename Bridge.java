interface Color {
    void applyColor();
}

abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void applyColor();
}

class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying red color");
    }
}

class BlueColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying blue color");
    }
}

class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    void applyColor() {
        System.out.print("Circle filled with color ");
        color.applyColor();
    }
}

class Rectangle extends Shape {
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    void applyColor() {
        System.out.print("Rectangle filled with color ");
        color.applyColor();
    }
}

public class Main {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedColor());
        redCircle.applyColor();

        Shape blueRectangle = new Rectangle(new BlueColor());
        blueRectangle.applyColor();
    }
}
