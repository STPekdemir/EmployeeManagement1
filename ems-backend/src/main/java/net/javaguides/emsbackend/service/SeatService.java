package net.javaguides.emsbackend.service;

import net.javaguides.emsbackend.dto.SeatDto;

import java.util.List;

public interface SeatService {

    SeatDto createSeat(SeatDto SeatDto);




   List<SeatDto> getAllSeats();

   void deleteSeat(Long seatNo);


}
