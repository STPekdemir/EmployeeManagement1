package net.javaguides.emsbackend.service;

import net.javaguides.emsbackend.config.SearchClass;
import net.javaguides.emsbackend.dto.ReservationDto;
import net.javaguides.emsbackend.dto.UpdateReservationRequest;

import java.util.List;

public interface ReservationService {
    ReservationDto createReservation(ReservationDto reservationDto);
    ReservationDto getReservationById(Long randevuId);
    List<ReservationDto> getAllReservations();

    ReservationDto updateReservation(UpdateReservationRequest updateRequest);
    // ReservationDto updateReservation(SearchClass searchClass, ReservationDto updatedReservationDto);
    void deleteReservation(SearchClass searchClass);

    List<ReservationDto> searchReservation(SearchClass searchClass);


}

