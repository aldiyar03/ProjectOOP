package services;

import repository.FAQRepository;
import models.FAQ;

import java.sql.SQLException;

public class FAQService {
    private FAQRepository faqRepository = new   FAQRepository();

    public FAQService() throws SQLException {
    }

    public void showFAQs() {
        for (FAQ faq : faqRepository.getFAQs()) {
            System.out.println(faq.getQuestion() + " - " + faq.getAnswer());
        }
    }
}
