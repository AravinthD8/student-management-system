package com.platformcommons.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platformcommons.studentmanagementsystem.entity.Address;
import com.platformcommons.studentmanagementsystem.service.AddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

	private final AddressService addressService;

	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@PostMapping
	public ResponseEntity<Address> createAddress(@Valid @RequestBody Address address) {
		return ResponseEntity.ok(addressService.createAddress(address));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Address> getAddress(@PathVariable Long id) {

		Address address = addressService.getAddress(id);

		if (address == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(address);
	}

	@GetMapping
	public ResponseEntity<List<Address>> getAllAddresses() {
		return ResponseEntity.ok(addressService.getAllAddresses());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable Long id, @Valid @RequestBody Address address) {

		return ResponseEntity.ok(addressService.updateAddress(id, address));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {

		addressService.deleteAddress(id);

		return ResponseEntity.noContent().build();
	}
}