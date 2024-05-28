package net.javaguides.emsbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reservation_date")
    private Date reservationDate;


    @ManyToOne //(cascade = CascadeType.ALL)

    @JoinColumn(name = "user_name")

    private Employee employee;

    @ManyToOne //(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_no")
    private Seat seat;


    @Column (name = "is_active")
    private Boolean isActive;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;
    @CreationTimestamp
    @Column(name = "created_date")
    private Date createdDate;



}
