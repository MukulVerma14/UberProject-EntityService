package com.example.uberprojectentityservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="booking_review")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "booking"})
public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;

    private Double rating;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking;

    @Override
    public String toString() {
        return "Review :" + this.content + " " + "booking :" + (this.booking != null ? this.booking.getId() : "null") + " " + this.rating + " " + this.createdAt;
    }
}
