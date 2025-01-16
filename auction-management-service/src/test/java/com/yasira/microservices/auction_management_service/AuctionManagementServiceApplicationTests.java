package com.yasira.microservices.auction_management_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class AuctionManagementServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
