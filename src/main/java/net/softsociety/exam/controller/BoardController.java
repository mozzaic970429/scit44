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

    // 판매 정보
    @GetMapping("info")
    public String info(int boardnum, Model model) {
        Board b = service.info(boardnum);
        model.addAttribute("board", b);
        return "/board/info";
    }

    // 판매글 삭제
    @GetMapping("delete")
    public String delete(int boardnum, @AuthenticationPrincipal UserDetails user) {
        Board b = new Board();
        b.setBoardnum(boardnum);
        b.setMemberid(user.getUsername());
        service.delete(b);
        return "redirect:/board/list";
    }

    // 판매상품 구매
    @GetMapping("buyItem")
    public String buyItem(int boardnum, @AuthenticationPrincipal UserDetails user) {
        Board b = new Board();
        b.setBoardnum(boardnum);
        b.setBuyerid(user.getUsername());
        service.buyItem(b);
        return "redirect:/board/list";
    } 

    // 판매글 댓글쓰기
    @PostMapping("writeReply")
    public String writeReply(Reply reply, @AuthenticationPrincipal UserDetails user) {
        log.debug("리플 : {}", reply);
        reply.setMemberid(user.getUsername());
        log.debug("리플 : {}", reply);
        service.writeReply(reply);
        return "redirect:/board/info?boardnum=" + reply.getBoardnum();
    }
}
