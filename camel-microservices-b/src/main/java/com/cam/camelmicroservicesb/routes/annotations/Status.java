package com.cam.camelmicroservicesb.routes.annotations;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
	DRAFT("DRAFT"), DELETED("DELETED"), PUBLISHED("PUBLISHED"),

	UNKNOWN_TO_SDK_VERSION(null);

	private final String value;

	Status(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

}
