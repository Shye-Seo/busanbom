package com.voucher.movie.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voucher.movie.mappers.BoardDao;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	//박물관소식------------------------------
	public int findAllNews() {
		return boardDao.fintAllNews();
	}
	
	public List<NewsVO> findNewsPaging(int startIndex, int pageSize) {
		return boardDao.findNewsPaging(startIndex, pageSize);
	}
	
	public NewsVO viewNewsDetail(int news_id) {
		return boardDao.viewNewsDetail(news_id);
	}

	public List<NewsFileVo> viewNewsFileDetail(int news_id) {
		return boardDao.viewNewsFileDetail(news_id);
	}

	public int searchNewsCnt(String searchKeyword) {
		return boardDao.searchNewsCnt(searchKeyword);
	}

	public List<NewsVO> news_searchList(String searchKeyword, int startIndex, int pageSize) {
		return boardDao.news_searchList(searchKeyword, startIndex, pageSize);
	}

	//박물관이벤트------------------------------
	public int findAllEvents() {
		return boardDao.findAllEvents();
	}

	public List<EventVO> findEventPaging(int startIndex, int pageSize) {
		return boardDao.findEventPaging(startIndex, pageSize);
	}

	public int searchEventCnt(String searchKeyword) {
		return boardDao.searchEventCnt(searchKeyword);
	}

	public List<EventVO> event_searchList(String searchKeyword, int startIndex, int pageSize) {
		return boardDao.event_searchList(searchKeyword, startIndex, pageSize);
	}

	public EventVO viewEventDetail(int event_id) {
		return boardDao.viewEventDetail(event_id);
	}

	public List<EventFileVo> viewEventFileDetail(int event_id) {
		return boardDao.viewEventFileDetail(event_id);
	}

	//제휴안내------------------------------
	public int findAllPartners() {
		return boardDao.findAllPartners();
	}

	public List<PartnerVO> findPartnerPaging(int startIndex, int pageSize) {
		return boardDao.findPartnerPaging(startIndex, pageSize);
	}

	public int searchPartnerCnt(String searchKeyword) {
		return boardDao.searchPartnerCnt(searchKeyword);
	}

	public List<PartnerVO> partner_searchList(String searchKeyword, int startIndex, int pageSize) {
		return boardDao.partner_searchList(searchKeyword, startIndex, pageSize);
	}

	public PartnerVO viewPartnerDetail(int partner_id) {
		return boardDao.viewPartnerDetail(partner_id);
	}

	public List<PartnerFileVo> viewPartnerFileDetail(int partner_id) {
		return boardDao.viewPartnerFileDetail(partner_id);
	}
	
	//지난교육------------------------------
	public int findAllEdu() {
		return boardDao.findAllEdu();
	}

	public List<EduVO> findEduPaging(int startIndex, int pageSize) {
		return boardDao.findEduPaging(startIndex, pageSize);
	}

	public int searchEduCnt(String searchKeyword) {
		return boardDao.searchEduCnt(searchKeyword);
	}

	public List<EduVO> edu_searchList(String searchKeyword, int startIndex, int pageSize) {
		return boardDao.edu_searchList(searchKeyword, startIndex, pageSize);
	}

	public EduVO viewEduDetail(int edu_id) {
		return boardDao.viewEduDetail(edu_id);
	}

	public List<EduFileVo> viewEduFileDetail(int edu_id) {
		return boardDao.viewEduFileDetail(edu_id);
	}
}
