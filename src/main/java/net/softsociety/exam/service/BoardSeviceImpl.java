package net.softsociety.exam.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.dao.BoardDAO;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

@Slf4j
@Transactional
@Service
public class BoardSeviceImpl implements BoardService {

    @Autowired
    BoardDAO dao;

    // 전체글 조회
    @Override
    public ArrayList<Board> listAll() {
        ArrayList<Board> b =  dao.listAll();
        return b;
    }

    // 판매글 등록
    @Override
    public void insert(Board b) {
        dao.insertBoard(b);
    }

    // 판매 정보
    @Override
    public Board info(int boardnum) {
        Board b = dao.infoBoard(boardnum);
        return b;
    }

    // 판매글 삭제
    @Override
    public void delete(Board b) {
        dao.deleteBoard(b);
    }

    // 상품 구매
    @Override
    public void buyItem(Board b) {
        dao.buyItem(b);
    }

    // 댓글 쓰기
    @Override
    public void writeReply(Reply reply) {
        dao.writeReply(reply);
    }

    // 댓글 조회
    @Override
    public ArrayList<Reply> replyAll() {
        ArrayList<Reply> r = dao.replyAll();
        return r;
    }

    // 카테고리 필터링된 리스트 조회
    @Override
    public ArrayList<Board> searchCategory(String category) {
        log.debug("서비스 카테고리 : {}", category);
        return dao.searchCategory(category);
    }

    // 카테고리 + 검색어 필터링
    @Override
    public ArrayList<Board> searchWord(String category, String keyword) {
        log.debug("서비스 카테고리 : {}, 키워드 : {}", category, keyword);
        HashMap<String, String> map = new HashMap<>();
        map.put("category", category);
        map.put("keyword", keyword);
        return dao.searchWord(map);
    }



}
