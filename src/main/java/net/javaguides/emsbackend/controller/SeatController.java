package net.javaguides.emsbackend.controller;


import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.api.SeatApi;
import net.javaguides.emsbackend.dto.Dto;
import net.javaguides.emsbackend.dto.ErrorMessageDto;
import net.javaguides.emsbackend.dto.SeatDto;
import net.javaguides.emsbackend.entity.Seat;
import net.javaguides.emsbackend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;

@AllArgsConstructor
@RestController
@RequestMapping("/api/seats")
public class SeatController implements SeatApi {

    @Autowired
    private SeatService seatService;


    public ResponseEntity<Dto>createSeat( SeatDto seatDto){
        try{
            SeatDto createdSeat=seatService.createSeat(seatDto);

            return new ResponseEntity<>(createdSeat, HttpStatus.CREATED);
        }catch (Exception e){
            ErrorMessageDto errorMessageDto=new ErrorMessageDto();
            errorMessageDto.setMessage(e.getMessage());
            return new ResponseEntity<>(errorMessageDto,HttpStatus.BAD_REQUEST);
        }

    }




    public ResponseEntity<List<? extends Dto>> getAllSeats() {
        try {
            List<SeatDto> seats = seatService.getAllSeats();
            return new ResponseEntity<>(seats, HttpStatus.OK);
        } catch (Exception e) {
            ErrorMessageDto errorMessageDto = new ErrorMessageDto();
            errorMessageDto.setMessage(e.getMessage());
            return new ResponseEntity<>(List.of(errorMessageDto), HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<String>deleteSeat( Long seatNo){
        try{
            seatService.deleteSeat(seatNo);
            return new ResponseEntity<>("Seat deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }


    }




}
