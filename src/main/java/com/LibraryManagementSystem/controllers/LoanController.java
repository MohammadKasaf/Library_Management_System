package com.LibraryManagementSystem.controllers;

import com.LibraryManagementSystem.models.Book;
import com.LibraryManagementSystem.models.Loan;
import com.LibraryManagementSystem.models.Member;
import com.LibraryManagementSystem.services.BookService;
import com.LibraryManagementSystem.services.LoanService;
import com.LibraryManagementSystem.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;
    @Autowired
    private BookService bookService;
    @Autowired
    private MemberService memberService;

    @GetMapping("/getAllLoans")
    public ResponseEntity<List<Loan>> getAllLoans(){

        try{
            List<Loan> loans=loanService.getAllLoans();
            return new ResponseEntity<>(loans, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getLoanById")
    public ResponseEntity<Loan> getLoanById(@RequestParam("id") int id){
        try{
            Loan loan=loanService.getLoanById(id);
            return new ResponseEntity<>(loan, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createLoan")
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {

        try {
            Loan savedLoan = loanService.saveLoan(loan);
            return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteLoanById")
    public ResponseEntity deleteLoanById(@RequestParam("id") int id) {
        try {
            loanService.deleteLoanById(id);
            return new ResponseEntity<>(HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getLoansByMember/{memberId}")
    public ResponseEntity<List<Loan>> getLoansByMember(@PathVariable int memberId) {
        try {
            Member member = memberService.getMemberById(memberId);
            if (member == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<Loan> loans = loanService.findLoansByMember(member);
            return new ResponseEntity<>(loans, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getLoansByBook/{bookId}")
    public ResponseEntity<List<Loan>> getLoansByBook(@PathVariable int bookId) {
        try {
            Book book = bookService.findById(bookId);
            if (book == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<Loan> loans = loanService.findLoansByBook(book);
            return new ResponseEntity<>(loans, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
