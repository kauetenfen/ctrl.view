package br.com.coontrol.ctrl.view.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import br.com.coontrol.ctrl.view.service.FibonacciService;

@Component(value="fibonacciBean")
@RequestScope
public class FibonacciBean {
	
	@Autowired
	FibonacciService fibonacciService;
	
	private Integer quantidade;
	private Integer inicio;
	private String sequenciaFibonacci;
	
	@PostConstruct
	public void InicializarBean() {
		this.quantidade = null;
		this.inicio = null;
		sequenciaFibonacci = null;
	}
	
	public void obterSequenciaFibonacci() {
		this.sequenciaFibonacci = fibonacciService.obterSequenciaFibonacci(this.inicio, this.quantidade);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getInicio() {
		return inicio;
	}

	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}

	public String getSequenciaFibonacci() {
		return sequenciaFibonacci;
	}

	public void setSequenciaFibonacci(String sequenciaFibonacci) {
		this.sequenciaFibonacci = sequenciaFibonacci;
	}	
}