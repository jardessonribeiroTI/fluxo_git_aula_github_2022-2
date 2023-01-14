import java.util.Arrays;

import database.ContaDatabase;
import menus.Menu;
import models.Conta;
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
			}
		}
	}

	public static void criarConta(){
		Conta conta = new ContaPoupanca();
		contaDatabase.salvar(conta);

		System.out.println("Conta poupança salva: "+conta.informacoesConta());
	}
}
