package gui;
import java.io.Serializable;
import java.util.ArrayList;

class MultipleChoiceQuestion extends QuestionHmWk implements Serializable{
	private ArrayList<String> possibleAnswers;
	
public MultipleChoiceQuestion(String question, ArrayList<String> inputAnswers, ArrayList<String> corrAnswer){
		super(question, corrAnswer);
		possibleAnswers = new ArrayList<>();
		for(int i=0;i<4;i++){
			possibleAnswers.add(inputAnswers.get(i));
		}
}
	
	

public MultipleChoiceQuestion(String question, ArrayList<String> inputAnswers, String answer){
		super(question,answer);
		possibleAnswers = new ArrayList<>();
		for(int i=0;i<4;i++){
			possibleAnswers.add(inputAnswers.get(i));
		}
	}
	
@Override
public String askQuestion(){
		return super.askQuestion()+"\n1."+possibleAnswers.get(0)+"\n2."+possibleAnswers.get(1)+"\n3."+possibleAnswers.get(2)+"\n4."+possibleAnswers.get(3)+"\n";
	}
	
public void setPossibleAnswers(ArrayList<String> inputAnswers){
	possibleAnswers.clear();
    for(int i=0;i<4;i++){
			possibleAnswers.add(inputAnswers.get(i));
		}
  }
  
 public ArrayList<String> getPossibleAnswers(){
    return possibleAnswers;
  }

 @Override
public boolean check(String userAnswer){
	String holder=userAnswer;
	switch(userAnswer){
		case "1":	holder=possibleAnswers.get(0);	
					break;
		case "2":	holder=possibleAnswers.get(1);
					break;
		case "3":	holder=possibleAnswers.get(2);
					break;
		case "4":	holder=possibleAnswers.get(3);
					break;
	}
	
	return super.check(holder);
}
@Override 
public String toString(){
		
		return super.askQuestion()+"<br>1."+possibleAnswers.get(0)+"\n<br>2."+possibleAnswers.get(1)+"\n<br>3."+possibleAnswers.get(2)+"\n<br>4."+possibleAnswers.get(3)+"\n";
}
	
@Override
public MultipleChoiceQuestion clone(){
	return new MultipleChoiceQuestion(askQuestion(), possibleAnswers, getAnswer());
}
}
	
