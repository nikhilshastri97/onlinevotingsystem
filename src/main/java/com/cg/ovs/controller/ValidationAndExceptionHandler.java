package com.cg.ovs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.ovs.exception.CandidateNotFoundException;
import com.cg.ovs.exception.CooperativeSocietyNotFoundException;
import com.cg.ovs.exception.NominatedCandidateNotFoundException;
import com.cg.ovs.exception.RegisteredVoterNotFoundException;
import com.cg.ovs.exception.UserNotFoundException;
import com.cg.ovs.exception.VotedListNotFoundException;

import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins = "http://localhost:4200/")
@Slf4j
@ControllerAdvice
public class ValidationAndExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = CandidateNotFoundException.class)
	public ResponseEntity<Object> exception(CandidateNotFoundException exception) {

		return new ResponseEntity<>("Candidate not found", HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = VotedListNotFoundException.class)
	public ResponseEntity<Object> exception2(VotedListNotFoundException exception) {

		log.info("VotedList not found");
		return new ResponseEntity<>("Voted list not found", HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = CooperativeSocietyNotFoundException.class)
	public ResponseEntity<Object> exception(CooperativeSocietyNotFoundException exception) {

		return new ResponseEntity<>("CooperativeSocietyNotFound!!", HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = RegisteredVoterNotFoundException.class)
	public ResponseEntity<Object> exception2(RegisteredVoterNotFoundException exception) {

		return new ResponseEntity<>("Voter Not Found!!", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception) {

		return new ResponseEntity<>("User Not Found!!", HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = NominatedCandidateNotFoundException.class)
	public ResponseEntity<Object> exception(NominatedCandidateNotFoundException exception) {

		return new ResponseEntity<>("Nominated candidate not found!!", HttpStatus.NOT_FOUND);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {

			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);

		});
		System.err.println(errors);
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

}
