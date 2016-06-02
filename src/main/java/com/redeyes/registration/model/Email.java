package com.redeyes.registration.model;

import java.io.Serializable;

/**
 * Email model.
 */
public class Email implements Serializable {
    /**
     * Email rec.
     */
    private String recipient;
    /**
     * Email subj.
     */
    private String subject;
    /**
     * Email text.
     */
    private String emailText;

    /**
     * Non-parameter constructor.
     */
    public Email() {
    }

    /**
     * Constructor with parameters.
     *
     * @param rec  Email rec.
     * @param subj Email subj.
     * @param text Email text.
     */
    public Email(final String rec, final String subj, final String text) {
        this.recipient = rec;
        this.subject = subj;
        this.emailText = text;
    }

    /**
     * Email rec.
     *
     * @return Email rec.
     */
    public final String getRecipient() {
        return recipient;
    }

    /**
     * Email subj.
     *
     * @return Email subj.
     */
    public final String getSubject() {
        return subject;
    }

    /**
     * Email text.
     *
     * @return Email text.
     */
    public final String getEmailText() {
        return emailText;
    }

    /**
     * Set email rec.
     *
     * @param rec Email rec.
     */
    public final void setRecipient(final String rec) {
        this.recipient = rec;
    }

    /**
     * Set email subj.
     *
     * @param subj Email subj.
     */
    public final void setSubject(final String subj) {
        this.subject = subj;
    }

    /**
     * Set email text.
     *
     * @param text Email text.
     */
    public final void setEmailText(final String text) {
        this.emailText = text;
    }
}
