package saatairlinesapi.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "flight_number")
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @Column(name = "price")
    private int price;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private String date;

    @Column(name = "departure_time")
    @Temporal(TemporalType.TIME)
    private String departureTime;

    @Column(name = "arrival_time")
    @Temporal(TemporalType.TIME)
    private String arrivalTime;

    @Column(name = "capacity")
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private FlightStatus status;

}
