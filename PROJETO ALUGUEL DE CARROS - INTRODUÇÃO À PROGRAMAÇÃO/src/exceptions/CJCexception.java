package exceptions;

public class CJCexception extends Exception {
    public CJCexception(String nome) {
        super("O Sr(a) " + nome + " j� est� cadastrado!");
    }
}
