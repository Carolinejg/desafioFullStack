package com.rns.testes.java.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rns.testes.java.dto.FilialDTO;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.repositories.FilialRepository;



@Service
public class FilialService{
	
	@Autowired
	private FilialRepository repository;
	
	@Transactional
	public FilialDTO insert(FilialDTO dto) {
		Filial entity = new Filial();
		entity.setCnpj(dto.getCnpj());
		entity.setEndereco(dto.getEndereco());
		entity.setRazaoSocial(dto.getRazaoSocial());
		entity.setTipoFilial(dto.getTipoFilial());
			
		Date date = new Date();
		entity.setDataUltAlteracao1(date);
		entity = repository.save(entity);
		
		return new FilialDTO(entity);

	}
	
	@Transactional(readOnly=true) 
	public List<FilialDTO> findAll(){
		List<Filial> list= repository.findAll();
		List<FilialDTO>listDto = new ArrayList<>();
		
		for(Filial cob : list) {
			listDto.add(new FilialDTO(cob));
		}
		
		return listDto;
	}
	
	


	

}
