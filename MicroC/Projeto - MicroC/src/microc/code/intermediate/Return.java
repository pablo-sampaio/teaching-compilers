package microc.code.intermediate;

public class Return extends Instruction {
    public final OperandoTA valor;

    public Return(OperandoTA valor) {
        this.valor = valor;
    }
    public String toString () {
        return ("return " + this.valor);
    }
}