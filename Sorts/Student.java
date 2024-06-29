public class Student
{
    private int studentID;
    private String studentName;
    
    //Alternate Constructor
    public Student(int inStudentID, String inStudentName)
    {
        studentID = inStudentID;
        studentName = inStudentName;
    }

    //Setters
    public void setStudentID(int inStudentID)
    {
        studentID = inStudentID;
    }
    public void setStudentName(String inStudentName)
    {
        studentName = inStudentName;
    }
    
    //Getters
    public int getStudentID()
    {
        return studentID;
    }
    public String getStudentName()
    {
        return studentName;
    }

    public String toString()
    {
        return (studentID + "," + studentName);
    }
}