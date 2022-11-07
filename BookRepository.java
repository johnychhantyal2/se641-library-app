package library.com.example.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import library.com.example.libraryapp.model.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, java.lang.Integer> {

//    @Query("SELECT creds FROM Credentials creds WHERE creds.username = ?1 and creds.password = ?2")
//    public Book getCredsbyUserNameAndPassword(String username, String password);
}
