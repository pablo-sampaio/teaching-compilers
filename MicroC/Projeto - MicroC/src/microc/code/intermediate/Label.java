package microc.code.intermediate;

public class Label extends Instruction {
    private static int lastLabel = 0;

    public final String nome;

    public Label() {
        this.nome = "label" + lastLabel;
        lastLabel ++;
    }

    public String toString() {
        return nome + ":";
    }

}