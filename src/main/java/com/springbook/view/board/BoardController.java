package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAOMybatis;

@Controller
public class BoardController {
	
	//�� ��ϰ˻� getBoardList.do �� ���� ��Ź�帳�ϴ�.-cmk 
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAOMybatis boardDao) {
		boardDao.updateBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAOMybatis boardDao) {
		boardDao.deleteBoard(vo);
		return "getBoardList.do";
	}
	
}
