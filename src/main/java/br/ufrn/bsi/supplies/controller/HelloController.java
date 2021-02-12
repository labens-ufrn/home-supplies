package br.ufrn.bsi.supplies.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.bsi.supplies.entity.Address;
import br.ufrn.bsi.supplies.service.address.AddressService;
import br.ufrn.bsi.supplies.service.cep.CepApi;

@RestController
public class HelloController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {

		String cep = "58705000";
		long start1 = System.currentTimeMillis();
		Optional<Address> address1 = addressService.search(cep, CepApi.BRASIL_API_CEP);
		long elapsed1 = (System.currentTimeMillis() - start1);
		long start2 = System.currentTimeMillis();
		Optional<Address> address2 = addressService.search(cep, CepApi.VIA_CEP);
		long elapsed2 = (System.currentTimeMillis() - start2);

		return String.format("Hello %s! <br> Endereço Brazil API (%s ms): %s <br> Endereço ViaCep (%s ms): %s", name, elapsed1, address1.get(), elapsed2, address2.get());
	}
}
