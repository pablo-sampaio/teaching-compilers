package microc.code.intermediate;

//if (operando1 operador operando2) goto labelDest
public class IfGoto extends Instruction {
    public final Label label;
    public final OperandoTA operando1, operando2;
    public final int op;

    public IfGoto(OperandoTA operando1, int operador, OperandoTA operando2, Label labelDest) {
        this.operando1 = operando1;
        this.op = operador;
        this.operando2 = operando2;
        this.label = labelDest;
    }
    public String toString () {
        return ("if " + this.operando1 + " " + ProgramaTA.converterOperador(this.op) + " " + this.operando2 + " goto " + this.label);
    }
}