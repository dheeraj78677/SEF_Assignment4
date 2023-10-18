import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
class ArtistTest {

	@Test
	//Create a test method with all valid inputs and add artist
	    public void createArtistValidInp() throws ParseException {
	        String ID = "778DABCD%_";
	        String Name = "Dheeraj";
	        String Address = "Melbourne|Victoria|Australia";
	        String Birthdate = "04-04-1997";
	        String Bio = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
	        ArrayList<String> Awards = new ArrayList<String>();
	        ArrayList<String> Occupations = new ArrayList<String>();
	        ArrayList<String> Genres = new ArrayList<String>();

	        // Add valid data to the lists
	        Occupations.add("Singer");
	        Genres.add("pop");
	        Genres.add("jazz");
	        Awards.add("2022, Best Song of the year ");
	        Artist artist1 = new Artist(ID, Name, Address, Birthdate, Bio, Awards, Occupations, Genres);
	        boolean result = artist1.addArtist();
	        assertEquals(true, result);
	        
	        String ID1 = "777SABCD%_";
	        String Name1 = "Geet";
	        String Address1 = "Armadale|Sydney|Australia";
	        String Birthdate1 = "05-11-1980";
	        String Bio1 = "Hello word good morning this is your friend Geet Singh";
	        ArrayList<String> Awards1 = new ArrayList<String>();
	        ArrayList<String> Occupations1 = new ArrayList<String>();
	        ArrayList<String> Genres1 = new ArrayList<String>();

	        // Add valid data to the lists
	        Occupations1.add("Singer");
	        Genres1.add("metal");
	        Genres1.add("jazz");
	        Awards1.add("2000, Best guitar player of the year ");
	        Artist artist2 = new Artist(ID1, Name1, Address1, Birthdate1, Bio1, Awards1, Occupations1, Genres1);
	        boolean result1 = artist2.addArtist();
	        assertEquals(true, result1);
	        
	    }

	
	@Test
	//Create a method to insert artist but with invalid ID format
    public void createArtistInvalidID() throws ParseException {
        String ID = "7A7EABCD%_";
        String Name = "Dheeraj";
        String Address = "Melbourne|Victoria|Australia";
        String Birthdate = "04-04-1997";
        String Bio = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
        ArrayList<String> Awards = new ArrayList<String>();
        ArrayList<String> Occupations = new ArrayList<String>();
        ArrayList<String> Genres = new ArrayList<String>();

        // Add valid data to the lists
        Occupations.add("Singer");
        Genres.add("pop");
        Genres.add("jazz");
        Awards.add("2022, Best Song of the year ");
        Artist artist1 = new Artist(ID, Name, Address, Birthdate, Bio, Awards, Occupations, Genres);
        boolean result = artist1.addArtist();
        assertEquals(false, result);
        
        String ID1 = "123XBCD%_";
        String Name1 = "Geet";
        String Address1 = "Armadale|Sydney|Australia";
        String Birthdate1 = "05-11-1980";
        String Bio1 = "Soulful singer with a mesmerizing voice captivating audiences worldwide with heartfelt lyrics and unforgettable melodies.";
        ArrayList<String> Awards1 = new ArrayList<String>();
        ArrayList<String> Occupations1 = new ArrayList<String>();
        ArrayList<String> Genres1 = new ArrayList<String>();

        // Add valid data to the lists
        Occupations1.add("Singer");
        Genres1.add("metal");
        Genres1.add("jazz");
        Awards1.add("2000, Best guitar player of the year ");
        Artist artist2 = new Artist(ID1, Name1, Address1, Birthdate1, Bio1, Awards1, Occupations1, Genres1);
        boolean result1 = artist2.addArtist();
        assertEquals(false, result1);
    }
	
	
	@Test
	//Create a method to insert artist but with invalid birthday format
    public void createArtistInvalidBirthdate() throws ParseException {
        String ID = "569MMMRR_%";
        String Name = "Sneha";
        String Address = "Geelong|Victoria|Australia";
        String Birthdate = "1977-08-25";
        String Bio = "Mesmerizing vocalist enchanting crowds with her powerful voice and heartfelt melodies.";
        ArrayList<String> Awards = new ArrayList<String>();
        ArrayList<String> Occupations = new ArrayList<String>();
        ArrayList<String> Genres = new ArrayList<String>();

        // Add valid data to the lists
        Occupations.add("Musician");
        Genres.add("rock");
        Genres.add("classical");
        //Awards.add("2022, Best Song of the year ");
        Artist artist1 = new Artist(ID, Name, Address, Birthdate, Bio, Awards, Occupations, Genres);
        boolean result = artist1.addArtist();
        assertEquals(false, result);
        
        String ID1 = "569MMKRR%%";
        String Name1 = "Prerna";
        String Address1 = "Auckland|Victoria|Australia";
        String Birthdate1 = "2027-15-25";
        String Bio1 = "Mesmerizing vocalist enchanting crowds with her powerful voice and heartfelt melodies.";
        ArrayList<String> Awards1 = new ArrayList<String>();
        ArrayList<String> Occupations1 = new ArrayList<String>();
        ArrayList<String> Genres1 = new ArrayList<String>();

        // Add valid data to the lists
        Occupations1.add("Musician");
        Genres1.add("rock");
        Genres1.add("classical");
        Awards.add("2022, Best Song of the year ");
        Artist artist2 = new Artist(ID1, Name1, Address1, Birthdate1, Bio1, Awards1, Occupations1, Genres1);
        boolean result1 = artist2.addArtist();
        assertEquals(false, result1);
        
        
    }
	
	
	@Test
	//Create a method to insert artist but with invalid birthday format
    public void createArtistInvalidAddress() throws ParseException {
        String ID = "569MMMRR_%";
        String Name = "Sneha";
        String Address = "Geelong--Victoria--Australia";
        String Birthdate = "04-08-1995";
        String Bio = "Mesmerizing vocalist enchanting crowds with her powerful voice and heartfelt melodies.";
        ArrayList<String> Awards = new ArrayList<String>();
        ArrayList<String> Occupations = new ArrayList<String>();
        ArrayList<String> Genres = new ArrayList<String>();

        // Add valid data to the lists
        Occupations.add("Musician");
        Genres.add("rock");
        Genres.add("classical");
        //Awards.add("2022, Best Song of the year ");
        Artist artist1 = new Artist(ID, Name, Address, Birthdate, Bio, Awards, Occupations, Genres);
        boolean result = artist1.addArtist();
        assertEquals(false, result);
        
        String ID1 = "569MMKRR%%";
        String Name1 = "Prerna";
        String Address1 = "Auckland-Victoria-NewZealand";
        String Birthdate1 = "22-05-1996";
        String Bio1 = "Mesmerizing vocalist enchanting crowds with her powerful voice and heartfelt melodies.";
        ArrayList<String> Awards1 = new ArrayList<String>();
        ArrayList<String> Occupations1 = new ArrayList<String>();
        ArrayList<String> Genres1 = new ArrayList<String>();

        // Add valid data to the lists
        Occupations1.add("Musician");
        Genres1.add("rock");
        Genres1.add("classical");
        Awards.add("2022, Best Song of the year ");
        Artist artist2 = new Artist(ID1, Name1, Address1, Birthdate1, Bio1, Awards1, Occupations1, Genres1);
        boolean result1 = artist2.addArtist();
        assertEquals(false, result1);
        
        
    }
	
	
	@Test
	//Create a method to insert artist but with invalid occupation format
    public void createArtistInvalidOccupation() throws ParseException {
        String ID = "569MMMRR_%";
        String Name = "Ravi";
        String Address = "Geelong|Victoria|Australia";
        String Birthdate = "04-08-1995";
        String Bio = "Mesmerizing vocalist enchanting crowds with her powerful voice and heartfelt melodies.";
        ArrayList<String> Awards = new ArrayList<String>();
        ArrayList<String> Occupations = new ArrayList<String>();
        ArrayList<String> Genres = new ArrayList<String>();

        // Add valid data to the lists
        //Occupations.add("Musician");
        Genres.add("rock");
        Genres.add("classical");
        //Awards.add("2022, Best Song of the year ");
        Artist artist1 = new Artist(ID, Name, Address, Birthdate, Bio, Awards, Occupations, Genres);
        boolean result = artist1.addArtist();
        assertEquals(false, result);
        
        String ID1 = "569MMKRR%%";
        String Name1 = "Hemant";
        String Address1 = "Auckland|Victoria|NewZealand";
        String Birthdate1 = "22-05-1996";
        String Bio1 = "Mesmerizing vocalist enchanting crowds with her powerful voice and heartfelt melodies.";
        ArrayList<String> Awards1 = new ArrayList<String>();
        ArrayList<String> Occupations1 = new ArrayList<String>();
        ArrayList<String> Genres1 = new ArrayList<String>();

        // Add valid data to the lists
        Occupations1.add("Musician");
        Occupations1.add("Singer");
        Occupations1.add("Dancer");
        Occupations1.add("Producer");
        Occupations1.add("Composer");
        Occupations1.add("Athlete");
        Genres1.add("rock");
        Awards.add("2022, Best Song of the year ");
        Artist artist2 = new Artist(ID1, Name1, Address1, Birthdate1, Bio1, Awards1, Occupations1, Genres1);
        boolean result1 = artist2.addArtist();
        assertEquals(false, result1);        
        
    }
	
