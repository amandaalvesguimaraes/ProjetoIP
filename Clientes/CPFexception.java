package Clientes;

public class CPFexception extends Exception {
    public CPFexception(){
        super("CPF ou CNH irregular.");
    }
}