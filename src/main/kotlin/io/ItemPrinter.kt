package io

import ingredients.item.Item

/**
 * 아이템 내용물을 표시하는 프린터 (인터페이스로 따로 만들어도 좋을듯)
 * @property console 출력에 사용되는 아이템입니다.
 */
class ItemPrinter(private val console: Console) {

    /**
     * 현재 넣은 아이템을 출력합니다.
     */
    fun printItems(list : List<Item>) {
        console.print("현재 넣은 재료들 : \n")
        val groupedItem = list.groupBy { it.name } //group by로 묶음
        groupedItem.forEach { (name, items) ->
            console.print("$name : ${items.size}개\n")
        }
    }
}