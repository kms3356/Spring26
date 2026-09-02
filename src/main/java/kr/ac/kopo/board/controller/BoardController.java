package kr.ac.kopo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	public BoardController() {
		System.out.println("new BoardController()...");
	}
	
	// 전체 게시글 조회
	@RequestMapping("/board")
	public String list(Model model) throws Exception {
		List<BoardVO> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		return "board/list";
	}
	
	// 게시글 작성 폼 화면 요청
	@GetMapping("/board/write")
	public String writeForm(Model model) {
		model.addAttribute("boardVO", new BoardVO());
		System.out.println("Get /board/write");
		return "board/write";
	}
	
	//@GetMapping("/board/write")
	public String writeForm2() {
		System.out.println("Get /board/write2");
		return "board/write2";
	}
	
	// 게시글 작성 처리
	//@RequestMapping(value="/board/write", method=RequestMethod.POST)
	//HttpServletRequest request
	//HttpServletResponse response
	//@RequestParam
	@PostMapping("/board/write")
	public String write(@Valid @ModelAttribute BoardVO board, BindingResult result) {
		System.out.println("Post /board/write");
		
		//String title = request.getParameter("title");
		//String writer = request.getParameter("writer");
		if(result.hasErrors()) {
			return "board/write";
		}
		try {
			boardService.addNewBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(board);
		
		return "redirect:/board";
	}
	
	// 23번 게시글 상세 조회 1
	// http://localhost:8080/board-mvc/board/detail?no=23
	@GetMapping("/board/detail")
	public String detail(@RequestParam("no") int boardNo, Model model) throws Exception {
		
		BoardVO board = boardService.getBoardByBoardNo(boardNo);
		
		model.addAttribute("board", board);
		
		return "board/detail";
	}
	
	// 23번 게시글 상세 조회 2 -> 파라미터만 변경됨
	// http://localhost:8080/board-mvc/board/23
	@GetMapping("/board/{no}")
	public String detail2(@PathVariable("no") int boardNo, Model model) throws Exception {
			
			BoardVO board = boardService.getBoardByBoardNo(boardNo);
			
			model.addAttribute("board", board);
			
			return "board/detail";
		}
}