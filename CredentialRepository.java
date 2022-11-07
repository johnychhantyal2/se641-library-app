package library.com.example.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import library.com.example.libraryapp.model.Credentials;

@Repository
public interface CredentialRepository extends JpaRepository<Credentials, java.lang.Integer> {

    @Query("SELECT creds FROM Credentials creds WHERE creds.username = ?1 and creds.password = ?2")
    public Credentials getCredsbyUserNameAndPassword(String username, String password);
}