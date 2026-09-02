/*
    SPRING 웹 프로젝트: 게시판(tbl_table) 생성
    번호, 제목, 작성자, 내용, 조회수, 등록일
*/
create table tbl_board(
    no number(5) primary key
  , title varchar2(200) not null
  , writer varchar2(200) not null
  , content varchar2(200) not null
  , view_cnt number(5) default 0
  , reg_date date default sysdate
);

-- 게시판 일련번호 생성
create sequence seq_tbl_board_no nocache;

insert into tbl_board(no, title, writer, content)
values(seq_tbl_board_no.nextval, '제목1', '홍길동', '내용1');

insert into tbl_board(no, title, writer, content)
values(seq_tbl_board_no.nextval, '제목2', '홍길순', '내용2');

insert into tbl_board(no, title, writer, content)
values(seq_tbl_board_no.nextval, '제목3', '윤길동', '내용3');

insert into tbl_board(no, title, writer, content)
values(seq_tbl_board_no.nextval, '제목4', '홍길동', '내용4');

insert into tbl_board(no, title, writer, content)
values(seq_tbl_board_no.nextval, '제목5', '하길동', '내용5');

commit;

select * from tbl_board;


CREATE TABLE TBL_MEMBER (
    ID           VARCHAR2(20) PRIMARY KEY,
    NAME         VARCHAR2(20) NOT NULL,
    PASSWORD     VARCHAR2(20) NOT NULL,
    EMAIL_ID     VARCHAR2(30),
    EMAIL_DOMAIN VARCHAR2(20),
    TEL1         CHAR(3),
    TEL2         CHAR(4),
    TEL3         CHAR(4),
    POST         CHAR(5),
    BASIC_ADDR   VARCHAR2(200),
    DETAIL_ADDR  VARCHAR2(200),
    TYPE         CHAR(1) DEFAULT 'U',
    REG_DATE     DATE DEFAULT SYSDATE
);

insert into TBL_MEMBER(ID, NAME, PASSWORD, EMAIL_ID, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr, type)
values ('seungjoo', '승주', '1234', 'sj1234', 'gmail.com', '010', '1234', '5678', '13579', '성남시 중원구 산성동', '산속깊은골짜기', 'U');

insert into TBL_MEMBER(ID, NAME, PASSWORD, EMAIL_ID, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr, type)
values ('minsuk', '민석', '1234', 'ms1234', 'naver.com', '010', '1234', '5678', '13579', '성남시 중원구 이천동', '개미굴', 'U');

insert into TBL_MEMBER(ID, NAME, PASSWORD, EMAIL_ID, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr, type)
values ('bearpower', '웅기', '1234', 'bear1234', 'daum.net', '010', '1234', '5678', '13579', '성남시 중원구 딩댕동', '말벌집 201호', 'U');

insert into TBL_MEMBER(ID, NAME, PASSWORD, EMAIL_ID, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr, type)
values ('ziwoogae', '지우', '1234', '지우개1234', 'kopo.co.kr', '010', '1234', '5678', '13579', '성남시 중원구 왈동', '개가짖는집 305호', 'U');

commit;

select * from tbl_member;













