public class Adapter {
    public static void main(String[] args) {
        Target adapter = new AdapterPattern();
        adapter.request();
    }
}

// Interfaz Target
interface Target {
    void request();
}

// Clase Adaptee (a ser adaptada)
class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee: Método específico de solicitud");
    }
}

// Adaptador que adapta Adaptee a Target
class AdapterPattern implements Target {
    private Adaptee adaptee;

    public AdapterPattern() {
        this.adaptee = new Adaptee();
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
