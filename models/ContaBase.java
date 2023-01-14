package models;

import java.time.LocalDate;

import enums.TipoConta;

public abstract class ContaBase {
    private Long numero;
    private TipoConta tipoConta;
    private double saldo;

    public ContaBase(TipoConta tipoConta){
        this.numero = LocalDate.now().toEpochDay();
        this.tipoConta =  tipoConta;
        this.saldo = 0;
    }

    public Long getNumero(){
        return this.numero;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public TipoConta getTipoConta(){
        return this.tipoConta;
    }
}
