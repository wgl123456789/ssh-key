package interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class SessionInterceptor implements HandlerInterceptor{



	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
	     System.out.println("preHandle()");
	         //获取session看没有那个值     
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("admin");
			if(obj==null){
				response.sendRedirect("toLogin.do");
				return false;
			}
			
		
		return true;

	}	
}
