package com.rachelleboyette.catquiz.dtos;

import com.rachelleboyette.catquiz.models.CatFact;

public class CatFactDto {
    private String fact;

    public CatFactDto(String fact) {
        this.fact = fact;
    }

    public static CatFact fromDto(CatFactDto dto) {
        return new CatFact(dto.fact);
    }
}