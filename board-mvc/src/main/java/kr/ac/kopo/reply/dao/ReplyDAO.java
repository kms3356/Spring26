package kr.ac.kopo.reply.dao;

import java.util.List;

import kr.ac.kopo.reply.vo.ReplyVO;

public interface ReplyDAO {
	public void save(ReplyVO reply);
	public List<ReplyVO> selectByBoardNo(int boardNo);
}
