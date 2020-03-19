package persistence;

import java.util.List;

public interface MemberDAO {

	boolean join(MemberDTO mdto);
	MemberDTO login(MemberDTO mdto);
	int idCheck(String email);
	List<MemberDTO> selectList();


}
