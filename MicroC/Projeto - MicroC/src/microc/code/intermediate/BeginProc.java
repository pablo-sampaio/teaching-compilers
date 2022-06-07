package microc.code.intermediate;

public class BeginProc extends Instruction {
    public final String nome;

    public BeginProc(String nomeProc) {
        this.nome = nomeProc;
    }

    public String toString() {
        return "PROC " + this.nome;
    }
}