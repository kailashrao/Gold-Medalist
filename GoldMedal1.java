
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
        // System.out.println(count1);

        // Initialize lists
        List<String> names = new ArrayList<String>(Arrays.asList());
        List<String> genders = new ArrayList<String>(Arrays.asList());
        List<String> ids = new ArrayList<String>(Arrays.asList());
        List<String> subjects = new ArrayList<String>(Arrays.asList());
        List<Integer> eng_scores = new ArrayList<Integer>(Arrays.asList());
        List<Integer> math_scores = new ArrayList<Integer>(Arrays.asList());
        List<Integer> phy_scores = new ArrayList<Integer>(Arrays.asList());
        List<Integer> chem_scores = new ArrayList<Integer>(Arrays.asList());
        List<Integer> bio_scores = new ArrayList<Integer>(Arrays.asList());
        List<List<Integer>> score_list = new ArrayList<List<Integer>>(Arrays.asList(eng_scores, math_scores, phy_scores, chem_scores, bio_scores));
        // List<Boolean> pass = new ArrayList<Boolean>(Arrays.asList());
        List<String> toppers1 = new ArrayList<String>();

        int index = 3;

        List<String> temp1 = new ArrayList<String>();
        int max1 = 0;

        
        // Parse through each line
        for (String line: lines) {
            // Separate each line at "," to isolate different information
            List<String> info1 = new ArrayList<String>(Arrays.asList(line.split(",", -1)));
            names.add(info1.get(0));
            genders.add(info1.get(1));
            ids.add(info1.get(2));

            // temp1 = Arrays.asList(info1.get(3).split(":"));
            // subjects.add(temp1.get(0));
            // eng_scores.add(Integer.parseInt(temp1.get(1)));

            // temp1 = Arrays.asList(info1.get(4).split(":"));
            // subjects.add(temp1.get(0));
            // math_scores.add(Integer.parseInt(temp1.get(1)));

            for (List<Integer> scores: score_list) {
                temp1 = Arrays.asList(info1.get(index).split(":"));
                subjects.add(temp1.get(0));
                scores.add(Integer.parseInt(temp1.get(1)));
                index += 1;
            }
            index = 3;    
            // Find all subjects and associated scores
            // for (String subject: info1.subList(3, info1.size()-1)){
            //     List<String> subject_score = new ArrayList<String>(Arrays.asList(subject.split(":", -1)));
            //     if (!subjects.contains(subject_score.get(0))) {
            //         subjects.add(subject_score.get(0));
            //     }
            //     Integer score = Integer.parseInt(subject_score.get(1));
            //     scores.add(score);
            // }
            // Check if student passed or not
            // if (info1.get(info1.size()-1).equals("PASS")) 
            //     pass.add(true);
            // else
            //     pass.add(false);
            
        }
        index = 0;
        for (List<Integer> scores: score_list){
            max1 = Collections.max(scores);
            // System.out.println(max1);
            for (int i = 0; i<count1; i++){
                if (scores.get(i).equals(max1)){
                    toppers1.add(names.get(i));
                }
            }
            System.out.println(toppers1 + " are the toppers in " + subjects.get(index) + " with marks of " + max1);
            index += 1;
            toppers1.clear();
        }
        
        



        // Output sorted data
        // System.out.println(names);
        // // System.out.println(genders);
        // // System.out.println(ids);
        // System.out.println(subjects);
        // System.out.println(eng_scores);
        // System.out.println(math_scores);
        // System.out.println(pass);
        




    }

        
        
}
