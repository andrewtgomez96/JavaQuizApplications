package gui;
import java.io.Serializable;
import java.util.ArrayList;

public class QuestionHmWk implements Serializable{
	private String question, answer;
	private ArrayList<String> multipleCorrAnswers;
	
	public QuestionHmWk(String question, ArrayList<String> corrAnswers){
		this.question = question;
		multipleCorrAnswers = new ArrayList<>();
		for(int i=0;i<corrAnswers.size();i++){
			multipleCorrAnswers.add(corrAnswers.get(i));
		}
	}
	
	public QuestionHmWk(String question, String answer){
		this.question = question;
		this.answer = answer;
	}
	public ArrayList<String> getMultipleCorrAnswers() {
		return multipleCorrAnswers;
	}
	
	public String askQuestion(){
		return question+"\n";
	}
	public boolean check(String userAnswer){
		String S="";
		if(getMultipleCorrAnswers()==null)
			return answer.equals(userAnswer);
		else 
			for(int i=0;i<multipleCorrAnswers.size();i++) {
				if(userAnswer.equals(multipleCorrAnswers.get(i)))
						return true;
				S+=multipleCorrAnswers.get(i);
				if(i!=(multipleCorrAnswers.size()-1))
				S+=",";
			}

		if(userAnswer.equals(S))
			return true;
		
		System.out.println(userAnswer+"\n");
		System.out.println(S);
		
		return false;
	}
        protected String getAnswer(){
        	String answer="";
        	if(getMultipleCorrAnswers()==null)
        		return this.answer;
        	else 
        		for(int i=0;i<multipleCorrAnswers.size();i++) {
        			answer+=multipleCorrAnswers.get(i);
        			answer+=" ";
        		}
          return answer;
        }	
	public void setAnswer(String answer){
		if(getMultipleCorrAnswers()==null)
		this.answer = answer;
		else {
			multipleCorrAnswers.clear();
			multipleCorrAnswers.add(answer);
		}
	}
	
	public void setQuestion(String question){
		this.question = question;
	}
 
	public QuestionHmWk clone(){
		return new QuestionHmWk(question, answer);
	}
	@Override
	public String toString(){
		return question+"\n";
	}
}