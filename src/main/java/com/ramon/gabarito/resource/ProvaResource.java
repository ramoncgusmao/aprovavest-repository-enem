package com.ramon.gabarito.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.gabarito.domain.Prova;
import com.ramon.gabarito.service.ProvaService;

@RestController
@RequestMapping(value="/prova")
public class ProvaResource {

	@Autowired
	private ProvaService provaService;
	
	@PostMapping()
	public void salvar(@RequestBody Prova prova) {
		provaService.salvar(prova);	
	}
	
	
	@GetMapping()
	public ResponseEntity<List<Prova>> buscar() {
		List<Prova> lista =  provaService.listaProvas();	
	return ResponseEntity.ok().body(lista);
	}
	
	
	
	@PostMapping("/lista")
	public void salvar(@RequestBody List<Prova> provas) {
		provaService.salvarLista(provas);	
	}
}
