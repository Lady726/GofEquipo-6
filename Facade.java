public class Facade {
    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade();
        computerFacade.startComputer();
    }
}

class CPU {
    public void start() {
        System.out.println("CPU: Iniciando...");
    }

    public void execute() {
        System.out.println("CPU: Ejecutando...");
    }
}

class Memory {
    public void load() {
        System.out.println("Memoria: Cargando...");
    }
}

class HardDrive {
    public void readData() {
        System.out.println("Disco duro: Leyendo datos...");
    }
}

class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.start();
        memory.load();
        hardDrive.readData();
        cpu.execute();
    }
}
