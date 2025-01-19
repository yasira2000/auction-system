package com.yasira.auction.auctionmanagementservice.dto;

import com.yasira.auction.auctionenum.AuctionStatus;
import com.yasira.auction.auctionmanagementservice.model.Seller;
import lombok.AllArgsConstructor;

import java.time.LocalTime;
import java.util.Date;


public record AuctionResponseDTO(
        Long auctionId,
        String auctionTitle,
        String auctionDescription,
        Date auctionDate,
        LocalTime auctionStartingTime,
        LocalTime auctionEndingTime,
        Boolean isPublished,
        AuctionStatus auctionStatus,
        Seller seller) {
}
