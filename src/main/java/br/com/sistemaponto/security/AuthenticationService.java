package br.com.sistemaponto.security;

import br.com.sistemaponto.model.domain.Usuario;
import br.com.sistemaponto.repository.UsuarioRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {
	
	private final UsuarioRepository usuarioRepository;

	public AuthenticationService(
			UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
		return usuarioRepository.findByLogin(login)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found.", login)));
	}

	public Usuario getUsuario() {
		 return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	}
}
