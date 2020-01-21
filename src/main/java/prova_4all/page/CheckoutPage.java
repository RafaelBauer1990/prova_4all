package prova_4all.page;

import prova_4all.core.BasePage;

public class CheckoutPage extends BasePage{


	private String qtdAtual;
	private String botaoAdicionar;
	private String botaoRemover;

	//Altera quantidade do item no carrinho
	public void alteraQuantidadeBrigadeiro(Integer quantidade) {
		qtdAtual = "//*[@id=\"product-4-qtd\"]";
		botaoAdicionar = "//*[@id=\"add-product-4-qtd\"]/span";
		botaoRemover = "//*[@id=\"remove-product-4-qtd\"]";
		dsl.alteraQuantidade(quantidade, qtdAtual, botaoAdicionar, botaoRemover);
	}


	public void alteraQuantidadeRissoleMedio(Integer quantidade) {
		qtdAtual = "//*[@id=\"product-3-qtd\"]";
		botaoAdicionar = "//*[@id=\"add-product-3-qtd\"]/span";
		botaoRemover = "//*[@id=\"remove-product-3-qtd\"]";		
		dsl.alteraQuantidade(quantidade, qtdAtual, botaoAdicionar, botaoRemover);

	}

	//Retorna o preco de cada item


	public Double valorRissole() {
		Double valorRissole = dsl.converteValorDouble("//*[@id=\"product-3-price\"]");
		return 	valorRissole;	
	}

	public Double valorCocaCola() {
		Double valorCocaCola = dsl.converteValorDouble("//*[@id=\"product-0-price\"]");
		return 	valorCocaCola;	
	}
	public Double valorFantaUva() {
		Double valorFantaUva = dsl.converteValorDouble("//*[@id=\"product-1-price\"]");
		return 	valorFantaUva;	
	}

	public Double valorAguaMineral() {
		Double valorAguaMineral = dsl.converteValorDouble("//*[@id=\"product-2-price\"]");
		return 	valorAguaMineral;	
	}	

	public Integer quantidadeRissoleMedio() {
		Integer valorAtual = Integer.parseInt(dsl.mensagemByXpath("//*[@id=\"product-3-qtd\"]"));
		return valorAtual;
	}

	public Double valorTotalCompra() {
		Double valorTotalCompra = dsl.converteValorDouble("//*[@id=\"price-total-checkout\"]");
		return valorTotalCompra;
	}
	public Double CalculaValorTotalCompra() {
		Double valorTotal = valorRissole() * quantidadeRissoleMedio() + valorCocaCola() + valorFantaUva() + valorAguaMineral();
		return valorTotal;
	}
	// finaliza compra
	public void finalizaCompra() {
		dsl.clicaElementoById("finish-checkout-button");
	}

	public String mensagemDeSucessoDoPedido() {
		return dsl.mensagemByXpath("//*[@id=\"root\"]/div[3]/div/div/div/h2"); 
	}

	public void fechaAlertaDeFinalizacaoDeCompra() {
		dsl.clicaElementoByXpath("//*[@id=\"root\"]/div[3]/div/div/div/button");
	}
}