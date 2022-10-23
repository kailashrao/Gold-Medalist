
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        // Open File and Initialize Scanner object
        File file = new File("DelhiPublicSchoolNoida.txt");
        Scanner scan = new Scanner(file); 
        // Create ArrayList and add file lines to list
        List<String> lines = new ArrayList<String>(Arrays.asList());
        while(scan.hasNextLine()) {
            lines.add(scan.nextLine());
        }
        scan.close();

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
