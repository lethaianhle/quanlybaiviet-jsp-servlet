package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.utils.HttpUtil;
import com.laptrinhjavaweb.utils.SessionUtil;

@WebServlet("/api/admin/new")
public class NewAPI extends HttpServlet {
	
	@Inject
	private INewService newService;

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		ObjectMapper mapper = new ObjectMapper();
		
		NewModel newModel = HttpUtil.of(req.getReader()).toModel(NewModel.class);
		UserModel userLoggedIn = (UserModel) SessionUtil.getInstance().getValue(req, "userLoggedIn");
		newModel.setCreatedBy(userLoggedIn.getUserName());
		newModel = newService.create(newModel);
		mapper.writeValue(resp.getOutputStream(), newModel);
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		
		NewModel newModel = HttpUtil.of(req.getReader()).toModel(NewModel.class);
		UserModel userLoggedIn = (UserModel) SessionUtil.getInstance().getValue(req, "userLoggedIn");
		newModel.setModifiedBy(userLoggedIn.getUserName());
		newModel = newService.update(newModel);
		
		mapper.writeValue(resp.getOutputStream(), newModel);	
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		
		NewModel newModel = HttpUtil.of(req.getReader()).toModel(NewModel.class);
		newService.delete(newModel.getIds());
		
		mapper.writeValue(resp.getOutputStream(), "{}");
		
	}

}






























