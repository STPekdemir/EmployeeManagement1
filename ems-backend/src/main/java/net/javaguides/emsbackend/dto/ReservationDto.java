package net.javaguides.emsbackend.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationDto implements Dto{
  //  private Long id;
    private Date reservationDate;
    private EmployeeDto employee;
   // private Boolean isActive;
    private SeatDto seat;

}
