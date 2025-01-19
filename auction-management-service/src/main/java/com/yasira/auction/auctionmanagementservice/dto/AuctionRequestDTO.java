package com.yasira.auction.auctionmanagementservice.dto;

import com.yasira.auction.auctionenum.AuctionStatus;
import com.yasira.auction.auctionmanagementservice.model.AuctionItem;
import com.yasira.auction.auctionmanagementservice.model.Seller;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public record AuctionRequestDTO(
        @NotNull(message = "Title cannot be null")
        @Size(min = 3, max = 255, message = "Title must be between 3 and 255 characters")
        String auctionTitle,

        @Size(max = 500, message = "Description cannot exceed 500 characters")
        String auctionDescription,

        @NotNull(message = "Auction date cannot be null")
        @FutureOrPresent(message = "Auction date must be in the future")
        Date auctionDate,

        @NotNull(message = "Auction created date cannot be null")
        Date auctionCreatedDate,

        @NotNull(message = "Auction created time cannot be null")
        LocalDateTime auctionCreatedTime,

        @NotNull(message = "Auction starting time cannot be null")
        @Future(message = "Starting time must be in the future")
        LocalDateTime unixStartingTime,

        @NotNull(message = "Auction ending time cannot be null")
        @Future(message = "Ending time must be in the future")
        LocalDateTime unixEndingTime,

        Boolean isPublished,

        AuctionStatus auctionStatus,

        @NotNull(message = "Seller cannot be null")
        Seller seller) {
}
