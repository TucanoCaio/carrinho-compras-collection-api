package lojaOnline.itens;

public class Item {

    private String nome;
    private double preco;
    private int quantidade;
    private String id;

    public Item(String id, String nome, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getId() {
        return id;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade + "]";
    }
       
}
