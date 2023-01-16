package models;

import enums.TipoConta;

public class ContaPoupanca extends ContaBase implements Conta {

    public ContaPoupanca(){
        super(TipoConta.POUPANCA);
    }

    @Override
    public String informacoesConta() {
        String info = "Conta :"+this.getNumero()+
                    "\n saldo: "+this.getSaldo();
        
        return info;
    }

    @Override
    public Long getId() {
        return this.getNumero();
    }

    @Override
    public double deposito(double valor){
        setSaldo(this.getSaldo() + valor);

        return this.getSaldo();
    }
}