	@Test
	//Create a method to insert artist but with invalid genre format
    public void createArtistInvalidGenre() throws ParseException {
        String ID = "569MMMRR_%";
        String Name = "Ravi";
        String Address = "Geelong|Victoria|Australia";
        String Birthdate = "04-08-1995";
        String Bio = "Mesmerizing vocalist enchanting crowds with her powerful voice and heartfelt melodies.";
        ArrayList<String> Awards = new ArrayList<String>();
        ArrayList<String> Occupations = new ArrayList<String>();
        ArrayList<String> Genres = new ArrayList<String>();

        // Add valid data to the lists
        Occupations.add("Musician");
        Genres.add("rock");
        Genres.add("classical");
        Genres.add("jazz");
        Genres.add("pop");
        Genres.add("metal");
        Genres.add("folk");
        //Awards.add("2022, Best Song of the year ");
        Artist artist1 = new Artist(ID, Name, Address, Birthdate, Bio, Awards, Occupations, Genres);
        boolean result = artist1.addArtist();
        assertEquals(false, result);
        
        String ID1 = "569MMKRR%%";
        String Name1 = "Hemant";
        String Address1 = "Auckland|Victoria|NewZealand";
        String Birthdate1 = "22-05-1996";
        String Bio1 = "Mesmerizing vocalist enchanting crowds with her powerful voice and heartfelt melodies.";
        ArrayList<String> Awards1 = new ArrayList<String>();
        ArrayList<String> Occupations1 = new ArrayList<String>();
        ArrayList<String> Genres1 = new ArrayList<String>();

        // Add valid data to the lists
        Occupations1.add("Musician");
        Occupations1.add("Singer");
        Occupations1.add("Dancer");
        Occupations1.add("Producer");
        Occupations1.add("Composer");
        //Occupations1.add("Athlete");
        Genres1.add("rock");
        //Genres1.add("classical");
        Awards.add("2022, Best Song of the year ");
        Artist artist2 = new Artist(ID1, Name1, Address1, Birthdate1, Bio1, Awards1, Occupations1, Genres1);
        boolean result1 = artist2.addArtist();
        assertEquals(false, result1);        
        
    }
	
	
	@Test
	//Create a test method to update artist Name
	    public void updateArtistName() throws ParseException, FileNotFoundException {
	        String ID = "778DABCD%_";
	        String Name = "Prerna";
	        String Address = "Melbourne|Victoria|Australia";
	        String Birthdate = "04-04-1997";
	        String Bio = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
	        ArrayList<String> Awards = new ArrayList<String>();
	        ArrayList<String> Occupations = new ArrayList<String>();
	        ArrayList<String> Genres = new ArrayList<String>();

	        // Add valid data to the lists
	        Occupations.add("Singer");
	        Genres.add("pop");
	        Genres.add("jazz");
	        Awards.add("2022, Best Song of the year ");
	        Artist artist1 = new Artist(ID, Name, Address, Birthdate, Bio, Awards, Occupations, Genres);
	        boolean result = artist1.updateArtist();
	        assertEquals(true, result);
	        
	        String ID1 = "778DABCD%_";
	        String Name1 = "Kalpana";
	        String Address1 = "Melbourne|Victoria|Australia";
	        String Birthdate1 = "04-04-1997";
	        String Bio1 = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
	        ArrayList<String> Awards1 = new ArrayList<String>();
	        ArrayList<String> Occupations1 = new ArrayList<String>();
	        ArrayList<String> Genres1 = new ArrayList<String>();

	        // Add valid data to the lists
	        Occupations1.add("Singer");
	        Genres1.add("pop");
	        Genres1.add("jazz");
	        Awards1.add("2022, Best Song of the year ");
	        Artist artist2 = new Artist(ID1, Name1, Address1, Birthdate1, Bio1, Awards1, Occupations1, Genres1);
	        boolean result1 = artist2.updateArtist();
	        assertEquals(true, result1);
	        
	    }
	
	
	@Test
	//Create a test method to update artist BirthDate
	    public void updateArtistBirthDate() throws ParseException, FileNotFoundException {
	        String ID = "778DABCD%_";
	        String Name = "Dheeraj";
	        String Address = "Melbourne|Victoria|Australia";
	        String Birthdate = "11-04-1997";
	        String Bio = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
	        ArrayList<String> Awards = new ArrayList<String>();
	        ArrayList<String> Occupations = new ArrayList<String>();
	        ArrayList<String> Genres = new ArrayList<String>();

	        // Add valid data to the lists
	        Occupations.add("Singer");
	        Occupations.add("Chef");
	        Genres.add("pop");
	        Genres.add("jazz");
	        Awards.add("2022, Best Song of the year ");
	        Artist artist1 = new Artist(ID, Name, Address, Birthdate, Bio, Awards, Occupations, Genres);
	        boolean result = artist1.updateArtist();
	        assertEquals(true, result);
	        
	        String ID1 = "778DABCD%_";
	        String Name1 = "Dheeraj";
	        String Address1 = "Melbourne|Victoria|Australia";
	        String Birthdate1 = "22-10-1980";
	        String Bio1 = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
	        ArrayList<String> Awards1 = new ArrayList<String>();
	        ArrayList<String> Occupations1 = new ArrayList<String>();
	        ArrayList<String> Genres1 = new ArrayList<String>();

	        // Add valid data to the lists
	        Occupations1.add("Singer");
	        Genres1.add("pop");
	        Genres1.add("jazz");
	        Awards1.add("2022, Best Song of the year ");
	        Artist artist2 = new Artist(ID1, Name1, Address1, Birthdate1, Bio1, Awards1, Occupations1, Genres1);
	        boolean result1 = artist2.updateArtist();
	        assertEquals(true, result1);
	        
	    }
	
	
	@Test
	//Create a test method to update artist BirthDate
	    public void updateArtistOccupations() throws ParseException, FileNotFoundException {
	        String ID = "778DABCD%_";
	        String Name = "Dheeraj";
	        String Address = "Melbourne|Victoria|Australia";
	        String Birthdate = "04-04-1997";
	        String Bio = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
	        ArrayList<String> Awards = new ArrayList<String>();
	        ArrayList<String> Occupations = new ArrayList<String>();
	        ArrayList<String> Genres = new ArrayList<String>();

	        // Add valid data to the lists
	        Occupations.add("Singer");
	        Genres.add("pop");
	        Genres.add("jazz");
	        Awards.add("2022, Best Song of the year ");
	        Artist artist1 = new Artist(ID, Name, Address, Birthdate, Bio, Awards, Occupations, Genres);
	        boolean result = artist1.updateArtist();
	        assertEquals(true, result);
	        
	        String ID1 = "778DABCD%_";
	        String Name1 = "Dheeraj";
	        String Address1 = "Melbourne|Victoria|Australia";
	        String Birthdate1 = "04-04-2001";
	        String Bio1 = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
	        ArrayList<String> Awards1 = new ArrayList<String>();
	        ArrayList<String> Occupations1 = new ArrayList<String>();
	        ArrayList<String> Genres1 = new ArrayList<String>();

	        // Add valid data to the lists
	        Occupations1.add("Musician");
	        Occupations1.add("Singer");
	        Occupations1.add("Dancer");
	        Occupations1.add("Producer");
	        Occupations1.add("Composer");
	        Genres1.add("pop");
	        Genres1.add("jazz");
	        Awards1.add("2022, Best Song of the year ");
	        Artist artist2 = new Artist(ID1, Name1, Address1, Birthdate1, Bio1, Awards1, Occupations1, Genres1);
	        boolean result1 = artist2.updateArtist();
	        assertEquals(true, result1);
	        
	    }
	
