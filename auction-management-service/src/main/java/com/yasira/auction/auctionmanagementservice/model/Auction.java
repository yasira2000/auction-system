package com.yasira.auction.auctionmanagementservice.model;

import com.yasira.auction.auctionenum.AuctionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "auction")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use identity for primary key generation
    @Column(name = "auction_id") // Custom column name
    private Long auctionId;

    @NotNull(message = "Title cannot be null") // Enforce not null constraint
    @Size(min = 3, max = 255, message = "Title must be between 3 and 255 characters") // String size validation
    @Column(name = "auction_title", nullable = false, unique = true) // Enforce unique constraint
    private String auctionTitle;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Column(name = "auction_description", length = 500)
    private String auctionDescription;

    @NotNull(message = "Auction date cannot be null")
    @Temporal(TemporalType.DATE) // Specify precision for the date
    @Column(name = "auction_date", nullable = false)
    private Date auctionDate;

    @NotNull(message = "Auction created date cannot be null")
    @Temporal(TemporalType.DATE) // Specify precision for the date
    @Column(name = "auction_created_date", nullable = false, updatable = false)
    private Date auctionCreatedDate;

    @NotNull(message = "Auction created date cannot be null")
    @Temporal(TemporalType.TIME) // Specify precision for the time
    @Column(name = "auction_created_time", nullable = false, updatable = false)
    private LocalDateTime auctionCreatedTime;

    @Temporal(TemporalType.DATE) // Specify precision for the date
    @Column(name = "last_updated_date")
    private Date auctionLastUpdatedDate;

    @Temporal(TemporalType.TIME) // Specify precision for the time
    @Column(name = "last_updated_time")
    private LocalDateTime auctionLastUpdatedTime;

    @NotNull(message = "Unix starting time cannot be null")
    @Column(name = "starting_time", nullable = false)
    private Long unixStartingTime;

    @NotNull(message = "Unix ending time cannot be null")
    @Column(name = "ending_time", nullable = false)
    private Long unixEndingTime;

    @NotNull(message = "Publish status cannot be null")
    @Column(name = "is_published", nullable = false)
    private Boolean isPublished = false;

    @Enumerated(EnumType.STRING) // Store Enum as a string in the database
    @Column(name = "status", nullable = false)
    private AuctionStatus auctionStatus = AuctionStatus.NOT_STARTED;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuctionItem> auctionItems;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "seller_id")
    private Seller seller;


}
