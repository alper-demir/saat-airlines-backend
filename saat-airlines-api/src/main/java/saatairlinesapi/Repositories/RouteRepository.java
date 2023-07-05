package saatairlinesapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import saatairlinesapi.entities.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> { }
