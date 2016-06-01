package com.redeyes.registration.model;

public class Email {
    private String recipient;
    private String subject;
    private String emailText;

    public Email() {
    }

    public Email(String recipient, String subject, String emailText) {
        this.recipient = recipient;
        this.subject = subject;
        this.emailText = emailText;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmailText() {
        return emailText;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }
}
