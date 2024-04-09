public class Command {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        CommandPattern command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);

        invoker.executeCommand();
    }
}


interface CommandPattern {
    void execute();
}


class ConcreteCommand implements CommandPattern {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

class Receiver {
    public void action() {
        System.out.println("Receiver: Ejecutando acción");
    }
}

class Invoker {
    private CommandPattern command;

    public Invoker(CommandPattern command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
