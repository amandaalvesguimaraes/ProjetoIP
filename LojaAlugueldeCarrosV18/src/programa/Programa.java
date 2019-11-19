package programa;
import dados.*;
import clientes.*;
import carros.*;
import exceptions.*;
import fachada.*;
import vendedores.*;
import abstrata.*;
import alugueis.*;
import java.util.Scanner;


public class Programa {
	
	public static String Menu() {
		
		return "\n" + "----- MENU PRINCIPAL -----\n" + "\n"
		+ "[1] PARA CADASTRAR UM AUTOMÓVEL\n" + "[2] PARA REMOVER UM AUTOMÓVEL\n" + 
		"[3] PARA ATUALIZAR UM AUTOMÓVEL\n" + "[4] PARA VERIFICAR SE UM AUTOMÓVEL EXISTE\n" 
		+ "[5] PARA VERIFICAR SE UM AUTOMÓVEL ESTÁ ALUGADO\n" + 
		"[6] PARA PROCURAR AS ESPECIFICAÇÕES DE UM AUTOMÓVEL\n" + "[7] PARA CADASTRAR UM VENDEDOR\n" +
		"[8] PARA DEMITIR UM VENDEDOR\n" + "[9] PARA ATUALIZAR O CADASTRO DE UM VENDEDOR\n" + 
		"[10] PARA VERIFICAR SE UM VENDEDOR ESTÁ CADASTRADO NO SISTEMA\n" + "[11] PARA PROCURAR UM VENDEDOR\n" +
		"[12] PARA CADASTRAR UM CLIENTE\n" + "[13] PARA REMOVER UM CLIENTE\n" + "[14] PARA ATUALIZAR UM CLIENTE\n" +
		"[15] PARA VERIFICAR SE UM CLIENTE ESTÁ CADASTRADO\n" + "[16] PARA PROCURAR UM CLIENTE\n" + "[17] PARA CADASTRAR UM ALUGUEL\n"+
		"[18] PARA REMOVER UM ALUGUEL\n"+"[19] PARA ATUALIZAR UM ALUGUEL\n" + "[20] PARA PROCURAR UM ALUGUEL A PARTIR DO CPF DE UM CLIENTE\n" +
		"[21] PARA PROCURAR UM ALUGUEL A PARTIR DA PLACA DO CARRO\n"+ "[22] PARA CHECAR SE EXISTE UM CLIENTE ALUGANDO UM AUTOMÓVEL\n" +
		"[23] PARA CHECAR SE EXISTE UM CARRO SENDO ALUGADO\n" + "[0] PARA SAIR\n"; 
	
	}
	
	public static boolean opcaovalida(String a) {

		boolean valido = false;
		for (int i = 0; i < 24 && !valido; i++) {
			if (a.equals(Integer.toString(i))) {
				valido = true;
			}
		}
		return valido;
	}
	
