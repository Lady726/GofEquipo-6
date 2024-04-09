public class Mediator {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);

        mediator.setColleagueA(colleagueA);
        mediator.setColleagueB(colleagueB);

        colleagueA.send("Hello from Colleague A");
        colleagueB.send("Hi from Colleague B");
    }
}

interface MediatorPattern {
    void sendMessage(String message, Colleague colleague);
}

// Interfaz Colleague
abstract class Colleague {
    protected MediatorPattern mediator;

    public Colleague(MediatorPattern mediator) {
        this.mediator = mediator;
    }

    public abstract void receive(String message);

    public abstract void send(String message);
}


class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(MediatorPattern mediator) {
        super(mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("Colleague A received: " + message);
    }

    @Override
    public void send(String message) {
        mediator.sendMessage(message, this);
    }
}

class ConcreteColleagueB extends Colleague {
    public ConcreteColleagueB(MediatorPattern mediator) {
        super(mediator);
    }

    @Override
    public void receive(String message) {
        System.out.println("Colleague B received: " + message);
    }

    @Override
    public void send(String message) {
        mediator.sendMessage(message, this);
    }
}

class ConcreteMediator implements MediatorPattern {
    private ConcreteColleagueA colleagueA;
    private ConcreteColleagueB colleagueB;

    public void setColleagueA(ConcreteColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    public void setColleagueB(ConcreteColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        if (colleague == colleagueA) {
            colleagueB.receive(message);
        } else if (colleague == colleagueB) {
            colleagueA.receive(message);
        }
    }
}
