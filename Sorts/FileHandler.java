import java.io.*;

public class FileHandler
{
    public static Student[] readFile(String pFileName, int size)
    {
        Student[] studentInfo = new Student[size];
        FileInputStream  fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line, splitLine[];
        int i;

        try
        {
            fileStream = new FileInputStream(pFileName); //Open the file.
            rdr = new InputStreamReader(fileStream); //Create reader to read the stream.
            bufRdr = new BufferedReader(rdr); //Read stream line one at a time.
            line = bufRdr.readLine(); //Reads first line of csv file.
            i = 0;

            while(line != null)
            {
                splitLine = line.split(","); //split line using comma from csv file.
                if(splitLine.length == 2) //Check for any extra rows with data. If none, continue to split line.
                {
                    try
                    {
                        int studentID = Integer.parseInt(splitLine[0]); //splitLine from index[0] which is first column of csv file.
                        String studentName = splitLine[1];
                        studentInfo[i] = new Student(studentID, studentName);
                        i++;
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("Issue with reading lines.");
                    }
                }
                line = bufRdr.readLine(); //Read next line
            }
            fileStream.close(); //Clean up stream when not in use.
        }
        catch(IOException errorDetails)
        {
            System.out.println("Invalid File" + errorDetails.getMessage());
        }
        return studentInfo;
    }

    public static void writeToFile(String filename, Student[] studentID)
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw;

        try
        {
            fileStrm = new FileOutputStream(filename);
            pw = new PrintWriter(fileStrm);

            for(int i=0; i<studentID.length; i++)
            {
                pw.println(studentID[i].getStudentID() + "," + studentID[i].getStudentName());
            }
            pw.close();
        }
        catch(IOException e)
        {
            if(fileStrm != null)
            {
                try
                {
                    fileStrm.close();
                }
                catch(IOException ex2)
                {

                }
            }
            System.out.println("Error in writing to file " + e.getMessage());
        }
    }
}