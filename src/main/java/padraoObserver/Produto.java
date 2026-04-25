package padraoObserver;

import java.util.Observable;

public class Produto extends Observable {

    private String nome;
    private String categoria;
    private boolean emEstoque;

    public Produto(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
        this.emEstoque = false;
    }

    public void reporEstoque() {
        this.emEstoque = true;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", emEstoque=" + emEstoque +
                '}';
    }

}
