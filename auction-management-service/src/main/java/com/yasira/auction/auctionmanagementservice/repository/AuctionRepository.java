package com.yasira.auction.auctionmanagementservice.repository;

import com.yasira.auction.auctionmanagementservice.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
}
