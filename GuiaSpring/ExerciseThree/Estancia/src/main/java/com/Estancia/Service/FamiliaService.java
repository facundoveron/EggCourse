package com.Estancia.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Estancia.Entities.Familia;
import com.Estancia.Entities.Usuario;
import com.Estancia.Error.ErrorServicio;
import com.Estancia.Repository.FamiliaRepository;

@Service
public class FamiliaService {

	@Autowired
	FamiliaRepository familiaRepository;

	@Transactional
	public void registreFamilia(Familia familia, Usuario usuario) throws ErrorServicio {
		try {
			if (familia.getNombre().trim().isEmpty() || familia.getNombre() == null) {
				throw new ErrorServicio("Nombre vacio");
			}
			if(familia.getEdadMin() < 0 || familia.getEdadMin() == null || familia.getEdadMin() > 50) {
				throw new ErrorServicio("Edad minima invalidad");
			}
			if(familia.getEdadMax() < 0 || familia.getEdadMin() == null || familia.getEdadMax() > 50) {
				throw new ErrorServicio("Edad maxima error");
			}
			if(familia.getNumHijos() < 0 || familia.getNumHijos() == null || familia.getNumHijos() > 20) {
				throw new ErrorServicio("Numero de hijos error");
			}
			
			familia.setUsuario(usuario);
			familiaRepository.save(familia);
		} catch (ErrorServicio e) {
			throw e;
		}
	}

	@Transactional
	public Familia searchFamiliaByUsuario(Usuario usuario) throws ErrorServicio {
		try {
			if (usuario == null) {
				throw new ErrorServicio("error");
			}
			Familia familia = familiaRepository.findByUsuario(usuario);
			return familia;
		} catch (ErrorServicio e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}
}
