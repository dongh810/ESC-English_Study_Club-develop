package org.highfives.esc.userservice.aggregate;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "member")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "nickname")
    private String nickname;

    @Column(nullable = false, name = "status")
    @ColumnDefault("N")
    private String status;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "report_count")
    @ColumnDefault("0")
    private int reportCount;

    @Column(nullable = false, name = "grade")
    @ColumnDefault("0")
    private int grade;

    @Column(nullable = false, name = "point")
    @ColumnDefault("0")
    private int point;

    @Column(name = "end_date")
    private LocalDateTime endDate;

}
