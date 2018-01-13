package bean;

public class QuestionHistory{
    private String id;
    private int grade;
    private int gradeText=0;
    private String time;
    private String user;
    public QuestionHistory(String id,int grade,String time,String user){
        this.id=id;
        this.grade=grade;
        this.time=time;
        this.user=user;
    }

    public String getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public int getGradeText() {
        return gradeText;
    }

    public String getTime() {
        return time;
    }

    public String getUser() {
        return user;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setGradeText(int gradeText) {
        this.gradeText = gradeText;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int totalGrade(){
        return this.grade+this.gradeText;
    }
}
