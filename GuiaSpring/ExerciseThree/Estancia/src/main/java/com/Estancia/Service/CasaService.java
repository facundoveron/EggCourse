package com.Estancia.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Estancia.Entities.Casa;
import com.Estancia.Repository.CasaRepository;


@Service
public class CasaService {

	@Autowired
	private CasaRepository casaRepository;
	
	@Transactional
	public Collection<String> listCountryHouse(){
		List<String> houseList = null;
		try {
			houseList = casaRepository.findAll().stream()
													.map(country -> country.getPais())
													.collect(Collectors.toList());
		} catch (Exception e) {
			throw e;
		}
		
		return houseList;
	}
	
	@Transactional
	public Collection<Casa> listAllCasa(){
		try {
			List<Casa> allHouse = casaRepository.findAll();
			return allHouse;
		} catch (Exception e) {
			return null;
		}
	}
}
