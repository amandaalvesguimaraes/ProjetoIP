package exceptions;

public class CJCexception extends Exception {
    public CJCexception(String nome) {
        super("O Sr(a) " + nome + " ja esta cadastrado!");
    }
}
