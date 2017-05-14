package netctoss.controller.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.support.RequestPartServletServerHttpRequest;
import org.springframework.web.servlet.HttpServletBean;

import netctoss.controller.dao.AdminDAO;
import netctoss.controller.entity.Admin;
import netctoss.controller.util.ImageUtil;

@Controller
public class LoginController {
	@Resource(name="adminDAO")
	private AdminDAO dao;
	
  @RequestMapping("/toLogin.do")
  public String toLogin(){
	 //System.out.println("toLogin...");
	  return "login";
  }
	//重定向
  @RequestMapping("/login.do")
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException{
	  System.out.println("login.do");
	  Admin admin = null;
	  //读取账号密码
	  String adminCode = request.getParameter("adminCode");
        System.out.println(adminCode);
	  String pwd = request.getParameter("pwd");	
	   System.out.println(pwd);

	   //绑定session值
	   HttpSession ss = request.getSession();
	      admin = dao.findByAdminCode(adminCode); 
	   if(admin==null){
		   request.setAttribute("login", "不好意思,亲...账号错误");
		   return "login";
	   }else if (admin.getPassword().equals(pwd)){
			   ss.setAttribute("admin", admin);
			   //登录成功
		     return "redirect:toIndex.do";
		   }else {
			   request.setAttribute("login", "不好意思,亲..密码错误");
			  
		   }

	       return "login"; 
		 
	   }
	   
	  
  @RequestMapping("/createImg.do")
	public void checkcode(){
		//生成验证码的代码
	  
	  
	  
	  
	  
	  
	}
  
  
  @RequestMapping("/toIndex.do")
  public String toIndex(){
	  return "index";
  }
  
  @RequestMapping("index.do")
  public String toFee(){
	  System.out.println(1);
	  return "toFee";
  }
  
  @RequestMapping("/toFind.do")
  public String Fee(HttpServletRequest req, HttpServletResponse res) throws IOException{
	
	  
	  return null;
		//查询所有的资费


  }
  
  
}
