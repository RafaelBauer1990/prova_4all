package prova_4all.page;

import prova_4all.core.BasePage;

public class HomePage extends BasePage{

	public void clicaSelecionaCategoria() {
		dsl.clicaElementoById("open-categories-btn");
	}
	
	public void selecionaCategoriaBebidas() {
		dsl.waitById("category-0");
		dsl.clicaElementoById("category-0");
		
	}
	public void selecionaCategoriaDoces() {
		dsl.waitById("category-1");
		dsl.clicaElementoById("category-1");
	}
	
	public void selecionaCategoriaTodos() {
		dsl.waitById("category-all");
		dsl.clicaElementoById("category-all");
	}

	
	public void adicionaBrigadeiroAoCarrinho() {
		dsl.waitById("add-product-4-btn");
		dsl.clicaElementoById("add-product-4-btn");
	}
	public void adicionaRissoleMedioAoCarrinho() {
		dsl.waitById("add-product-3-btn");
		dsl.clicaElementoById("add-product-3-btn");
	}
	
	public void adicionaAlfajorDeChocolateAoCarrinho() {
		dsl.waitById("add-product-5-btn");
		dsl.clicaElementoById("add-product-5-btn");
	}
	
	public void adicionaCocaColaAoCarrinho() {
		dsl.waitById("add-product-0-btn");
		dsl.clicaElementoById("add-product-0-btn");
	}
	
	public void adicionaFantaUvaAoCarrinho() {
		dsl.waitById("add-product-1-btn");
		dsl.clicaElementoById("add-product-1-btn");
	}
	
	public void adicionaAguaMineralAoCarrinho() {
		dsl.waitById("add-product-2-btn");
		dsl.clicaElementoById("add-product-2-btn");
	}
	
	public void acessaCarrinho() {
		dsl.clicaElementoById("cart-btn");
		
	}
	


}
