package com.scalaboy.spring_pet_clinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String desctiption;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;


}
