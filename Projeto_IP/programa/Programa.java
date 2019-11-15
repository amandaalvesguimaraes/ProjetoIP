package programa;
import dados.*;
import carros.*;
import exceptions.*;
import fachada.*;
import vendedores.*;
import abstrata.*;
import java.util.Scanner;


public class Programa {
	
	public static String Menu() {
		// PRIMEIRO: coloque todas as opçoes da sua classe fachada acessiveis ao usuario aqui. Lembre de colocar o "\n" depois.
		return "\n" + "----- MENU PRINCIPAL -----\n" + "\n"
		+ "[1] PARA CADASTRAR UM AUTOMÓVEL\n" + "[2] PARA REMOVER UM AUTOMÓVEL\n" + 
		"[3] PARA ATUALIZAR UM AUTOMÓVEL\n" + "[4] PARA VERIFICAR SE UM AUTOMÓVEL EXISTE\n" 
		+ "[5] PARA VERIFICAR SE UM AUTOMÓVEL ESTÁ ALUGADO\n" + 
		"[6] PARA PROCURAR AS ESPECIFICAÇÕES DE UM AUTOMÓVEL\n" + "[7] PARA CADASTRAR UM VENDEDOR\n" +
		"[8] PARA DEMITIR UM VENDEDOR\n" + "[9] PARA ATUALIZAR O CADASTRO DE UM VENDEDOR\n" + 
		"[10] PARA VERIFICAR SE UM VENDEDOR ESTÁ CADASTRADO NO SISTEMA\n" + "[11] PARA PROCURAR UM VENDEDOR\n" +
		"[0] PARA SAIR\n"; 
	}
	
	public static boolean opcaovalida(String a) {
		//SEGUNDO: mude o numero x (do i < x && !valido) para o número da sua ultima opção do menu+1
		boolean valido = false;
		for (int i = 0; i < 12 && !valido; i++) {
			if (a.equals(Integer.toString(i))) {
				valido = true;
			}
		}
		return valido;
	}
	
