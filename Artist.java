//Add all the necessary or required import to run the program
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.FileReader;

//Create main class Artist with various essential attributes needed to perform addartist and update artist function 
public class Artist {
    private String ID;
    private String Name;
    private String Address;
    private String Birthdate;
    private String Bio;
    private ArrayList<String> Awards;
    private ArrayList<String> Occupations;
    private ArrayList<String> Genres;

    //Create a constructor 
    public Artist(String ID, String Name, String Address, String Birthdate, String Bio, ArrayList<String> Awards, ArrayList<String> Occupations, ArrayList<String> Genres) {
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
        this.Birthdate = Birthdate;
        this.Bio = Bio;
        this.Awards = Awards;
        this.Occupations = Occupations;
        this.Genres = Genres;
    }
    
    //addArtist method will check for all the conditions mention in the assignment 
    // and if all the conditions are satisfied it will add the artist info in the text file
    public boolean addArtist() throws ParseException {
       
        if (!checkID(this.ID) || !checkBirthdate(this.Birthdate) || !checkAddress(this.Address) ||
                !checkBio(this.Bio)  || !checkOccupations(this.Occupations) || !checkAwards(this.Awards) || !checkGenre(this.Genres)){
            return false;
        }

        try {
            // Open a FileWriter in append mode to add the artist to the text file
            BufferedWriter writer = new BufferedWriter(new FileWriter("artists.txt", true));

            // Write the artist's information to the file
            writer.write(ID + "," + Name + "," + Address + "," + Birthdate + "," + Bio + "," +Occupations +"," + Genres +","+Awards);

            writer.newLine();

            // Close the FileWriter
            writer.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //update Artist function will first check the input with the conditions specify in the assignment
    // and if it satisfy it will update the artist record in the artists text file 
    
    public boolean updateArtist() throws ParseException, FileNotFoundException {
    	//check conditions
        if (!checkID(this.ID) || !checkBirthdate(this.Birthdate) || !checkAddress(this.Address) ||
                !checkBio(this.Bio) || !checkOccupations(this.Occupations) || !checkAwards(this.Awards) || !checkGenre(this.Genres)) {
            return false;
        }
        String updateText = "";
        String replacedLine = "";
        
        
        //open the artists text file and  search for the artist and if find update it
        FileWriter writer = null;
        try{
            try (BufferedReader reader = new BufferedReader(new FileReader("artists.txt"))) {
                String line = reader.readLine();
                String oldContent="";
                while (line != null)
                {
                    if (line.contains(this.ID)) {
                        updateText = line;
                        replacedLine = checkUpdateString(updateText);
                        if (replacedLine == "false") {
                            return false;
                        }
                        line = replacedLine;
                    }
                    oldContent = oldContent + line + System.lineSeparator();
                    line = reader.readLine();
                }
                reader.close();
      
                if(oldContent != "") {
                    writer = new FileWriter("artists.txt");
                    writer.write(oldContent);
                }
            }
            writer.close();
            return true;
        }catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

    }


    //method to check and update the string
    //This method is called from the updateArtist function with input argument as 
    //the match artist string and this method will update that string 
    public String checkUpdateString(String input) throws ParseException {
        String[] artistList = input.split(",(?![^\\[\\]]*\\])");
        String ID = artistList[0];
        String Name = artistList[1];
        String Address = artistList[2];
        String Birthdate = artistList[3];
        String Bio = artistList[4];

        
        String awardStr = artistList[7].substring(1, artistList[7].length() - 1);
        String[] elements = awardStr.split(",");

        ArrayList<String> Awards = new ArrayList<String>();
        for(String eachelement: elements){
            Awards.add(eachelement);
        }
       
        String occupationStr = artistList[5].substring(1, artistList[5].length() - 1);
        String[] elementsOcc = occupationStr.split(",");
        ArrayList<String> Occupations = new ArrayList<String>(Arrays.asList(elementsOcc));


        String genreStr = artistList[6].substring(1, artistList[6].length() - 1);
        String[] elementsGenre = genreStr.split(",");
        ArrayList<String> Genres = new ArrayList<String>(Arrays.asList(elementsGenre));
        
        Date validDate = new SimpleDateFormat("dd-MM-yyyy").parse(this.Birthdate);
        LocalDate localDate1 = validDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();


        if(localDate1.getYear() < 2000){
            this.Occupations = Occupations;
        }
        
        ArrayList<String> awardLists= new ArrayList<String>();
        HashMap<String, String> newAwards = new HashMap<>();
        HashMap<String, String> oldAwards = new HashMap<>();
        
        for (int i = 0; i < elements.length; i += 2) {
            String key = elements[i];
            String value = elements[i + 1];
           
            oldAwards.put(key,value);
        }
        


        for (String prize : this.Awards){
            String[] prizeList = prize.split(",");
            for (int i = 0; i < prizeList.length; i += 2) {
                String key = prizeList[i].toLowerCase();
                String value = prizeList[i + 1];
                
                newAwards.put(key,value);
            }
        }

        //Iterate over old award to update changes
        for (String key : oldAwards.keySet()) {
            Integer awardYear = Integer.parseInt(key.trim());
            if(newAwards.containsKey(key) && awardYear >= 2000){
                awardLists.add(key+","+newAwards.get(key));
            }
            else{
                awardLists.add(key+","+oldAwards.get(key));
            }
        }

        //Iterate over old award to update changes
        for (String key : newAwards.keySet()) {
            if(!oldAwards.containsKey(key)){
                awardLists.add(key+","+newAwards.get(key));
            }
        }
        
        this.Awards = awardLists;
        if (!checkID(this.ID) || !checkBirthdate(this.Birthdate) || !checkAddress(this.Address) ||
                !checkBio(this.Bio) || !checkOccupations(this.Occupations) || !checkAwards(this.Awards) || !checkGenre(this.Genres)) {
            return "false";
        }
        String newArtistDetail = this.ID + "," + this.Name + "," + this.Address + "," + this.Birthdate + "," + this.Bio + "," +this.Occupations + "," + this.Genres + "," +this.Awards;
        return newArtistDetail;
    }


    //method to check the ID as per the requirement
    public boolean checkID(String input){
        String matchID = "^[5-9]{3}[A-Z]{5}[!@#$%^&*()-_=+\\\\[\\\\]{};:'\\\",<.>/?\\\\|\\\\\\\\\\\\]{2}$";
        //String matchID = "^[5-9]{3}[A-Z]{4}[^\\w \\d \\s]{2}$";
        Pattern IDpattern = Pattern.compile(matchID);
        Matcher matcher = IDpattern.matcher(input);
        if (!matcher.matches()){
           
            return false;
        }
        return true;
    }

    //method to check birth-date
    public boolean checkBirthdate(String input) throws ParseException{
        String matchBirthdate = "^[0-9]{2}-[0-9]{2}-[0-9]{4}$";
        Pattern birthdatePattern = Pattern.compile(matchBirthdate);
        Matcher matcherDate = birthdatePattern.matcher(input);
        if (!matcherDate.matches()){
           
            return false;
        }
        else{
            Date validDate = new SimpleDateFormat("dd-MM-yyyy").parse(input);
            LocalDate localDate1 = validDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            if (localDate1.isAfter(LocalDate.now())){
             
                return false;

            }
            else if (localDate1.getDayOfMonth() > 31 || localDate1.getDayOfMonth() == 0 ){
               
                return false;
            }
            else if (localDate1.getMonthValue()> 12 || localDate1.getMonthValue()==0){
               
                return false;
            }
            else if(localDate1.getDayOfMonth() ==31  && (localDate1.getMonthValue()==1 || localDate1.getMonthValue()==3
                    || localDate1.getMonthValue()==5 || localDate1.getMonthValue()==7 || localDate1.getMonthValue()==8
                    || localDate1.getMonthValue()==10 || localDate1.getMonthValue()==12  ) ){
              
                return false;

            }
            else if (localDate1.getDayOfMonth() >28  && localDate1.getMonthValue()== 2 && (localDate1.getYear()%4 !=0) ){
               
                return false;
            }
        }
        return true;
    }

    //validate artist address City|State|Country. Example: Melbourne|Victoria|Australia.
    public boolean checkAddress(String input){
        String[] validateAddress = input.split("\\|");
        if (validateAddress.length !=3){
           
            return false;
        }
        return true;
    }

    //validate bio of an artist
    public boolean checkBio(String input){
    	String[] bioLen = input.split(" ");
        if( !(bioLen.length >= 10 && bioLen.length <= 30)){
          
            return false;
        }
        return true;
    }


    //validate occupations
    public boolean checkOccupations(ArrayList<String> input){
        if (! (input.size() >= 1 && input.size() <= 5) ){
           
            return false;
        }
        return true;
    }

    //validate award for an artist
    public boolean checkAwards(ArrayList<String> awards2){
        if (awards2.size() >6){
          
            return false;
        }
        if(awards2.size() == 0){

            return true;
        }
        for (String prizeLists: awards2){
            String [] eachAward  = prizeLists.split(",");
            for(int i = 0; i < eachAward.length; i += 2){

                //check for prize year regex
                String matchPrizeYear = "^[0-9]{4}$";
                Pattern PrizePattern = Pattern.compile(matchPrizeYear);
                Matcher matcherYear = PrizePattern.matcher(eachAward[i].trim());
                if (!matcherYear.matches()){
                    return false;
                }

                String[] awardDescription = eachAward[i+1].split(" ");
                if (!(awardDescription.length >=4 && awardDescription.length <= 10) ){
                   
                    return false;
                }
            }
        }
        return true;
    }

    //validate artist genres
    public boolean checkGenre(ArrayList<String> input){
        if  (!(input.size() >=2  && input.size() <=5) ){
          
            return false;
        }
        Boolean popGenre = false;
        Boolean rockGenre = false;

        for (String gen : input){
            if (gen.trim() == "pop" ) {
                popGenre= true;
            }
            if (gen.trim() == "rock" ) {
                rockGenre= true;
            }
        }
        if (popGenre == true && rockGenre== true){           
            return false;
        }
        return true;
    }
}
