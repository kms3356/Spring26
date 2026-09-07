package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardService {

	List<BoardVO> getBoardList() throws Exception;
	void addNewBoard(BoardVO board) throws Exception;
	BoardVO getBoardByBoardNo(int boardNo) throws Exception;
	void modifyBoard(int boardNo, BoardVO board) throws Exception;
	void deleteBoard(int boardNo) throws Exception;
	void plusViewCnt(int boardNo);
}
