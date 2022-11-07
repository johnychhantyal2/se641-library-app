package library.com.example.libraryapp.service;

import library.com.example.libraryapp.model.*;
import library.com.example.libraryapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.com.example.libraryapp.repository.UserRepository;
import library.com.example.libraryapp.repository.CredentialRepository;
import java.util.List;

@Service
public class LibraryService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    BookRepository bookRepository;

    // CREATE
    public Users createUser(Users user1) {
        return userRepository.save(user1);
    }

    // READ
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public List<Books> getBooks() {
        return bookRepository.findAll();
    }

    public Users getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public Books getBookById(int id) { return bookRepository.findById(id).get(); }

//    public Credentials getCredsbyUserNameAndPasswordById(int id) { return credentialRepository.findById(id).get(); }

    // DELETE
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    // UPDATE
    public Users updateUser(int userId, Users userDetails) {
        Users user = userRepository.findById(userId).get();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setStreetAddress(userDetails.getStreetAddress());

        return userRepository.save(user);
    }

    public Users loginUser(Login loginDetails) throws NullPointerException {
        Users user = new Users();
        String username = loginDetails.getUsername();
        System.out.print("username is :" + username);
        try {
            Credentials creds = credentialRepository.getCredsbyUserNameAndPassword(loginDetails.getUsername(), loginDetails.getPassword());
            if (creds == null) {
                System.out.print("Did not find credentials of the user!");
            }
            user = userRepository.findById(creds.getUserId()).get();
            if (user == null) {
                System.out.print("No user record with given ID");
            }
        } catch (NullPointerException e) {
            System.out.print("NullPointerException Caught");
        }
        return user;
    }

    public Users registerUser(Register userDetails) throws Exception {
        Users user = new Users();
        Credentials creds = new Credentials();

        // Save user info
        List<Users> users = getUsers();
        Integer numOfUsers = users.size();
        user.setUserID(numOfUsers+10);
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setStreetAddress(userDetails.getStreetAddress());
        user.setCity(userDetails.getCity());
        user.setState(userDetails.getState());
        user.setZipcode(userDetails.getZipcode());
        user.setPhone(userDetails.getPhone());
        user.setMembershipDate(userDetails.getMembershipDate());
        user.setIsLibrarian(userDetails.getIsLibrarian());
        userRepository.save(user);

        // Save credential of above user
        creds.setUserId(user.getUserID());
        creds.setUsername(userDetails.getUsername());
        creds.setPassword(userDetails.getPassword());
        credentialRepository.save(creds);

        return user;
    }
}
