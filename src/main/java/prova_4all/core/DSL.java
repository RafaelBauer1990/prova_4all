package prova_4all.core;

import static prova_4all.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

	private WebElement element;

	//Metodos para clicar no elemento
	public void clicaElementoByXpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}

	public void clicaElementoById(String id) {
		getDriver().findElement(By.id(id)).click();
	}


	//Metodos para aguardar elemento ficar visivel
	public void waitById(String id){
		WebDriverWait wait = new WebDriverWait(getDriver(), 3);
		setElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
	}

	public void waitByXpath(String xpath){
		WebDriverWait wait = new WebDriverWait(getDriver(), 3);
		setElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))));
	}

	// retorna o texto visivel do elemento
	public String mensagemByXpath (String xpath){
		return getDriver().findElement(By.xpath(xpath)).getText();
	}

	public Double converteValorDouble(String xpath) {
		String mensagem = mensagemByXpath(xpath);
		int index = mensagem.indexOf(" ");
		mensagem = mensagem.substring(index + 1);
		mensagem = mensagem.replace(",", ".");
		Double valorCampo = Double.parseDouble(mensagem);
		return valorCampo;
	}

	public Integer converteValorInteger(String xpath) {
		Integer valorCampo = Integer.parseInt(mensagemByXpath(xpath));
		return valorCampo;
	}

	public void alteraQuantidade(Integer quantidade, String qtdAtual, String botaoAdicionar, String botaoRemover) {
		Integer valorAtualConvertido = converteValorInteger(qtdAtual);
		if (valorAtualConvertido < quantidade) {
			while (valorAtualConvertido < quantidade) {
				clicaElementoByXpath(botaoAdicionar);
				Integer valorCampo = converteValorInteger(qtdAtual);
				valorAtualConvertido = valorCampo;
			}
		} else {
			while (valorAtualConvertido > quantidade) {
				clicaElementoByXpath(botaoRemover);
				Integer valorCampo = converteValorInteger(qtdAtual);
				valorAtualConvertido = valorCampo;
			}
		} 		
	}

	public WebElement getElement() {
		return element;
	}

	public void setElement(WebElement element) {
		this.element = element;
	}
}
