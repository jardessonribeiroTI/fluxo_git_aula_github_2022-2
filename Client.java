public class Client {
    String name;
    Integer age;
    Integer cpf;
    String email;

    public Client(String name, Integer age, Integer cpf, String email) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.email = email;
    }

    public String toString() {
        return "Client [name=" + name + ", age=" + age + ", cpf=" + cpf + ", email=" + email + "]";
    }
}
