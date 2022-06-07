package microc.code.intermediate;

//destino := <op> operando
public class UnaryOpAssignment extends Instruction {
    public final Variavel destino;
    public final OperandoTA operando;
    public final int op;

    public UnaryOpAssignment(Variavel varDestino, int operador, OperandoTA fonte) {
        this.destino = varDestino;
        this.op = operador;
        this.operando = fonte;
    }

    public String toString() {
        return(this.destino + " := " + ProgramaTA.converterOperador(this.op) + " " + this.operando);
    }

}