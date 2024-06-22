package ingredients.calculator

import ingredients.item.Item

/**
 * 최종적으로 들어간 재료의 점수를 계산하는 인터페이스
 */
interface ItemCalculator {

    /**
     * 점수를 계산하는 메소드
     * @param items 점수를 가진 아이템의 리스트입니다.
     * @return 계산한 결과값인 Int를 반환합니다.
     */
    fun calculateScore(items : List<Item>) : Int
}