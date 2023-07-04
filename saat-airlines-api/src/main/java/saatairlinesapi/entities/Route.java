package saatairlinesapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private Airport source;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Airport destination;

    @Column(name = "distance_in_miles")
    private int distanceInMiles;
}