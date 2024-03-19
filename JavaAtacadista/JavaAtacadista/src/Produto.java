public class Produto {
    private String nomeProduto;
    private double precoProduto;


    public String getNomeProduto() {
        return nomeProduto;
    }

    public Produto(String nomeProduto, double precoProduto) {
        setNomeProduto(nomeProduto);
        setPrecoProduto(precoProduto);
    }

    //ADICIONA O NOME DO PRODUTO
    private void setNomeProduto(String nomeProduto) {
        if(nomeProduto == null || nomeProduto.isBlank()){throw new IllegalStateException("O nome do produto não pode ser nulo ou vazio");}
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    //ADICIONA O PREÇO DO PRODUTO
    private void setPrecoProduto(double precoProduto) {
        if(precoProduto <= 0){throw new RuntimeException("O preço do produto tem de ser maior que 0");}
        this.precoProduto = precoProduto;
    }
}
