package saatairlinesapi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "airports")
@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;
}
