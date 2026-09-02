package kr.ac.kopo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.ac.kopo.member.vo.MemberVO;

@Mapper
public interface MemberMapper {

	// 회원가입
//	@Insert("""
//			insert into tbl_member(id, name, password, email_id, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr, type)
//			values(#{id}, #{name}, #{password}, #{emailId}, #{emailDomain}, #{tel1}, #{tel2}, #{tel3}, #{post}, #{basicAddr}, #{detailAddr}, #{type})
//			""")
	void insert(MemberVO member);

	// 전체 회원 조회
//	@Select("""
//			select id, name, password,
//				   email_id as "emailId",
//				   email_domain as "emailDomain",
//				   tel1, tel2, tel3, post,
//				   basic_addr as "basicAddr",
//				   detail_addr as "detailAddr",
//				   type,
//				   to_char(reg_date, 'yyyy-mm-dd') as "regDate"
//			from tbl_member
//			order by reg_date desc
//			""")
	List<MemberVO> selectAll();
	
	// 회원 정보 상세 조회
//	@Select("""
//			select id, name, password,
//				   email_id as "emailId",
//				   email_domain as "emailDomain",
//				   tel1, tel2, tel3, post,
//				   basic_addr as "basicAddr",
//				   detail_addr as "detailAddr",
//				   type,
//				   to_char(reg_date, 'yyyy-mm-dd') as "regDate"
//			from tbl_member
//		   where id = #{id}
//			order by reg_date desc
//			""")
	MemberVO selectById(String memberId);
}
