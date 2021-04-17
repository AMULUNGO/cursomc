package com.aprendeali.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprendeali.cursomc.domain.Pedido;
import com.aprendeali.cursomc.repositories.PedidoRepository;
import com.aprendeali.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto nao encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));

	}
}
