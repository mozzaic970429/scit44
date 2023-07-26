package net.softsociety.exam.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;
import net.softsociety.exam.service.BoardService;

/**
 * 상품게시판 관련 콘트롤러
 */
@Slf4j
@RequestMapping("board")
@Controller
public class BoardController {

    @Autowired
    BoardService service;

    // 게시판 리스트
	@GetMapping("list")
    public String list(Model model) {
        ArrayList<Board> b =  service.listAll();
        model.addAttribute("board", b);
        return "/board/list";
    }

    // 판매글 등록
    @GetMapping("insert")
    public String insertForm() {
        return "/board/insert";
    }

    @PostMapping("insert")
    public String insert(Board b, @AuthenticationPrincipal UserDetails user) {
        b.setMemberid(user.getUsername());
        service.insert(b);
        return "redirect:/board/list";
    }
}
