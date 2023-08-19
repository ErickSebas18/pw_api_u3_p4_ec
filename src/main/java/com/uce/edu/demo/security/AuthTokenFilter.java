package com.uce.edu.demo.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtils jwtUtils;
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthTokenFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		String jwt = this.parseJwt(request);
		if (jwt != null && this.jwtUtils.validateJwtToken(jwt)) {
			// Como es valido el token le voy autenticar
			String nombre = this.jwtUtils.getUsernameFromJwtToken(jwt);

			// le autenticamos
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(nombre, null,
					new ArrayList<>());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			//Seteamos la autenticacion en la sesión
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		}catch(Exception e) {
			LOG.error("No se puedo realizar la autenticación con el token enviado {}",e.getMessage());
		}
		
		filterChain.doFilter(request, response);
	}

	private String parseJwt(HttpServletRequest request) {
		String valorCompleto = request.getHeader("Authorization");
		if (StringUtils.hasText(valorCompleto) && valorCompleto.startsWith("Bearer ")) {
			return valorCompleto.substring(7, valorCompleto.length());
		}
		return null;
	}

}
