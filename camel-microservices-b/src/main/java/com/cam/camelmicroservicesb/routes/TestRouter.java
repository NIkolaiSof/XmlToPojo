package com.cam.camelmicroservicesb.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.cam.camelmicroservicesb.routes.dto.response.CurrencyExchange;

@Component
public class TestRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {

//		JAXBContext jaxbContext = JAXBContext.newInstance(CurrencyExchange.class);
//		JaxbDataFormat jaxbDataFormat = new JaxbDataFormat(jaxbContext);
//		jaxbDataFormat.setIgnoreJAXBElement(false);
		// jaxbDataFormat.setContextPath(jaxbContext.toString());

		from("file:file/json").to("direct:my-activemq-xml-queue");

		from("direct:my-activemq-xml-queue").unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
				.to("bean-validator://x?group=javax.validation.groups.Default")
				.log("${body} ::::::::::::::::pojo:::::::::::::::").marshal().jacksonxml(CurrencyExchange.class)
				.log("${body} :::::::::::::::::::::xml:::::::::::::::::").to("direct:my-activemq-xml-json-queue");

		// converto xml to pojo
		from("direct:my-activemq-xml-json-queue").unmarshal().jacksonxml(CurrencyExchange.class)
				.to("log:received-message-from-active-mq");

	}

}
