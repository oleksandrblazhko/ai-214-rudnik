// Визначаємо дані класу WorksList, який імплементує інтерфейс Parcelable для передачі об'єктів між компонентами Android.
@Parcelize
data class WorksList(
    var worksCode: String = "",
    var worksName: String = "",
    var worksGenre: String = "",
    var worksAuthor: String = ""
) : Parcelable

// Клас WorksListRepository взаємодіє з Firebase Realtime Database для зберігання та обробки даних про роботи.
class WorksListRepository {
    private val database = Firebase.database
    private val worksDBRef = database.getReference("works_list")

    // Метод створює або оновлює запис про роботу в базі даних.
    fun createOrUpdateWorks(wrkList: WorksList) {
        val worksNodeRef = worksDBRef.child(wrkList.worksCode.toString())
        worksNodeRef.setValue(wrkList)
    }

    // Метод видаляє запис про роботу з бази даних.
    fun deleteWorks(wrkList: WorksList) {
        val worksNodeRef = worksDBRef.child(wrkList.worksCode.toString())
        worksDBRef.removeValue()
    }
}

// Клас Literature представляє активність Android для введення даних про літературні роботи.
class Literature : AppCompatActivity() {
    private lateinit var binding: ActivityLiteratureBinding
    private var repository = WorksListRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiteratureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.findButton.setOnClickListener {
            // Перевіряємо, чи хоча б одне з полів для введення не є порожнім.
            if (binding.nameLiteratureText.text.toString().isNotBlank() ||
                binding.genreLiteratureText.text.toString().isNotBlank() ||
                binding.authorLiteratureText.text.toString().isNotBlank()
            ) {
                // Отримуємо дані з полів введення.
                val nameLiteratureText = binding.nameLiteratureText.text.toString()
                val genreLiteratureText = binding.genreLiteratureText.text.toString()
                val authorLiteratureText = binding.authorLiteratureText.text.toString()
                // Визначаємо результат валідації введених даних.
                val result = getWorksInfo(nameLiteratureText, genreLiteratureText, authorLiteratureText)

                when (result) {
                    1 -> {
                        // Користувач коректно ввів дані, виконуємо потрібні дії.
                        val worksCode = Random.nextInt(1000).toString()
                        val work = WorksList(worksCode, nameLiteratureText, genreLiteratureText, authorLiteratureText)
                        repository.createOrUpdateWorks(work)
                        val intent = Intent(this, BookActivity::class.java)
                        intent.putExtra("bookName", nameLiteratureText)
                        startActivity(intent)
                    }
                    -1 -> {
                        // Назва не відповідає умові або умовам.
                        Toast.makeText(this, "Назва не відповідає умові або умовам", Toast.LENGTH_SHORT).show()
                    }
                    -2 -> {
                        // Жанр не відповідає умові або умовам.
                        Toast.makeText(this, "Жанр не відповідає умові або умовам", Toast.LENGTH_SHORT).show()
                    }
                    -3 -> {
                        // Автор не відповідає умові або умовам.
                        Toast.makeText(this, "Автор не відповідає умові або умовам", Toast_SHORT).show()
                    }
                }
            } else {
                // Виводимо повідомлення про необхідність заповнення хоча б одного поля.
                Toast.makeText(this, "Введіть хоча б одне поле", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Функція визначає результат валідації введених даних на основі назви, жанру та автора.
    private fun getWorksInfo(nameLiteratureText: String, genreLiteratureText: String, authorLiteratureText: String): Int {
        if (isValidName(nameLiteratureText) && isValidGenre(genreLiteratureText) && isValidAuthor(authorLiteratureText)) {
            return 1 // Користувач коректно ввів дані.
        }

        if (!isValidName(nameLiteratureText)) {
            return -1 // Назва не відповідає умові або умовам.
        }

        if (!isValidGenre(genreLiteratureText)) {
            return -2 // Жанр не відповідає умові або умовам.
        }

        if (!isValidAuthor(authorLiteratureText)) {
            return -3 // Автор не відповідає умові або умовам.
        }

        return -4 // Якщо немає жодного відповідного варіанту (повертаємо -4 за замовчуванням).
    }

    // Функції для валідації назви, жанру і автора літературної роботи.
    private fun isValidName(name: String): Boolean {
        return name.length in 2..50 && name.all { it.isLetter() }
    }

    private fun isValidGenre(genre: String): Boolean {
        return genre.length in 2..20 && genre.all { it.isLetter() }
    }

    private fun isValidAuthor(author: String): Boolean {
        return author.length in 2..50 and author.all { it.isLetter() }
    }
}
