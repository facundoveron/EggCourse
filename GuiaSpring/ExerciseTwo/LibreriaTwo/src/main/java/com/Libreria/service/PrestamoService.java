package com.Libreria.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Libreria.entities.Cliente;
import com.Libreria.entities.Libro;
import com.Libreria.entities.Prestamo;
import com.Libreria.error.ErrorService;
import com.Libreria.repository.PrestamoRepository;

@Service
public class PrestamoService {

	@Autowired
	PrestamoRepository prestamoRepository;

	@Autowired
	ClienteService clienteService;

	@Autowired
	LibroService libroService;

	@Transactional
	public void createLoanMain(Long dni, Long isbn, Date dateOfReturn) throws ErrorService {
		try {
			if (dni == null) {
				throw new ErrorService("dni null");
			}
			if (isbn == null) {
				throw new ErrorService("isbn null");
			}
			if (dateOfReturn == null || dateOfReturn.before(new Date())) {
				throw new ErrorService("date null or date incorret");
			}

			Cliente cliente = clienteService.searchByDni(dni);
			if (cliente == null) {
				throw new ErrorService("no found customer");
			}
			Libro libro = libroService.searchBookByIsbn(isbn);
			if (libro == null) {
				throw new ErrorService("no found book");
			}
			if (libro.getEjemplaresRestantes() == 0) {
				throw new ErrorService("no books to lend");
			}

			Prestamo prestamo = new Prestamo();
			prestamo.setAlta(true);
			prestamo.setFechaPrestamo(new Date());
			prestamo.setFechaDevolucion(dateOfReturn);
			prestamo.setLibro(libro);
			prestamo.setCliente(cliente);

			prestamoRepository.save(prestamo);
			libroService.loanBook(libro);
		} catch (IllegalArgumentException e) {
			throw new ErrorService("error");
		} catch (NullPointerException e) {
			throw new ErrorService("error system");
		} catch (ErrorService e) {
			throw e;
		}
	}

	@Transactional
	public void createLoanSecondary(String phone, String title, Date dateOfReturn) throws ErrorService {
		try {
			if (phone == null || phone.trim().isEmpty()) {
				throw new ErrorService("phone null or empty");
			}
			if (title == null || title.trim().isEmpty()) {
				throw new ErrorService("title null or empty");
			}
			if (dateOfReturn == null || dateOfReturn.before(new Date())) {
				throw new ErrorService("date null or date incorret");
			}

			Cliente cliente = clienteService.searchByPhone(phone);
			if (cliente == null) {
				throw new ErrorService("no found customer");
			}
			Libro libro = libroService.searchBookByTitle(title);
			if (libro == null) {
				throw new ErrorService("no found book");
			}
			if (libro.getEjemplaresRestantes() == 0) {
				throw new ErrorService("no books to lend");
			}

			Prestamo prestamo = new Prestamo();
			prestamo.setAlta(true);
			prestamo.setFechaPrestamo(new Date());
			prestamo.setFechaDevolucion(dateOfReturn);
			prestamo.setLibro(libro);
			prestamo.setCliente(cliente);

			prestamoRepository.save(prestamo);
			libroService.loanBook(libro);
		} catch (NullPointerException e) {
			throw new ErrorService("error system");
		} catch (ErrorService e) {
			throw e;
		}
	}
}
