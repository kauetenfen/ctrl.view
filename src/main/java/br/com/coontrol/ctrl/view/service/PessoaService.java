package br.com.coontrol.ctrl.view.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.coontrol.ctrl.view.dto.Pessoa;
import br.com.coontrol.ctrl.view.util.RestResponsePage;

@Service
public class PessoaService {
	
	private static final String URL_SERVICE_PESSOAS = "http://localhost:8081/pessoas";

	public List<Pessoa> obterListaPessoas() {
		 RestTemplate restTemplate = new RestTemplate();
		 restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("coontrol","coontrol"));		 
		 ParameterizedTypeReference<RestResponsePage<Pessoa>> responseType = new ParameterizedTypeReference<RestResponsePage<Pessoa>>() { };
		 ResponseEntity<RestResponsePage<Pessoa>> result = restTemplate.exchange(URL_SERVICE_PESSOAS, HttpMethod.GET, null, responseType);
		 List<Pessoa> searchResult = result.getBody().getContent();
		 return searchResult;
	}
	
	public void cadastrarPessoa(Pessoa pessoa) {
		 RestTemplate restTemplate = new RestTemplate();
		 HttpEntity<Pessoa> request = new HttpEntity<Pessoa>(pessoa);
		 restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("coontrol","coontrol"));
		 restTemplate.exchange(URL_SERVICE_PESSOAS, HttpMethod.POST, request, Pessoa.class);
	}
}
