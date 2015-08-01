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

import br.com.reserva.aerea.bean.LoginBean;

@WebFilter(urlPatterns={"/xhtml/private/*"})
public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Captura o ManagedBean chamado “usuarioMB”

		LoginBean usuarioMB = (LoginBean) ((HttpServletRequest) request)
				.getSession().getAttribute("loginBean");

		// Verifica se nosso ManagedBean ainda não //foi instanciado ou caso a
		// //variável loggedIn seja false, assim saberemos que // o usuário não
		// está logado
		if (usuarioMB == null || !usuarioMB.isLoggedUsuario()) {
			 HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
			String contextPath	= httpServletRequest.getContextPath();
			String servletPath = httpServletRequest.getServletPath();

			// Redirecionamos o usuário imediatamente //para a página de
			// login.xhtml
			httpServletRequest.getSession().setAttribute("redirectTo", servletPath);
			((HttpServletResponse) response).sendRedirect(contextPath
					+ "/xhtml/login.xhtml");

		} else {
			// Caso ele esteja logado, apenas deixamos
			// que o fluxo continue
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}