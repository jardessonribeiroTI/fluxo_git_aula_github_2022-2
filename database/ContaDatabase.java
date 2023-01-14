package database;

import java.util.ArrayList;
import java.util.List;

import models.Conta;

public class ContaDatabase {
    public List<Conta> contas;

    public ContaDatabase(){
        this.contas = new ArrayList<>();
    }

    public void salvar(Conta conta){
        this.contas.add(conta);
    }

    public List<Conta> listar(){
        return this.contas;
    }

    public Conta buscarPorId(Long id){
        for (Conta conta : this.contas) {
            if(conta.getId().equals(id)){
                return conta;
            }
        }
        return null;
    }
}
