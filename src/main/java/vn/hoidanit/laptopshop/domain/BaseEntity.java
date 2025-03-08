package vn.hoidanit.laptopshop.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@MappedSuperclass  // Makes these fields available in all entities extending this class
@EntityListeners(AuditingEntityListener.class) 
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    // Getters
    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
    public String getFormattedCreatedAt() {
        return formatDateTime(createdAt);
    }

    public String getFormattedUpdatedAt() {
        return formatDateTime(updatedAt);
    }

    private String formatDateTime(Instant instant) {
        if (instant == null) return "N/A";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                                       .withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
}

