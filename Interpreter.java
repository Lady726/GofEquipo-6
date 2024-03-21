import java.util.HashMap;
import java.util.Map;

// Contexto
class Context {
    private Map<String, Integer> variables;

    public Context() {
        this.variables = new HashMap<>();
    }

    public void setVariable(String name, int value) {
        variables.put(name, value);
    }

    public int getVariable(String name) {
        return variables.get(name);
    }
}

// Abstract Expression
interface Expression {
    int interpret(Context context);
}

// Terminal Expression
class Number implements Expression {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Context context) {
        return number;
    }
}

// Nonterminal Expression
class Plus implements Expression {
    private Expression left;
    private Expression right;

    public Plus(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}

// Nonterminal Expression
class Minus implements Expression {
    private Expression left;
    private Expression right;

    public Minus(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }
}

// Cliente
public class Interpreter {
    public static void main(String[] args) {
        // Creamos el contexto y establecemos algunas variables
        Context context = new Context();
        context.setVariable("a", 5);
        context.setVariable("b", 10);

        // Creamos las expresiones
        Expression expression = new Plus(new Number(5), new Minus(new Number(10), new Number(2)));

        // Interpretamos la expresión y mostramos el resultado
        int result = expression.interpret(context);
        System.out.println("Resultado: " + result);
    }
}
