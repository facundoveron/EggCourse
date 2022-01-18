package com.Estancia.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Estancia.Entities.Casa;
import com.Estancia.Error.ErrorServicio;
import com.Estancia.Repository.CasaRepository;

@Service
public class CasaService {

	@Autowired
	private CasaRepository casaRepository;

	@Transactional
	public Collection<String> listCountryHouse() {
		List<String> houseList = null;
		try {
			houseList = casaRepository.findAll().stream().map(country -> country.getPais())
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw e;
		}

		return houseList;
	}

	@Transactional
	public Collection<Casa> listAllCasa() {
		try {
			List<Casa> allHouse = casaRepository.findAll().stream().filter(x -> x.getAlquilada() != false)
					.collect(Collectors.toList());
			return allHouse;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public void registrar(Casa casa) throws ErrorServicio {
		try {
			if (casa.getCalle().trim().isEmpty() || casa.getCalle() == null) {
				throw new ErrorServicio("calle vacia");
			}
			if (casa.getNumero() < 0 || casa.getNumero() == null) {
				throw new ErrorServicio("Numero invalido");
			}
			if (casa.getCodPostal().trim().isEmpty() || casa.getCodPostal() == null) {
				throw new ErrorServicio("Codigo Postal no valido");
			}
			if (casa.getCiudad().trim().isEmpty() || casa.getCiudad() == null) {
				throw new ErrorServicio("Ciudad invalidad");
			}
			if (casa.getPais().trim().isEmpty() || casa.getPais() == null) {
				throw new ErrorServicio("Pais invalido");
			}
			if (casa.getFechaDesde() == null || casa.getFechaDesde().before(casa.getFechaHasta())) {
				throw new ErrorServicio("Fecha desde invalidad");
			}
			if (casa.getFechaDesde() == null) {
				throw new ErrorServicio("Fecha hasta invalidad");
			}
			if (casa.getMinDias() < 0 || casa.getMinDias() > casa.getMaxDias()) {
				throw new ErrorServicio("Minimo de dias invalido");
			}
			if (casa.getMaxDias() < 0) {
				throw new ErrorServicio("Maximo de dias invalido");
			}
			if (casa.getPrecio() < 0) {
				throw new ErrorServicio("precio invalido");
			}
			if (casa.getTipoVivienda().trim().isEmpty() || casa.getCalle() == null) {
				throw new ErrorServicio("calle vacia");
			}

			casaRepository.save(casa);
		} catch (IllegalArgumentException e) {
			throw new ErrorServicio("error Date");
		} catch (ErrorServicio e) {
			throw e;
		}
	}

	@Transactional
	public void alquilar(String id) throws ErrorServicio {
		try {
			Casa casa = searchById(id);
			if(casa == null) {
				throw new ErrorServicio("casa no registrada");
			}
			casa.setAlquilada(false);
			casaRepository.save(casa);
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional
	public Casa searchById(String id) throws ErrorServicio {
		try {
			if (id.trim().isEmpty() || id == null) {
				throw new ErrorServicio("Error id");
			}
			return casaRepository.findById(id).get();
		} catch (NullPointerException e) {
			return null;
		} catch (ErrorServicio e) {
			return null;
		}
	}
}
