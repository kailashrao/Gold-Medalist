import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class GoldMedal1 {
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
        int count1 = lines.size();

        // Initialize Variables
        List<String> names = new ArrayList<String>(Arrays.asList());
        List<String> subjects = new ArrayList<String>(Arrays.asList());

        List<Integer> eng_scores = new ArrayList<Integer>(Arrays.asList());
        List<Integer> math_scores = new ArrayList<Integer>(Arrays.asList());
        List<Integer> phy_scores = new ArrayList<Integer>(Arrays.asList());
        List<Integer> chem_scores = new ArrayList<Integer>(Arrays.asList());
        List<Integer> bio_scores = new ArrayList<Integer>(Arrays.asList());

        List<List<Integer>> score_list = new ArrayList<List<Integer>>(Arrays.asList(eng_scores, math_scores, phy_scores, chem_scores, bio_scores));

        // Temporary Use Variables
        List<String> subject_scores = new ArrayList<String>();
        int max1 = 0;
        List<String> gold_medalists = new ArrayList<String>();
        int index = 3;
        
        // Parse through each line
        for (String line: lines) {
            // Separate each line at "," to isolate different information
            List<String> line_data = new ArrayList<String>(Arrays.asList(line.split(",", -1)));
            names.add(line_data.get(0));

            // Add scores to corresponding subject list
            for (List<Integer> scores: score_list) {
                subject_scores = Arrays.asList(line_data.get(index).split(":"));
                subjects.add(subject_scores.get(0));
                scores.add(Integer.parseInt(subject_scores.get(1)));
                index += 1;
            }
            index = 3;       
        }

        // Find highest score(s) in each subject and corresponding names
        index = 0;
        for (List<Integer> scores: score_list){
            max1 = Collections.max(scores);
            for (int i = 0; i<count1; i++){
                if (scores.get(i).equals(max1)){
                    gold_medalists.add(names.get(i));
                }
            }
            System.out.println(gold_medalists + " are the toppers in " + subjects.get(index) + " with marks of " + max1);
            index += 1;
            gold_medalists.clear();
        }
        

    }

        
}
