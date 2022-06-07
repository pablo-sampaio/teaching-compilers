package microc.code.intermediate;


public class EndProc extends Instruction {
    public final String nome;

    public EndProc(String nomeProc) {
        this.nome = nomeProc;
    }

    public String toString() {
        return "ENDP " + this.nome + "\n\n";
    }
}