package microc.code.intermediate;

//destino := fonte
public class Copy extends Instruction {
    public final Variavel destino;
    public final OperandoTA fonte;

    public Copy(Variavel varDestino, OperandoTA varFonte) {
        this.fonte = varFonte;
        this.destino = varDestino;
    }

    public String toString() {
        return (this.destino + " := " + this.fonte);
    }
}