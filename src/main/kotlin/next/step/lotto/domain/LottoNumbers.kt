package next.step.lotto.domain

@JvmInline
value class LottoNumbers(private val numbers: Set<LottoNumber>) : Set<LottoNumber> by numbers {

    init {
        require(numbers.size == 6) { "로또 번호들은 6개만 생성할 수 있습니다." }
    }

    fun numbers() = numbers.map { it.number() }

    companion object {
        fun from(numbers: Set<Int>): LottoNumbers = LottoNumbers(numbers.map { LottoNumber.of(it) }.toSet())

        fun random(): LottoNumbers {
            val numbers = mutableSetOf<LottoNumber>()
            while (numbers.size != 6) {
                numbers.add(LottoNumber.random())
            }
            return LottoNumbers(numbers)
        }
    }

}