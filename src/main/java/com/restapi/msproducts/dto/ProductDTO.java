package com.restapi.msproducts.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.restapi.msproducts.validation.NamePrefix;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ProductDTO {
	
	@NamePrefix(message = "Name must start with PRD")
	@NotBlank(message = "Name is required!")
	private String name;
	
	@NotNull
	@Min(value = 20)
	@Positive(message = "Price cannot be Zero or negative")
	private int price;

}
