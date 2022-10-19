package com.doanchuyennganh.ungtuyenvn.exception.response;

public class ExceptionResponse {

    private final int status;
    private final String message;
    private final String timestamp;
    private final String url;

    private ExceptionResponse(int status, String message, String timestamp, String url) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getUrl() {
        return url;
    }

    public static ExceptionBuilder builder() {
        return new ExceptionBuilder();
    }

    public static class ExceptionBuilder {
        private int status;
        private String message;
        private String timestamp;
        private String url;

        public ExceptionBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ExceptionBuilder withStatus(int status) {
            this.status = status;
            return this;
        }

        public ExceptionBuilder withTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ExceptionBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public ExceptionResponse build() {
            return new ExceptionResponse(status, message, timestamp, url);
        }
    }

}
