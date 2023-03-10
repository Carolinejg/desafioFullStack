package com.rns.testes.java.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rns.testes.java.dto.FilialDTO;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.repositories.FilialRepository;
import com.rns.testes.java.services.exceptions.ResourceNotFoundException;



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
	
	@Transactional(readOnly=true)
	public FilialDTO findById(int id) {
		Optional<Filial>obj = repository.findById(id);
		Filial entity = obj.orElseThrow(()->new ResourceNotFoundException("Entidade n�o encontrada"));
		 
		return new FilialDTO(entity);
	}
	
	@Transactional
	public FilialDTO update(int id,FilialDTO dto) {
		try {
			Filial entity = repository.getOne(id);
			entity.setCnpj(dto.getCnpj());
			entity.setEndereco(dto.getEndereco());
			entity.setRazaoSocial(dto.getRazaoSocial());
			entity.setTipoFilial(dto.getTipoFilial());
			Date date = new Date();
			entity.setDataUltAlteracao1(date);
			entity = repository.save(entity);
			
			return new FilialDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new  ResourceNotFoundException("Id n�o encontrado "+id);
		}
		
	}

	

}
