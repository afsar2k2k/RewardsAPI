package com.innova.rewards.repo;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import com.innova.rewards.model.CustomerPurchaseInfo;
import org.springframework.stereotype.Repository;

import com.innova.rewards.model.RewardInfo;

@Repository
public class RewardRepoImpl {


	List<CustomerPurchaseInfo> rewards = null;

	public RewardRepoImpl() {

		 // populate test data with customer rewards

        CustomerPurchaseInfo purchase1 = new CustomerPurchaseInfo("C001",  120.00, LocalDate.of(2026, 1, 1));
        CustomerPurchaseInfo purchase2 = new CustomerPurchaseInfo("C002",   80.00, LocalDate.of(2026, 1, 2));
        CustomerPurchaseInfo purchase3 = new CustomerPurchaseInfo("C003",   150.00, LocalDate.of(2026, 1, 3));

        CustomerPurchaseInfo purchase4 = new CustomerPurchaseInfo("C001",  100.00, LocalDate.of(2026, 2, 11));
        CustomerPurchaseInfo purchase5 = new CustomerPurchaseInfo("C002",   600.00, LocalDate.of(2026, 2, 21));
        CustomerPurchaseInfo purchase6 = new CustomerPurchaseInfo("C003",   700.00, LocalDate.of(2026, 2, 13));

        CustomerPurchaseInfo purchase7 = new CustomerPurchaseInfo("C001",  200.00, LocalDate.of(2026, 3, 21));
        CustomerPurchaseInfo purchase8 = new CustomerPurchaseInfo("C002",   40.00, LocalDate.of(2026, 3, 22));
        CustomerPurchaseInfo purchase9 = new CustomerPurchaseInfo("C003",   50.00, LocalDate.of(2026, 3, 25));

        rewards = List.of(purchase1, purchase2, purchase3, purchase4, purchase5, purchase6, purchase7, purchase8, purchase9);

    }

	
	
	
	public List<CustomerPurchaseInfo> getAllCustomerPurchases() {
		return rewards;
	}

	
	
	public void addCustomerPurchase(CustomerPurchaseInfo purchaseInfo) {
		rewards.add(purchaseInfo);

	}


	public CustomerPurchaseInfo getCustomerPurchase(String id) {
		for (CustomerPurchaseInfo customerPurchaseInfo : rewards) {
            String customerId = customerPurchaseInfo.getCustomerId();
			if (customerId.equalsIgnoreCase(id)) {
				return customerPurchaseInfo;
			}
		}
        // not found
		return null;
	}

}
