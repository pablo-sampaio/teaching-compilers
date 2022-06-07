package microc.code.intermediate;


public class Goto extends Instruction {
    public final Label label;

    public Goto(Label labelDest) {
        this.label = labelDest;
    }
    public String toString() {
      return ("goto " + this.label);
    }
}
