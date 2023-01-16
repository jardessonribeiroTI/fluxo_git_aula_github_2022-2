package models;

public interface Conta {
    String informacoesConta();
    Long getId();
    double deposito(double valor);
}
