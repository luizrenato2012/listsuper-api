package br.com.lrsantos.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CorsFilter extends OncePerRequestFilter{
	
	private Logger log = LoggerFactory.getLogger(CorsFilter.class);
	
	@Autowired
	private ListSuperApiProperty apiProperty;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
	
		log.info("Origem permitida: " + apiProperty.getOrigemPermitida());
		res.setHeader("Access-Control-Allow-Origin", this.apiProperty.getOrigemPermitida());
		res.setHeader("Access-Control-Allow-Credentials", "true"); 
		
		if (req.getMethod().equals("OPTIONS") && this.apiProperty.getOrigemPermitida().equals(req.getHeader("Origin"))) {
			res.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
			res.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
			res.setHeader("Access-Control-Allow-Max-Age", "3600");
			
			res.setStatus(HttpServletResponse.SC_OK);
		} else {
			filterChain.doFilter(req, res);
		}
		
	}

}
