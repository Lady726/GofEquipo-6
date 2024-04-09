import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class MessagePublisher {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

class MessageSubscriber implements Observer {
    private String name;

    public MessageSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        MessagePublisher publisher = new MessagePublisher();

        Observer subscriber1 = new MessageSubscriber("Subscriber 1");
        Observer subscriber2 = new MessageSubscriber("Subscriber 2");

        publisher.attach(subscriber1);
        publisher.attach(subscriber2);

        publisher.notifyObservers("New message!");
    }
}
