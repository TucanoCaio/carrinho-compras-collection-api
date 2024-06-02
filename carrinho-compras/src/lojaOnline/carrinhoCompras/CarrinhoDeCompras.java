package lojaOnline.carrinhoCompras;

import java.util.ArrayList;
import java.util.List;

import lojaOnline.itens.Item;

public class CarrinhoDeCompras {

    private List<Item> carrinhoItens;

    public CarrinhoDeCompras() {
        this.carrinhoItens = new ArrayList<>();
    }
    
    public void adicionarItem(String nome, double preco, int quantidade){
        String id = nome+preco;
        if (carrinhoItens.size() != 0) {

            for(Item x : carrinhoItens){

                if (x.getNome().equalsIgnoreCase(nome) && x.getPreco() == preco) {

                    int idItem = carrinhoItens.indexOf(x);

                    carrinhoItens.get(idItem).setQuantidade(x.getQuantidade()+quantidade);

                    break;

                }else if ((carrinhoItens.indexOf(x)+1)==carrinhoItens.size()){

                    carrinhoItens.add(new Item(nome, preco, quantidade));
                    break;
                }
            }
        }else{
            carrinhoItens.add(new Item(nome, preco, quantidade));
        }
    }
    public void removerItem(String nome, int quantidade){

        for(Item x : carrinhoItens){

            if (x.getNome().equalsIgnoreCase(nome)) {

                int idItem = carrinhoItens.indexOf(x);

                if (x.getQuantidade() <= quantidade) {
                    carrinhoItens.remove(idItem);  
                }else {
                    carrinhoItens.get(idItem).setQuantidade(x.getQuantidade()-quantidade);
                }
                break;
            }
        }
    }

    public void lista(){
        System.out.println(carrinhoItens);
    }

    public int tamanho(){
        return carrinhoItens.size();
    }

    public static void main(String[] args) throws Exception {

        CarrinhoDeCompras carrinhoItens = new CarrinhoDeCompras();

       carrinhoItens.lista();
       System.out.println(carrinhoItens.tamanho());
        

        carrinhoItens.adicionarItem("calça", 10, 1);
        carrinhoItens.lista();
        
        carrinhoItens.adicionarItem("Calça", 11, 2);
        carrinhoItens.lista();
        
        carrinhoItens.adicionarItem("calça", 10, 1);
        carrinhoItens.lista();
       
        carrinhoItens.adicionarItem("Calça", 11, 1);
        carrinhoItens.lista();

        carrinhoItens.adicionarItem("Calça", 11, 1);
        carrinhoItens.lista();

        carrinhoItens.adicionarItem("Trem", 20, 5);
        carrinhoItens.lista();

        carrinhoItens.removerItem("Trem", 3);
        carrinhoItens.lista();

        carrinhoItens.removerItem("Trem", 3);
        carrinhoItens.lista();

        System.out.println(carrinhoItens.tamanho());
    }
}
