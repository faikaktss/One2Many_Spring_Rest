package com.faik.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Controller.IHomeController;
import com.faik.Services.IHomeServices;
import com.faik.dto.DtoHome;

@RestController
@RequestMapping("/rest/api/home")
public class HomeController implements IHomeController {

	@Autowired
	private IHomeServices homeServices;
	
	@GetMapping(path = "/{id}")
	@Override
	public DtoHome findHomeById(@PathVariable(name="id") Long id) {
		return homeServices.findHomeById(id);
	}


}
