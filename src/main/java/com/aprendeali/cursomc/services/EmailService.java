package com.aprendeali.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.aprendeali.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage msg);

}
