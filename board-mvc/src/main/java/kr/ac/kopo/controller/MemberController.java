package kr.ac.kopo.controller;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

/**
 * 회원 요청 처리 컨트롤러
 */
// 세션 종료시점은 세션 시작한 컨트롤러에서만 할 수 있
@SessionAttributes(value = {"userVO"})
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// 회원가입 폼 화면 요청
	@GetMapping("/member/register")
	public String registerForm(Model model) {
		model.addAttribute("memberVO", new MemberVO());
		return "member/register";	
	}
	
	// 회원가입 처리
	@PostMapping("/member/register")
	public String register(@Valid @ModelAttribute MemberVO member, BindingResult result) {
		
		if(result.hasErrors()) {
			return "member/register";
		}
		try {
			memberService.registerMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(member);

		return "redirect:/";
	}

	// 전체 멤버 조회 요청
	@RequestMapping("/member")
	public String list(Model model) throws Exception {
		
		List<MemberVO> memberList = memberService.getMemberList();
		
		model.addAttribute("memberList", memberList);
		
		return "member/list";
	}	
	
	// 회원 정보 상세 조회 요청
	@GetMapping("/member/{id}")
	public String detail(@PathVariable("id") String memberId, Model model) throws Exception {
		MemberVO member = memberService.getMemberById(memberId);
		
		model.addAttribute("member", member);
		
		return "member/detail";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String login(MemberVO member, Model model, HttpSession session) throws Exception {
		
		MemberVO user = memberService.checkMember(member);
		
		// 로그인 실패
		if (user == null) {
			model.addAttribute("msg", "아이디 또는 패스워드가 맞지 않습니다.");
			return "member/login";
		}
		// 세션에 유저정보 로그인 정보 저장
		//session.setAttribute("userVO", user);
		model.addAttribute("userVO", user);
		return "redirect:/";
	}
	
	@GetMapping("/member/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
}
