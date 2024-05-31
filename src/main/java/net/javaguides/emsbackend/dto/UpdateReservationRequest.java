package net.javaguides.emsbackend.dto;

import lombok.*;
import net.javaguides.emsbackend.config.SearchClass;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateReservationRequest implements Dto{

    private SearchClass searchClass;
    private ReservationDto updatedReservationDto;
}
