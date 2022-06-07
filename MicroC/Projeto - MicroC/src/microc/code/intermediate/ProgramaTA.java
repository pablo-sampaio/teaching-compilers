package microc.code.intermediate;

import java.util.Vector;
import java.util.HashMap;


public class ProgramaTA {
    private static int lastPlace = 0;
    public static final String MAIN = "_MAIN_";
    public static final BeginProc START = new BeginProc(MAIN);
    public static final EndProc END = new EndProc(MAIN);
    private Vector tempsLivres  = new Vector();
    private Vector instrucoes;
    private HashMap tabela;

    public ProgramaTA() {
        this.instrucoes = new Vector();
        this.tabela = new HashMap();
    }

    public void addCode(Instruction instr) {
        this.instrucoes.add(instr);
    }

    public VarTemporaria nextPlace() {
        VarTemporaria retorno;

        if (this.tempsLivres.size() > 0){
            retorno = (VarTemporaria)this.tempsLivres.remove(0);
        }else{
           lastPlace++;
           retorno = new VarTemporaria(lastPlace);
        }

        return retorno;
    }

    public int maxPlace() {
        return this.lastPlace;
    }

    public void zeraPlace(){
        lastPlace = 0;
        this.tempsLivres.removeAllElements();
    }

    public void liberaTemp(Variavel temp){
        if (temp instanceof VarTemporaria){
            this.tempsLivres.add(temp);
        }
    }

    public static String converterOperador(int op){
        String resultado;

        switch(op){
            case 11: resultado = ">=";
                     break;
            case 15: resultado = "NOT";
                     break;
            case 13: resultado = "AND";
                     break;
            case 7: resultado = "==";
                     break;
            case 14: resultado = "OR";
                     break;
            case 2: resultado = "+";
                     break;
            case 3: resultado = "/";
                     break;
            case 9: resultado = ">";
                     break;
            case 12: resultado = "!=";
                     break;
            case 4: resultado = "-";
                     break;
            case 8: resultado = "<";
                     break;
            case 6: resultado = "MOD";
                     break;
            case 10: resultado = "<=";
                     break;
            case 5: resultado = "*";
                     break;
            default: resultado = "?NOP?" + op;
        }

         return resultado;
    }

    public String toString () {
        String retorno = "";
        char espaco = ' ';

        for (int i=0, prof = 0; i < this.instrucoes.size(); i++) {
            if (this.instrucoes.get(i) instanceof EndProc) {
                prof --;
            }

            for (int j=0; j < 2*prof; j++)
                retorno += espaco;

            retorno += this.instrucoes.get(i).toString() + "\n";

            if (this.instrucoes.get(i) instanceof BeginProc) {
                prof ++;
            }
        }

        return retorno;
    }

    public Vector getInstrucoes(){
        return this.instrucoes;
    }

    public void inserirNumTemps(String ident, int num) {
        this.tabela.put(ident, new Integer(num));
    }

    public int getNumTemps(String ident) {
        return ((Integer)this.tabela.get(ident)).intValue();
    }
}