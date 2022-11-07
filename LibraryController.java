package library.com.example.libraryapp.controller;

import java.util.List;

import library.com.example.libraryapp.model.Books;
import library.com.example.libraryapp.model.Register;
import library.com.example.libraryapp.model.Users;
import library.com.example.libraryapp.model.Login;
import library.com.example.libraryapp.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @RequestMapping(value="/users/{id}", method=RequestMethod.GET)
    public Users getUserById(@PathVariable(value = "id") int id) {
        return libraryService.getUserById(id);
    }

    @RequestMapping(value="/users", method=RequestMethod.GET)
    public List<Users> getUsers() {
        return libraryService.getUsers();
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public Users loginUser(@RequestBody Login loginDetails) throws NullPointerException {
        String userName = loginDetails.getUsername();
        System.out.print("Username at controller: " + userName);
        return libraryService.loginUser(loginDetails);
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public Users registerUser(@RequestBody Register userDetails) throws Exception {
        Users user = libraryService.registerUser(userDetails);
        return user;
    }

    @RequestMapping(value="/books", method=RequestMethod.GET)
    public List<Books> getBooks() {
        return libraryService.getBooks();
    }

    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public Books getBookById(@PathVariable(value = "id") int id) {
        return libraryService.getBookById(id);
    }
}
