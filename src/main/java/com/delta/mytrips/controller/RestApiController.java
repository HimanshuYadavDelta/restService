package com.delta.mytrips.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.delta.mytrips.model.User;
import com.delta.mytrips.service.PnrService;
import com.websystique.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/booking")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired
	PnrService pnrService;



	// -------------------Retrieve Single User------------------------------------------

	@RequestMapping(value = "/pnr/{pnr}/firstName/{firstName}/lastName/{lastName}", method = RequestMethod.GET)
	public ResponseEntity<?> getPnr(@PathVariable("pnr") String pnr,@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName) {
		logger.info("Fetching User with pnr {}", pnr);
		User user = pnrService.findPnr(pnr, lastName, firstName );
		if (user == null) {
			logger.error("User with id {} not found.", pnr);
			return new ResponseEntity(new CustomErrorType("User with pnr " + pnr 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}


}