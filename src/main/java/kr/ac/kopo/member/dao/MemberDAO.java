package kr.ac.kopo.member.dao;

import java.util.List;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberDAO {

	/**
	 * 회원가입
	 */
	void insert(MemberVO member);
	
	/**
	 * 전체 회원 조회 기능
	 */
	List<MemberVO> selectAll();
	
	/**
	 * 회원 정보 상세 조회 기능
	 */
	MemberVO selectById(String memberId);
}
