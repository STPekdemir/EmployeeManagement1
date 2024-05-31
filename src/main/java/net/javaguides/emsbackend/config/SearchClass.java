package net.javaguides.emsbackend.config;

import lombok.*;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

public class SearchClass {

    private String userName;
    private Date date;
    private Long seatNo;



}
