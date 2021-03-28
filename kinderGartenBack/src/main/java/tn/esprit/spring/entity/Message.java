package tn.esprit.spring.entity;


import javax.persistence.*;

import tn.esprit.spring.entity.User;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Date date;

    @ManyToOne
    @JoinColumn(name="from_user_id", nullable=false)
    private User fromUser;


    @ManyToOne
    @JoinColumn(name="to_user_id", nullable=false)
    private User toUser;

    public Message(){
        this.date = new Date();
    }

    public Message(User fromUser, User toUser, String content) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
        this.date = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", date=" + date + ", fromUser=" + fromUser.getEmail() + ", toUser="
				+ toUser.getEmail() + "]";
	}
    
    
    
    
    
    
    
}
