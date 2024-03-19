//Autor: Yuri Seixeiro
//Data: 19/03/2024

public class JavaAtacadista {
    public static void main(String[] args) {
        Horario horaCompra = new Horario();
        Caixa caixa = new Caixa();
        Cliente cliente = new Cliente("Dona Maria", "123.456.789-10");
        Compra compra = new Compra();
        System.out.println("JAVA ATACADISTA");
        compra.setProdutos();
        System.out.println("Caixa: " + caixa.getNumeroCaixa());
        horaCompra.setHorario();
        System.out.println("Data de Compra: " + horaCompra.getHorario());
        System.out.println("Cliente: " + cliente.getNomeCliente() + " - Cpf: " + cliente.getCpf());
        System.out.println();
        System.out.println("Nova Compra:");
        compra.setCarrinho();
        for(Produto lista : compra.getCarrinho()){
            System.out.printf(lista.getNomeProduto() , lista.getPrecoProduto());
        }
        compra.setTotalCompra();
        cliente.setPalpiteCliente();
        System.out.println();
        System.out.println("PROMOÇÃO COMPRA PREMIADA JAVA ATACADISTA!!!");
        System.out.printf("Palpite do Valor Total da Compra: R$%.2f%n" , cliente.getPalpiteCliente());
        System.out.printf("Total da Compra: R$%.2f%n", compra.getTotalCompra());
        compra.setTotalArredondado();
        cliente.setPalpiteArredondado();
        if (cliente.getPalpiteCliente() == compra.getTotalCompra()){
            System.out.println("Parabens!! você ganhou na promoção, sua compra é GRATIS!!!");
        } else if(cliente.getPalpiteArredondado() == compra.getTotalArredondado()){
            compra.setTotalCompraComDesconto();
            System.out.println("Parabens!! você ganhou na promoção, sua compra tem 30% de DESCONTO!!!");
            System.out.printf("Novo valor total da compra: R$%.2f%n" , compra.getTotalCompraComDesconto());
        } else {
            System.out.println("Infelizmente voce errou o palpite e nao ganhou na promoção!");
        }
    }
}