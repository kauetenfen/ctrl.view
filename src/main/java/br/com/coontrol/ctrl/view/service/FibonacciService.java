package br.com.coontrol.ctrl.view.service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FibonacciService {
	
	public String obterSequenciaFibonacci(int inicio, int quantidade) {
		 RestTemplate restTemplate = new RestTemplate();
		 restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("coontrol","coontrol"));	
		 String url = String.format("http://localhost:8081/fibonacci/%s/%s", inicio, quantidade);
		 ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
		 return result.getBody();
	}

}
