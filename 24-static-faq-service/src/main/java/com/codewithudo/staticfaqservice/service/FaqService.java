package com.codewithudo.staticfaqservice.service;

import com.codewithudo.staticfaqservice.model.Faq;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaqService {

    private final List<Faq> faqs = new ArrayList<>();
    private int nextId = 1;

    // Add a new FAQ
    public boolean addFaq(Faq faq) {
        faq.setId(nextId++);
        faqs.add(faq);
        return true;
    }

    // Get all FAQs
    public List<Faq> getAllFaqs() {
        return faqs;
    }

    // Get a FAQ by its ID
    public Faq getFaqById(int id) {
        for (Faq faq : faqs) {
            if (faq.getId().equals(id)) {
                return faq;
            }
        }
        return null;
    }

    // Update an existing FAQ
    public boolean updateFaq(int id, Faq updatedFaq) {
        for (Faq faq : faqs) {
            if (faq.getId().equals(id)) {
                faq.setQuestion(updatedFaq.getQuestion());
                faq.setAnswer(updatedFaq.getAnswer());
                return true;
            }
        }
        return false;
    }

    // Delete a FAQ by its ID
    public boolean deleteFaq(int id) {
        return faqs.removeIf(faq -> faq.getId().equals(id));
    }
}
