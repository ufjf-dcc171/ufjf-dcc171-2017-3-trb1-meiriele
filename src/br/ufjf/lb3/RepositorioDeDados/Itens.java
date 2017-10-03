
package br.ufjf.lb3.RepositorioDeDados;

import javax.swing.JTextField;


public class Itens {
    private String nome;
    private Integer quantidade;
    private Double valor;

    public Itens(String nome, Integer quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Itens(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setQuantidade(JTextField txtQtd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
