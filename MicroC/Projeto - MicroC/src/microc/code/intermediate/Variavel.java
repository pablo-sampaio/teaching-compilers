package microc.code.intermediate;


public class Variavel extends OperandoTA{
    public static final Variavel returnValue = new Variavel("return_value");
    public final String nome;

    public Variavel(String variavel) {
        this.nome = variavel;
    }

    public String toString() {
        return nome;
    }

    public int hashCode() {
        return nome.hashCode();
    }
}