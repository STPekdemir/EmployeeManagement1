package net.javaguides.emsbackend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.config.SearchClass;
import net.javaguides.emsbackend.dto.ReservationDto;
import net.javaguides.emsbackend.dto.UpdateReservationRequest;
import net.javaguides.emsbackend.entity.Reservation;
import net.javaguides.emsbackend.entity.Seat;
import net.javaguides.emsbackend.exception.SeatAlreadyBookedException;
import net.javaguides.emsbackend.repository.ReservationRepository;
import net.javaguides.emsbackend.repository.SeatRepository;
import net.javaguides.emsbackend.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public ReservationDto createReservation(ReservationDto reservationDto) {
        Long seatNo = reservationDto.getSeat().getSeatNo();
        Optional<Seat> seat = seatRepository.findBySeatNo(seatNo);
        if (!seat.isPresent()) {
            throw new RuntimeException("Seat not found with seatNo: " + seatNo);
        }
        String dateStr1 = reservationDto.getReservationDate().toString();

        // Define the input format
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

        // Define the output format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

        // Parse the date
        ZonedDateTime date = ZonedDateTime.parse(dateStr1, inputFormatter);

        // Format the date into the desired output format
        String formattedDate = date.format(outputFormatter);

        List<Reservation> reservations = reservationRepository.reservations(seatNo);
        List<Reservation> filteredR = reservations.stream()
                .filter(reservation -> reservation.getReservationDate().toString().equals(formattedDate)).toList();
        if (filteredR.size() > 0) {
            throw new SeatAlreadyBookedException("This seat is already booked");
        }
        List<Reservation> userReservations = reservationRepository.chechSameDayReservation(
                reservationDto.getEmployee().getUserName(), reservationDto.getReservationDate());
        if (userReservations.size() > 0) {
            throw new SeatAlreadyBookedException("You have already booked a seat for this day");
        }
        Reservation reservation = modelMapper.map(reservationDto, Reservation.class);
        Reservation savedReservation = reservationRepository.save(reservation);
        return modelMapper.map(savedReservation, ReservationDto.class);
    }

    @Override
    public List<ReservationDto> searchReservation(SearchClass searchClass) {
        return reservationRepository.findWithOptionalParameters(searchClass.getUserName(),
                searchClass.getSeatNo(), searchClass.getDate())
                .stream().map(reservation -> modelMapper.map(reservation, ReservationDto.class)).toList();
    }

    @Override
    public ReservationDto getReservationById(Long randevuId) {
        Optional<Reservation> optionalRandevu = reservationRepository.findById(randevuId);
        if (optionalRandevu.isPresent()) {
            Reservation reservation = optionalRandevu.get();
            return modelMapper.map(reservation, ReservationDto.class);
        }
        throw new RuntimeException("Randevu not found with id: " + randevuId);
    }

    @Override
    public List<ReservationDto> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(reservation -> modelMapper.map(reservation, ReservationDto.class)).toList();
    }

    @Override
    public ReservationDto updateReservation(UpdateReservationRequest updateRequest) {
        SearchClass searchClass = updateRequest.getSearchClass();
        ReservationDto updatedReservationDto = updateRequest.getUpdatedReservationDto();
        System.out.println(updateRequest);

        List<Reservation> currentReservation = reservationRepository.findWithOptionalParameters(
                searchClass.getUserName(), searchClass.getSeatNo(), searchClass.getDate());

        if (currentReservation.size()==0) {
            throw new RuntimeException("Reservation not found with given search criteria");
        }

        List<Reservation> wantedSeatReservations = reservationRepository.findWithOptionalParameters(
                null, updatedReservationDto.getSeat().getSeatNo(), updatedReservationDto.getReservationDate());

        if (wantedSeatReservations.size() > 0) {
            throw new SeatAlreadyBookedException("This seat is already booked");
        }

        Reservation reservation = currentReservation.get(0);
        reservation.setReservationDate(updatedReservationDto.getReservationDate());
        Seat wantedSeat= seatRepository.findById(updatedReservationDto.getSeat().getId()).get();
        reservation.setSeat(wantedSeat);


        Reservation updatedReservation = reservationRepository.save(reservation);
        return modelMapper.map(updatedReservation, ReservationDto.class);
    }

    @Override
    public void deleteReservation(SearchClass searchClass) {
        List<Reservation> optionalRandevu = reservationRepository.findWithOptionalParameters(searchClass.getUserName(),searchClass.getSeatNo(),searchClass.getDate());
        if (optionalRandevu.size()>0) {
            Reservation reservation = optionalRandevu.get(0);
            reservation.setIsActive(Boolean.FALSE);
            reservationRepository.save(reservation);
        } else {
            throw new RuntimeException("Randevu not found with userName: " + searchClass.getUserName());
        }
    }
}