	@Test
	//Create a test method to update artist Genre it should fail as the input is  not valid
	   public void updateArtistGenre() throws ParseException, FileNotFoundException {
	        String ID = "778DABCD%_";
	        String Name = "Dheeraj";
	        String Address = "Melbourne|Victoria|Australia";
	        String Birthdate = "04-04-1997";
	        String Bio = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
	        ArrayList<String> Awards = new ArrayList<String>();
	        ArrayList<String> Occupations = new ArrayList<String>();
	        ArrayList<String> Genres = new ArrayList<String>();

	        // Add valid data to the lists
	        Occupations.add("Singer");
	        Genres.add("pop");
	        //Genres.add("jazz");
	        Awards.add("2022, Best Song of the year ");
	        Artist artist1 = new Artist(ID, Name, Address, Birthdate, Bio, Awards, Occupations, Genres);
	        boolean result = artist1.updateArtist();
	        assertEquals(false, result);
	        
	        String ID1 = "778DABCD%_";
	        String Name1 = "Dheeraj";
	        String Address1 = "Melbourne|Victoria|Australia";
	        String Birthdate1 = "04-04-1997";
	        String Bio1 = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
	        ArrayList<String> Awards1 = new ArrayList<String>();
	        ArrayList<String> Occupations1 = new ArrayList<String>();
	        ArrayList<String> Genres1 = new ArrayList<String>();

	        // Add valid data to the lists
	        Occupations1.add("Singer");
	        Genres1.add("pop");
	        Genres1.add("jazz");
	        Genres1.add("folk");
	        Genres1.add("classical");
	        //Genres1.add("metal");
	        Genres1.add("rock");
	        Awards1.add("2022, Best Song of the year ");
	        Artist artist2 = new Artist(ID1, Name1, Address1, Birthdate1, Bio1, Awards1, Occupations1, Genres1);
	        boolean result1 = artist2.updateArtist();
	        assertEquals(false, result1);
	        
	    }
	
