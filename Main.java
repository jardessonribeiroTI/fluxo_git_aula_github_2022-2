import java.util.Arrays;

import database.ContaDatabase;
import menus.Menu;
import models.Conta;
import models.ContaPoupanca;

public class Main {

	public static ContaDatabase contaDatabase =  new ContaDatabase();


	public static void main(String[] args) {
		criarConta();
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
		System.out.println(mainMenu.getSelection() + "foi selecionada");
		System.out.println("Fim");
	}

	public static void criarConta(){
		Conta conta = new ContaPoupanca();
		contaDatabase.salvar(conta);

		System.out.println("Conta poupança salva: "+conta.informacoesConta());
	}

}