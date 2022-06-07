package com.swyg.petdiary.dto;

import com.swyg.petdiary.domain.Board;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BoardDto {

    private Long boardId;
    private String boardName; //게시판 명

    /*게시판 생성 API*/
    public void setBoardCreateAPI(String boardName) {
        this.boardName = boardName;
    }

    public Map getBoardCreateAPI() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("boardCreate", true);
        map.put("boardName", boardName);
        return map;
    }

    /*게시판 수정 API*/
    public void setBoardUpdateAPI(String boardName) {
        this.boardName = boardName;
    }

    public Map getBoardUpdateAPI() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("boardEdit", true);
        map.put("boardName", boardName);
        return map;
    }

    /*게시판 전체 보기
    public void setViewAllBoardsAPI(List<Board> boards) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();


    }*/
}
