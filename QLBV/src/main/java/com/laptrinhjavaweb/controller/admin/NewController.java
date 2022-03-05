package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet("/admin/list_new")
public class NewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private INewService newService;
	
	@Inject
	private ICategoryService categoryService;

	public NewController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewModel model = FormUtil.toModel(NewModel.class, request);
		String view = "";
		if(model.getType().equals("list")) {
			Sorter sort = new Sorter(model.getSortName(), model.getSortBy());
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), sort);
			
			model.setListResult(newService.findAll(pageble));
			model.setTotalItem(newService.count());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));

			view = "/views/admin/new/list.jsp";
			
		} else if(model.getType().equals("edit")) {
			if(model.getNewId() != null) {
				model = newService.get(model.getNewId());
			} else {
				
			}
			
			List<CategoryModel> listCategory = categoryService.findAll();
			request.setAttribute("listCategory", listCategory);
			view = "/views/admin/new/edit.jsp";
		}
		
		request.setAttribute("model", model);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}

}
