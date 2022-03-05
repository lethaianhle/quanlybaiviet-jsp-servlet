package com.laptrinhjavaweb.controller.web;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.FormUtil;
import com.laptrinhjavaweb.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang_chu", "/login", "/logout", "/registration" })
public class WebHomeController extends HttpServlet {
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private IUserService userService;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	private static final long serialVersionUID = 2686801510274002166L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		//if user request to login
		if(action != null && action.equals("login")) {
			//set notification response if have
			String message = req.getParameter("message");
			if(message != null) {
				req.setAttribute("message", resourceBundle.getString(message));
			}
			// redirect to login form
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
			dispatcher.forward(req, resp);
			
			// if user request to logout
		} else if (action != null && action.equals("logout")) {
			// remove session and redirect to trangchu
			SessionUtil.getInstance().removeValue(req, "userLoggedIn");
			resp.sendRedirect(req.getContextPath() + "/trang_chu");
			
			//if user want to resgister
		}	else if(action != null && action.equals("registration")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/registration.jsp");
			dispatcher.forward(req, resp);
			
		} else {
			List<CategoryModel> listCategory = categoryService.findAll();
			req.setAttribute("listCategory", listCategory);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/home.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		// if user submit login
		if(action != null && action.equals("login")) {
			UserModel user = FormUtil.toModel(UserModel.class, req);  // FormUtil auto mapping data from request to model
			user.setStatus(1);
			user = userService.findByUserAndPassAndStatus(user.getUserName(), user.getPassword(), user.getStatus()); 
			// redirect by role
			if(user != null) {
				SessionUtil.getInstance().putValue(req, "userLoggedIn", user);
				if(user.getRole().getRoleCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/trang_chu");
				} else if(user.getRole().getRoleCode().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath() + "/admin/trang_chu");
				}
				
			} else {
				resp.sendRedirect(req.getContextPath() + "/login?action=login&message=loginFail"); //login fail
			}
			
			// if user submit data for registration	
		} else if(action != null && action.equals("registration")) {
			UserModel user = FormUtil.toModel(UserModel.class, req);
			UserModel userExited = userService.findByUserName(user.getUserName());
			
			// check if there is any same username in db?
			if(userExited != null) {
				req.setAttribute("message", resourceBundle.getString("registerFail"));
				RequestDispatcher dispatcher = req.getRequestDispatcher("/views/registration.jsp");
				dispatcher.forward(req, resp);
			} else {
				UserModel newUser = userService.registration(user); 
				SessionUtil.getInstance().putValue(req, "userLoggedIn", newUser);
				resp.sendRedirect(req.getContextPath() + "/trang_chu");
			}
			
		}
		
	}
	
	
	
	

}























