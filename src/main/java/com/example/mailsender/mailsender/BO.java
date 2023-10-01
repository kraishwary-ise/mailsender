package com.example.mailsender.mailsender;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.cache.annotation.Cacheable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Cacheable
public class BO {
		@NotNull
	    @Max(value = 999999, message = "MSISDN Should be valid")
	    private String msisdn;
		@NotNull
	    private int otp;
		@NotNull
	    private String messageBody;


}
