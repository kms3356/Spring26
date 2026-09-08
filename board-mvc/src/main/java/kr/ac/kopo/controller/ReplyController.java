package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.reply.service.ReplyService;
import kr.ac.kopo.reply.vo.ReplyVO;

// restcontroller, responsebody붙히면 return 값을 html로 해석하는게 아니라 단순 텍스트, xml, json으로 해석
@RestController
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/reply")
	public void addReply(ReplyVO reply) {
		System.out.println("reply : " + reply);
		replyService.addReplyService(reply);
	}
	
	@GetMapping("/reply")
	public List<ReplyVO> replyList(@RequestParam("boardNo") int boardNo) {
		List<ReplyVO> replyList = replyService.getReplyList(boardNo);
		for(ReplyVO reply : replyList) {
			System.out.println(reply);
		}
		return replyList;
	}
}
