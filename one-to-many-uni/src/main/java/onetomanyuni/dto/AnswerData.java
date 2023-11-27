package onetomanyuni.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnswerData {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String answer;
private String answeredBy;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public String getAnsweredBy() {
	return answeredBy;
}
public void setAnsweredBy(String answeredBy) {
	this.answeredBy = answeredBy;
}

}
