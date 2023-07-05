package saatairlinesapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import saatairlinesapi.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> { }
