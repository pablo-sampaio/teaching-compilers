package microc.code.intermediate;


public class VarTemporaria extends Variavel {
    public final int num;

    public VarTemporaria(int num) {
        super("temp_" + num);
        this.num = num;
    }
}