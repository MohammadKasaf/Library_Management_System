package com.LibraryManagementSystem.services;

import com.LibraryManagementSystem.models.Book;
import com.LibraryManagementSystem.models.Loan;
import com.LibraryManagementSystem.models.Member;
import com.LibraryManagementSystem.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(int id) {
        return loanRepository.findById(id).orElse(null);
    }

    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public void deleteLoanById(int id) {
        loanRepository.deleteById(id);
    }

    public List<Loan> findLoansByMember(Member member) {
        return loanRepository.findByMember(member);
    }

    public List<Loan> findLoansByBook(Book book) {
        return loanRepository.findByBook(book);
    }


}
