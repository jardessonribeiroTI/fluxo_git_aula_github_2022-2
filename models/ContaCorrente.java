package models;

import enums.TipoConta;

public class ContaCorrente extends ContaBase implements Conta{
    
    public ContaCorrente(){
        super(TipoConta.CORRENTE);
    }

    @Override
    public String informacoesConta() {
       String info = "Conta :"+this.getNumero()+
                    "\nsaldo: "+this.getSaldo();
        
        return info;
    }

    @Override
    public Long getId() {
        return this.getNumero();
    }
}
