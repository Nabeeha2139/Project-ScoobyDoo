import java.time.LocalDate; // Shows date without a time-of-day and without a time zone

//This class is the extention of the pre-build exception class
public class incorrectDateException extends Exception {
    
    public incorrectDateException(String message){
        super(message);
    }

}
