package net.javaguides.emsbackend.api;

import net.javaguides.emsbackend.dto.Dto;
import net.javaguides.emsbackend.dto.SeatDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SeatApi {

    @PostMapping
    ResponseEntity<Dto> createSeat(@RequestBody SeatDto seatDto);
    @GetMapping
    ResponseEntity<List<? extends Dto>> getAllSeats();

    @DeleteMapping("/{seatNo}")
    public ResponseEntity<String>deleteSeat(@PathVariable Long seatNo);
}
