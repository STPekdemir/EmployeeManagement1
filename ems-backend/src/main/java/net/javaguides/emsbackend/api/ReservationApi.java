package net.javaguides.emsbackend.api;

import net.javaguides.emsbackend.config.SearchClass;
import net.javaguides.emsbackend.dto.Dto;
import net.javaguides.emsbackend.dto.ReservationDto;
import net.javaguides.emsbackend.dto.UpdateReservationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ReservationApi {
    @PostMapping
    ResponseEntity<Dto> createRandevu(@RequestBody ReservationDto reservationDto);

    @GetMapping("/search")
    ResponseEntity<List<? extends Dto>> searchReservation(@RequestBody SearchClass searchClass);

    @GetMapping("/{randevuId}")
    ResponseEntity<ReservationDto> getRandevuById(@PathVariable Long randevuId);

    @GetMapping
    ResponseEntity<List<? extends Dto>> getAllRandevular();

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    ResponseEntity<? extends Dto> update(@RequestBody UpdateReservationRequest updateRequest);

    @DeleteMapping("/deleteByUsername")
    ResponseEntity<String> deleteRandevuByUsername(@RequestBody SearchClass searchClass);
}
