package net.javaguides.emsbackend.repository;

import net.javaguides.emsbackend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

   // List<Randevu> findByReservationDateAndIsActiveTrue(Date date);
  // Optional<Reservation>findByEmployee_UserName(String userName);
   boolean existsBySeatId(Long seatId);

    @Query(value = "SELECT * FROM reservation WHERE seat_no = ?1", nativeQuery = true)
    List<Reservation> reservations(Long seatNo);

    @Query(value = "SELECT * FROM reservation WHERE user_name=?1 and reservation_date=?2", nativeQuery = true)
    List<Reservation>chechSameDayReservation(String userName,Date reservationDate);

    @Query(value = "SELECT * FROM reservation WHERE (:userName IS NULL OR user_name = :userName) AND (:seatNo IS NULL OR seat_no = :seatNo) AND (:date IS NULL OR reservation_date = :date)", nativeQuery = true)
    List<Reservation> findWithOptionalParameters(@Param("userName") String userName, @Param("seatNo") Long seatNo, @Param("date") Date date);


}
