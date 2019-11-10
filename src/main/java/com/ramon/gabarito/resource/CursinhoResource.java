package com.ramon.gabarito.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.gabarito.domain.Cursinho;
import com.ramon.gabarito.service.CursinhoService;

@RestController
@RequestMapping("/cursinho")
public class CursinhoResource {

	@Autowired
	private CursinhoService cursinhoService;
	
	@PostMapping()
	public void salvar(@RequestBody Cursinho cursinho) {
		cursinhoService.salvar(cursinho);
	}
	
	@GetMapping()
	public ResponseEntity<List<Cursinho>> buscar() {
		List<Cursinho> lista =  cursinhoService.listar();	
	return ResponseEntity.ok().body(lista);
	}
	
	
	
}
