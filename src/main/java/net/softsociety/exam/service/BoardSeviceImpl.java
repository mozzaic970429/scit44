package net.softsociety.exam.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.softsociety.exam.dao.BoardDAO;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;


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



}
