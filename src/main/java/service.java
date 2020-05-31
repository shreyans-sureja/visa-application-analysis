import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

// class with default access modifier so that only accessible within same package
class service {

    void readFile(File file) throws FileNotFoundException {

        Scanner scan = new Scanner(file);

        // try catch for writing in file
        try {
            FileWriter outputFile = generateOutputFile();
            CSVWriter writer = new CSVWriter(outputFile);
            generateRow(writer,new String[] {"Name","Category"});

            scan.nextLine();

            // scanning for each line in input.txt file
            while(scan.hasNext()){
                String entry = scan.nextLine();

                // saving each comma seperated element in an arraylist so that data extraction will be easy with indexes.
                List<String> rowEntry = new ArrayList<String>();
                String temp = "";
                char comma = ',';

                // adding comma seperated strings into list
                for(int i=0; i<entry.length(); i++){
                    if(entry.charAt(i) == comma){
                        rowEntry.add(temp);
                        temp = "";
                    }
                    else if(!Character.isWhitespace(entry.charAt(i)))
                        temp += entry.charAt(i);
                }
                rowEntry.add(temp);

                // validating each row for given condition in problem statement
                if(validEntry(rowEntry)) {
                    String name = getName(rowEntry);
                    String category = getCategory(Integer.parseInt(getAge(rowEntry)));

                    // calling write method for entry of validate row
                    generateRow(writer,new String[] {name,category});
                }
            }

            // closing writer after editing file.
            System.out.println("All the valid entries are done, Please check output file in files folder!");
            writer.close();
        }
        catch (Exception e){
            System.out.println("Error in file generation");
            return;
        }
    }

    FileWriter generateOutputFile() throws IOException {
        FileWriter outputfile = new FileWriter("/home/shreyans/projects/Assignment/src/files/output.csv");
        return outputfile;
    }

    // adding row in csv file
    void generateRow(CSVWriter writer, String[] row){
        writer.writeNext(row);
    }

    // validating row by name, age, email and country
    boolean validEntry(List<String> row) {

        if(getName(row).length()<1 || !checkValidEmail(row.get(row.size()-1)) || !checkCountry(row) || !checkAge(getAge(row))){
            return false;
        }
        return true;
    }

    // validating email using java regular expression(Regex)
    boolean checkValidEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    // checking country and address using India keyword
    boolean checkCountry(List<String> row){
        boolean indian = false;

        for(String str:row){
            if(str.toLowerCase().contains("India".toLowerCase()))
                indian = true;
        }
        return indian;
    }

    // checking age is valid number or not
    boolean checkAge(String age){
        if(age.length() < 1)
            return false;

        for(int i=0; i<age.length(); i++){
            if(!Character.isDigit(age.charAt(i))){
                return false;
            }
        }
        return true;
    }

    String getName(List<String> row){
        return row.get(0);
    }

    String getAge(List<String> row){
        return row.get(1);
    }

    String getCategory(int age){
        if(age > 18)
            return "Adult";
        return "Kid";
    }
}