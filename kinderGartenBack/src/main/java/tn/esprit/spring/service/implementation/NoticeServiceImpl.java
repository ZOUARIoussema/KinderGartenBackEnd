package tn.esprit.spring.service.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Notice;
import tn.esprit.spring.repository.INoticeRepository;
import tn.esprit.spring.service.interfaceS.INoticeService;

@Service
public class NoticeServiceImpl implements INoticeService {

	@Autowired
	INoticeRepository noticeRepo;
	
	@Override
	public List<Notice> getAllNotices() {
		
		List<Notice> listnotices = (List<Notice>) noticeRepo.findAll();
		return listnotices;
	}

	@Override
	public List<Notice> getAllNoticesByScore() {
		
		return (List<Notice>) noticeRepo.getNoticesByScore();
		
	}
	

	@Override
	public void deletNoticeById(int noticeId) 
	{
		
		noticeRepo.deleteById(noticeId);
		
	}

	@Override
	public Notice getNoticeById(int id) {
		return noticeRepo.findById(id).orElse(null);
	}

	

}
