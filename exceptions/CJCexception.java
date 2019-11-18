package Clientes;

public class CJCexception extends Exception {

    public CJCexception(String nome) {
        super("O Sr(a) " + nome + " já está cadastrado!");
    }
}
