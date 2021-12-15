package com.example.oodbackend.entity;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="events")
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;


    @NotBlank(message = "Please Add Event name ")
    @Length(max =100 ,min =2)
    private String eventName ;



    private String eventDescription;

    // Each event is going to be mapped to a Location
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "location_id",
            referencedColumnName = "locationId"
    )
    @NotNull
    private Location location ;


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "events", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();


    @Temporal(TemporalType.DATE)
    Date eventStartDate;

    @Temporal(TemporalType.DATE)
    Date eventEndDate;




    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "categoryId"
    )
    @NotNull
    private Categories categories;



}
