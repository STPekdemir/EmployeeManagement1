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
@Table(name = "Seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_no",unique = true)
    private Long seatNo;
/*
   @Column(columnDefinition = "boolean default  false")
    private Boolean isOccupied;
*/

    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;
    @CreationTimestamp
    @Column(name = "created_date")
    private Date createdDate;

}
