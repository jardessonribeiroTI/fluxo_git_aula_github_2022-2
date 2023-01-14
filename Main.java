import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
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
}