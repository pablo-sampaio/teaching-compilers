package microc.code.intermediate;

//array[indice] := fonte;
public class CopyToArray extends Instruction {
    public final Variavel array;
    public final OperandoTA indice, fonte;

    public CopyToArray(Variavel arrayDest, OperandoTA posicao, OperandoTA fonte) {
        this.array = arrayDest;
        this.indice = posicao;
        this.fonte = fonte;
    }

    public String toString() {
        return (this.array + "[" + this.indice + "]" + " := " + this.fonte);
    }

}