import java.util.ArrayList;
import java.util.Random;

public class Compra {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private ArrayList<Produto> carrinho = new ArrayList<>();
    private double totalCompra;
    int totalArredondado;
    private double totalCompraComDesconto;

    //VERIFICA SE O TOTAL DA COMPRA JA FOI SOMADO
    boolean jaFechouACompra(){ return totalCompra != 0;}

    //VERIFICA SE O TOTAL DA COMPRA COM DESCONTO JA FOI CALCULADO
    boolean jaFechouTotalComDesconto(){return totalCompraComDesconto != 0;}

    //DEFINE O VALOR TOTAL DA COMPRA
    public void setTotalCompra() {
        if(jaFechouACompra()){throw new IllegalStateException("O total ja foi fechado");}
        for(Produto total : carrinho){
            totalCompra += total.getPrecoProduto();
        }
        this.totalCompra += totalCompra;
    }


    public double getTotalCompraComDesconto() {
        return totalCompraComDesconto;
    }
    //OBTER O VALOR TOTAL CASO A COMPRA TENHA 30% DE DESCONTO
    public void setTotalCompraComDesconto() {
        if(jaFechouTotalComDesconto()){throw new IllegalStateException("O total com desconto ja foi fechado");}
        this.totalCompraComDesconto = totalCompra * 0.30;
    }

    //LISTA DE PRODUTOS DISPONÍVEIS
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    //ADICIONA PRODUTOS ALEATORIOS NO "ESTOQUE"
    public void setProdutos() {
        if(jaFechouACompra()){throw new IllegalStateException("Não é possível adicionar produtos com o total fechado");}
        Random random = new Random();
        produtos = new ArrayList<>();
        for(int i=0; i<10; i++) {
            produtos.add(new Produto("Produto: " + (i+1) + " - %.2f%n", random.nextDouble(100)));
        }
    }
    public double getTotalCompra() {
        return totalCompra;
    }

    //ARREDONDAMENTO DO TOTAL DA COMPRA PARA COMPARAÇÃO
    public void setTotalArredondado(){
        this.totalArredondado = (int)Math.floor(getTotalCompra());
    }
    public int getTotalArredondado(){
        return totalArredondado;
    }

    //ADICIONA PRODUTOS NO CARRINHO DE COMPRA
    public void setCarrinho() {
        if(jaFechouACompra()){throw new IllegalStateException("Não é possível adicionar produtos com o total fechado");}
        carrinho = new ArrayList<>();
        for (Produto produtosNoCarrinho : getProdutos()) {
            carrinho.add(new Produto(produtosNoCarrinho.getNomeProduto(), produtosNoCarrinho.getPrecoProduto()));
        }
    }

    //CARRINHO DE COMPRAS
    public ArrayList<Produto> getCarrinho(){
        return carrinho;
    }
}


