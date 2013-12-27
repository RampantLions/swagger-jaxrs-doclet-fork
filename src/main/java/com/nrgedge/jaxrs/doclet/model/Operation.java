package com.nrgedge.jaxrs.doclet.model;

import static com.google.common.base.Strings.emptyToNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.nrgedge.jaxrs.doclet.parser.AnnotationHelper;

public class Operation {

    private HttpMethod httpMethod;
    private String nickname;
    private String type; // void, primitive, complex or a container
    private Map<String,String> items;
    private List<ApiParameter> parameters;
    private String summary; // cap at 60 characters for readability in the UI
    private String notes;

    @JsonProperty("errorResponses")                    // swagger 1.1 name
    private List<ApiResponseMessage> responseMessages; // swagger 1.2 name

    @SuppressWarnings("unused")
    private Operation() {
    }

    public Operation(Method method) {
        this.httpMethod = method.getMethod();
        this.nickname = emptyToNull(method.getMethodName());
        this.type = emptyToNull(AnnotationHelper.typeOf(method.getReturnType()));
        
        if ("array".equals(this.type)) {
        	this.items = new HashMap<String,String>();
        	this.items.put("type", AnnotationHelper.typeOf(method.getGenericReturnType()));
        }
        
        this.parameters = method.getParameters().isEmpty() ? null : method.getParameters();
        this.responseMessages = method.getResponseMessages().isEmpty() ? null : method.getResponseMessages();
        this.summary = emptyToNull(method.getFirstSentence());
        this.notes = emptyToNull(method.getComment());
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getNickname() {
        return nickname;
    }

    public String getType() {
        return type;
    }
    
	public Map<String,String> getItems() {
		return items;
	}

    public List<ApiParameter> getParameters() {
        return parameters;
    }
    
    public List<ApiResponseMessage> getResponseMessages() {
        return responseMessages;
    }

    public String getSummary() {
        return summary;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation that = (Operation) o;
        return Objects.equal(httpMethod, that.httpMethod)
                && Objects.equal(nickname, that.nickname)
                && Objects.equal(type, that.type)
                && Objects.equal(items, that.items)
                && Objects.equal(parameters, that.parameters)
                && Objects.equal(responseMessages, that.responseMessages)
                && Objects.equal(summary, that.summary)
                && Objects.equal(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(httpMethod, nickname, type, items, parameters, responseMessages, summary, notes);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("httpMethod", httpMethod)
                .add("nickname", nickname)
                .add("type", type)
                .add("items", items)
                .add("parameters", parameters)
                .add("responseMessages", responseMessages)
                .add("summary", summary)
                .add("notes", notes)
                .toString();
    }

}
