package microc.code.intermediate;

public class SetParam extends Instruction {
    public final OperandoTA parametro;
    public final int numParametro;

    public SetParam(OperandoTA param, int numParam) {
        this.parametro = param;
        this.numParametro = numParam;
    }

    public String toString() {
        return ("param " + this.parametro + ", " + this.numParametro);
    }
}