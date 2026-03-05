public class ItemDePedido {

    // Atributos encapsulados
    private Produto produto;
    private int quantidade;
    private double precoVenda;

    public Produto getProduto(){
        return produto;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public double getPrecoVenda(){
        return precoVenda;
    }
    
    /**
     * Construtor da classe ItemDePedido.
     * O precoVenda deve ser capturado do produto no momento da criação do item,
     * garantindo que alterações futuras no preço do produto não afetem este pedido.
     */
    public ItemDePedido(Produto produto, int quantidade, double precoVenda) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    /* 
        1.2. Implementação de Igualdade  
        A comparação deve retornar true se o Produto atrelado ao 
        item for o mesmo, independentemente da quantidade ou do preço congelado.
    */
    // --- Sobrescrita do método equals ---
    public boolean validar(ItemDePedido[] item) {
        for(int i=0; i<item.length; i++) {
            if(item.equals(produto)){
                return true;
            }
        }
        return false;
    }

    public double calcularSubtotal() {
        return 0;
    }

    /**
     * Compara a igualdade entre dois itens de pedido.
     * A regra de negócio define que dois itens são iguais se possuírem o mesmo Produto.
     */
    @Override
    public boolean equals(Object obj) {
        return false;
    }

}
