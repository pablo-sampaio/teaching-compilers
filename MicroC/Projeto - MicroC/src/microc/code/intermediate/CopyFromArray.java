package microc.code.intermediate;

//destino := array[indice]
public class CopyFromArray extends Instruction {
    public final Variavel destino, array;
    public final OperandoTA indice;

    public CopyFromArray(Variavel dest, Variavel arrayFonte, OperandoTA posicao) {
        this.destino = dest;
        this.array = arrayFonte;
        this.indice = posicao;
    }

    public String toString() {
        return (this.destino + " := " + this.array + "[" + this.indice + "]");
    }

}