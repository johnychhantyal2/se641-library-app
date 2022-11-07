package library.com.example.libraryapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="Book")
public class Rentals {
    @Id
    @Column(name="RentalId")
    private int rentalID;

    @Column(name="BookId")
    private int bookID;

    @Column(name="UserId")
    private int userID;

    @Column(name="CheckoutDate")
    private Date checkoutDate;

    @Column(name="ScheduledReturnDate")
    private Date scheduledReturnDate;

    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getScheduledReturnDate() {
        return scheduledReturnDate;
    }

    public void setScheduledReturnDate(Date scheduledReturnDate) {
        this.scheduledReturnDate = scheduledReturnDate;
    }
}
