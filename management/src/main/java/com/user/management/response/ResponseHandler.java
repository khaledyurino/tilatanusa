package com.user.management.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

    public class ResponseHandler {
        public static ResponseEntity<Object> generateResponse(HttpStatus status,
                                                              Object responseObj,
                                                              String success) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("status", status.value());
            map.put("data", responseObj);
            map.put("success",success);

            return new ResponseEntity<Object>(map, status);
        }

    }