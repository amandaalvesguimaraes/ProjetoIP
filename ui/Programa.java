package ui;
import java.util.Scanner;
import dados.*;
import sistemaaluguel.*;
import fachada.*;

public class Programa {
	
	public static String Menu() {
		return "\n" + "----- MENU PRINCIPAL -----\n" + "\n" + "[1] PARA CADASTRAR UM AUTOM�VEL\n" + "[2] PARA REMOVER UM AUTOM�VEL\n" + "[3] PARA ATUALIZAR UM AUTOM�VEL\n" + "[4] PARA VERIFICAR SE UM AUTOM�VEL EXISTE\n" + "[5] PARA VERIFICAR SE UM AUTOM�VEL EST� ALUGADO\n" + "[6] PARA PROCURAR AS ESPECIFICA��ES DE UM AUTOM�VEL\n" +
		 "[0] PARA SAIR\n"; 
	}
	
	public static boolean opcaovalida(String a) {
		boolean valido = false;
		for (int i = 0; i < 7 && !valido; i++) {
			if (a.equals(Integer.toString(i))) {
				valido = true;
			}
		}
		return valido;
	}
	
	public static void main(String[] args) throws CCException, QPIException, PDIException, ANException, PNEException, PEException {
		
		Scanner in = new Scanner(System.in);
		String resp, a, b, c, e, lr, pa, resp1; //lr � pra pegar o resto da linha do int //pa � a placa antiga
		int qp = 0;
		int d = 0;
		double pd = 0;
		boolean repetir = true;
		boolean anoinvalido = true;
		boolean portasinvalidas = true;
		boolean diariainvalida = true;
		
		RepositorioCarros repositorio = new RepositorioCarrosLista();
		CadastroCarros cadastrocarro = new CadastroCarros(repositorio); 
		ClasseFachada cf = new ClasseFachada(cadastrocarro);
		
		while (repetir) {
			System.out.println();
			System.out.println("---- SISTEMA DE ALUGUEL DE CARROS ----");
			System.out.println();
			System.out.println(Menu());
			do {
				System.out.print("Digite sua op��o: ");
				resp = in.nextLine();
				if (!opcaovalida(resp))
					System.out.print("Op��o inv�lida! ");
			} while (!opcaovalida(resp));
			switch (resp) {
			
			case "1":	//CADASTRAR UM AUTOM�VEL
				
				System.out.println("Voc� escolheu CADASTRAR UM AUTOM�VEL.");
				System.out.print("Digite o modelo do ve�culo: ");
				a = in.nextLine();
				System.out.print("Digite a cor do ve�culo: ");
				b = in.nextLine();
				System.out.print("Digite a placa do ve�culo: ");
				c = in.nextLine();
				System.out.print("Digite o ano do ve�culo: ");
				while (anoinvalido) {
					if (in.hasNextInt()) {
						d = in.nextInt();
						lr = in.nextLine();
						anoinvalido = false;
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inv�lida. Digite um valor inteiro para o ano: ");
					}
				}
				anoinvalido = true;
				System.out.print("Digite a quantidade de portas: ");
				while (portasinvalidas) {
					if (in.hasNextInt()) {
						qp = in.nextInt();
						lr = in.nextLine();
						portasinvalidas = false;
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inv�lida. Digite um valor inteiro para a quantidade de portas: ");
					}
				}
				portasinvalidas = true;
				System.out.print("Digite o valor do pre�o da di�ria: ");
				while (diariainvalida) {
					if (in.hasNextDouble()) {
						pd = in.nextDouble();
						lr = in.nextLine();
						diariainvalida = false;
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inv�lida. Digite um valor num�rico para o pre�o da di�ria: ");
					}
				}
				diariainvalida = true;
				cadastrocarro.cadastrar(a, b, c, d, qp, pd);
				System.out.print("Se deseja realizar outra opera��o, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "2": 	// REMOVER UM AUTOM�VEL
				
				System.out.println("Voc� escolheu REMOVER UM AUTOM�VEL.");
				System.out.print("Digite a placa do carro que voc� deseja remover: ");
				c = in.nextLine();
				c = c.trim();
				cf.removerCarro(c);
				System.out.println("Carro removido!");
				System.out.print("Se deseja realizar outra opera��o, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "3":	//ATUALIZAR UM AUTOM�VEL
				
				System.out.println("Voc� escolheu ATUALIZAR UM AUTOM�VEL.");
				System.out.print("Digite a placa do carro que voc� deseja atualizar: ");
				pa = in.nextLine();
				pa = pa.trim();
				System.out.println("Reinsira todos os dados do carro");
				System.out.print("Digite o modelo do ve�culo: ");
				a = in.nextLine();
				System.out.print("Digite a cor do ve�culo: ");
				b = in.nextLine();
				System.out.print("Digite a placa do ve�culo: ");
				c = in.nextLine();
				System.out.print("Digite o ano do ve�culo: ");
				while (anoinvalido) {
					if (in.hasNextInt()) {
						d = in.nextInt();
						anoinvalido = false;
						lr = in.nextLine();
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inv�lida. Digite um valor inteiro para o ano: ");
					}
				}
				anoinvalido = true;
				System.out.print("Digite a quantidade de portas: ");
				while (portasinvalidas) {
					if (in.hasNextInt()) {
						qp = in.nextInt();
						portasinvalidas = false;
						lr = in.nextLine();
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inv�lida. Digite um valor inteiro para a quantidade de portas: ");
					}
				}
				portasinvalidas = true;
				System.out.print("Digite o valor do pre�o da di�ria: ");
				while (diariainvalida) {
					if (in.hasNextDouble()) {
						pd = in.nextDouble();
						diariainvalida = false;
						lr = in.nextLine();
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inv�lida. Digite um valor num�rico para o pre�o da di�ria: ");
					}
				}
				diariainvalida = true;
				cf.atualizarCarro(a, b, c, d, qp, pd, pa);
				System.out.print("Se deseja realizar outra opera��o, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "4":	// VERIFICAR SE UM AUTOM�VEL EXISTE
				
				System.out.println("Voc� escolheu VERIFICAR SE UM AUTOM�VEL EXISTE.");
				System.out.print("Digite a placa do autom�vel que voc� deseja verificar: ");
				pa = in.nextLine();
				pa = pa.trim();
				if (cf.existePlaca(pa)) {
					System.out.println("O autom�vel existe.");
				} else {
					System.out.println("O autom�vel n�o existe.");
				}
				System.out.print("Se deseja realizar outra opera��o, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "5":	// VERIFICAR SE UM AUTOM�VEL EST� ALUGADO
				
				System.out.println("Voc� escolheu VERIFICAR SE UM AUTOM�VEL EST� ALUGADO.");
				System.out.print("Digite a placa do autom�vel que voc� deseja verificar: ");
				pa = in.nextLine();
				pa = pa.trim();
				if (cf.isAlugado(pa)) {
					System.out.println("O autom�vel est� alugado.");
				} else {
					System.out.println("O autom�vel n�o est� alugado.");
				}
				System.out.print("Se deseja realizar outra opera��o, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "6":	//PROCURAR UM AUTOM�VEL
				
				System.out.println("Voc� escolheu PROCURAR UM AUTOM�VEL.");
				System.out.print("Digite a placa do autom�vel que voc� deseja procurar especifica��es: ");
				pa = in.nextLine();
				pa = pa.trim();
				Carros car;
				car = cadastrocarro.procurar(pa);
				System.out.println("MODELO: " + car.getModelo());
				System.out.println("COR: " + car.getCor());
				System.out.println("PLACA: " + car.getPlaca());
				System.out.println("QUANTIDADE DE PORTAS: " + car.getQuantidadePortas());
				System.out.println("ANO: " + car.getAno());
				System.out.println("PRE�O DA DI�RIA: " + car.getPrecoDiaria());
				System.out.print("Se deseja realizar outra opera��o, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equalsIgnoreCase("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "0":	//SAIR
				
				System.out.println("Voc� escolheu SAIR");
				repetir = false;
				break;
			}
			
		}
	}
}
