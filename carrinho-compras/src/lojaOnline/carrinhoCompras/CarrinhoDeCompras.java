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
        String id = nome+"-"+preco;
        if (carrinhoItens.size() != 0) {

            for(Item x : carrinhoItens){

                if (x.getId().equalsIgnoreCase(id)) {

                    int idItem = carrinhoItens.indexOf(x);

                    carrinhoItens.get(idItem).setQuantidade(x.getQuantidade()+quantidade);

                    break;

                }else if ((carrinhoItens.indexOf(x)+1)==carrinhoItens.size()){

                    carrinhoItens.add(new Item(id, nome, preco, quantidade));
                    break;
                }
            }
        }else{
            carrinhoItens.add(new Item(id, nome, preco, quantidade));
        }
    }
    public void removerItem(String nome, double preco, int quantidade){
        String id = nome+"-"+preco;
        for(Item x : carrinhoItens){

            if (x.getId().equalsIgnoreCase(id)) {

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

    public void calcularValorTotal(){
        double valor=0;
        double valorTotal=0;
        for(Item x : carrinhoItens){
            valor = (x.getPreco()*x.getQuantidade());
            valorTotal = valorTotal+valor; 
        }
        System.out.println("");
        System.out.println("Valor total da compra é: " + String.format("R$ %.2f",valorTotal));
    }

    public void exibirItens(){
        for(Item x : carrinhoItens){
            int idItem = carrinhoItens.indexOf(x);
            double valor = (x.getPreco()*x.getQuantidade());

            System.out.println("");

            System.out.println("Item " + (idItem+1));
            System.out.println("Produto:.............." + x.getNome());
            System.out.println("Valor Uni.:..........." + String.format("R$ %.2f",x.getPreco()));
            System.out.println("Quantidade:..........." + x.getQuantidade());
            System.out.println("Valor total do item:.." + String.format("R$ %.2f",valor));
        }
    }

    //Teste de inicialização vazia da List
    /*public void lista(){
        System.out.println(carrinhoItens);
    }*/

    //Verificação de tamanho da List
    /*public int tamanho(){
        return carrinhoItens.size();
    }*/

    //Metodo main esta sendo utilizado para testar o algoritimo. Aqui esta sendo instanciado a List e chamando seus metodos em varias interações diferentes
    public static void main(String[] args) throws Exception {

        // Instanciando a List carrinhoItens
        CarrinhoDeCompras carrinhoItens = new CarrinhoDeCompras();
        
        //esta primeira interação utilizando o metodo lista e tamanho para validar a criação de uma lista vazia
        /*carrinhoItens.lista();
        System.out.println(carrinhoItens.tamanho());*/
        
        // Varias interação adicionando ou removendo itens e logo em seguida acionando os metodos de exibirItem e calcularValorTotal que exibem respectivamente uma lista de dos itens em formato de ficha e o valor total da compra.
        //System.out.println("");
        //System.out.println("interação 1");
        carrinhoItens.adicionarItem("Calça", 80.76, 1);
        //carrinhoItens.exibirItens();
        //carrinhoItens.calcularValorTotal();
        
        //System.out.println("");
        //System.out.println("interação 2");
        carrinhoItens.adicionarItem("Camiseta", 50.5, 2);
        //carrinhoItens.exibirItens();
        //carrinhoItens.calcularValorTotal();
        
        //System.out.println("");
        //System.out.println("interação 3");
        carrinhoItens.adicionarItem("Calça", 80.76, 1);
        //carrinhoItens.exibirItens();
        //carrinhoItens.calcularValorTotal();

        //System.out.println("");
        //System.out.println("interação 4");
        carrinhoItens.adicionarItem("Calça", 75, 1);
        //carrinhoItens.exibirItens();
        //carrinhoItens.calcularValorTotal();

        //System.out.println("");
        //System.out.println("interação 5");
        carrinhoItens.adicionarItem("Camiseta", 50.5, 1);
        //carrinhoItens.exibirItens();
        //carrinhoItens.calcularValorTotal();

        //System.out.println("");
        //System.out.println("interação 6");
        carrinhoItens.adicionarItem("Tenis", 321.33, 5);
        //carrinhoItens.exibirItens();
        //carrinhoItens.calcularValorTotal();

        //System.out.println("");
        //System.out.println("interação 7");
        carrinhoItens.removerItem("Tenis", 321.33, 4);
        //carrinhoItens.exibirItens();
        //carrinhoItens.calcularValorTotal();

        //System.out.println("");
        //System.out.println("interação 8");
        //carrinhoItens.removerItem("Trem", 20, 3);
        //carrinhoItens.exibirItens();
        //carrinhoItens.calcularValorTotal();

        //System.out.println("");
        //System.out.println("interação 9");
        carrinhoItens.removerItem("Calça", 75, 3);
        //carrinhoItens.exibirItens();
        //carrinhoItens.calcularValorTotal();

        //System.out.println("");
        //System.out.println("interação 10");
        carrinhoItens.removerItem("Calça", 80.76, 1);
        carrinhoItens.exibirItens();
        carrinhoItens.calcularValorTotal();

        //Ultima validação de de tamanho da lista
        //System.out.println(carrinhoItens.tamanho());
    }
}
