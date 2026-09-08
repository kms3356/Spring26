package kr.ac.kopo.reply.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.mapper.ReplyMapper;
import kr.ac.kopo.reply.vo.ReplyVO;

@Repository
public class RestDAOImpl implements ReplyDAO {
	
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public void save(ReplyVO reply) {
		replyMapper.save(reply);
		
	}
	
	@Override
	public List<ReplyVO> selectByBoardNo(int boardNo) {
		return replyMapper.selectByBoardNo(boardNo);
		
	}

}
