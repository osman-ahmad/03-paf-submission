package ibf2022.paf.assessment.server.services;

public class UserException extends Exception{
    
        public UserException() { 
            super();
        }
        public UserException(String message, Throwable throwable) {
            super(message, throwable);
        }
        public UserException(String message) {
            super(message);
        }
}
