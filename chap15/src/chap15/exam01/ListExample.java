package chap15.exam01;

import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDao dao = new BoardDao();
		List<Board2> list = dao.getBoardList();
		
		for(Board2 board : list){
			System.out.println(board.getTitle() + "-" + board.getContent());
		}
	}

}
