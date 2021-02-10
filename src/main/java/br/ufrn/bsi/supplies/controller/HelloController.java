package br.ufrn.bsi.supplies.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.bsi.supplies.entity.Address;
import br.ufrn.bsi.supplies.service.address.AddressService;

@RestController
public class HelloController {

	@Autowired
	private AddressService addressService;
    
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {

		String cep = "59300000";
		Optional<Address> address = addressService.search(cep);

		return String.format("Hello %s! Endereço: %s", name, address.get());
	}
}
