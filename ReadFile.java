
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        // Open File and Initialize Scanner object
        File file = new File("schools.txt");
        Scanner scan1 = new Scanner(file); 
        // Create ArrayList and add school files to list
        List<String> schools = new ArrayList<String>(Arrays.asList());
        while(scan1.hasNextLine()) {
            schools.add(scan1.nextLine());
        }
        scan1.close();
        // Scan All school files
        for (String school: schools){
            school.replace("\n", "");
            File school_file = new File("Schools/" + school);
            Scanner scan2 = new Scanner(school_file);
            List<String> lines = new ArrayList<String>(Arrays.asList());
            while(scan2.hasNextLine()) {
                lines.add(scan2.nextLine());
            }
            scan2.close();
            // Initialize lists
            List<String> names = new ArrayList<String>(Arrays.asList());
            List<String> genders = new ArrayList<String>(Arrays.asList());
            List<String> ids = new ArrayList<String>(Arrays.asList());
            List<String> subjects = new ArrayList<String>(Arrays.asList());
            List<Integer> scores = new ArrayList<Integer>(Arrays.asList());
            List<Boolean> pass = new ArrayList<Boolean>(Arrays.asList());
            
            // Parse through each line
            for (String line: lines) {
                // Separate each line at "," to isolate different information
                List<String> separate = new ArrayList<String>(Arrays.asList(line.split(",", -1)));
                names.add(separate.get(0));
                genders.add(separate.get(1));
                ids.add(separate.get(2));
                // Find all subjects and associated scores
                for (String subject: separate.subList(3, separate.size()-1)){
                    List<String> subject_score = new ArrayList<String>(Arrays.asList(subject.split(":", -1)));
                    subjects.add(subject_score.get(0));
                    Integer score = Integer.parseInt(subject_score.get(1));
                    scores.add(score);
                // Check if student passed or not
                if (separate.get(separate.size()-1).equals("PASS")) 
                    pass.add(true);
                else
                    pass.add(false);
                }
            }
            // Output sorted data
            System.out.println(names);
            System.out.println(genders);
            System.out.println(ids);
            System.out.println(subjects);
            System.out.println(scores);
            System.out.println(pass);

        }

        
    }       
}
