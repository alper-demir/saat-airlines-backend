package saatairlinesapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import saatairlinesapi.entities.Airport;

public interface AirportRepository extends JpaRepository<Airport,Integer> { }
