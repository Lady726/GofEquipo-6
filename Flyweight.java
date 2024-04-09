import java.util.HashMap;
import java.util.Map;

class ShapeFactory {
    private static final Map<String, Shape> shapes = new HashMap<>();

    public static Shape getShape(String name) {
        Shape shape = shapes.get(name);

        if (shape == null) {
            switch (name) {
                case "circle":
                    shape = new Circle();
                    break;
                case "rectangle":
                    shape = new Rectangle();
                    break;
                // Add more cases for different shapes as needed
                default:
                    throw new IllegalArgumentException("Unsupported shape type: " + name);
            }
            shapes.put(name, shape);
        }

        return shape;
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle1 = ShapeFactory.getShape("circle");
        circle1.draw();

        Shape circle2 = ShapeFactory.getShape("circle");
        circle2.draw();

        Shape rectangle1 = ShapeFactory.getShape("rectangle");
        rectangle1.draw();

        Shape rectangle2 = ShapeFactory.getShape("rectangle");
        rectangle2.draw();
    }
}
