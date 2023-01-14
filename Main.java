import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import database.ContaDatabase;
import menus.Menu;
import menus.MenuConta;
import models.Conta;
import models.ContaBase;
import models.ContaCorrente;
import models.ContaPoupanca;

public class Main {

	public static ContaDatabase contaDatabase =  new ContaDatabase();

	public static void main(String[] args) {
		criarConta();
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
		int op = 0;
		while (op != 4){
			op = mainMenu.getSelection();
			switch (op) {
				case 2:
					Menu clientMenu = new Menu("Menu Cliente", Arrays.asList("Cadastrar Cliente", "Listar Clientes" ,"Voltar"));
					int opClient = 0;
					while (opClient != 3){
						opClient = clientMenu.getSelection();
						switch (opClient) {
						case 1:
							System.out.println("Cadastrar Cliente");
							break;
						case 2:
							System.out.println("Listar Clientes");
							break;
						case 3:
							System.out.println("Voltar");
							break;
						default:
							break;
						}
					}
					break;
				case 1:
					Scanner inputConta = new Scanner(System.in);
					Menu menuConta = new MenuConta();
					int opcao = menuConta.getSelection();
					if(opcao == 1){
						System.out.println("Qual conta deseja cadastrar:");
						System.out.println("1 para conta corrente\n2 para conta poupança");
						int opcaoTipoConta = 0;
						while(opcaoTipoConta == 0){
							opcaoTipoConta = inputConta.nextInt();
							if(opcaoTipoConta == 1){
								Conta conta = new ContaCorrente();
								contaDatabase.salvar(conta);
								System.out.println("Conta Corrente salva com sucesso: "+conta.informacoesConta());

							}else if(opcaoTipoConta == 2){
								Conta conta = new ContaPoupanca();
								contaDatabase.salvar(conta);
								System.out.println("Conta Poupança salva com sucesso: "+conta.informacoesConta());
							}else {
								System.out.println("Opção não permitida");
							}
						}
					}else if(opcao == 2){
						System.out.println("Listar contas");
						List<Conta> contas = contaDatabase.listar();
						for (Conta conta : contas) {
							System.out.println(conta.informacoesConta());
						}
					}else if(opcao == 3){
						System.out.println("Informe o id da conta: ");
						Long numeroConta = inputConta.nextLong();
						Conta conta = contaDatabase.buscarPorId(numeroConta);
						if(conta == null){
							System.out.println("nenhuma conta encontrada para o id "+numeroConta);
						}else {
							System.out.println(conta.informacoesConta());
						}
					}else {
						System.out.println("Opção não válida");
					}
					break;
				case 3:
					System.out.println("Entrou");
					Menu operationsMenu = new Menu("Menu Operacoes", Arrays.asList("Mostrar Historico", "Voltar"));
					int opOperations = 0;
					while (opOperations != 2){
						opOperations = operationsMenu.getSelection();
						switch (opOperations) {
						case 1:
							Scanner inputOperacoes= new Scanner(System.in);
							System.out.println("Informe o id da conta: ");
							Long numeroConta = inputOperacoes.nextLong();
							Conta conta = contaDatabase.buscarPorId(numeroConta);
							if(conta == null){
								System.out.println("Nenhuma conta encontrada para o id "+ numeroConta);
							}else {
								System.out.println("-----------------------------");
								System.out.println("Historico da conta: ");
								for (String operacao : ((ContaBase)conta).getHistorico()) {
									System.out.println(operacao);	
								}
								System.out.println("-----------------------------");
							}
							break;
						case 2:
							System.out.println("Voltar");
							break;
						default:
							break;
						}
					}
					break;
			}
		}
	}

	public static void criarConta(){
		Conta conta = new ContaPoupanca();
		contaDatabase.salvar(conta);

		System.out.println("Conta poupança salva: "+conta.informacoesConta());
	}
}
