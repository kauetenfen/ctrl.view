package br.com.coontrol.ctrl.view.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import br.com.coontrol.ctrl.view.dto.Pessoa;
import br.com.coontrol.ctrl.view.service.PessoaService;

@Component(value="pessoaBean")
@RequestScope
public class PessoaBean {
	
	@Autowired
	PessoaService pessoaService;
	
	private Pessoa pessoa;
	List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	
	@PostConstruct
	public void InicializarBean() {
		atualizarListaPessoas();
		pessoa = new Pessoa();
	}
	
	public void cadastrarPessoa() {
		pessoaService.cadastrarPessoa(pessoa);
		limparFormulario();
		atualizarListaPessoas();
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + "Tudo certo") );
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
	}
	
	public void limparFormulario() {
		pessoa = new Pessoa();
	}
	
	public void atualizarListaPessoas() {
		listaPessoas = pessoaService.obterListaPessoas();
	}
	
	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public boolean existePessoaCadastrada() {
		return listaPessoas.size() > 0;
	}
	
}
