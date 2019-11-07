package projetoip;

//placa já existe, ou seja, não vai dar pra atualizar o carro com uma placa diferente se essa nova placa já existe em outro carro.
public class PEException extends Exception {
	public PEException() {
		super ("Não foi possível atualizar a ");
	}

}
