package com.aprendeali.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.aprendeali.cursomc.domain.Cliente;
import com.aprendeali.cursomc.domain.enums.TipoCliente;
import com.aprendeali.cursomc.dto.ClienteNewDTO;
import com.aprendeali.cursomc.repositories.ClienteRepository;
import com.aprendeali.cursomc.resources.exception.FieldMessage;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Autowired
	ClienteRepository repo;

	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTipoCliente().equals(TipoCliente.PESSOAFISICA.getCod()) && !MZ.isValidCPF(objDto.getNuit())) {
			list.add(new FieldMessage("nuit", "NUIT invalido	"));
		}

		if (objDto.getTipoCliente().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !MZ.isValidCNPJ(objDto.getNuit())) {
			list.add(new FieldMessage("nuit", "NUIT invalido	"));
		}

		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email ja esxistente"));

		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
