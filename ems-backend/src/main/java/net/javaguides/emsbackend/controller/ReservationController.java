package net.javaguides.emsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.config.SearchClass;
import net.javaguides.emsbackend.dto.ReservationDto;
import net.javaguides.emsbackend.dto.UpdateReservationRequest;
import net.javaguides.emsbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/randevular")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationDto> createRandevu(@RequestBody ReservationDto reservationDto) {
        ReservationDto createdRandevu = reservationService.createReservation(reservationDto);
        return new ResponseEntity<>(createdRandevu, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ReservationDto>> searchReservation(@RequestBody SearchClass searchClass) {
        List<ReservationDto> reservations = reservationService.searchReservation(searchClass);
        return ResponseEntity.ok(reservations);
    }


    @GetMapping("/{randevuId}")
    public ResponseEntity<ReservationDto> getRandevuById(@PathVariable Long randevuId) {
        ReservationDto reservationDto = reservationService.getReservationById(randevuId);
        return ResponseEntity.ok(reservationDto);
    }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllRandevular() {
        System.out.println("getAllRandevular");
        List<ReservationDto> randevular = reservationService.getAllReservations();
        return ResponseEntity.ok(randevular);
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ReservationDto> update(@RequestBody UpdateReservationRequest updateRequest) {
       System.out.println("updateRequest");
        ReservationDto updatedRandevu = reservationService.updateReservation(updateRequest);
        return ResponseEntity.ok(updatedRandevu);
    }

    @DeleteMapping("/deleteByUsername")
    public ResponseEntity<Void> deleteRandevuByUsername(@RequestBody SearchClass searchClass) {
        reservationService.deleteReservation(searchClass);
        return ResponseEntity.noContent().build();
    }

}
