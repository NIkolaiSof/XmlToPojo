package com.cam.camelmicroservicesb.routes.dto.response;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = false)
@XmlRootElement(name = "table")
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {

	@NotNull
	@NotEmpty
	// @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Invalid email address!")
	@Valid
	@XmlElement(name = "keyRequest", namespace = "", required = false)
	public String key;
	@NotNull
	@NotEmpty
	@Size(min = 2, max = 2, message = "minimo 2")
	@XmlElement(name = "valuePcRequest", namespace = "", required = false)
	public String value;

	public Table() {
		super();
	}

	public Table(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "table [key=" + key + ", value=" + value + "]";
	}

}
