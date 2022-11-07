package library.com.example.libraryapp.repository;

import library.com.example.libraryapp.model.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rentals, Integer> {
}
