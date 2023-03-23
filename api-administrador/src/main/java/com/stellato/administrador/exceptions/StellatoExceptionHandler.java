package com.stellato.administrador.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.context.NoSuchMessageException;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.stellato.administrador.exceptions.vo.DetalhesErro;

@ControllerAdvice
public class StellatoExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		
		// Carrega a mensagem para o servidor configurada
		//String mensagemUsuario = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
		String mensagemUsuario = ex.getMostSpecificCause().getMessage();
		
		// Carrega a mensagem desenvolvedor
		String mensagemDesenvolvedor = ex.getCause() != null ? ex.getCause().toString() : ex.toString();

		// Cria a lista de erros
		List<com.stellato.administrador.exceptions.vo.DetalhesErro> erros = Arrays.asList(DetalhesErro.builder().addMsgUsuario(mensagemUsuario)
				.addMsgDesenvolvedor(mensagemDesenvolvedor).addStatus(HttpStatus.BAD_REQUEST)
				.addHttpMethod(getHttpMethod(request)).addPath(getPath(request)).build());
		// Retorna a mensagem de erro tratada
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<DetalhesErro> erros = criarListaDeErros(ex.getBindingResult(), request);
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class, NoSuchElementException.class })
	public ResponseEntity<Object> handleEmptyResultDataAccessException(RuntimeException ex, WebRequest request) {

		// Carrega os dados do erro
		String mensagemUsuario = StellatoExceptionMensagem.RECURSO_NAO_ENCONTRADO;
		
		String mensagemDesenvolvedor = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
		// Cria a lista de erros
		List<DetalhesErro> erros = Arrays.asList(DetalhesErro.builder().addMsgUsuario(mensagemUsuario)
				.addMsgDesenvolvedor(mensagemDesenvolvedor).addStatus(HttpStatus.NOT_FOUND)
				.addHttpMethod(getHttpMethod(request)).addPath(getPath(request)).build());
		// Retorna o erro tratado ao cliente
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler({ NoSuchMessageException.class })
	public ResponseEntity<Object> handleEmptyResultSuchMessageException(NoSuchMessageException ex, WebRequest request) {
	
		// Carrega os dados do erro
		String mensagemUsuario = StellatoExceptionMensagem.ARQUIVO_MENSAGEM_NAO_ENCONTRADO;
				
		@SuppressWarnings("deprecation")
		String mensagemDesenvolvedor = NestedExceptionUtils.buildMessage(mensagemUsuario, ex);
		
		// Cria a lista de erros
		List<DetalhesErro> erros = Arrays.asList(DetalhesErro.builder().addMsgUsuario(mensagemUsuario)
				.addMsgDesenvolvedor(mensagemDesenvolvedor).addStatus(HttpStatus.NOT_FOUND)
				.addHttpMethod(getHttpMethod(request)).addPath(getPath(request)).build());
		// Retorna o erro tratado ao cliente
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	

	@ExceptionHandler({ DataIntegrityViolationException.class, SQLIntegrityConstraintViolationException.class })
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
			WebRequest request) {
	
		String mensagemUsuario = StellatoExceptionMensagem.RECURSO_VIOLACAO_CHAVE;
		
		@SuppressWarnings("deprecation")
		String mensagemDesenvolvedor = NestedExceptionUtils.buildMessage(mensagemUsuario, ex);
		
		List<DetalhesErro> erros = Arrays.asList(DetalhesErro.builder().addMsgUsuario(mensagemUsuario)
				.addMsgDesenvolvedor(mensagemDesenvolvedor).addStatus(HttpStatus.BAD_REQUEST)
				.addHttpMethod(getHttpMethod(request)).addPath(getPath(request)).build());
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ StellatoException.class })
	protected ResponseEntity<Object> handleExceptionGeral(RuntimeException ex, WebRequest request) {
		// Carrega os dados do erro
		String mensagemUsuario = ex.getMessage();

		String mensagemDesenvolvedor = tratarMsgDesenvolvedor(ex);

		// Cria a lista de erros
		List<DetalhesErro> erros = Arrays.asList(DetalhesErro.builder().addMsgUsuario(mensagemUsuario)
				.addMsgDesenvolvedor(mensagemDesenvolvedor).addStatus(HttpStatus.BAD_REQUEST)
				.addHttpMethod(getHttpMethod(request)).addPath(getPath(request)).build());
		// Retorna o erro tratado a aplicação cliente
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ IllegalArgumentException.class, RuntimeException.class })
	protected ResponseEntity<Object> handleExceptionAplicacao(RuntimeException error, WebRequest request) {
		// Carrega os dados do erro
		String mensagemUsuario = error.getMessage();
		String mensagemDesenvolvedor = error.getCause() != null ? error.getCause().toString()
				: error.toString() + (error.getStackTrace() != null ? error.getStackTrace()[0].toString() : "");
		// Cria a lista de erros
		List<DetalhesErro> erros = Arrays.asList(DetalhesErro.builder().addMsgUsuario(mensagemUsuario)
				.addMsgDesenvolvedor(mensagemDesenvolvedor).addStatus(HttpStatus.BAD_REQUEST)
				.addHttpMethod(getHttpMethod(request)).addPath(getPath(request)).build());
		// Retorna o erro tratado a aplicação cliente
		return handleExceptionInternal(error, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	private List<DetalhesErro> criarListaDeErros(BindingResult bindingResult, WebRequest request) {
		List<DetalhesErro> erros = new ArrayList<>();

		for (FieldError fieldError : bindingResult.getFieldErrors()) {
	
			String mensagemUsuario = fieldError.getDefaultMessage();
			String mensagemDesenvolvedor = fieldError.toString();
			erros.add(DetalhesErro.builder().addMsgUsuario(mensagemUsuario).addMsgDesenvolvedor(mensagemDesenvolvedor)
					.addStatus(HttpStatus.BAD_REQUEST).addHttpMethod(getHttpMethod(request)).addPath(getPath(request))
					.build());
		}

		return erros;
	}

	private String tratarMsgDesenvolvedor(RuntimeException ex) {
		// Carrega a mensagem principal
		String msg = "Causa: " + (ex.getCause() != null ? ex.getCause().toString() : ex.toString());
		// existe pilha de erro
		if (ex.getStackTrace() != null && ex.getStackTrace().length > 0) {
			// Percorre a lista de erro
			for (int i = 0; i < ex.getStackTrace().length; i++) {
				msg += "\n" + ex.getStackTrace()[i].toString();
			}
		}
		// Retorna a mensagem de erro do desenvolvedor
		return msg;
	}
	

	private String getPath(WebRequest request) {

		return ((ServletWebRequest) request).getRequest().getRequestURI();
	}

	private String getHttpMethod(WebRequest request) {

		return ((ServletWebRequest) request).getRequest().getMethod();
	}
}