	public static void main(String[] args) throws CCException, QPIException, NPAException, PDIException, ANException, PNEException, PEException, VCException, MATException, TELException, CPFException, FNEException, MNException, CJCexception, IDexception, CNCException, CJAException, CJACException, CNCException, VNCException, DiaIException, ANEException, CNAException {
		
		Scanner in = new Scanner(System.in);
		String resp, a, b, c, e, lr, t, pa, resp1, cnh, data, cpfantigo, cnhantigo; //lr é pra pegar o resto da linha do int //pa é a placa antiga
		int qp = 0;
		int d = 0;
		int g = 0;
		int ga = 0;
		int dias = 0;
		double pd = 0;
		boolean repetir = true;
		boolean anoinvalido = true;
		boolean portasinvalidas = true;
		boolean diariainvalida = true;
		boolean matinvalido = true;
		boolean diasinvalidos = true;
		boolean exception = true;
		
		// RepositorioCarros repositoriocarro = new RepositorioCarrosLista();
		// RepositorioVendedor repositoriovendedor = new RepositorioVendedorLista();
		// RepositorioCliente repositoriocliente = new RepositorioClienteLista();
		// RepositorioAlugados repositorioalugados = new RepositorioAlugadosLista();
		RepositorioCliente repositoriocliente = new RepositorioClientesArray(100);
		CadastroClientes cadastrocliente = new CadastroClientes(repositoriocliente);
		RepositorioCarros repositoriocarro = new RepositorioCarrosArray(100);
		CadastroCarros cadastrocarro = new CadastroCarros(repositoriocarro);
		RepositorioVendedor repositoriovendedor = new RepositorioVendedorArray(100);
		CadastroVendedor cadastrovendedor = new CadastroVendedor(repositoriovendedor);
		RepositorioAlugados repositorioalugados = new RepositorioAlugadosArray(100);
		CadastroAluguel cadastroaluguel = new CadastroAluguel(repositorioalugados, repositoriocliente);
		ClasseFachada cf = new ClasseFachada(cadastrocarro, cadastrovendedor, cadastrocliente, cadastroaluguel);
		
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
			
			case "1":
				
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
				try {
					cf.cadastrarCarro(carro1);
					exception = false;
				} catch (CCException erro) {
					System.out.println(erro.getMessage());
				} catch (QPIException erro) {
					System.out.println(erro.getMessage());
				} catch (PDIException erro) {
					System.out.println(erro.getMessage());
				} catch (ANException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					} else {
						System.out.println("Cadastro realizado com sucesso!");
					}
				}
				exception = true;
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
				try {
					cf.removerCarro(c);
					exception = false;
				} catch (PNEException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					} else {
						System.out.println("Remoção realizada com sucesso!");
					}
				}
				exception = true;
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
				try {
					cf.atualizarCarro(carro2, pa);
					exception = false;
				} catch (CCException erro) {
					System.out.println(erro.getMessage());
				} catch (QPIException erro) {
					System.out.println(erro.getMessage());
				} catch (PDIException erro) {
					System.out.println(erro.getMessage());
				} catch (ANException erro) {
					System.out.println(erro.getMessage());
				} catch (PEException erro) {
					System.out.println(erro.getMessage());
				} catch (PNEException erro) {
					System.out.println(erro.getMessage());
				} catch (NPAException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					} else {
						System.out.println("Atualização realizada com sucesso!");
					}
				}
				exception = true;
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
				try {
					if (cf.isAlugado(pa)) {
						System.out.println("O automóvel está alugado.");
					} else {
						System.out.println("O automóvel não está alugado.");
					}
					exception = false;
				} catch (PNEException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					}
				}
				exception = true;
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
				Carros car = null;
				try {
					car = cf.procurarCarro(pa);
					exception = false;
				} catch (PNEException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					}
				}
				exception = true;
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
				try {
					cf.cadastrarVendedor(vendedor);
					exception = false;
				} catch (VCException erro) {
					System.out.println(erro.getMessage());
				} catch (MATException erro) {
					System.out.println(erro.getMessage());
				} catch (TELException erro) {
					System.out.println(erro.getMessage());
				} catch (CPFException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					} else {
						System.out.println("Cadastro realizado com sucesso!");
					}
				}
				exception = true;
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
				try {
					cf.removerVendedor(g);
					exception = false;
				} catch (FNEException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					} else {
						System.out.println("Remoção realizada com sucesso!");
					}
				}
				exception = true;
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
				System.out.print("Digite a matrícula ANTIGA do vendedor: "); //TIREI O LN!!!!
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
				try {
					cf.atualizarVendedor(vendedor1, ga);
					exception = false;
				} catch (MATException erro) {
					System.out.println(erro.getMessage());
				} catch (MNException erro) {
					System.out.println(erro.getMessage());
				} catch (TELException erro) {
					System.out.println(erro.getMessage());
				} catch (CPFException erro) {
					System.out.println(erro.getMessage());
				} catch (VCException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					} else {
						System.out.println("Atualização realizada com sucesso!");
					}
				}
				exception = true;
				System.out.print("Se deseja realizar outra operação, digite [s]: "); //ADICIONEI ESSA OPÇÃO
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
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
				Vendedor ven = null;
				try {
					ven = cf.procurarVendedor(g);
					exception = false;
				} catch (VCException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					}
				}
				exception = true;
				System.out.println(ven.getNome());
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
				
			case "12":
				
				System.out.println("Você escolheu CADASTRAR UM CLIENTE");
				System.out.print("Digite o nome do cliente: ");
				a = in.nextLine();
				a = a.trim();
				System.out.print("Digite o cpf do cliente: ");
				b = in.nextLine();
				b = b.trim();
				System.out.print("Digite o telefone do cliente: ");
				c = in.nextLine();
				c = c.trim();
				System.out.print("Digite a CNH do cliente: ");
				cnh = in.nextLine();
				cnh = cnh.trim();
				System.out.print("Digite a data de cadastro: ");
				data = in.nextLine();
				data = data.trim();
				Cliente cliente = new Cliente(a, b, c, cnh, data);
				try {
					cf.cadastrarCliente(cliente);
					exception = false;
				} catch (CJCexception erro) {
					System.out.println(erro.getMessage());
				} catch (IDexception erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					} else {
						System.out.println("Cadastro realizado com sucesso!");
					}
				}
				exception = true;
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "13":
				
				System.out.println("Você escolheu REMOVER UM CLIENTE");
				System.out.print("Digite o cpf do cliente: ");
				a = in.nextLine();
				a = a.trim();
				try {
					cf.removerCliente(a);
					exception = false;
				} catch (CNCException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					} else {
						System.out.println("Remoção realizada com sucesso!");
					}
				}
				exception = true;
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "14":
				
				System.out.println("Você escolheu ATUALIZAR O CADASTRO DE UM CLIENTE");
				System.out.print("Digite o nome do cliente: ");
				a = in.nextLine();
				a = a.trim();
				System.out.print("Digite o cpf antigo do cliente: ");
				cpfantigo = in.nextLine();
				cpfantigo = cpfantigo.trim();
				System.out.println("Digite o cpf novo do cliente: ");
				b = in.nextLine();
				b = b.trim();
				System.out.print("Digite o telefone do cliente: ");
				c = in.nextLine();
				c = c.trim();
				System.out.println("Digite a CNH antiga do cliente: ");
				cnhantigo = in.nextLine();
				cnhantigo = cnhantigo.trim();
				System.out.print("Digite a nova CNH do cliente: ");
				cnh = in.nextLine();
				cnh = cnh.trim();
				System.out.print("Digite a data de cadastro: ");
				data = in.nextLine();
				data = data.trim();
				Cliente cliente1 = new Cliente(a, b, c, cnh, data);
				try {
					cf.atualizarCliente(cliente1, cpfantigo, cnhantigo);
					exception = false;
				} catch (CNCException erro) {
					System.out.println(erro.getMessage());
				} catch (IDexception erro) {
					System.out.println(erro.getMessage());
				} catch (CPFException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					} else {
						System.out.println("Atualização realizada com sucesso!");
					}
				}
				exception = true;
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "15":
				
				System.out.println("Você escolheu VERIFICAR SE UM CLIENTE ESTÁ CADASTRADO");
				System.out.print("Digite o cpf do cliente: ");
				a = in.nextLine();
				a = a.trim();
				if (cf.existeCliente(a)) {
					System.out.println("O cliente está cadastrado.");
				} else {
					System.out.println("O cliente não está cadastrado.");
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
				
			case "16":
				
				System.out.println("Você escolheu PROCURAR UM CLIENTE");
				System.out.print("Digite o cpf do cliente: ");
				a = in.nextLine();
				a = a.trim();
				Cliente client = null;
				try {
					client = cf.procurarCliente(a);
					exception = false;
				} catch (CNCException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					} 
				}
				exception = true;
				System.out.println(client.getNome());
				System.out.println("CPF: "+client.getCpf());
				System.out.println("CNH: "+client.getCnh());
				System.out.println("DATA: "+client.getData());
				System.out.println("TELEFONE: "+client.getTelefone());
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
			
			case "17":
				
				System.out.println("Você escolheu CADASTRAR UM ALUGUEL");
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
				Vendedor ven1;
				ven1 = cf.procurarVendedor(g);
				System.out.print("Digite o cpf do cliente: ");
				a = in.nextLine();
				a = a.trim();
				Cliente client1 = cf.procurarCliente(a);
				System.out.print("Digite a placa do carro que o cliente deseja alugar: ");
				pa = in.nextLine();
				pa = pa.trim();
				Carros car1;
				car1 = cf.procurarCarro(pa);
				System.out.print("Digite a quantidade de dias que o cliente vai alugar o carro: ");
				while (diasinvalidos) {
					if (in.hasNextInt()) {
						dias = in.nextInt();
						lr = in.nextLine();
						diasinvalidos = false;
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inválida. Digite um valor inteiro para os dias: ");
					}
				}
				diasinvalidos = true;
				Aluguel aluguel = new Aluguel(ven1, client1, car1, dias);
				try {
					cf.cadastrarAluguel(aluguel);
					exception = false;
				} catch (CJAException erro) {
					System.out.println(erro.getMessage());
				} catch (CJACException erro) {
					System.out.println(erro.getMessage());
				} catch (PNEException erro) {
					System.out.println(erro.getMessage());
				} catch (CNCException erro) {
					System.out.println(erro.getMessage());
				} catch (VNCException erro) {
					System.out.println(erro.getMessage());
				} catch (DiaIException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					} else {
						System.out.println("Cadastro realizado com sucesso!");
					}
				}
				exception = true;
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "18":
				
				System.out.println("Você escolheu REMOVER UM ALUGUEL");
				System.out.print("Digite o CPF do cliente: ");
				a = in.nextLine();
				a = a.trim();
				try {
					cf.removerAluguel(a);
					exception = false;
				} catch (ANEException erro) {
					System.out.println(erro.getMessage());
				} catch (CNAException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					} else {
						System.out.println("Remoção realizada com sucesso!");
					}
				}
				exception = true;
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "19":
				
				System.out.println("Você escolheu ATUALIZAR UM ALUGUEL");
				System.out.print("Digite o CPF cadastrado anteriormente: ");
				cpfantigo = in.nextLine();
				cpfantigo = cpfantigo.trim();
				System.out.println("Digite a placa do carro cadastrada anteriormente: ");
				pa = in.nextLine();
				pa = pa.trim();
				System.out.println("Reinsira os novos dados: ");
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
				Vendedor ven2 = null;
				try {
					ven2 = cf.procurarVendedor(g);
					exception = false;
				} catch (VCException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					}
				}
				exception = true;
				System.out.print("Digite o cpf do cliente: ");
				a = in.nextLine();
				a = a.trim();
				Cliente client2 = null;
				try {
					client2 = cf.procurarCliente(a);
					exception = false;
				} catch (CNCException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					}
				}
				exception = true;
				System.out.print("Digite a placa do carro que o cliente deseja alugar: ");
				b = in.nextLine();
				b = b.trim();
				Carros car2 = null;
				try {
					car2 = cf.procurarCarro(b);
					exception = false;
				} catch (PNEException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					}
				}
				exception = true;
				System.out.print("Digite a quantidade de dias que o cliente vai alugar o carro: ");
				while (diasinvalidos) {
					if (in.hasNextInt()) {
						dias = in.nextInt();
						lr = in.nextLine();
						diasinvalidos = false;
					} else {
						lr = in.nextLine();
						System.out.print("Entrada inválida. Digite um valor inteiro para os dias: ");
					}
				}
				diasinvalidos = true;
				Aluguel aluguel1 = new Aluguel(ven2, client2, car2, dias);
				try {
					cf.atualizarAluguel(aluguel1, pa, cpfantigo);
					exception = false;
				} catch (PNEException erro) {
					System.out.println(erro.getMessage());
				} catch (CNCException erro) {
					System.out.println(erro.getMessage());
				} catch (CJAException erro) {
					System.out.println(erro.getMessage());
				} catch (CJACException erro) {
					System.out.println(erro.getMessage());
				} catch (VNCException erro) {
					System.out.println(erro.getMessage());
				} catch (ANEException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					} else {
						System.out.println("Atualização realizada com sucesso!");
					}
				}
				exception = true;
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "20":
				
				System.out.println("Você escolheu PROCURAR CADASTRO DE ALUGUEL A PARTIR DO CPF DO CLIENTE");
				System.out.print("Digite o CPF do cliente: ");
				a = in.nextLine();
				a = a.trim();
				Aluguel a1 = null;
				try {
					a1 = cf.procurarAluguelCliente(a);
					exception = false;
				} catch (CNCException erro) {
					System.out.println(erro.getMessage());
				} catch (ANEException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					}
				}
				exception = true;
				System.out.println("NOME DO CLIENTE: "+a1.getCliente().getNome());
				System.out.println("CPF: "+a1.getCliente().getCpf());
				System.out.println("MODELO DO CARRO: "+a1.getCarros().getModelo());
				System.out.println("PLACA: "+a1.getCarros().getPlaca());
				System.out.println(a1.getVendedor().getNome());
				System.out.println("MATRÍCULA: "+a1.getVendedor().getMatricula());
				System.out.println("VALOR TOTAL DO ALUGUEL: R$"+a1.getValorTotal());
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
			
			case "21":
				
				System.out.println("Você escolheu PROCURAR CADASTRO DE ALUGUEL A PARTIR DA PLACA DO CARRO");
				System.out.print("Digite a placa do carro: ");
				a = in.nextLine();
				a = a.trim();
				Aluguel a2 = null;
				try {
					a2 = cf.procurarAluguelCarro(a);
					exception = false;
				} catch (PNEException erro) {
					System.out.println(erro.getMessage());
				} catch (CNAException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					}
				}
				exception = true;
				System.out.println("NOME DO CLIENTE: "+a2.getCliente().getNome());
				System.out.println("CPF: "+a2.getCliente().getCpf());
				System.out.println("MODELO DO CARRO: "+a2.getCarros().getModelo());
				System.out.println("PLACA: "+a2.getCarros().getPlaca());
				System.out.println(a2.getVendedor().getNome());
				System.out.println("MATRÍCULA: "+a2.getVendedor().getMatricula());
				System.out.println("VALOR TOTAL DO ALUGUEL: R$"+a2.getValorTotal());
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "22":
				
				System.out.println("Você escolheu CHECAR SE UM CLIENTE ESTÁ ALUGANDO UM CARRO");
				System.out.print("Digite o cpf do cliente: ");
				a = in.nextLine();
				a = a.trim();
				try {
					if (cf.existeClienteAlugando(a)) {
						System.out.println("O cliente está alugando um carro.");
					} else {
						System.out.println("O cliente não está alugando um carro.");
					}
					exception = false;
				} catch (CNCException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					}
				}
				exception = true;
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "23":
				
				System.out.println("Você escolheu CHECAR SE UM CARRO ESTÁ SENDO ALUGADO");
				System.out.println("Digite a placa do carro: ");
				a = in.nextLine();
				a = a.trim();
				try {
					if (cf.existeCarroAlugado(a)) {
						System.out.println("O carro está sendo alugado no momento.");
					} else {
						System.out.println("O carro não está sendo alugado no momento.");
					}
					exception = false;
				} catch (PNEException erro) {
					System.out.println(erro.getMessage());
				} finally {
					if (exception) {
						System.out.println("Tente novamente!");
					}
				}
				exception = true;
				System.out.print("Se deseja realizar outra operação, digite [s]: ");
				resp1 = in.nextLine();
				resp1 = resp1.trim();
				if (resp1.equals("s")) {
					repetir = true;
				} else {
					repetir = false;
				}
				break;
				
			case "0":
				
				repetir = false;
				break;
				
			}
		}
		System.out.println("Você escolheu SAIR");
	}
}

