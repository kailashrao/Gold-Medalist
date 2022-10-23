
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("DelhiPublicSchoolNoida.txt");
        Scanner scan = new Scanner(file); 
        
        List<String> lines = new ArrayList<String>(Arrays.asList());
        while(scan.hasNextLine()) {
            lines.add(scan.nextLine());
        }
        System.out.println(lines);
        scan.close();
        
        
    }
}