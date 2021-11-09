package com.Libreria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Libreria.error.ErrorService;
import com.Libreria.repository.PublisherRepository;

@Service
public class PublisherService {
	
	@Autowired
	PublisherRepository publisherRepository;
	
	
	@Transactional
	public void createPublisher(String name) throws ErrorService {
		try {
			if(name == null) {
				throw new ErrorService("name null");
			}
		} catch (ErrorService e) {
			throw e;
		}
	}
}
