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
@Table(name = "seller")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long sellerId;

    @NotNull(message = "Seller name cannot be null")
    @Size(min = 3, max = 100, message = "Seller name must be between 3 and 100 characters")
    @Column(name = "name", nullable = false, length = 100)
    private String sellerName;

    @NotNull(message = "Seller email cannot be null")
    @Email(message = "Seller email should be a valid email address")
    @Column(name = "email", nullable = false, unique = true)
    private String sellerEmail;

    @NotNull(message = "Seller phone cannot be null")
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Seller contact number should be a valid phone number")
    @Column(name = "contact_number", nullable = false, length = 15)
    private String sellerContactNumber;

    @Column(name = "image_url")
    private String sellerImageUrl;
}