	@Test
    //Create a test method to update artist Name
        public void updateArtistNameAddress() throws ParseException, FileNotFoundException {
            String ID = "778DABCD%_";
            String Name = "Prerna";
            String Address = "Tapou|Auckland|NewZealand";
            String Birthdate = "04-04-1997";
            String Bio = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
            ArrayList<String> Awards = new ArrayList<String>();
            ArrayList<String> Occupations = new ArrayList<String>();
            ArrayList<String> Genres = new ArrayList<String>();

            // Add valid data to the lists
            Occupations.add("Singer");
            Genres.add("pop");
            Genres.add("jazz");
            Awards.add("2022, Best Song of the year ");
            Artist artist1 = new Artist(ID, Name, Address, Birthdate, Bio, Awards, Occupations, Genres);
            boolean result = artist1.updateArtist();
            assertEquals(true, result);
            
            String ID1 = "778DABCD%_";
            String Name1 = "Kalpana";
            String Address1 = "Mumbai|Maharashtra|India";
            String Birthdate1 = "04-04-1997";
            String Bio1 = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
            ArrayList<String> Awards1 = new ArrayList<String>();
            ArrayList<String> Occupations1 = new ArrayList<String>();
            ArrayList<String> Genres1 = new ArrayList<String>();

            // Add valid data to the lists
            Occupations1.add("Singer");
            Genres1.add("pop");
            Genres1.add("jazz");
            Awards1.add("2022, Best Song of the year ");
            Artist artist2 = new Artist(ID1, Name1, Address1, Birthdate1, Bio1, Awards1, Occupations1, Genres1);
            boolean result1 = artist2.updateArtist();
            assertEquals(true, result1);
            
        }
	
