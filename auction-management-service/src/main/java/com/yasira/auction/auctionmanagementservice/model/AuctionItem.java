package com.yasira.auction.auctionmanagementservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "auction_item")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuctionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @NotNull(message = "Item name cannot be null")
    @Size(min = 3, max = 200, message = "Item name must be between 3 and 200 characters")
    @Column(name = "item_name", nullable = false, length = 200)
    private String itemName;

    @Column(name = "item_description")
    private String itemDescription;

    @NotNull(message = "Auction Item created date cannot be null")
    @Temporal(TemporalType.DATE) // Specify precision for the date
    @Column(name = "item_created_date", nullable = false, updatable = false)
    private Date auctionItemCreatedDate;

    @NotNull(message = "Auction Item created date cannot be null")
    @Temporal(TemporalType.TIME) // Specify precision for the time
    @Column(name = "item_created_time", nullable = false, updatable = false)
    private LocalDateTime auctionItemCreatedTime;

    @Temporal(TemporalType.DATE) // Specify precision for the date
    @Column(name = "last_updated_date")
    private Date auctionItemLastUpdatedDate;

    @Temporal(TemporalType.TIME) // Specify precision for the time
    @Column(name = "last_updated_time")
    private LocalDateTime auctionItemLastUpdatedTime;

    @NotNull(message = "Starting price cannot be null")
    @Column(name = "starting_price", nullable = false)
    private BigDecimal itemStartingPrice;

    @Column(name = "sold_price")
    private BigDecimal itemSoldPrice;

    @NotNull(message = "Minimum bid increment cannot be null")
    @Column(name = "min_bid_increasing_price", nullable = false)
    private BigDecimal minBidIncreasingPrice;

    @NotNull(message = "Sold status cannot be null")
    @Column(name = "is_sold", nullable = false)
    private Boolean isSold = false;

    @NotNull(message = "Category cannot be null")
    @Column(name = "category", nullable = false)
    private String category;

    @ManyToOne
    @JoinColumn(name = "auction_id", referencedColumnName = "auction_id", nullable = false)
    private Auction auction;

    @ManyToOne
    @JoinColumn(name = "winner_id", referencedColumnName = "bidder_id")
    private Bidder winner;

}
