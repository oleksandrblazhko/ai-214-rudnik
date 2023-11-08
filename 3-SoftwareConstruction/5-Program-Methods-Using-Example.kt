// Приклад правильної взаємодії
val repository = WorksListRepository()
val worksCode = "123"
val worksName = "Двадцять тисяч льє під водою"
val worksGenre = "Наукова фантастика"
val worksAuthor = "Жюль Верн"
val result = getWorksInfo(worksName, worksGenre, worksAuthor)

                when (result) {
                    1 -> {
                        val message = "Коректно введено дані"
                        Toast.makeText(message)
                    }
                }
                
// Приклад неправильної взаємодії
val repository = WorksListRepository()
val worksCode = "123"
val worksName = "Двадцять тисяч льє під водоюДвадцять тисяч льє під водою"
val worksGenre = "Наукова фантастика"
val worksAuthor = "Жюль Верн"
val result = getWorksInfo(worksName, worksGenre, worksAuthor)

                when (result) {
                    -1 -> {
                        val message = "Назва не відповідає умові або умовам (довжина рядка назва менше 50 літерів та більше 1 літери) | (у рядку повинно міститись лише літери)"
                        Toast.makeText(message)
                    }
                }
                
// Приклад неправильної взаємодії
val repository = WorksListRepository()
val worksCode = "123"
val worksName = "Двадцять тисяч льє під водою"
val worksGenre = "Експериментальний амбієнт-метал з елементами фолк-року"
val worksAuthor = "Жюль Верн"
val result = getWorksInfo(worksName, worksGenre, worksAuthor)

                when (result) {
                    -2 -> {
                        val message = "Жанр не відповідає умові або умовам (довжина рядка жанр менше 20 літерів та більше 1 літери) | (у рядку повинно міститись лише літери)"
                        Toast.makeText(message)
                    }
                }
                
// Приклад неправильної взаємодії
val repository = WorksListRepository()
val worksCode = "123"
val worksName = "Двадцять тисяч льє під водою"
val worksGenre = "Наукова фантастика"
val worksAuthor = "Жюль ВернЖюль ВернЖюль Верн"
val result = getWorksInfo(worksName, worksGenre, worksAuthor)

                when (result) {
                    -3 -> {
                        val message = "Автор не відповідає умові або умовам (довжина рядка автор менше 50 літерів та більше 1 літери) | (у рядку повинно міститись лише літери)"
                        Toast.makeText(message)
                    }
                }
