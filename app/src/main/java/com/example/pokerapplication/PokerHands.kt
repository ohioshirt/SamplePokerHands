package com.example.pokerapplication

/**
 * 役に関する処理
 */
object PokerHands {
    /**
     * カード文字列から役の文字列を返す
     * @param input カード文字列（スート+数字５枚分、ほかは考えなくてよい）
     * @return　役に対応する文字列
     */
    fun makeHands(input: String): String {
        return Hand.fromOrder(
            Regex("[SHDC][^SHDC]+").findAll(input)
                .map { it.groupValues[0] }
                .groupBy { it.substring(1) } // drop SDHC
                .map { it.value.count() }
                .sortedDescending()
                .joinToString("")
        ).symbol
    }
}

enum class Hand(val symbol: String, val order: String) {
    FourCard("4K", "41"),
    FullHouse("FH", "32"),
    ThreeCard("3K", "311"),
    TwoPair("2P", "221"),
    OnePair("1P", "2111"),
    None("--", "11111");

    companion object {
        fun fromOrder(card: String): Hand = values().firstOrNull { it.order == card } ?: None
    }
}
