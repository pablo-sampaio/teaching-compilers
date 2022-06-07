package microc.code.intermediate;

//destino := operando1 <op> operando2
public class OpAssignment extends Instruction {
    public final Variavel destino;
    public final OperandoTA operando1, operando2;
    public final int op;

    public OpAssignment(Variavel destino, OperandoTA temp1, int operador, OperandoTA temp2) {
        this.destino = destino;
        this.operando1 = temp1;
        this.operando2 = temp2;
        this.op = operador;
    }

    public String toString () {
        return (this.destino + " := " + this.operando1 + " "+ ProgramaTA.converterOperador(this.op) + " " + this.operando2);
    }
}