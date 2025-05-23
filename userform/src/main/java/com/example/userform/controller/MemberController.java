package com.example.userform.controller;

import com.example.userform.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class MemberController {
    private List<Member> members = Arrays.asList(
            new Member(1L, "Trịnh Tấn Thành", "thanhtrinh@example.com", "01/01/2004"),
            new Member(2L, "Cao Lê Sơn", "soncao@example.com", "15/05/2004"),
            new Member(3L, "Phạm Nguyễn Minh Hoàng", "hoangpham@example.com", "20/08/2004"),
            new Member(4L, "Hồ Vũ Xuân Tùng", "tungho@example.com", "10/12/2004")
    );

    @GetMapping("/")
    public String getMembers(Model model) {
        model.addAttribute("members", members);
        return "memberList";
    }

    @GetMapping("/member/{id}")
    public String getMemberDetail(@PathVariable Long id, Model model) {
        Member member = members.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (member == null) {
            return "error";
        }
        model.addAttribute("member", member);
        return "memberDetail";
    }
}