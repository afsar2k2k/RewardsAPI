package com.innova.rewards.controller;

import com.innova.rewards.dto.RewardResponseDTO;
import com.innova.rewards.model.CustomerPurchaseInfo;
import com.innova.rewards.service.RewardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController	
public class RewardsController {
	
	@Autowired
	private RewardServiceImpl service;
	
	
	@GetMapping("/get-all-rewards")
	public List<RewardResponseDTO> getAllRewards() {
		return service.getAllRewards();
		
	}
	
	@GetMapping("/get-customer-purchase/{customerId}")
	public
    CustomerPurchaseInfo getCustomerInfo(@PathVariable String customerId) {
		return service.getCustomerPurchase(customerId);
	}

	@PostMapping("add-customer-purchase")
	public
    CustomerPurchaseInfo addCustomerInfo(@RequestBody
                                CustomerPurchaseInfo customerPurchaseInfo) {
		service.addCustomerPurchase(customerPurchaseInfo);
		return service.getCustomerPurchase(customerPurchaseInfo.getCustomerId());
	}
}
