package net.softsociety.exam.service;

import java.util.ArrayList;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

public interface BoardService {

    // 전체글 조회
    ArrayList<Board> listAll();

    // 판매글 등록
    void insert(Board b);

    // 판매 정보
    Board info(int boardnum);

    // 판매글 삭제
    void delete(Board b);
    
    // 상품 구매
    void buyItem(Board b);
    
    // 댓글 쓰기
    void writeReply(Reply reply);

    // 댓글 조회
    ArrayList<Reply> replyAll();

    // 카테고리 필터링된 전체글 조회
    ArrayList<Board> filteredList(String type);


}
