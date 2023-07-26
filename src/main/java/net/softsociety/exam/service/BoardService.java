package net.softsociety.exam.service;

import java.util.ArrayList;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

public interface BoardService {

    // 전체글 조회
    ArrayList<Board> listAll();

    // 판매글 등록
    void insert(Board b);



}