	public static void main(String[] args) throws CCException, QPIException, PDIException, ANException, PNEException, PEException, VCException, MATException, TELException, CPFException, FNEException, MNException {
		
		//TERCEIRO: coloque todas as variáveis que vc for utilizar aqui em cima
		Scanner in = new Scanner(System.in);
		String resp, a, b, c, e, lr, t, pa, resp1; //lr é pra pegar o resto da linha do int //pa é a placa antiga
		int qp = 0;
		int d = 0;
		int g = 0;
		int ga = 0;
		double pd = 0;
		boolean repetir = true;
		boolean anoinvalido = true;
		boolean portasinvalidas = true;
		boolean diariainvalida = true;
		boolean matinvalido = true;
		
		// RepositorioCarros repositorio = new RepositorioCarrosLista();
		// RepositorioVendedor repositorio = new RepositorioVendedorLista();
		//QUARTO: coloque primeiro o "RepositorioSuaClasse repositorioSuaClasse [..] e dps crie o objeto CadastroSuaClasse. Do mesmo jeito que foi feito aí.
		RepositorioCarros repositoriocarro = new RepositorioCarrosArray(100);
		CadastroCarros cadastrocarro = new CadastroCarros(repositoriocarro);
		RepositorioVendedor repositoriovendedor = new RepositorioVendedorArray(100);
		CadastroVendedor cadastrovendedor = new CadastroVendedor(repositoriovendedor);
		ClasseFachada cf = new ClasseFachada(cadastrocarro, cadastrovendedor);
		//QUINTO: adicione como parametro o objeto CadastroSuaClasse. Daí, vai ter que mudar o construtor da classe fachada. (Já tem lá comentado o que é pra fazer).
		
		while (repetir) {
			System.out.println();
			System.out.println("---- SISTEMA DE ALUGUEL DE CARROS ----");
			System.out.println();
			System.out.println(Menu());
			do {
				System.out.print("Digite sua opção: ");
				resp = in.nextLine();
				if (!opcaovalida(resp))
					System.out.print("Opção inválida! ");
			} while (!opcaovalida(resp));
			switch (resp) {
			
			case "1":	//CADASTRAR UM AUTOMÓVEL
				
				System.out.println("Você escolheu CADASTRAR UM AUTOMÓVEL.");
				System.out.print("Digite o modelo do veículo: ");
				a = in.nextLine();
				System.out.print("Digite a cor do veículo: ");
				b = in.nextLine();
				System.out.print("Digite a placa do veículo: ");
				c = in.nextLine();
				System.out.print("Digite o ano do veículo: ");
				while (anoinvalido) {
					if (in.hasNextInt()) {
						d = in.nextInt();
						lr = in.nextLine();
						anoinvalido = false;
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inválida. Digite um valor inteiro para o ano: ");
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
						System.out.print("Entrada inválida. Digite um valor inteiro para a quantidade de portas: ");
					}
				}
				portasinvalidas = true;
				System.out.print("Digite o valor do preço da diária: ");
				while (diariainvalida) {
					if (in.hasNextDouble()) {
						pd = in.nextDouble();
						lr = in.nextLine();
						diariainvalida = false;
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inválida. Digite um valor numérico para o preço da diária: ");
					}
				}
				diariainvalida = true;
				Carros carro1 = new Carros(a, b, c, d, qp, pd);
				cf.cadastrarCarro(carro1);
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "2": 	// REMOVER UM AUTOMÓVEL
				
				System.out.println("Você escolheu REMOVER UM AUTOMÓVEL.");
				System.out.print("Digite a placa do carro que você deseja remover: ");
				c = in.nextLine();
				c = c.trim();
				cf.removerCarro(c);
				System.out.println("Carro removido!");
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "3":	//ATUALIZAR UM AUTOMÓVEL
				
				System.out.println("Você escolheu ATUALIZAR UM AUTOMÓVEL.");
				System.out.print("Digite a placa do carro que você deseja atualizar: ");
				pa = in.nextLine();
				pa = pa.trim();
				System.out.println("Reinsira todos os dados do carro");
				System.out.print("Digite o modelo do veículo: ");
				a = in.nextLine();
				System.out.print("Digite a cor do veículo: ");
				b = in.nextLine();
				System.out.print("Digite a placa do veículo: ");
				c = in.nextLine();
				System.out.print("Digite o ano do veículo: ");
				while (anoinvalido) {
					if (in.hasNextInt()) {
						d = in.nextInt();
						anoinvalido = false;
						lr = in.nextLine();
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inválida. Digite um valor inteiro para o ano: ");
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
						System.out.print("Entrada inválida. Digite um valor inteiro para a quantidade de portas: ");
					}
				}
				portasinvalidas = true;
				System.out.print("Digite o valor do preço da diária: ");
				while (diariainvalida) {
					if (in.hasNextDouble()) {
						pd = in.nextDouble();
						diariainvalida = false;
						lr = in.nextLine();
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inválida. Digite um valor numérico para o preço da diária: ");
					}
				}
				diariainvalida = true;
				Carros carro2 = new Carros(a, b, c, d, qp, pd);
				cf.atualizarCarro(carro2, pa);
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "4":	// VERIFICAR SE UM AUTOMÓVEL EXISTE
				
				System.out.println("Você escolheu VERIFICAR SE UM AUTOMÓVEL EXISTE.");
				System.out.print("Digite a placa do automóvel que você deseja verificar: ");
				pa = in.nextLine();
				pa = pa.trim();
				if (cf.existePlaca(pa)) {
					System.out.println("O automóvel existe.");
				} else {
					System.out.println("O automóvel não existe.");
				}
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "5":	// VERIFICAR SE UM AUTOMÓVEL ESTÁ ALUGADO
				
				System.out.println("Você escolheu VERIFICAR SE UM AUTOMÓVEL ESTÁ ALUGADO.");
				System.out.print("Digite a placa do automóvel que você deseja verificar: ");
				pa = in.nextLine();
				pa = pa.trim();
				if (cf.isAlugado(pa)) {
					System.out.println("O automóvel está alugado.");
				} else {
					System.out.println("O automóvel não está alugado.");
				}
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "6":	//PROCURAR UM AUTOMÓVEL
				
				System.out.println("Você escolheu PROCURAR UM AUTOMÓVEL.");
				System.out.print("Digite a placa do automóvel que você deseja procurar especificações: ");
				pa = in.nextLine();
				pa = pa.trim();
				Carros car;
				car = cadastrocarro.procurar(pa);
				System.out.println("MODELO: " + car.getModelo());
				System.out.println("COR: " + car.getCor());
				System.out.println("PLACA: " + car.getPlaca());
				System.out.println("QUANTIDADE DE PORTAS: " + car.getQuantidadePortas());
				System.out.println("ANO: " + car.getAno());
				System.out.println("PREÇO DA DIÁRIA: " + car.getPrecoDiaria());
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equalsIgnoreCase("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
			
			case "7":
				
				System.out.println("Você escolheu CADASTRAR UM VENDEDOR.");
				System.out.print("Digite o nome do vendedor: ");
				a = in.nextLine();
				a = a.trim();
				System.out.print("Digite o cpf do vendedor: ");
				b = in.nextLine();
				b = b.trim();
				System.out.print("Digite o telefone do vendedor: ");
				c = in.nextLine();
				c = c.trim();
				System.out.print("Digite a matrícula do vendedor: ");
				while (matinvalido) {
					if (in.hasNextInt()) {
						g = in.nextInt();
						lr = in.nextLine();
						matinvalido = false;
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inválida. Digite um valor inteiro para a matrícula: ");
					}
				}
				matinvalido = true;
				Vendedor vendedor = new Vendedor(a, b, c, g);
				cf.cadastrarVendedor(vendedor);
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "8": 
				
				System.out.println("Você escolheu DEMITIR UM VENDEDOR");
				System.out.print("Digite a matrícula do vendedor: ");
				while (matinvalido) {
					if (in.hasNextInt()) {
						g = in.nextInt();
						lr = in.nextLine();
						matinvalido = false;
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inválida. Digite um valor inteiro para a matrícula: ");
					}
				}
				matinvalido = true;
				cf.removerVendedor(g);
				System.out.println("Vendedor removido.");
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "9":
				
				System.out.println("Você escolheu ATUALIZAR O CADASTRO DE UM VENDEDOR");
				System.out.print("Digite o nome do vendedor: ");
				a = in.nextLine();
				a = a.trim();
				System.out.print("Digite o cpf do vendedor: ");
				b = in.nextLine();
				b = b.trim();
				System.out.print("Digite o telefone do vendedor: ");
				c = in.nextLine();
				c = c.trim();
				System.out.print("Digite a matrícula NOVA do vendedor: ");
				while (matinvalido) {
					if (in.hasNextInt()) {
						g = in.nextInt();
						lr = in.nextLine();
						matinvalido = false;
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inválida. Digite um valor inteiro para a matrícula: ");
					}
				}
				matinvalido = true;
				System.out.println("Digite a matrícula ANTIGA do vendedor: ");
				while (matinvalido) {
					if (in.hasNextInt()) {
						ga = in.nextInt();
						lr = in.nextLine();
						matinvalido = false;
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inválida. Digite um valor inteiro para a matrícula: ");
					}
				}
				matinvalido = true;
				Vendedor vendedor1 = new Vendedor(a, b, c, g);
				cf.atualizarVendedor(vendedor1, ga);
				break;
			
			case "10":
				
				System.out.println("Você escolheu VERIFICAR SE UM VENDEDOR ESTÁ CADASTRADO.");
				System.out.print("Digite a matrícula do vendedor: ");
				while (matinvalido) {
					if (in.hasNextInt()) {
						g = in.nextInt();
						lr = in.nextLine();
						matinvalido = false;
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inválida. Digite um valor inteiro para a matrícula: ");
					}
				}
				matinvalido = true;
				if (cf.existeVendedor(g)) {
					System.out.println("O vendedor existe.");
				} else {
					System.out.println("O vendedor não existe.");
				}
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "11":
				
				System.out.println("Você escolheu PROCURAR UM VENDEDOR.");
				System.out.print("Digite a matrícula do vendedor: ");
				while (matinvalido) {
					if (in.hasNextInt()) {
						g = in.nextInt();
						lr = in.nextLine();
						matinvalido = false;
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inválida. Digite um valor inteiro para a matrícula: ");
					}
				}
				matinvalido = true;
				Vendedor ven;
				ven = cf.procurarVendedor(g);
				System.out.println("NOME: " + ven.getNome());
				System.out.println("CPF: " + ven.getCpf());
				System.out.println("TELEFONE: " + ven.getTelefone());
				System.out.println("MATRÍCULA: " + ven.getMatricula());
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equalsIgnoreCase("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			//case "x":
				
				//SIGAM OS MODELOS ANTERIORES PARA FICAR TUDO PADRONIZADO!!
				//SEMPRE COLOQUE ISSO NO FINAL!!!
				//System.out.print("Se deseja realizar outra operação, digite [s]: ");
				//resp1 = in.nextLine();
				//resp1 = resp1.trim();
				//if (resp1.equalsIgnoreCase("s")) {
					//repetir = true;
				//} else {
					//repetir = false;
				//}
				//break;
				
			case "0":	//SAIR
				
				System.out.println("Você escolheu SAIR");
				repetir = false;
				break;
				
			}
			
		}
	}
}

