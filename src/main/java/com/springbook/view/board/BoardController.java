package com.springbook.view.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAOMybatis;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService; 
	// �������������� �ش� Ŭ������ ��ü�� ����� �ٷ� �޼��带 �� �� �ִ�. 
	
		// ���� �Է�
		@RequestMapping("/insertBoard.do") 
		public String inserBoard(BoardVO vo) {
			System.out.println("�� ��� ó��");

			boardService.insertBoard(vo); 
			return "getBoardList.do";
		}
	
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
	
	// �� �� ��ȸ
	@RequestMapping("/getBoard.do") 
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));			
		return "getBoard.jsp";

	}

	// �� ��� �˻�
	// @RequestMapping >>> ��Ʈ�ѷ��� ��θ� �����Ͽ� �ش� ��û�� ó���� �Ǿ������� �ϴ� ������̼�
	@RequestMapping("/getBoardList.do")
	// BoardVO >>> ����� �Է°��� �ޱ� ���� BoardVOŬ����
	// BoardDAO >>> DB ���� ó���� ���� BoardDAOŬ����
	// ModelAndView >>> �˻������ ȭ�� ������ �����Ͽ� �����ϱ� ���� ModelAndView Ŭ����
	public String getBoardList(BoardVO vo, Model model) {
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";

	}
}
