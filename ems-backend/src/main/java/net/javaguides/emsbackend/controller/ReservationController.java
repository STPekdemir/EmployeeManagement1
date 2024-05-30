package net.javaguides.emsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.api.ReservationApi;
import net.javaguides.emsbackend.config.SearchClass;
import net.javaguides.emsbackend.dto.Dto;
import net.javaguides.emsbackend.dto.ErrorMessageDto;
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
public class ReservationController implements ReservationApi {

    @Autowired
    private ReservationService reservationService;


    public ResponseEntity<Dto> createRandevu( ReservationDto reservationDto) {
        try {
            ReservationDto createdRandevu = reservationService.createReservation(reservationDto);

            if (createdRandevu == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(createdRandevu, HttpStatus.CREATED);
        } catch (Exception e) {
            ErrorMessageDto errorMessageDto = new ErrorMessageDto();
            errorMessageDto.setMessage(e.getMessage());
            return new ResponseEntity<>(errorMessageDto, HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<List<? extends Dto>> searchReservation( SearchClass searchClass)  {

        try{
            List<ReservationDto> reservations = reservationService.searchReservation(searchClass);
            return ResponseEntity.ok(reservations);
        } catch (Exception e) {
            ErrorMessageDto errorMessageDto = new ErrorMessageDto();
            errorMessageDto.setMessage(e.getMessage());
            return new ResponseEntity<>(List.of(errorMessageDto), HttpStatus.BAD_REQUEST);
        }

    }



    public ResponseEntity<ReservationDto> getRandevuById( Long randevuId) {

        ReservationDto reservationDto = reservationService.getReservationById(randevuId);
        return ResponseEntity.ok(reservationDto);
    }


    public ResponseEntity<List<?extends Dto>> getAllRandevular() {
        try{
            List<ReservationDto> randevular = reservationService.getAllReservations();
            return ResponseEntity.ok(randevular);
        } catch (Exception e) {
            ErrorMessageDto errorMessageDto = new ErrorMessageDto();
            errorMessageDto.setMessage(e.getMessage());
            return new ResponseEntity<>(List.of(errorMessageDto), HttpStatus.BAD_REQUEST);
        }

    }


    public ResponseEntity<? extends Dto> update(UpdateReservationRequest updateRequest) {
        try{
            ReservationDto updatedRandevu = reservationService.updateReservation(updateRequest);
            return ResponseEntity.ok(updatedRandevu);
        } catch (Exception e) {
            ErrorMessageDto errorMessageDto = new ErrorMessageDto();
            errorMessageDto.setMessage(e.getMessage());
            return new ResponseEntity<>(errorMessageDto, HttpStatus.BAD_REQUEST);
        }

    }


    public ResponseEntity<String> deleteRandevuByUsername( SearchClass searchClass) {
        try{
            reservationService.deleteReservation(searchClass);
            return new ResponseEntity<String>("Delete successful",HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

}
