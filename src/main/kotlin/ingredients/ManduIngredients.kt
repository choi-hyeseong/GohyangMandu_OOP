package ingredients

import ingredients.calculator.ItemCalculator
import ingredients.item.Item
import io.ItemPrinter

/**
 * 내용물인 Item이 들어가는 만두 입니다.
 * 내용물을 추가, 제거할 수 있습니다.
 */
class ManduIngredients(private val calculator: ItemCalculator, private val printer : ItemPrinter) {

    private val items : MutableList<Item> = mutableListOf()

    //아이템을 추가합니다.
    fun addItem(item: Item) {
        items.add(item)
    }


    //해당 이름을 가진 아이템을 전부 제거합니다.
    fun removeItemsByName(name : String) {
        items.removeAll { it.name == name }
    }

    fun printItems() {
        printer.printItems(items)
    }

    /**
     * 최종 게임 종료시 점수를 계산하는 메소드 입니다.
     * @return 총 아이템의 점수를 계산한 값입니다.
     */
    fun calculateScore() : Int {
        return calculator.calculateScore(items)
    }

}