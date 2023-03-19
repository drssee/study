package org.zerock.api01.security.exception;

import com.google.gson.Gson;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class AccessTokenException extends RuntimeException {

    TOKEN_ERROR token_error;

    public enum TOKEN_ERROR {
        //enum 타입의 enum은 내부적으로 enum클래스의 구현체들
        UNACCEPT(401,"Token is null or too short"),
        BADTYPE(401, "Token type Bearer"),
        MALFORM(403, "Malformed Token"),
        BADSIGN(403, "BadSignatured Token"),
        EXPIRED(403, "Expired Token");

        private int status;
        private String msg;

        TOKEN_ERROR(int status, String msg) {
            this.status = status;
            this.msg = msg;
        }

        public int getStatus() {
            return this.status;
        }

        public String getMsg() {
            return this.msg;
        }
    }

    public AccessTokenException(TOKEN_ERROR token_error) {
        super(token_error.name());
        this.token_error = token_error;
    }

    public void sendResponseError(HttpServletResponse response) {
        response.setStatus(token_error.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        Gson gson = new Gson();
        String responseStr = gson.toJson(Map.of("msg",token_error.getMsg(), "time", new Date()));

        try {
            //응답의 바디에 responseStr(json)을 전달
            response.getWriter().println(responseStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
