package com.ssb.rest.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController {

	//based on uri or url version
	@GetMapping(path = "/v1/person")
	public PersonV1 getName() {
		return new PersonV1("Swapnil Bhalerao");
	}

	@GetMapping(path = "/v2/person")
	public PersonV2 getNameV2() {
		return new PersonV2(new Name("Swapnil", "Bhalerao"));
	}

	//based on request param version
	@GetMapping(path = "/person",params = "version=1")
	public PersonV1 getPersonV1() {
		return new PersonV1("Swapnil Bhalerao");
	}
	@GetMapping(path = "/person",params = "version=2")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Swapnil", "Bhalerao"));
	}

	//based on header param version
	@GetMapping(path = "/person",headers = "x-api-version=1")
	public PersonV1 getPersonHeaderBasedV1() {
		return new PersonV1("Swapnil Bhalerao");
	}

	@GetMapping(path = "/person",headers = "x-api-version=2")
	public PersonV2 getPersonHeaderBasedV2() {
		return new PersonV2(new Name("Swapnil", "Bhalerao"));
	}

	//based on media type 
	//based on header param version
		@GetMapping(path = "/person",produces = "application/vnd.company.app-v1+json")
		public PersonV1 getPersonMediaBasedV1() {
			return new PersonV1("Swapnil Bhalerao");
		}
		
		@GetMapping(path = "/person",produces = "application/vnd.company.app-v2+json")
			public PersonV2 getPersoMediaBasedV2() {
				return new PersonV2(new Name("Swapnil", "Bhalerao"));
			}
	
}