	@Test
    //Create a test method to update artist Award list
        public void updateArtistAwards() throws ParseException, FileNotFoundException {
			String ID2 = "778DABCC%_";
	        String Name2 = "Dheeraj";
	        String Address2 = "Melbourne|Victoria|Australia";
	        String Birthdate2 = "04-04-1997";
	        String Bio2 = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
	        ArrayList<String> Awards2 = new ArrayList<String>();
	        ArrayList<String> Occupations2 = new ArrayList<String>();
	        ArrayList<String> Genres2 = new ArrayList<String>();
	
	        // Add valid data to the lists
	        Occupations2.add("Singer");
	        Genres2.add("pop");
	        Genres2.add("jazz");
	        Awards2.add("1999, Best Song of the year ");
	        Artist artist2 = new Artist(ID2, Name2, Address2, Birthdate2, Bio2, Awards2, Occupations2, Genres2);
	        boolean result2 = artist2.addArtist();
	        assertEquals(true, result2);
		
            String ID = "778DABCC%_";
            String Name = "Dheeraj";
            String Address = "Melbourne|Victoria|Australia";
            String Birthdate = "04-04-1997";
            String Bio = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
            ArrayList<String> Awards = new ArrayList<String>();
            ArrayList<String> Occupations = new ArrayList<String>();
            ArrayList<String> Genres = new ArrayList<String>();

            // Add valid data to the lists
            Occupations.add("Singer");
            Genres.add("pop");
            Genres.add("jazz");
            Awards.add("1999, Best Singer of the year ");
            Artist artist1 = new Artist(ID, Name, Address, Birthdate, Bio, Awards, Occupations, Genres);
            boolean result = artist1.updateArtist();
            assertEquals(true, result);
            
            String ID1 = "778DABCC%_";
            String Name1 = "Dheeraj";
            String Address1 = "Melbourne|Victoria|Australia";
            String Birthdate1 = "04-04-1997";
            String Bio1 = "Passionate vocalist captivating hearts with soulful melodies and powerful emotive performances.";
            ArrayList<String> Awards1 = new ArrayList<String>();
            ArrayList<String> Occupations1 = new ArrayList<String>();
            ArrayList<String> Genres1 = new ArrayList<String>();

            // Add valid data to the lists
            Occupations1.add("Singer");
            Genres1.add("pop");
            Genres1.add("jazz");
            Awards1.add("2021, Best Musician of the year ");
            Artist artist3 = new Artist(ID1, Name1, Address1, Birthdate1, Bio1, Awards1, Occupations1, Genres1);
            boolean result1 = artist3.updateArtist();
            assertEquals(true, result1);
            
        }
}
