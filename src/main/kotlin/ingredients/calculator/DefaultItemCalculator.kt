package ingredients.calculator

import ingredients.item.Item

/**
 * ItemCalculator의 default 구현체입니다.
 * 현재 기본 값은 모든 아이템 score의 덧셈입니다.
 */
class DefaultItemCalculator : ItemCalculator {
    /**
     * 모든 아이템의 값을 더합니다.
     */
    override fun calculateScore(items: List<Item>): Int {
        return items.sumOf { it.score }
    }
}