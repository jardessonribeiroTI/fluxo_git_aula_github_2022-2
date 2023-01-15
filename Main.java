import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import database.ContaDatabase;
import enums.TipoConta;
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
					Menu operationsMenu = new Menu("Menu Operacoes", Arrays.asList("Depositar na conta","Sacar dinheiro","Transferir para outra conta","Mostrar Historico", "Voltar"));
					int opOperations = 0;
					while (opOperations != 5){
						opOperations = operationsMenu.getSelection();
						switch (opOperations) {
						case 1:
							System.out.println("Depositar na conta");
							break;
						case 2:
							Scanner inputSaque= new Scanner(System.in);
							System.out.println("Digite o numero da conta: ");
							Long numeroConta = inputSaque.nextLong();
							Conta conta = contaDatabase.buscarPorId(numeroConta);
							if(conta == null){
								System.out.println("Nenhuma conta encontrada para o id "+ numeroConta);
							}else {
								ContaBase contaBase = (ContaBase) conta;
								System.out.println("Digite o valor a ser sacado: ");
								Double valorSaque = inputSaque.nextDouble();
								if(valorSaque>(contaBase.getSaldo())){
									System.out.println("Voce nao possui saldo suficiente para o saque.");
									if(contaBase.getTipoConta()==TipoConta.CORRENTE){
										ContaCorrente contaCorrente = (ContaCorrente) conta;
										if(contaCorrente.getLimite()>=valorSaque-contaBase.getSaldo()){
											int resposta = 0;
											while(resposta!=2){
												System.out.println("Voce possui o limite de R$"+contaCorrente.getLimite()+" para usar mas terá que pagar juros de 10% caso retire desse valor.");
												System.out.println("Deseja usar seu limite?");
												System.out.println("1-Sim");
												System.out.println("2-Nao");
												resposta = inputSaque.nextInt();
												if(resposta==1){
													Double saldo = contaCorrente.getSaldo();
													Double limite = contaCorrente.getLimite();
													Double jurosLimite = contaCorrente.getJurosLimite();
													contaCorrente.setLimite(limite-(valorSaque-saldo));
													contaCorrente.setDivida((valorSaque-saldo)*jurosLimite);
													System.out.println("Seu saldo atual é de R$"+contaCorrente.getSaldo());
													System.out.println("Seu limite atual é de R$"+contaCorrente.getLimite());
													contaBase.adicionarHistorico("Saque usando Limite de :R$"+saldo+" no saldo e "+(valorSaque-saldo)+" no limite.");
													System.out.println("Saque realizado com sucesso!");
													contaCorrente.setSaldo(0.0);
													break;
												}
												else if(resposta!=2){
													System.out.println("Opcao Invalida.");
												}
											}
										}
										else{
											System.out.println("Voce nao possui limite suficiente para o saque.");
										}
								}
								else{
									contaBase.setSaldo(contaBase.getSaldo()-valorSaque);
									contaBase.adicionarHistorico("Saque de R$"+valorSaque);
									System.out.println("Saque realizado com sucesso.");
								}
							}
						}
							break;
						case 3:
							System.out.println("Transferir para outra conta");
							break;
						case 4:
							Scanner inputOperacoes= new Scanner(System.in);
							System.out.println("Informe o id da conta: ");
							Long nConta = inputOperacoes.nextLong();
							Conta c = contaDatabase.buscarPorId(nConta);
							if(c == null){
								System.out.println("Nenhuma conta encontrada para o id "+ nConta);
							}else {
								System.out.println("-----------------------------");
								System.out.println("Historico da conta: ");
								for (String operacao : ((ContaBase)c).getHistorico()) {
									System.out.println(operacao);	
								}
								System.out.println("-----------------------------");
							}
							break;
						case 5:
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
		Conta conta = new ContaCorrente();
		contaDatabase.salvar(conta);

		System.out.println("Conta corrente salva: "+conta.informacoesConta());
	}
}