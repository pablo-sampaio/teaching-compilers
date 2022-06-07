package microc.code.intermediate;


public class Constante extends OperandoTA{
    public Object valor;

    public Constante(int num) {
        this.valor = new Integer(num);
    }

    public Constante(char c) {
        this.valor = new Character(c);
    }

    public Constante(boolean c) {
        this.valor = new Boolean(c);
    }

    public Object getValor() {
        return this.valor;
    }

    public String toString() {
        String resultado;
        if (valor instanceof Character) {
            resultado = "\"" + this.valor + "\"";
        } else {
            resultado = this.valor.toString().toUpperCase();
        }

        return resultado;
    }

}