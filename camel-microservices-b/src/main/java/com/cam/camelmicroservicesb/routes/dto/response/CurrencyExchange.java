package com.cam.camelmicroservicesb.routes.dto.response;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.cam.camelmicroservicesb.routes.annotations.Status;
import com.cam.camelmicroservicesb.routes.annotations.ValueOfEnum;

@XmlRootElement(name = "currencyExchange")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class CurrencyExchange {

	private static final long serialVersionUID = -1032725425267130914L;
	private Long id;
	@NotNull
	@NotEmpty
	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "Invalid email address!")
	@XmlElement(name = "From", required = false)
	private String from;
	// @CustomerTypeSubset(anyOf = { Status.DELETED, Status.DRAFT,
	// Status.UNKNOWN_TO_SDK_VERSION })
	@ValueOfEnum(enumClass = Status.class)
	// @EnumNamePattern(regexp = "DRAFT|DELETED|PUBLISHED")
	private Status to;
	@XmlElement(name = "ConversionMultiple", required = false)
	private BigDecimal conversionMultiple;
	@NotNull
	// @AssertFalse
	@Pattern(regexp = "^(true|false)$")
	private String bool;
	@Valid
	@XmlElement(name = "table", required = false)
	private Table table;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Status getTo() {
		return to;
	}

	public void setTo(Status to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getBool() {
		return bool;
	}

	public void setBool(String bool) {
		this.bool = bool;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CurrencyExchange(Long id,
			@NotNull @NotEmpty @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Invalid email address!") String from,
			Status to, BigDecimal conversionMultiple, @NotNull @Pattern(regexp = "^(true|false)$") String bool,
			@Valid Table table) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.bool = bool;
		this.table = table;
	}

	public CurrencyExchange() {
		super();
	}

	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", bool=" + bool + ", table=" + table + "]";
	}

}
