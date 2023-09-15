package com.voucher.movie.board;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.voucher.movie.config.CardPagingVO;

@Controller
public class BoardController {
	
	@Inject
	BoardService boardService;
	
	List<NewsVO> news_list;
	List<EventVO> event_list;
	List<NoticeVO> notice_list;
	List<PartnerVO> partner_list;
	List<EduVO> edu_list;
	
	//메인 - 박물관 소식 리스트
	@RequestMapping(value="/museum_newsList", method=RequestMethod.GET)
	public String museum_newsList(@ModelAttribute NewsVO newsVo, ModelMap model, @RequestParam(defaultValue = "1") int page, String searchKeyword) throws Exception {
				
		// 총 게시물 수 
		int totalListCnt = boardService.findAllNews();

		// 생성인자로  총 게시물 수, 현재 페이지를 전달
		CardPagingVO pagination = new CardPagingVO(totalListCnt, page);

		// DB select start index
		int startIndex = pagination.getStartIndex();
		// 페이지 당 보여지는 게시글의 최대 개수
		int pageSize = pagination.getPageSize();

		if(searchKeyword == null) { //키워드 null (기본상태)
			news_list = boardService.findNewsPaging(startIndex, pageSize);
	    	model.addAttribute("pagination", pagination);
	    	model.addAttribute("total_cnt", totalListCnt);
	    }else if(searchKeyword != null) { //키워드검색
    		totalListCnt = boardService.searchNewsCnt(searchKeyword);
    		pagination = new CardPagingVO(totalListCnt, page);
    		startIndex = pagination.getStartIndex();
    		pageSize = pagination.getPageSize();
    		news_list = boardService.news_searchList(searchKeyword, startIndex, pageSize);
    		model.addAttribute("pagination", pagination);
    		model.addAttribute("searchKeyword", searchKeyword);
    		model.addAttribute("total_cnt", totalListCnt);
    	}
		    
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
		    
		for(NewsVO news : news_list) {
			String news_date = news.getCreate_date();
		    news_date = news_date.substring(0, 4) + "." + news_date.substring(5, 7) +"." + news_date.substring(8, 10);
		    news.setCreate_date(news_date);
		}
			    
		model.addAttribute("news_list", news_list);
		model.addAttribute("nowpage", page);
				 
		return "/museum_newsList";
	}
	
	//박물관 소식 조회
	@RequestMapping(value="/museum_newsDetail", method=RequestMethod.GET)
	public ModelAndView museum_newsDetail(@RequestParam("id") int news_id) throws Exception{
		ModelAndView mav = new ModelAndView();
		NewsVO detailVo = boardService.viewNewsDetail(news_id);
				
		List<NewsFileVo> newsFileList = boardService.viewNewsFileDetail(news_id);
		String news_date = detailVo.getCreate_date();
		news_date = news_date.substring(0, 4) + "." + news_date.substring(5, 7) +"." + news_date.substring(8, 10);
		detailVo.setCreate_date(news_date);
		    	
		mav.addObject("news", detailVo);
		mav.addObject("newsFileList", newsFileList);
		mav.setViewName("museum_newsDetail");
		return mav;
	}
	
	//메인 - 박물관 이벤트 리스트
	@RequestMapping(value="/museum_eventList", method=RequestMethod.GET)
	public String museum_eventList(@ModelAttribute EventVO eventVo, ModelMap model, @RequestParam(defaultValue = "1") int page, String searchKeyword) throws Exception {
				
		// 총 게시물 수 
		int totalListCnt = boardService.findAllEvents();

		// 생성인자로  총 게시물 수, 현재 페이지를 전달
		CardPagingVO pagination = new CardPagingVO(totalListCnt, page);

		// DB select start index
		int startIndex = pagination.getStartIndex();
		// 페이지 당 보여지는 게시글의 최대 개수
		int pageSize = pagination.getPageSize();

		if(searchKeyword == null) { //키워드 null (기본상태)
			event_list = boardService.findEventPaging(startIndex, pageSize);
	    	model.addAttribute("pagination", pagination);
	    	model.addAttribute("total_cnt", totalListCnt);
	    }else if(searchKeyword != null) { //키워드검색
    		totalListCnt = boardService.searchEventCnt(searchKeyword);
    		pagination = new CardPagingVO(totalListCnt, page);
    		startIndex = pagination.getStartIndex();
    		pageSize = pagination.getPageSize();
    		event_list = boardService.event_searchList(searchKeyword, startIndex, pageSize);
    		model.addAttribute("pagination", pagination);
    		model.addAttribute("searchKeyword", searchKeyword);
    		model.addAttribute("total_cnt", totalListCnt);
    	}
		    
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
		    
		for(EventVO event : event_list) {
			String event_date = event.getCreate_date();
		    event_date = event_date.substring(0, 4) + "." + event_date.substring(5, 7) +"." + event_date.substring(8, 10);
		    event.setCreate_date(event_date);
		}
			    
		model.addAttribute("event_list", event_list);
		model.addAttribute("nowpage", page);
				 
		return "/museum_eventList";
	}
	
	//박물관 이벤트 조회
	@RequestMapping(value="/museum_eventDetail", method=RequestMethod.GET)
	public ModelAndView museum_eventDetail(@RequestParam("id") int event_id) throws Exception{
		ModelAndView mav = new ModelAndView();
		EventVO detailVo = boardService.viewEventDetail(event_id);
				
		List<EventFileVo> eventFileList = boardService.viewEventFileDetail(event_id);
		String event_date = detailVo.getCreate_date();
		event_date = event_date.substring(0, 4) + "." + event_date.substring(5, 7) +"." + event_date.substring(8, 10);
		detailVo.setCreate_date(event_date);
		    	
		mav.addObject("event", detailVo);
		mav.addObject("eventFileList", eventFileList);
		mav.setViewName("museum_eventDetail");
		return mav;
	}
	
