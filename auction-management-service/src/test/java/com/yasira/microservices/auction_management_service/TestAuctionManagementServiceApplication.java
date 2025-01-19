package com.yasira.microservices.auction_management_service;

import com.yasira.auction.auctionmanagementservice.AuctionManagementServiceApplication;
import org.springframework.boot.SpringApplication;

public class TestAuctionManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(AuctionManagementServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
