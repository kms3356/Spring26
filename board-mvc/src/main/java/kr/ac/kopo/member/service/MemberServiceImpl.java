package kr.ac.kopo.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.mapper.MemberMapper;
import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDao;

	@Override
	public void registerMember(MemberVO member) throws Exception {
		memberDao.insert(member);
	}
	
	@Override
	public List<MemberVO> getMemberList() throws Exception {
		
		List<MemberVO> memberList = memberDao.selectAll();
		return memberList;
	}

	@Override
	public MemberVO getMemberById(String memberId) throws Exception {
		return memberDao.selectById(memberId);
	}

	@Override
	public MemberVO checkMember(MemberVO member) throws Exception {
		MemberVO user = getMemberById(member.getId());
		if (user == null || !user.getPassword().equals(member.getPassword()))
			return null;
		
		// 세션에 담을 것은 폼으로 넘어온 member가 아니라 DB에서 조회한 user
		return user;
	}

}
