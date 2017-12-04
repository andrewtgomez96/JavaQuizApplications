package gui;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Quiz implements Serializable{
	private ArrayList<QuestionHmWk>allQuestions=new ArrayList<>();
	private int counter=0;
	private int i=0;
	private int numCorrect;
	
	Quiz(){
	}
	
	Quiz(ArrayList<QuestionHmWk> allQuestions2){
		for(int i=0;i<allQuestions2.size();i++){
			allQuestions.add(allQuestions2.get(i));
		}
		//for(QuestionHmWk obj: allQuestions2)
			//allQuestions.add(obj.clone());
	}
	
	public void addQuestion(QuestionHmWk q){
		allQuestions.add(q);
		counter++;
	}
	
	@Override 
	public String toString(){
		String s="";
		for(int i=0;i<allQuestions.size();i++){
			s+=allQuestions.get(i).toString();
		}
		return s;
	}
	
	public boolean canContinue() {
		if(i<counter)
			return true;

			return false;
	}
	
	public String toStringElem() {
		String s="";
		if(i<counter)
		s=allQuestions.get(i).toString();
		return s;
	}
	
	public boolean checkElem(String userAnswer) {
		boolean isCorr=allQuestions.get(i).check(userAnswer);
		if(isCorr)
			numCorrect++;
		
		return isCorr;
	}
	
	public double getScore() {
		return (double)(numCorrect)/(double)counter;
	}
	
	public String getElemAnswer() {
		String answer=allQuestions.get(i).getAnswer();
		i++;
		return answer;
	}
	
	public void rearrangeQuestion(int froIndex, int toIndex) {
		froIndex-=1;
		toIndex-=1;
		Collections.swap(allQuestions, froIndex, toIndex);
		System.out.println(allQuestions.toString());
	}
	
	public void deleteQuestion(int index){
		allQuestions.remove(index-1);
		System.out.println(allQuestions.toString());
		counter--;
	}
	
	public void replaceQuestion(int index, String replacement) {
		allQuestions.get(index).setQuestion(replacement);
	}
	
	public void changeCorrAnswer(int index, String replacement) {
		allQuestions.get(index).setAnswer(replacement);
	}
	
}