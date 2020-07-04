package br.com.lrsantos.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lrsantos.config.ListSuperApiProperty;
import br.com.lrsantos.model.bean.Produto;
import br.com.lrsantos.model.repository.ProdutoRepository;

@RestController
@RequestMapping("/status")
public class StatusResource {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ListSuperApiProperty apiProperty;
	
	private Logger log = LoggerFactory.getLogger(StatusResource.class);
	
	@PostConstruct
	private void init() {
		log.info("Origem Permitida: " + this.apiProperty.getOrigemPermitida());
	}
	
	@GetMapping
	public ResponseEntity<StatusDTO> getStatus(HttpServletRequest request) {
		StatusDTO status = new StatusDTO();
		String endereco = request.getRemoteHost();
		try {
			Long totalProdutos = this.produtoRepository.count();
			status.setDescricao("Ok");
			status.setEndereco(endereco);
			status.setNumeroProdutos(totalProdutos);
			return ResponseEntity.ok(status);
		} catch (Exception e ) {
			e.printStackTrace();
			status.setDescricao(e.getMessage());
			status.setEndereco(endereco);
			return ResponseEntity.ok(status);
		}
	}
	
}
