package com.example.demo.dto;

import lombok.Data;

@Data
public class SearchDto {

    private String title;
    private String keyword;
    private String startDt;
    private String endDt;
    private String isDeleted;
    
    //private int total;
    //private int pageNum;
    //private int amount;
    private int page;             // 현재 페이지 번호
    private int recordSize;       // 페이지당 출력할 데이터 개수
    private int pageSize;         // 화면 하단에 출력할 페이지 사이즈
    private Pagination pagination;    // 페이지네이션 정보

    public SearchDto() {
        this.page = 1;
        this.recordSize = 10;
        this.pageSize = 10;
    }




    
}
