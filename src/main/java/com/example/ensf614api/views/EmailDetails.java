package com.example.ensf614api.views;

public class EmailDetails {

	private String recipient;
	private String msgBody;
	private String subject;
	
	public EmailDetails(String recipient, String msgBody, 
						String subject) {
        this.recipient = recipient;
        this.msgBody = msgBody;
        this.subject = subject;
    }

    // Getter for recipient
    public String getRecipient() {
        return recipient;
    }

    // Setter for recipient
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    // Getter for msgBody
    public String getMsgBody() {
        return msgBody;
    }

    // Setter for msgBody
    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    // Getter for subject
    public String getSubject() {
        return subject;
    }

    // Setter for subject
    public void setSubject(String subject) {
        this.subject = subject;
    }

}
