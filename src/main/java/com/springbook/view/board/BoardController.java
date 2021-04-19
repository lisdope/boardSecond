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
	// 의존성주입으로 해당 클래스의 객체를 만들어 바로 메서드를 쓸 수 있다. 
	
		// 새글 입력
		@RequestMapping("/insertBoard.do") 
		public String inserBoard(BoardVO vo) {
			System.out.println("글 등록 처리");

			boardService.insertBoard(vo); 
			return "getBoardList.do";
		}
	
	//글 목록검색 getBoardList.do 로 지정 부탁드립니다.-cmk 
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
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do") 
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));			
		return "getBoard.jsp";

	}

	// 글 목록 검색
	// @RequestMapping >>> 컨트롤러의 경로를 매핑하여 해당 요청을 처리가 되어지도록 하는 어노테이션
	@RequestMapping("/getBoardList.do")
	// BoardVO >>> 사용자 입력값을 받기 위한 BoardVO클래스
	// BoardDAO >>> DB 연동 처리를 위한 BoardDAO클래스
	// ModelAndView >>> 검색결과와 화면 정보를 저장하여 리턴하기 위한 ModelAndView 클래스
	public String getBoardList(BoardVO vo, Model model) {
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";

	}
}
