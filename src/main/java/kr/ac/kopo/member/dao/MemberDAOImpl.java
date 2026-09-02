package kr.ac.kopo.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.mapper.MemberMapper;
import kr.ac.kopo.member.vo.MemberVO;

/**
 * Oracle DB에서 게시판 테이블에서 CRUD 기능 클래스
 */

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
//	private DataSource ds;
	private MemberMapper memberMapper;
	
//	public MemberDAOImpl(MemberMapper memberMapper) {
//		super();
//		this.memberMapper = memberMapper;
//	}

	@Override
	public void insert(MemberVO member) {
		memberMapper.insert(member);
	}

	@Override
	public List<MemberVO> selectAll() {
		return memberMapper.selectAll();
	}

	@Override
	public MemberVO selectById(String memberId) {
		return memberMapper.selectById(memberId);
	}
	
//	@Override
//	public List<MemberVO> selectAll() {
//		List<MemberVO> memberList = new ArrayList<>();
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String sql = "select id, name, password, email_id, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr, type, to_char(reg_date, 'yyyy-mm-dd') as regDate "
//				+ "from tbl_member";
////		       sql += " order by id desc ";
//		
//		try {
//			
//			conn = ds.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//		        MemberVO member = new MemberVO();
//		        
//		        member.setId(rs.getString("id"));
//		        member.setName(rs.getString("name"));
//		        member.setPassword(rs.getString("password"));
//		        
//		        // 2. ResultSet에서 가져올 때도 DB 컬럼명 그대로 지정!
//		        member.setEmailId(rs.getString("email_id"));         // emailId (X) -> email_id (O)
//		        member.setEmailDomain(rs.getString("email_domain")); // emailDomain (X) -> email_domain (O)
//		        member.setTel1(rs.getString("tel1"));
//		        member.setTel2(rs.getString("tel2"));
//		        member.setTel3(rs.getString("tel3"));
//		        member.setPost(rs.getString("post"));
//		        member.setBasicAddr(rs.getString("basic_addr"));     // basicAddr (X) -> basic_addr (O)
//		        member.setDetailAddr(rs.getString("detail_addr"));   // detailAddr (X) -> detail_addr (O)
//		        member.setType(rs.getString("type"));
//		        
//		        // 3. to_char(...) as regDate로 alias(별칭)를 줬으므로 regDate 사용
//		        member.setRegDate(rs.getString("regDate"));
//		        
//		        memberList.add(member);
//		    }
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			if(pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			if(conn!= null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		       
//		       
//		       
//		return memberList;
//	}

}
