package saatairlinesapi.entities;

import lombok.Data;
import jakarta.persistence.*;

import java.util.Date;


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
    private Date date;

    @Column(name = "arrival_time")
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;

    @Column(name = "capacity")
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private FlightStatus status;

}
