import java.util.HashMap;
import java.util.Map;

class Shape implements Cloneable {
    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
        return (Shape) super.clone();
    }
}

class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }
}

class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }
}

class PrototypePatternExample {
    private static Map<String, Shape> shapeMap = new HashMap<>();

    static {
        shapeMap.put("Circle", new Circle());
        shapeMap.put("Rectangle", new Rectangle());
    }

    public static Shape getShape(String type) throws CloneNotSupportedException {
        return shapeMap.get(type).clone();
    }
}

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Shape circle = PrototypePatternExample.getShape("Circle");
        System.out.println(circle.getType());

        Shape rectangle = PrototypePatternExample.getShape("Rectangle");
        System.out.println(rectangle.getType());
    }
}
