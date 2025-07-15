package com.codewithudo.staticfaqservice.controller;

import com.codewithudo.staticfaqservice.model.Faq;
import com.codewithudo.staticfaqservice.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faqs")
public class FaqController {

    @Autowired
    private FaqService faqService;

    // Get all FAQs
    @GetMapping
    public ResponseEntity<List<Faq>> getAllFaqs() {
        return new ResponseEntity<>(faqService.getAllFaqs(), HttpStatus.OK);
    }

    // Get a FAQ by ID
    @GetMapping("/{id}")
    public ResponseEntity<Faq> getFaqById(@PathVariable int id) {
        Faq faq = faqService.getFaqById(id);
        if (faq != null) {
            return new ResponseEntity<>(faq, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Add a new FAQ
    @PostMapping
    public ResponseEntity<String> addFaq(@RequestBody Faq faq) {
        boolean added = faqService.addFaq(faq);
        if (added) {
            return new ResponseEntity<>("FAQ added successfully.", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed to add FAQ.", HttpStatus.BAD_REQUEST);
    }

    // Update a FAQ by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateFaq(@PathVariable int id, @RequestBody Faq faq) {
        boolean updated = faqService.updateFaq(id, faq);
        if (updated) {
            return new ResponseEntity<>("FAQ updated successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("FAQ not found.", HttpStatus.NOT_FOUND);
    }

    // Delete a FAQ by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFaq(@PathVariable int id) {
        boolean deleted = faqService.deleteFaq(id);
        if (deleted) {
            return new ResponseEntity<>("FAQ deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("FAQ not found.", HttpStatus.NOT_FOUND);
    }
}
