package tn.esprit.spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.IFormSatisfac;

import tn.esprit.spring.service.interfaceS.IFormSatisfacService;


@Service
public class FormSatisfacImpl implements IFormSatisfacService{
	
	@Autowired
	IFormSatisfac formsatisRepo;
	
	
}
