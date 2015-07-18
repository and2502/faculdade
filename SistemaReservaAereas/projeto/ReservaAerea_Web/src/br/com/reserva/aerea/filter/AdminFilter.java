package br.com.reserva.aerea.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.reserva.aerea.beans.LoginBean;

@WebFilter(urlPatterns={"/xhtml/admin/*"})
public class AdminFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		LoginBean usuarioMB = (LoginBean) ((HttpServletRequest) request)
				.getSession().getAttribute("loginBean");

		if (usuarioMB != null && usuarioMB.isAdminUsuario()) {
			chain.doFilter(request, response);

		} else if(usuarioMB != null && usuarioMB.isLoggedUsuario()){
			((HttpServletResponse) response).sendError(403, "Usuario não tem permissão de acesso a esse recurso!");
		}else{
			HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
			String contextPath	= httpServletRequest.getContextPath();
			String servletPath = httpServletRequest.getServletPath();
			
			httpServletRequest.getSession().setAttribute("redirectTo", servletPath);
			request.setAttribute("msgPermissionDenied", "Usuario não tem permissão de acessar recursos administrativos!");
			((HttpServletResponse) response).sendRedirect(contextPath
					+ "/xhtml/login.xhtml");
		}
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
}