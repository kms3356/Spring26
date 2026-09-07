package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.mapper.BoardMapper;

/**
 * MyBatis (Mapper 클래스 활용) 게시판 CRUD
 */

@Repository
public class BoardDAOImpl02 implements BoardDAO {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<BoardVO> selectAll() {
		System.out.println("전체 게시글 조회");
		return boardMapper.selectAll();
	}

	@Override
	public void insert(BoardVO board) {
		boardMapper.insert(board);
	}

	@Override
	public BoardVO selectByNo(int boardNo) {
		return boardMapper.selectByNo(boardNo);
	}

	@Override
	public void update(int boardNo, BoardVO board) {
		boardMapper.update(boardNo, board);
		
	}

	@Override
	public void delete(int boardNo) {
		boardMapper.delete(boardNo);
	}

	@Override
	public void updateViewCnt(int boardNo) {
		boardMapper.updateViewCnt(boardNo);
		
	}
	
	
}
