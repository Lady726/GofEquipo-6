import java.util.ArrayList;
import java.util.List;

interface Component {
    void showPrice();
}

class Leaf implements Component {
    private String name;
    private int price;

    public Leaf(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showPrice() {
        System.out.println(name + ": $" + price);
    }
}

class Composite implements Component {
    private String name;
    private List<Component> components = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void showPrice() {
        System.out.println(name);
        for (Component component : components) {
            component.showPrice();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Leaf hardDisk = new Leaf("Hard Disk", 200);
        Leaf ram = new Leaf("RAM", 100);

        Composite peripherals = new Composite("Peripherals");
        peripherals.addComponent(hardDisk);
        peripherals.addComponent(ram);

        Leaf mouse = new Leaf("Mouse", 20);
        Leaf keyboard = new Leaf("Keyboard", 40);

        Composite computer = new Composite("Computer");
        computer.addComponent(peripherals);
        computer.addComponent(mouse);
        computer.addComponent(keyboard);

        computer.showPrice();
    }
}
