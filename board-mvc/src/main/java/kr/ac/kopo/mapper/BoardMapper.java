package kr.ac.kopo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardMapper {
	
//	@Select("""
//			select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as "regDate"
//			from tbl_board
//			order by no desc
//			""")
	List<BoardVO> selectAll();

//	@Insert("""
//			insert into tbl_board(no, title, writer, content)
//			values(seq_tbl_board_no.nextval, #{title}, #{writer}, #{content})
//			""")
	void insert(BoardVO board);
	
	@Select("""
			select no, title, writer, content, view_cnt as viewCnt
			     , to_char(reg_date, 'yyyy-mm-dd') as regDate
			  from tbl_board
			 where no = #{no}
			""")
	BoardVO selectByNo(int boardNo);
	
	@Update("""
			update tbl_board set title=#{board.title}, content=#{board.content}
			 where no=#{boardNo}
			""")
	void update(@Param("boardNo") int boardNo, @Param("board") BoardVO board);
	
	@Delete("""
			delete from tbl_board where no=#{no}
			""")
	void delete(int boardNo);
	
	@Update("""
			update tbl_board set view_cnt = view_cnt + 1
			 where no=#{no}
			""")
	void updateViewCnt(int boardNo);
}
