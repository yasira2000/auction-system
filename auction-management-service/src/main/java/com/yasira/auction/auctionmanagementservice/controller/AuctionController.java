package com.yasira.auction.auctionmanagementservice.controller;


import com.yasira.auction.auctionmanagementservice.dto.ApiResponse;
import com.yasira.auction.auctionmanagementservice.dto.AuctionRequestDTO;
import com.yasira.auction.auctionmanagementservice.dto.AuctionResponseDTO;
import com.yasira.auction.auctionmanagementservice.service.AuctionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auctions")
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionService auctionService;

    @PostMapping
    public ResponseEntity<?> createAuction(@Valid @RequestBody AuctionRequestDTO auctionRequestDTO) {
        AuctionResponseDTO auctionResponseDTO = auctionService.createAuction(auctionRequestDTO);
        URI location = URI.create("/api/v1/products/" + auctionResponseDTO.auctionId());
        return ResponseEntity.created(location)
                .body(new ApiResponse<>(
                        true,
                        "Auction created successfully",
                        auctionResponseDTO
                ));
    }

    @GetMapping
    public ResponseEntity<?> getAllAuctions() {
        List<AuctionResponseDTO> auctionsList = auctionService.getAllAuctions();
        return ResponseEntity
                .ok(new ApiResponse<>(
                        true,
                        "Auction created successfully",
                        auctionsList
                ));
    }

}
