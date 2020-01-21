package prova_4all.core;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Relatorio {

	static ExtentReports report;
	static ExtentTest test;

	public void registraRelatorio() {
		 
		report = new ExtentReports("target" + File.separator + "relatorio" + File.separator + "relatorioDosTestes.html");
		test = report.startTest("deveExecutarPedidoComSucesso");
		try {
			test.log(LogStatus.PASS, "Passou");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Falhou");
		}
		report.endTest(test);

		test = report.startTest("deveCalcularCorretamenteValorTotalDoPedido");
		try {
			test.log(LogStatus.PASS, "Passou");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Falhou");
		}
		report.endTest(test);
		report.flush();
	}
}
