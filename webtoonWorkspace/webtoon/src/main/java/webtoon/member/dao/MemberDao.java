package webtoon.member.dao;

import static webtoon.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webtoon.member.vo.MemberVo;

public class MemberDao {

	public int memberJoin(Connection conn, MemberVo vo) throws Exception{
		//SQL문
		String sql ="INSERT INTO MEMBER ( NO ,ID ,PWD ,NICK ,ADDRESS ,PHONE ) VALUES ( SEQ_MEMBER_NO.NEXTVAL ,? ,? ,? ,? ,? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		pstmt.setString(4, vo.getAddress());
		pstmt.setString(5, vo.getPhone());
		
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	}

	public MemberVo login(Connection conn, MemberVo vo) throws Exception{
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo loginMemberVo = null;
		
		if(rs.next()) {
			String no = rs.getString("NO");
			int vip_no = rs.getInt("VIP_NO");
			int mcoin = rs.getInt("MCOIN");
			int pay_total = rs.getInt("PAY_TOTAL");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String address = rs.getString("ADDRESS");
			String phone = rs.getString("PHONE");
			String interested_yn = rs.getString("INTERESTED_YN");
			String enroll_date = rs.getString("ENROLL_DATE");
			String modify_date = rs.getString("MODIFY_DATE");
			String del_yn = rs.getString("DEL_YN");
			
			loginMemberVo = new MemberVo();
			loginMemberVo.setNo(no);
			loginMemberVo.setVip_no(vip_no);
			loginMemberVo.setMcoin(mcoin);
			loginMemberVo.setPay_total(pay_total);
			loginMemberVo.setId(id);
			loginMemberVo.setPwd(pwd);
			loginMemberVo.setNick(nick);
			loginMemberVo.setAddress(address);
			loginMemberVo.setPhone(phone);
			loginMemberVo.setInterested_yn(interested_yn);
			loginMemberVo.setModify_date(modify_date);
			loginMemberVo.setDel_yn(del_yn);
			
		}
		close(rs);
		close(pstmt);
		return loginMemberVo;
	}

	public int quit(Connection conn, String no) throws Exception{
		//SQL
		String sql = "UPDATE MEMBER SET DEL_YN = 'Y' WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	}

	public int edit(Connection conn, MemberVo vo) throws Exception{
		
		//sql
		String sql = "UPDATE MEMBER SET PWD = ? , ADDRESS = ? WHERE  NO = ? AND DEL_YN ='N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPwd());
		pstmt.setString(2, vo.getAddress());
		pstmt.setString(3, vo.getNo());
		int result = pstmt.executeUpdate();
		
		return result;
	}

	public int idCheck(Connection conn, String id) throws Exception{		
		//SQl
		String sql = "SELECT COUNT(*) AS CNT FROM MEMBER  WHERE ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		
		int cnt = 1;
		if(rs.next()) {
			cnt = rs.getInt("CNT");
		}
		close(rs);
		close(pstmt);
		
		return cnt;
	}

	public List<MemberVo> getAllMembers(Connection conn) throws Exception {
	    String sql = "SELECT * FROM MEMBER WHERE DEL_YN = 'N'";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery();
	    
	    List<MemberVo> member = new ArrayList<MemberVo>();
	    while (rs.next()) {
	    	String no = rs.getString("NO");
	    	int vipNo = rs.getInt("VIP_NO");
	    	int mcoin = rs.getInt("MCOIN");
	    	int payTotal = rs.getInt("PAY_TOTAL");
	    	String id = rs.getString("ID") ;
	    	String pwd = rs.getString("PWD");
	    	String nick = rs.getString("NICK");
	    	String adrress = rs.getString("ADDRESS");
	    	String phone = rs.getString("PHONE") ;
	    	String interestedYn = rs.getString("INTERESTED_YN");
	    	String enrollDate = rs.getString("ENROLL_DATE") ;
	    	String modifyDate = rs.getString("MODIFY_DATE"); 
	    	String delYn = rs.getString("DEL_YN");
	        
	    	
	    	MemberVo vo = new MemberVo();
	        vo.setNo(no);
	        vo.setVip_no(vipNo);
	        vo.setMcoin(mcoin);
	        vo.setPay_total(payTotal);
	        vo.setId(id);
	        vo.setPwd(pwd);
	        vo.setNick(nick);
	        vo.setAddress(adrress);
	        vo.setPhone(phone);
	        vo.setInterested_yn(interestedYn);
	        vo.setEnroll_date(enrollDate);
	        vo.setModify_date(modifyDate);
	        vo.setDel_yn(delYn);
	        
	        member.add(vo);
	    }
	    close(rs);
	    close(pstmt);
	    return member;
	}
}
