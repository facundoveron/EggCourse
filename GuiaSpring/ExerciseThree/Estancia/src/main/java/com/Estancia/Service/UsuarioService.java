package com.Estancia.Service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.Estancia.Entities.Usuario;
import com.Estancia.Error.ErrorServicio;
import com.Estancia.Repository.UsuarioRepository;
import com.Estancia.PasswordEncoder;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		if (usuario != null) {
			List<GrantedAuthority> permissions = new ArrayList<>();
			GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRole().toString());
			permissions.add(p);
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpSession session = attr.getRequest().getSession(true);
			session.setAttribute("usuario", usuario);
			return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getClave(),
					permissions);
		} else {
			return null;
		}
	}

	@Transactional
	public Usuario registrar(Usuario usuario) throws ErrorServicio {
		try {
			if (usuario.getEmail().trim().isEmpty() || usuario.getEmail() == null) {
				throw new ErrorServicio("Email vacio o nulo");
			}
			if (usuario.getAlias().trim().isEmpty() || usuario.getAlias() == null) {
				throw new ErrorServicio("Alias vacio o nulo");
			}
			if (usuario.getRole() == null) {
				throw new ErrorServicio("Rol nulo");
			}
			if (usuario.getClave().trim().isEmpty() || usuario.getClave() == null) {
				throw new ErrorServicio("Clave vacia o nula");
			}

			Usuario user = usuarioRepository.findByEmail(usuario.getEmail());
			if (user != null) {
				throw new ErrorServicio("Este email ya esta registrado");
			}

			if (usuario.getFechaBaja() != null) {
				throw new ErrorServicio("Este usuario esta dado de baja");
			}

			usuario.setClave(generatePassword(usuario.getClave()));
			usuario.setFechaAlta(new Date());
			return usuarioRepository.save(usuario);
		} catch (ErrorServicio e) {
			throw e;
		}
	}

	@Transactional
	public String generatePassword(String password) {
		password = PasswordEncoder.encriptPassword(password);
		return password;
	}

	@Transactional
	public Boolean role(String email) throws ErrorServicio{
		try {
			Usuario usuario = searchByEmail(email);
			return usuario.getRole().toString().equals("FAMILIA");
		} catch (ErrorServicio e) {
			throw e;
		}
	}
	
	@Transactional
	public Boolean roleCliente(String email) throws ErrorServicio{
		try {
			Usuario usuario = searchByEmail(email);
			return usuario.getRole().toString().equals("CLIENTE");
		} catch (ErrorServicio e) {
			throw e;
		}
	}

	@Transactional
	public Usuario searchByEmail(String email) throws ErrorServicio {
		try {
			if (email.trim().isEmpty() || email == null) {
				throw new ErrorServicio("email null");
			}
			Usuario usuario = usuarioRepository.findByEmail(email);
			return usuario;
		} catch (ErrorServicio e) {
			throw e;
		} catch (NullPointerException e) {
			throw new ErrorServicio("error de servicio");
		}
	}
	
}
