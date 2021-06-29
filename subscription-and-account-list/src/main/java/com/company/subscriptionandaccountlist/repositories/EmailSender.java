package com.company.subscriptionandaccountlist.repositories;

public interface EmailSender {
    void send(String to, String text, String subject);
}
