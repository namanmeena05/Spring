package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;
import com.rays.form.AddForm;
import com.rays.form.UserForm;
import com.rays.service.UserServiceImpl;
import com.rays.util.DataUtility;

@Controller
@RequestMapping(value = "/ctl/User")
public class UserCtl {

	@Autowired
	public UserServiceImpl service;

	int pageNo = 1;
	int pageSize = 5;

	@ModelAttribute("form")
	public void preload(Model model) {

		List list = service.search(null, 0, 0);
		model.addAttribute("userList", list);

	}

	@GetMapping
	public String display(@ModelAttribute("form") UserForm form, Model m, @RequestParam(required = false) Long id) {

		if (id > 0) {

			UserDTO user = service.findByPk(id);

			if (user == null) {

				System.out.println("user null");

				return "UserView";

			} else {

				form.setFirstName(user.getFirstName());
				form.setLastName(user.getLastName());
				form.setLogin(user.getLogin());
				form.setPassword(user.getPassword());
				// form.setDob(DataUtility.stringToDate(user.getDob()));
				form.setAddress(user.getAddress());
				form.setId(user.getId());

				m.addAttribute("form", form);
				System.out.println("step1");
			}
		}
		System.out.println("user not null");

		return "UserView";

	}

	@PostMapping
	public String submit(@ModelAttribute("form") UserForm form, Model m) {

		UserDTO dto = new UserDTO();
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setDob(DataUtility.stringToDate(form.getDob()));
		dto.setAddress(form.getAddress());
		dto.setId(form.getId());

		m.addAttribute("form", form);
		System.out.println("step1");
		service.update(dto);
		return "UserView";
	}

	@GetMapping("search")
	public String display(@ModelAttribute("form") UserForm form, Model m) {

		UserDTO dto = new UserDTO();
		List list = service.search(dto, pageNo, pageSize);
		m.addAttribute("list", list);
		m.addAttribute("pageNo", pageNo);
		m.addAttribute("pageSize", pageSize);
		return "UserListView";

	}

	@GetMapping("AddUser")
	public String display(@ModelAttribute("form") AddForm form, Model m) {
		return "UserView";

	}

	@PostMapping("search")
	public String display(@ModelAttribute("form") UserForm form, @RequestParam(required = false) String operation,
			Model m) {

		System.out.println("method start display post");
		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();
		System.out.println(pageNo + "' " + pageSize);
		UserDTO dto = null;
		if (operation.equals("search")) {
			dto = new UserDTO();
			dto.setFirstName(form.getFirstName());
			dto.setUserId(form.getUserId());
		}

		else if (operation.equals("New")) {
			System.out.println("method add run");
			return "redirect:/UserRegister";

		}

		if (operation.equals("delete")) {
			if (form.getIds() != null && form.getIds().length > 0) {

				for (long id : form.getIds()) {
					dto = new UserDTO();
					dto.setId(id);
					service.delete(dto);
				}
			}
		}
		if (operation.equals("Next")) {
			pageNo++;
			System.out.println(pageNo + "' " + pageSize);
		}
		if(operation.equals("Previous")) {
			pageNo--;
		}

		List list = service.search(dto, pageNo, pageSize);
		m.addAttribute("list", list);
		return "UserListView";

	}

}