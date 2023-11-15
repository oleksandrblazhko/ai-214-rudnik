package com.nuop.tscp

data class WorksList(
    var worksCode: String = "",
    var worksName: String = "",
    var worksGenre: String = "",
    var worksAuthor: String = ""
)

object TestCases {

    fun getWorksInfo(nameLiteratureText: String, genreLiteratureText: String, authorLiteratureText: String): Int {
        val nameLength = nameLiteratureText.length
        val genreLength = genreLiteratureText.length
        val authorLength = authorLiteratureText.length

        if (nameLength < 1 || nameLength > 50) {
            return -1 // Назва не відповідає умові або умовам
        }

        if (genreLength < 1 || genreLength > 20) {
            return -2 // Жанр не відповідає умові або умовам
        }

        if (authorLength < 1 || authorLength > 20) {
            return -3 // Автор не відповідає умові або умовам
        }
        return 1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val result1 = getWorksInfo("Двадцять тисяч льє під водою", "Наукова фантастика", "Жюль Верн")
        println("TC1: ${
            if (result1 == 1) "Passed = 1" else "Failed"
        }")

        val result2 = getWorksInfo("Двадцять тисяч льє під водоюДвадцять тисяч льє під водоюДвадцять тисяч льє під водою", "Наукова фантастика", "Жюль Верн")
        println("TC2: ${
            if (result2 == -1) "Passed = -1" else "Failed"
        }")

        val result3 = getWorksInfo("Двадцять тисяч льє під водою", "Наукова фантастикаНаукова фантастикаНаукова фантастика", "Жюль Верн")
        println("TC3: ${
            if (result3 == -2) "Passed = -2" else "Failed"
        }")

        val result4 = getWorksInfo("Двадцять тисяч льє під водою", "Наукова фантастика", "Жюль ВернЖюль ВернЖюль ВернЖюль ВернЖюль Верн")
        println("TC4: ${
            if (result4 == -3) "Passed = -3" else "Failed"
        }")

        if (1 != result1 || -1 != result2 || -2 != result3 || -3 != result4) {
            System.exit(-1)
        }
    }
}
