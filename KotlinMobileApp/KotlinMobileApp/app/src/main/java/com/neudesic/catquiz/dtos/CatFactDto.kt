package com.neudesic.catquiz.dtos

import com.neudesic.catquiz.models.CatFact

class CatFactDto(val fact: String) {
    companion object Dto{
        fun fromDto(catDtos: List<CatFactDto>): List<CatFact>?{
            return null
        }

        fun fromDto(catDto: CatFactDto?) : CatFact? {
            return CatFact(catDto?.fact)
        }
    }

}