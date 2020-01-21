package prova_4all.test;

import static prova_4all.core.DriverFactory.getDriver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import prova_4all.core.BaseTest;
import prova_4all.page.CheckoutPage;
import prova_4all.page.HomePage;

public class TestePedido extends BaseTest{

	private static HomePage homePage;
	private static CheckoutPage checkoutPage;
	private String msgSucesso = "Pedido realizado com sucesso!";
	private String url = "https://shopcart-challenge.4all.com/";
	
	@BeforeEach
	public void setup() {
		getDriver().get(url);
		homePage = new HomePage();
		checkoutPage = new CheckoutPage();
	}


	@Test
	public void deveExecutarPedidoComSucesso() {
		homePage.clicaSelecionaCategoria();
		homePage.selecionaCategoriaDoces();
		homePage.adicionaBrigadeiroAoCarrinho();
		homePage.adicionaAlfajorDeChocolateAoCarrinho();
		homePage.clicaSelecionaCategoria();
		homePage.selecionaCategoriaTodos();
		homePage.acessaCarrinho();
		checkoutPage.alteraQuantidadeBrigadeiro(4);
		checkoutPage.finalizaCompra();
		Assertions.assertEquals(msgSucesso, checkoutPage.mensagemDeSucessoDoPedido());
		checkoutPage.fechaAlertaDeFinalizacaoDeCompra(); 		
	
	}
	
	@Test
	public void deveCalcularCorretamenteValorTotalDoPedido() {
		homePage.clicaSelecionaCategoria();
		homePage.selecionaCategoriaBebidas();
		homePage.adicionaCocaColaAoCarrinho();
		homePage.adicionaFantaUvaAoCarrinho();
		homePage.adicionaAguaMineralAoCarrinho();
		homePage.clicaSelecionaCategoria();
		homePage.selecionaCategoriaTodos();
		homePage.adicionaRissoleMedioAoCarrinho();
		homePage.acessaCarrinho();
		checkoutPage.alteraQuantidadeRissoleMedio(9);
		checkoutPage.alteraQuantidadeRissoleMedio(5);
		Assertions.assertEquals(checkoutPage.CalculaValorTotalCompra(), checkoutPage.valorTotalCompra());
		checkoutPage.finalizaCompra();
		Assertions.assertEquals(msgSucesso, checkoutPage.mensagemDeSucessoDoPedido());
		checkoutPage.fechaAlertaDeFinalizacaoDeCompra();
		

	}
}
