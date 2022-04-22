package com.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
public class ContactController {

	/** PATH Parameter based API versioning */
	@GetMapping(value="/api/contact/v1", produces=MediaType.APPLICATION_JSON_VALUE) //OLD API
	public Contact getContact() { 
		return new Contact("Tom", 12345);
	}
	@GetMapping(value="/api/contact/v2", produces=MediaType.APPLICATION_JSON_VALUE) //NEW API
	public ContactV2 getContact2() { 
		return new ContactV2("Tom", 12345);
	}

	/** Query/Request Parameter based API versioning */
	@GetMapping(value="/api/contact", produces=MediaType.APPLICATION_JSON_VALUE, params="version=v1") //OLD API
	public Contact getContactQueryV1() { 
		return new Contact("Tom", 12345);
	}
	@GetMapping(value="/api/contact", produces=MediaType.APPLICATION_JSON_VALUE, params="version=v2") //NEW API
	public ContactV2 getContactQueryV2() { 
		return new ContactV2("Tom", 12345);
	}

	/** Header Parameter based API versioning */
	@GetMapping(value="/api/contact", produces=MediaType.APPLICATION_JSON_VALUE, headers="version=v1") //OLD API
	public Contact getContactHeaderV1() { 
		return new Contact("Tom", 12345);
	}
	@GetMapping(value="/api/contact", produces=MediaType.APPLICATION_JSON_VALUE, headers="version=v2") //NEW API
	public ContactV2 getContactHeaderV2() { 
		return new ContactV2("Tom", 12345);
	}
	
	/** Content Negotiation based API versioning */
	@GetMapping(value="/api/contact", produces="application/contact.v1+json") //OLD API
	public Contact getContactContentNegoV1() { 
		return new Contact("Tom", 12345);
	}
	@GetMapping(value="/api/contact", produces="application/contact.v2+json") //NEW API
	public ContactV2 getContactContentNegoV2() { 
		return new ContactV2("Tom", 12345);
	}
	
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Contact {
	private String name;
	private int mobile;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class ContactV2 {
	private String name;
	private int mobileNo;
}