package library.com.example.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.com.example.libraryapp.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, java.lang.Integer> {
}
