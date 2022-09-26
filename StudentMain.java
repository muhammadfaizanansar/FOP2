
/**
 * Write a description of class StudentMain here.
 *
 * @author (Muhammad Faizan Ansar)
 * @version (25/09/2022)
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StudentMain
{
   
    public StudentMain() throws Exception 
    {
        // create and intilize the reader variable to read file
        BufferedReader br = new BufferedReader(new FileReader("prog5001_students_grade_2022.csv"));
        String line = null;
        // create and initialize the array lists to store the data
        List<String> fName = new ArrayList<String>();
        List<String> lName = new ArrayList<String>();
        List<String> sID = new ArrayList<String>();
        List<Double> g1 = new ArrayList<Double>();
        List<Double> g2 = new ArrayList<Double>();    
        List<Double> g3 = new ArrayList<Double>();
        List<Double> tMarks = new ArrayList<Double>();
        List<Double> hMarks ;
        List<Double> lMarks ;
        int linecount = 0;
        // create a menu for user
        Scanner inp = new Scanner(System.in);
        int opt;
        // show the menu
        do{
            System.out.println("Student Marks Main Menu\n");
            System.out.print("1.) Read the File \n");
            System.out.print("2.) Calculate Student Total Marks and Display.\n");
            System.out.print("3.) Print Student Data Less than a threshold.\n");
            System.out.print("4.) Print top 10 and low 10 Student Marks.\n");
            System.out.print("5.) Exit\n");
            System.out.print("\nEnter Your Choice 1-5: ");
            opt = inp.nextInt();
            // take choice from user
            switch(opt){
                case 1:
                       // run the loop until the last line of the file
                        while ((line = br.readLine()) != null) {
                        //String[] values = line.split(",");
                        // ifnore first two lines that holds unit name and column headers
                        linecount ++;
                            if(linecount <3)
                            {
                                continue;
                            }
                            else
                            {// split the line by comman 
                                String[] values = line.split(",");
                                // add values in the array list
                                lName.add(values[0]);
                                fName.add(values[1]);
                                sID.add(values[2]);
                                // as file contains some empty marks check and store them
                                g1.add(Double.valueOf(values[3])); 
                                g2.add(Double.valueOf(values[4]));
                                  g3.add(Double.valueOf(values[5]));
                                /*
                                 * // logic is not working for empty values
                                if(values.length == 4)
                                {
                                   if(values[3]!=null)
                                        g1.add(Double.valueOf(values[3])); 
                                }
                                else
                                {
                                    g1.add(0.0);
                                }
                                
                                if(values.length == 5)
                                {
                                    if(values[4].isEmpty()==false)
                                        g2.add(Double.valueOf(values[4]));
                                }
                                else
                                {
                                    g2.add(0.0);
                                }
                                if(values.length == 6)
                                {
                                    if(values[5]!=null)
                                        g3.add(Double.valueOf(values[5]));
                                }
                                else
                                {
                                    g3.add(0.0);
                                } 
                                */
                            }
                        }
                        System.out.println("File has been read successfully");
                    break;
                case 2:
                    // run the loop until the size of any arraylist
                    for (int i=0;i<fName.size();i++)
                    {       
                        // sum the marks for each student and add it into the array
                        tMarks.add(g1.get(i) + g2.get(i)+ g3.get(i)); 
                    }
                    System.out.println("Total Marks has been calculated successfully successfully");
                    // display student information
                    for (int i=0;i<fName.size();i++)
                    {
                        System.out.println("Student Full Name is "+ lName.get(i)+ " " + fName.get(i));
                        System.out.println("Student Grade 1 is "+ g1.get(i));
                        System.out.println("Student Grade 2 is "+ g2.get(i));
                        System.out.println("Student Grade 3 is "+ g3.get(i));
                        System.out.println("Student Total Mark is "+ tMarks.get(i));
                    }
                    break;
                case 3:
                    System.out.println("Enter the threshold value");
                    // take threshold value from user
                    int threshold = inp.nextInt();
                    System.out.println("Student Names having marks less than the threshold value" + threshold);
                    // run loop
                    for (int i=0;i<tMarks.size()-1;i++)
                    {
                        // check if the marks is less than from threshold value
                        if(tMarks.get(i)<threshold)
                        {
                            System.out.println("Student Full Name is "+ lName.get(i)+ " " + fName.get(i));
                            System.out.println("Student Total Mark is "+ tMarks.get(i));
                        }
                    }
                    break;
                case 4:
                    // print top and last 10 records
                    hMarks = new ArrayList<Double>();
                    lMarks = new ArrayList<Double>();
                    double max = tMarks.get(0);
                    double min = tMarks.get(0);
                    int cMax = 0;
                    int cMin = 0;
                    // run loop to save 10 records
                    for (int i=0;i<10;i++)
                    {
                       for (int j=0;j<tMarks.size();j++){
                        if (tMarks.get(j)>max){
                            max = tMarks.get(j);
                            hMarks.add(max);
                            break;
                            } 
                             
                        }
                        i++;
                    }
                    for (int i=0;i<10;i++)
                    {
                       for (int j=0;j<tMarks.size();j++){
                         if (tMarks.get(j) < min)
                           {
                             min = tMarks.get(j);
                             lMarks.add(min);
                             break;
                           } 
                           
                        }
                        i++;
                    }
            
                    System.out.println("Max Student Total Mark is "+ max);
                    System.out.println(" Min Student Total Mark is "+ min);
                    System.out.println("Max Array "+ hMarks);
                    System.out.println(" Min Array "+ lMarks);
                    break;
                default :
                 System.out.println("Invalid Option");
                 break;
                }
            }
        while(opt != 5);
        br.close();
    } 
}
