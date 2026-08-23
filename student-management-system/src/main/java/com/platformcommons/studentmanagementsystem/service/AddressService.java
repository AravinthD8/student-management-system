package com.platformcommons.studentmanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.platformcommons.studentmanagementsystem.entity.Address;
import com.platformcommons.studentmanagementsystem.repository.AddressRepository;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // CREATE
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    // GET BY ID
    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    // GET ALL
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    // UPDATE
    public Address updateAddress(Long id, Address address) {

        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        existingAddress.setAddressType(address.getAddressType());
        existingAddress.setAddressLine(address.getAddressLine());
        existingAddress.setCity(address.getCity());
        existingAddress.setState(address.getState());
        existingAddress.setPincode(address.getPincode());

        return addressRepository.save(existingAddress);
    }

    // DELETE
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
