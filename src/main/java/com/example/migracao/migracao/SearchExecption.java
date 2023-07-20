package com.example.migracao.migracao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class SearchExecption extends SQLException {

    public SearchExecption(String reason) {
        super(reason);
    }
}
