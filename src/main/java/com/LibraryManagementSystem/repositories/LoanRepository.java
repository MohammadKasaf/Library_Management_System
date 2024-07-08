package com.LibraryManagementSystem.repositories;

import com.LibraryManagementSystem.models.Book;
import com.LibraryManagementSystem.models.Loan;
import com.LibraryManagementSystem.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {


    List<Loan> findByMember(Member member);

    List<Loan> findByBook(Book book);

}
