import java.text.NumberFormat;

public class Produto {
	
	private static final double MARGEM_PADRAO = 0.2;
	private String descricao;
	private double precoCusto;
	private double margemLucro;
	private String dataDeValidade;
	private int quantidadeEmEstoque;

	/*Tarefa 2 (2 pontos): Lógica de Estoque e Agrupamento de Itens  */

	/*métodos de acesso (getters e setters)*/
	/*2.2. Controle de Estoque na Classe Produto - Novo Atributo */
	public int getQuantidadeEmEstoque(){
		return this.quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque){
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public String getDataDeValidade(){
		return this.dataDeValidade;
	}

	public void setDataDeValidade(String dataDeValidade){
		this.dataDeValidade = dataDeValidade;
	}
	
	/**
     * Inicializador privado. Os valores default, em caso de erro, são:
     * "Produto sem descrição", R$ 0.00, 0.0  
     * @param desc Descrição do produto (mínimo de 3 caracteres)
     * @param precoCusto Preço do produto (mínimo 0.01)
     * @param margemLucro Margem de lucro (mínimo 0.01)
     */
	private void init(String desc, double precoCusto, double margemLucro) {
		
		if ((desc.length() >= 3) && (precoCusto > 0.0) && (margemLucro > 0.0)) {
			descricao = desc;
			this.precoCusto = precoCusto;
			this.margemLucro = margemLucro;
		} else {
			throw new IllegalArgumentException("Valores inválidos para os dados do produto.");
		}
	}
	
	/**
     * Construtor completo. Os valores default, em caso de erro, são:
     * "Produto sem descrição", R$ 0.00, 0.0  
     * @param desc Descrição do produto (mínimo de 3 caracteres)
     * @param precoCusto Preço do produto (mínimo 0.01)
     * @param margemLucro Margem de lucro (mínimo 0.01)
	 * @param dataDeValidade Data validade
	 * @param quantidadeEmEstoque Quantidade em estoque
     */
	/*2.2. Controle de Estoque na Classe Produto - Carregamento dos Dados */
	public Produto(String desc, double precoCusto, double margemLucro, String dataDeValidade, int quantidadeEmEstoque) {
		//init(desc, precoCusto, margemLucro);
		this.descricao = desc;
		this.precoCusto = precoCusto;
		this.margemLucro = margemLucro;
		this.dataDeValidade = dataDeValidade;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	
	/**
     * Construtor sem margem de lucro - fica considerado o valor padrão de margem de lucro.
     * Os valores default, em caso de erro, são:
     * "Produto sem descrição", R$ 0.00 
     * @param desc Descrição do produto (mínimo de 3 caracteres)
     * @param precoCusto Preço do produto (mínimo 0.01)
     */
	public Produto(String desc, double precoCusto) {
		init(desc, precoCusto, MARGEM_PADRAO);
	}
	
	/**
     * Retorna o valor de venda do produto, considerando seu preço de custo e margem de lucro.
     * @return Valor de venda do produto (double, positivo)
	 * @param dataDeValidade Data validade
	 * @param quantidadeEmEstoque Quantidade em estoque
     */
	public double valorDeVenda() {
		return (precoCusto * (1.0 + margemLucro) * quantidadeEmEstoque);
	}

	/**
     * Retorna a disponibilidade do produto pela quantidade
     * @return true ou false
     */
	/*2.2. Controle de Estoque na Classe Produto - Validação de Disponibilidade: */
	public boolean isDisponivel(Produto produto){
		//se a descricao do produto passado for diferente de null
		if(produto.descricao != null){
			//valida a quantidade dessa produto, se for maior que zero -> true -> disponivel
			if(produto.getQuantidadeEmEstoque() > 0) {
				return true;
			}
		}
		return false; //se não retorno falso -> indisponivel
	}

	/**
     * Realiza a baixa de estoque ao ser vendido algum produto
     * @return quantidade atual de estoque daquele produto.
	 * @param produto[] todos os produtos vendidos.
	 * @param quantidadeVendida quantidade dos produtos vendidos.
     */
	/*2.2. Controle de Estoque na Classe Produto -  Baixa no Estoque*/
	public void baixaDeEstoque(Produto produto[], int quantidadeVendida){
		//percorre todos os itens vendidos
		for (int i=0; i<=produto.length; i++) {
			//faz o decremento de cada quantidade.
			quantidadeEmEstoque =  quantidadeEmEstoque - quantidadeVendida;
		}
	}

	/**
     * Descrição, em string, do produto, contendo sua descrição e o valor de venda.
     *  @return String com o formato:
     * [NOME]: R$ [VALOR DE VENDA]
     */
    @Override
	public String toString() {
    	NumberFormat moeda = NumberFormat.getCurrencyInstance();
		return String.format("NOME: " + descricao + ": " + moeda.format(valorDeVenda()));
	}
}