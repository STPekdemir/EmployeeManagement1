package net.javaguides.emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatDto implements Dto {

    private Long id;
    private Long seatNo;
   // private boolean isOccupied;
}
