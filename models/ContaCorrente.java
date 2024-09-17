package models;

import enums.TipoConta;

public class ContaCorrente extends ContaBase implements Conta{
    private double limite = 500;
    private double jurosLimite = 0.1;
    private double divida = 0;
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
    public double getLimite() {
        return this.limite;
    }

    public double getJurosLimite() {
        return this.jurosLimite;
    }

    public double getDivida() {
        return this.divida;
    }

    public void setLimite(Double limite){
        this.limite=limite;
    }

    public void setDivida(Double divida){
        this.divida=divida;
    }
}
