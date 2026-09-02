package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.mapper.BoardMapper;

/**
 * MyBatis (mapper xml 활용) 게시판 CRUD
 */

//@Repository
public class BoardDAOImpl03 implements BoardDAO {

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BoardVO> selectAll() {
		System.out.println("BoardDAOImpl03 -> selectAll");
		List<BoardVO> boardList = sqlSessionTemplate.selectList("board.dao.BoardDAO.selectAll");
		return boardList;
	}

	@Override
	public void insert(BoardVO board) {
		boardMapper.insert(board);
	}

	@Override
	public BoardVO selectByNo(int boardNo) {
		return boardMapper.selectByNo(boardNo);
	}

}
