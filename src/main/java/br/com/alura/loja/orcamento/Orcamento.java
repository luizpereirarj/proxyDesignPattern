package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Orcamento implements  Orcavel{

    private BigDecimal valor;
    private SituacaoOrcamento situacao;
    private List<Orcavel> itens;

    public Orcamento() {
        this.valor = BigDecimal.ZERO;
        this.itens=new ArrayList<>();
        this.situacao= new EmAnalise();
    }

    public void aplicarDescontoExtra(){
        BigDecimal valorDescontoExtra=this.situacao.calcularValorExra(this);
        this.valor=this.valor.subtract(valorDescontoExtra);
    }

    public void aprovar(){
        this.situacao.aprovar(this);
    }

    public void reprovar(){
        this.situacao.reprovar(this);
    }

    public void finalizar(){
        this.situacao.finalizado(this);
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setSituacao(SituacaoOrcamento situacao){
        this.situacao=situacao;
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    public boolean isFinalizado(){
        return situacao instanceof Finalizado;
    }

    public void adicionarItem(Orcavel item){
        this.valor = valor.add(item.getValor());
        this.itens.add(item);
    }
}
