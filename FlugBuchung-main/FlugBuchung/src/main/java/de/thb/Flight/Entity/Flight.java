package de.thb.Flight.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Flight {
    @Id
    @GeneratedValue
    private long flightId;
    private String flightNumber;
    @ManyToOne
    private Airport departureAirport;
    @ManyToOne
    private Airport destinationAirport;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalDate;

    private String departureTime;

    private String arrivalTime;

    private double flightCharge;

    @ManyToOne
    Aircraft aircraft;

    @OneToMany(mappedBy = "flight")
    List<Passenger> passengers = new ArrayList<>();


}