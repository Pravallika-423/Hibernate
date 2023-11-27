package onetomanyuni.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class QuestionData {
@Id
@GeneratedValue(strategy  = GenerationType.IDENTITY )
private int id;
private String question;
private String questionedBy;

@OneToMany(cascade = CascadeType.ALL)
private List<AnswerData> answers;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}

public String getQuestionedBy() {
	return questionedBy;
}

public void setQuestionedBy(String questionedBy) {
	this.questionedBy = questionedBy;
}

public List<AnswerData> getAnswers() {
	return answers;
}

public void setAnswers(List<AnswerData> answers) {
	this.answers = answers;
}


}
