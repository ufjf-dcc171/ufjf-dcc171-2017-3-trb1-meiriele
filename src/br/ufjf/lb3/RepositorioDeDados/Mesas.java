
package br.ufjf.lb3.RepositorioDeDados;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;


public class Mesas {
    private ArrayList<Itens> pedido = new ArrayList<>();
    private String horaAbertura;
    private String horaFechamento;
    private Boolean status;
    private String nome;
    //private Time teste;
    public Mesas() {
        this.horaAbertura = null;
        this.horaFechamento = null;
        this.status = null;
        this.nome = null;
        pedido = new ArrayList<>();
    }
    
    public ArrayList<Itens> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<Itens> pedido) {
        this.pedido = pedido;
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura() {
        this.horaAbertura = new String();
        this.horaAbertura = (new Date().toString().substring(11, 20));  // tratar abertura da hora(pegar so o meio da string)
    }

    public String getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento() {
        this.horaFechamento = new String();
        this.horaFechamento = (new Date().toString().substring(11, 20));
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public void reajustaHora(String hora){
        this.horaAbertura = hora;
        this.horaFechamento = hora;
    }
   
    
}
