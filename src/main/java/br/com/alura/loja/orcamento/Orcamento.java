package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;

public class Orcamento {

    private BigDecimal valor;
    private int quantidadeItens;
    private SituacaoOrcamento situacao;

    public Orcamento(BigDecimal valor, int quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
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
        return quantidadeItens;
    }

    public boolean isFinalizado(){
        return situacao instanceof Finalizado;
    }
}
