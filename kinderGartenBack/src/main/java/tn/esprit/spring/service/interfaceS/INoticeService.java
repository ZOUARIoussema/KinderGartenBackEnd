package tn.esprit.spring.service.interfaceS;

import java.util.List;

import tn.esprit.spring.entity.Notice;

public interface INoticeService {
	
	public List<Notice> getAllNotices();
	
	public List<Notice> getAllNoticesByScore();
	public void deletNoticeById(int noticeId);
	
}
