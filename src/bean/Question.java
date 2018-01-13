package bean;

public class Question {
    private int index;//问题序号
    private String text;//问题内容
    private String rightAnswer;//正确答案：用abcd的方式表示
    private String answer1;//选项A
    private String answer2;//选项B
    private String answer3;//选项C
    private String answer4;//选项D
    private String sign;//问题的唯一标识符（不能含数字）：为了避免在jsp页面传递中数字不能作为键的标识符的问题。
    private int style;//问题的种类：若为单选题则取值为1，若为多选题取值为2
    public Question(int index,String text,String answer1,String answer2,String answer3,String answer4,String rightAnswer,String sign,int style){
        this.index=index;
        this.text=text;
        this.answer1=answer1;
        this.answer2=answer2;
        this.answer3=answer3;
        this.answer4=answer4;
        this.rightAnswer=rightAnswer;
        this.sign=sign;
        this.style=style;
    }

    @Override
    public String toString() {
        String s="序号："+index+"\t题目："+text+"\nA:"+answer1+"\tB:"+answer2+"\tC:"+answer3+"\tD:"+answer4+"\t正确答案："+rightAnswer+"\n";
        return s;
    }

    public int getIndex() {
        return index;
    }

    public String getText() {
        return text;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getSign() {
        return sign;
    }

    public int getStyle() {
        return style;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}
