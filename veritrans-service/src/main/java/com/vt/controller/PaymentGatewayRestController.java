package com.vt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vt.dao.PaymentGatewayDao;
import com.vt.entity.VTServices;

@RestController
@RequestMapping("vtpay/api")
public class PaymentGatewayRestController {

	@Autowired
	PaymentGatewayDao paymentGatewayDao;

	@RequestMapping(value = { "/list", "" }, method = RequestMethod.GET)
	public ResponseEntity<List<VTServices>> services(@RequestParam(required = false, defaultValue = "1") String page, @RequestParam(required=false,defaultValue="ASC")String sortByRating) {
		
		List<VTServices> serviceList = paymentGatewayDao.services(Integer.parseInt(page),sortByRating);

		if (serviceList.isEmpty()) {
			return new ResponseEntity<List<VTServices>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<VTServices>>(serviceList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<List<VTServices>> searchVTServices(@RequestParam(required = false) String name,
			@RequestParam(required = false, defaultValue = "1") String page, @RequestParam(required=false,defaultValue="ASC")String sortByRating) {
		
		List<VTServices> serviceList = new ArrayList<>();

		if (StringUtils.isEmpty(name)) {
			serviceList = paymentGatewayDao.services(Integer.parseInt(page),sortByRating);
		}
		serviceList = paymentGatewayDao.findByName(name,Integer.parseInt(page),sortByRating);

		if (serviceList.isEmpty()) {
			return new ResponseEntity<List<VTServices>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<VTServices>>(serviceList, HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<Integer>
	 */
	@ResponseBody
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public ResponseEntity<Integer> getTotalPlacesCount() {

		Integer noOfServices = paymentGatewayDao.count();

		if (noOfServices == 0) {
			return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Integer>(noOfServices, HttpStatus.OK);
	}
	
	/**
	 * @param e
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> errorHandler(Exception e) {
		System.out.println("In exception handler..");
		e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
