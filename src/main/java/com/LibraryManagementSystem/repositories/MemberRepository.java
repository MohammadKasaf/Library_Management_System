package com.LibraryManagementSystem.repositories;

import com.LibraryManagementSystem.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {


}
