package com.LibraryManagementSystem.controllers;

import com.LibraryManagementSystem.models.Member;
import com.LibraryManagementSystem.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/getAllMembers")
    public ResponseEntity<List<Member>> getAllMembers() {
        try {
            List<Member> members = memberService.getAllMembers();
            if (members.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(members, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getMemberById")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") int id) {
        try {
            Member member = memberService.getMemberById(id);
            if (member != null) {
                return new ResponseEntity<>(member, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveMember")
    public ResponseEntity<Member> saveMember(@RequestBody Member member) {
        try {
            Member _member = memberService.saveMember(member);
            return new ResponseEntity<>(_member, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteMember")
    public ResponseEntity<HttpStatus> deleteMember(@PathVariable("id") int id) {
        try {
            memberService.deleteMember(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