	//메인 - 제휴안내 리스트
	@RequestMapping(value="/museum_partnerList", method=RequestMethod.GET)
	public String museum_partnerList(@ModelAttribute PartnerVO partnerVo, ModelMap model, @RequestParam(defaultValue = "1") int page, String searchKeyword) throws Exception {
				
		// 총 게시물 수 
		int totalListCnt = boardService.findAllPartners();

		// 생성인자로  총 게시물 수, 현재 페이지를 전달
		CardPagingVO pagination = new CardPagingVO(totalListCnt, page);

		// DB select start index
		int startIndex = pagination.getStartIndex();
		// 페이지 당 보여지는 게시글의 최대 개수
		int pageSize = pagination.getPageSize();

		if(searchKeyword == null) { //키워드 null (기본상태)
			partner_list = boardService.findPartnerPaging(startIndex, pageSize);
	    	model.addAttribute("pagination", pagination);
	    	model.addAttribute("total_cnt", totalListCnt);
	    }else if(searchKeyword != null) { //키워드검색
    		totalListCnt = boardService.searchPartnerCnt(searchKeyword);
    		pagination = new CardPagingVO(totalListCnt, page);
    		startIndex = pagination.getStartIndex();
    		pageSize = pagination.getPageSize();
    		partner_list = boardService.partner_searchList(searchKeyword, startIndex, pageSize);
    		model.addAttribute("pagination", pagination);
    		model.addAttribute("searchKeyword", searchKeyword);
    		model.addAttribute("total_cnt", totalListCnt);
    	}
		    
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
		    
		for(PartnerVO partner : partner_list) {
			String partner_date = partner.getCreate_date();
			partner_date = partner_date.substring(0, 4) + "." + partner_date.substring(5, 7) +"." + partner_date.substring(8, 10);
		    partner.setCreate_date(partner_date);
		}
			    
		model.addAttribute("partner_list", partner_list);
		model.addAttribute("nowpage", page);
				 
		return "/museum_partnerList";
	}
	
	//제휴안내 조회
	@RequestMapping(value="/museum_partnerDetail", method=RequestMethod.GET)
	public ModelAndView museum_partnerDetail(@RequestParam("id") int partner_id) throws Exception{
		ModelAndView mav = new ModelAndView();
		PartnerVO detailVo = boardService.viewPartnerDetail(partner_id);
				
		List<PartnerFileVo> partnerFileList = boardService.viewPartnerFileDetail(partner_id);
		String partner_date = detailVo.getCreate_date();
		partner_date = partner_date.substring(0, 4) + "." + partner_date.substring(5, 7) +"." + partner_date.substring(8, 10);
		detailVo.setCreate_date(partner_date);
		    	
		mav.addObject("partner", detailVo);
		mav.addObject("partnerFileList", partnerFileList);
		mav.setViewName("museum_partnerDetail");
		return mav;
	}
	
	//메인 - 지난교육 리스트
	@RequestMapping(value="/museum_eduList", method=RequestMethod.GET)
	public String museum_eduList(@ModelAttribute EduVO eduVo, ModelMap model, @RequestParam(defaultValue = "1") int page, String searchKeyword) throws Exception {
				
		// 총 게시물 수 
		int totalListCnt = boardService.findAllEdu();

		// 생성인자로  총 게시물 수, 현재 페이지를 전달
		CardPagingVO pagination = new CardPagingVO(totalListCnt, page);

		// DB select start index
		int startIndex = pagination.getStartIndex();
		// 페이지 당 보여지는 게시글의 최대 개수
		int pageSize = pagination.getPageSize();

		if(searchKeyword == null) { //키워드 null (기본상태)
			edu_list = boardService.findEduPaging(startIndex, pageSize);
	    	model.addAttribute("pagination", pagination);
	    	model.addAttribute("total_cnt", totalListCnt);
	    }else if(searchKeyword != null) { //키워드검색
    		totalListCnt = boardService.searchEduCnt(searchKeyword);
    		pagination = new CardPagingVO(totalListCnt, page);
    		startIndex = pagination.getStartIndex();
    		pageSize = pagination.getPageSize();
    		edu_list = boardService.edu_searchList(searchKeyword, startIndex, pageSize);
    		model.addAttribute("pagination", pagination);
    		model.addAttribute("searchKeyword", searchKeyword);
    		model.addAttribute("total_cnt", totalListCnt);
    	}
		    
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
		    
		for(EduVO edu : edu_list) {
			String edu_date = edu.getCreate_date();
			edu_date = edu_date.substring(0, 4) + "." + edu_date.substring(5, 7) +"." + edu_date.substring(8, 10);
			edu.setCreate_date(edu_date);
		}
			    
		model.addAttribute("edu_list", edu_list);
		model.addAttribute("nowpage", page);
				 
		return "/museum_eduList";
	}
	
	//지난교육 조회
	@RequestMapping(value="/museum_eduDetail", method=RequestMethod.GET)
	public ModelAndView museum_eduDetail(@RequestParam("id") int edu_id) throws Exception{
		ModelAndView mav = new ModelAndView();
		EduVO detailVo = boardService.viewEduDetail(edu_id);
				
		List<EduFileVo> eduFileList = boardService.viewEduFileDetail(edu_id);
		String edu_date = detailVo.getCreate_date();
		edu_date = edu_date.substring(0, 4) + "." + edu_date.substring(5, 7) +"." + edu_date.substring(8, 10);
		detailVo.setCreate_date(edu_date);
		    	
		mav.addObject("edu", detailVo);
		mav.addObject("eduFileList", eduFileList);
		mav.setViewName("museum_eduDetail");
		return mav;
	}

}
