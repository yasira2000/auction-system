package com.yasira.auction.auctionmanagementservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bidder")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bidder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bidder_id")
    private Long bidderId;

    @NotNull(message = "Bidder name cannot be null")
    @Size(min = 3, max = 100, message = "Bidder name must be between 3 and 100 characters")
    @Column(name = "name", nullable = false, length = 100)
    private String bidderName;

    @NotNull(message = "Bidder email cannot be null")
    @Email(message = "Bidder email should be a valid email address")
    @Column(name = "email", nullable = false, unique = true)
    private String bidderEmail;

    @NotNull(message = "Bidder phone cannot be null")
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Bidder contact number should be a valid phone number")
    @Column(name = "contact_number", nullable = false, length = 15)
    private String bidderContactNumber;

    @Column(name = "image_url")
    private String bidderImageUrl;

}
