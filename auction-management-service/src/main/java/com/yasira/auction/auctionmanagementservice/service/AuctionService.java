package com.yasira.auction.auctionmanagementservice.service;

import com.yasira.auction.auctionmanagementservice.dto.AuctionRequestDTO;
import com.yasira.auction.auctionmanagementservice.dto.AuctionResponseDTO;
import com.yasira.auction.auctionmanagementservice.model.Auction;
import com.yasira.auction.auctionmanagementservice.repository.AuctionRepository;
import com.yasira.auction.auctionutils.TimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuctionService {

    private final AuctionRepository auctionRepository;

    public AuctionResponseDTO createAuction(AuctionRequestDTO auctionRequest) {

        Auction auction = Auction.builder()
                .auctionTitle(auctionRequest.auctionTitle())
                .auctionDescription(auctionRequest.auctionDescription())
                .auctionCreatedDate(auctionRequest.auctionCreatedDate())
                .auctionCreatedTime(auctionRequest.auctionCreatedTime())
                .auctionDate(auctionRequest.auctionDate())
                .unixStartingTime(TimeUtil.toUnixTime(auctionRequest.unixStartingTime()))
                .unixEndingTime(TimeUtil.toUnixTime(auctionRequest.unixEndingTime()))
                .auctionStatus(auctionRequest.auctionStatus())
                .auctionLastUpdatedDate(null)
                .auctionLastUpdatedTime(null)
                .auctionItems(new ArrayList<>())
                .isPublished(auctionRequest.isPublished())
                .seller(auctionRequest.seller())
                .build();


        Auction createdAuction = auctionRepository.save(auction);
        log.info("Product created successfully");

        return new AuctionResponseDTO(
                createdAuction.getAuctionId(),
                createdAuction.getAuctionTitle(),
                createdAuction.getAuctionDescription(),
                createdAuction.getAuctionDate(),
                TimeUtil.fromUnixTime(createdAuction.getUnixStartingTime()),
                TimeUtil.fromUnixTime(createdAuction.getUnixEndingTime()),
                createdAuction.getIsPublished(),
                createdAuction.getAuctionStatus(),
                createdAuction.getSeller()
        );
    }

//    public AuctionResponseDTO updateAuction(AuctionRequestDTO auctionRequest) {}

    public List<AuctionResponseDTO> getAllAuctions() {
        return auctionRepository.findAll()
                .stream()
                .map(auction -> new AuctionResponseDTO(
                        auction.getAuctionId(),
                        auction.getAuctionTitle(),
                        auction.getAuctionDescription(),
                        auction.getAuctionDate(),
                        TimeUtil.fromUnixTime(auction.getUnixStartingTime()),
                        TimeUtil.fromUnixTime(auction.getUnixEndingTime()),
                        auction.getIsPublished(),
                        auction.getAuctionStatus(),
                        auction.getSeller()
                ))
                .toList();
    }
}
