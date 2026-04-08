package com.innova.rewards.service;

import com.innova.rewards.dto.RewardResponseDTO;
import com.innova.rewards.model.CustomerPurchaseInfo;
import com.innova.rewards.repo.RewardRepoImpl;
import com.innova.rewards.util.RewardsUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class RewardServiceImpl {
    @Autowired
    public RewardRepoImpl repo;


    public List<CustomerPurchaseInfo> getAllPurchase() {
        return repo.getAllCustomerPurchases();


    }

    public void addCustomerPurchase(CustomerPurchaseInfo purchaseInfo) {
        repo.addCustomerPurchase(purchaseInfo);

    }


    public CustomerPurchaseInfo getCustomerPurchase(String customerId) {

        return repo.getCustomerPurchase(customerId);
    }

    public List<RewardResponseDTO> getAllRewards() {
        List<CustomerPurchaseInfo> transactions = repo.getAllCustomerPurchases();

        // Group by customer
        Map<String, List<CustomerPurchaseInfo>> customerMap =
                transactions.stream().collect(Collectors.groupingBy(CustomerPurchaseInfo::getCustomerId));

        List<RewardResponseDTO> responseList = new ArrayList<>();

        for (String customerId : customerMap.keySet()) {
            Map<String, Integer> monthlyPoints = new HashMap<>();
            int totalPoints = 0;

            for (CustomerPurchaseInfo t : customerMap.get(customerId)) {
                int points = RewardsUtility.calculatePoints(t.getPurchaseAmount());

                String month = t.getPurchaseDate().getMonth().toString();

                monthlyPoints.put(month,
                        monthlyPoints.getOrDefault(month, 0) + points);

                totalPoints += points;
            }

            responseList.add(new RewardResponseDTO(customerId, monthlyPoints, totalPoints));
        }

        return responseList;
    }



}
