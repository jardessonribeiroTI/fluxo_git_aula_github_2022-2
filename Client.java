import java.util.Scanner;

public class Client {
    private String name;
    private Integer age;
    private Integer cpf;
    private String email;

    public Client(String name, Integer age, Integer cpf, String email) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Client [name=" + name + ", age=" + age + ", cpf=" + cpf + ", email=" + email + "]";
    }

    public static Client registerClient() {
        System.out.println("Digite o nome do cliente: ");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        System.out.println("Digite a idade do cliente(Apenas numeros): ");
        Integer age = Integer.parseInt(s.nextLine());
        System.out.println("Digite o CPF do cliente(Apenas numeros): ");
        Integer cpf = Integer.parseInt(s.nextLine());
        System.out.println("Digite o email do cliente: ");
        String email = s.nextLine();
        Client client = new Client(name, age, cpf, email);
        return client;
    }    
}
