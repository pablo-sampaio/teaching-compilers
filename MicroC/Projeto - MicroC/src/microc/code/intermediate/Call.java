package microc.code.intermediate;


public class Call extends Instruction {
    public final String nome;
    public final int numParam;

    public Call(String metName, int param) {
        this.nome = metName;
        this.numParam = param;
    }

    public String toString() {
        return "call " + nome + ", " + this.numParam;
    }
}