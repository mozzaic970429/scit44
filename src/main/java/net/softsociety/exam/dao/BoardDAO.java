package net.softsociety.exam.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

/**
 * 게시판 관련 매퍼
 */
@Mapper
public interface BoardDAO {

    // 전체글 조회
    ArrayList<Board> listAll();

    // 판매글 등록
    void insertBoard(Board b);

    // 판매 정보
    Board infoBoard(int boardnum);

    // 판매글 삭제
    void deleteBoard(Board b);

    // 상품 구매
    void buyItem(Board b);

    // 댓글 쓰기
    void writeReply(Reply reply);


}
