package chap15.exam01;

import java.util.*;

public class BoardDao {
	
	public List<Board2> getBoardList() {
		List<Board2> list = new ArrayList<>();
		
		for(int i=1; i<4; i++) {
			list.add(new Board2("제목"+i, "내용"+i));
		}
		
		return list;
	}
}
