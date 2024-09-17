package models;

import java.util.Date;
import java.util.ArrayList;
import enums.TipoConta;

public abstract class ContaBase {
    private Long numero;
    private TipoConta tipoConta;
    private double saldo;
    private ArrayList<String> historico = new ArrayList<String>();

    public ContaBase(TipoConta tipoConta){
        this.numero = new Date().getTime();
        this.tipoConta =  tipoConta;
        this.saldo = 0;
        this.adicionarHistorico("Criacao de Conta");
    }

    public Long getNumero(){
        return this.numero;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(Double saldo){
        this.saldo=saldo;
    }

    public TipoConta getTipoConta(){
        return this.tipoConta;
    }

    public void adicionarHistorico(String historico) {
        this.historico.add(historico);
    }

    public ArrayList<String> getHistorico() {
        return historico;
    }
}