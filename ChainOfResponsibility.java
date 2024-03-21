public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        Handler handler3 = new ConcreteHandler();

        handler1.setNext(handler2);
        handler2.setNext(handler3);

        // Simulate requests
        handler1.handleRequest(5);  // Output: Request 5 handled by ConcreteHandler
        handler1.handleRequest(15); // Output: No handler found for request 15
    }
}

interface Handler {
    void setNext(Handler next);
    void handleRequest(int request);
}

class ConcreteHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(int request) {
        if (canHandle(request)) {
            System.out.println("Request " + request + " handled by ConcreteHandler");
        } else if (next != null) {
            next.handleRequest(request);
        } else {
            System.out.println("No handler found for request " + request);
        }
    }

    private boolean canHandle(int request) {
        return request >= 0 && request < 10;
    }
}
