package net.javaguides.emsbackend.service.impl;


import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.SeatDto;
import net.javaguides.emsbackend.entity.Seat;
import net.javaguides.emsbackend.repository.SeatRepository;
import net.javaguides.emsbackend.service.SeatService;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SeatDto createSeat(SeatDto SeatDto) {

        Seat seat = modelMapper.map(SeatDto, Seat.class);
        Seat savedSeat = seatRepository.save(seat);

        return modelMapper.map(savedSeat, SeatDto.class);
    }


    @Override
    public List<SeatDto> getAllSeats() {
        List<Seat> seats = seatRepository.findAll();
        List<SeatDto> seatDtoList = seats.stream()
                .map(seat -> modelMapper.map(seat, SeatDto.class))
                .collect(Collectors.toList());
        return seatDtoList;
    }

    @Override
    public void deleteSeat(Long seatNo) {
        Optional<Seat> seatOptional = seatRepository.findById(seatNo);
        if (seatOptional.isEmpty()) {
            throw new RuntimeException("Seat not found with seatNo: " + seatNo);
        }


        seatRepository.deleteById(seatNo);

    }
}
