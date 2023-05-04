package com.artist.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page {
    private int totalCnt; // 총 게시물 갯수
    private int pageSize; // 한 페이지의 크기
    private int naviSize = 10; //페이지 내비게이션의 크기

    private int totalPage; //전체 페이지의 갯수

    private int page; //현재 페이지
    private int beginPage; // 내비게이션의 첫번째 페이지
    private int endPage; // 내비게이션의 마지막 페이지
    private boolean showPrev; //이전 페이지로 이동하는 링크를 보여줄 것인지의 여부
    private boolean showNext; // 다음 페이지로 이동하는 링크를 보여줄 것인지의 여부

    public Page(int totalCnt, int page) {
        this(totalCnt, page, 10);
    }

    public Page(int totalCnt, int page, int pageSize) {
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

        totalPage = (int)Math.ceil(totalCnt / (double)pageSize);//정수 나누기 실수로 해야 반올림 할 수 있는 소수점 나옴
        beginPage = page /naviSize*naviSize+1;
        endPage = Math.min(beginPage+naviSize-1, totalPage);
        showPrev = beginPage != 1; //beginPage가 1이 아니면 showPrev 페이지의 값은 beginPage
        showNext = endPage != totalPage;
    }

    void print() {
        System.out.println("page = "+page);
        System.out.print(showPrev ? "[PREV] " : ""); // showPrev 참이면 Prev 출력
        for (int i = beginPage; i <= endPage; i++) {
            System.out.print(i+ " ");
        }
        System.out.println(showNext ? "[NEXT]" : "");
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "totalCnt=" + totalCnt +
                ", pageSize=" + pageSize +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", page=" + page +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }

}