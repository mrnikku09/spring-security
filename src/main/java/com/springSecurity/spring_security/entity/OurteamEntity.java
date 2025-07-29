package com.springSecurity.spring_security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "cs_our_team")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OurteamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long team_id;

    @Column(name = "team_name", length = 255)
    private String teamName;

    @Column(name = "team_city", length = 255)
    private String teamCity;

    @Column(name = "team_image", length = 255)
    private String teamImage;

    @Column(name = "team_featured")
    private Integer teamFeatured;

    @Column(name = "team_status")
    private Integer teamStatus;

    @Column(name = "team_rating")
    private Integer teamRating;

    @Lob
    @Column(name = "team_desc")
    private String teamDesc;

    @Column(name = "team_email", length = 255)
    private String teamEmail;

    @Lob
    @Column(name = "team_meta_title")
    private String teamMetaTitle;

    @Lob
    @Column(name = "team_meta_keyword")
    private String teamMetaKeyword;

    @Lob
    @Column(name = "team_meta_desc")
    private String teamMetaDesc;

    @Column(name = "team_designation", length = 255)
    private String teamDesignation;

    @Column(name = "team_facebook_url", length = 255)
    private String teamFacebookUrl;

    @Column(name = "team_instagram_url", length = 255)
    private String teamInstagramUrl;

    @Column(name = "team_twitter_url", length = 255)
    private String teamTwitterUrl;

    @Column(name = "team_linkedin_url", length = 255)
    private String teamLinkedinUrl;

    @Column(name = "team_slug", length = 255)
    private String teamSlug;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
