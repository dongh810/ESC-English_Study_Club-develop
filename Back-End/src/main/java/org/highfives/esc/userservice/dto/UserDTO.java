package org.highfives.esc.userservice.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDTO {

    private int id;
    private String name;
    private String email;
    private String nickname;
    private String status;
    private String password;
    private int reportCount;
    private int grade;
    private int point;
    private LocalDateTime endDate;
}
