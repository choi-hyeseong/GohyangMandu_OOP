package game

import ingredients.ManduIngredients
import ingredients.calculator.DefaultItemCalculator
import ingredients.item.*
import io.Console
import io.ItemPrinter


// 성공 임계 점수입니다.
const val SUCCESS_SCORE = 8

/**
 * 게임을 수행하는 주체입니다.
 */
class HometownGame(private val console: Console) {

    //내용물을 담고 있는 만두입니다.
    lateinit var ingredients: ManduIngredients

    /**
     * 게임을 시작합니다. (재료확인 - 재료추가 - 재료 제거)
     */
    fun startGame() {
        //기본 만두 생성
        ingredients = ManduIngredients(DefaultItemCalculator(), ItemPrinter(console))
        console.print("게임을 시작합니다!\n")
        while (true) {
            //while 루프
            when (chooseMenu()) {
                1 -> insertItem()
                2 -> removeItem()
                3 -> showItem()
                4 -> {
                    endGame()
                    break
                }
            }
        }
    }

    //메뉴 선택
    private fun chooseMenu(): Int {
        var result: Int
        while (true) {
            console.print("원하는 기능을 선택해주세요!\n")
            console.print("1. 재료 넣기\t2.재료 빼기\t3.재료 확인하기\t4. 결과 보기 : ")
            result = console.readIntSafely() //안전하게 읽기
            if (result < 1 || result > 4) //선택지 밖을 벗어난경우. (잘못된 값 입력시 -1 반환함)
                console.print("잘못된 선택값입니다. 다시 선택해주세요\n")
            else
                break
        }
        return result

    }

    fun insertItem() {
        while (true) {
            console.print("넣을 재료의 번호를 입력해주세요.\n")
            console.print("1.돼지고기\t2.두부\t3.양파\t4.양배추\t5.참기름\t6.마늘\t7.대파\n")
            console.print("8.계란\t9.과자\t10.매운고추\t11.치즈\t12.고추장\t13.마요네즈\n")
            console.print("재료 넣기 모드에서 나가려면 14를 입력해주세요. : ")
            val result = console.readIntSafely()
            //나가기
            if (result == 14)
                break
            if (result < 1 || result > 14) {
                console.print("잘못된 입력값입니다.\n")
                continue
            }
            //아닌경우 입력
            val item: Item = when (result) {
                1 -> Pork()
                2 -> Tofu()
                3 -> Onion()
                4 -> Cabbage()
                5 -> SesameOil()
                6 -> Garlic()
                7 -> Leek()
                8 -> Egg()
                9 -> Snack()
                10 -> RedPepper()
                11 -> Cheese()
                12 -> RedPepperPaste()
                13 -> Mayonnaise()
                else -> throw IllegalArgumentException("잘못된 입력값입니다.") //도달하지는 않지만 else 브랜치로 생성
            }
            ingredients.addItem(item) //아이템 입력
            console.print("해당 재료를 넣었습니다 : ${item.name}\n")


        }
    }

    fun removeItem() {
        while (true) {
            console.print("뺄 재료의 번호를 입력해주세요.\n")
            console.print("1.돼지고기\t2.두부\t3.양파\t4.양배추\t5.참기름\t6.마늘\t7.대파\n")
            console.print("8.계란\t9.과자\t10.매운고추\t11.치즈\t12.고추장\t13.마요네즈\n")
            console.print("재료 빼기 모드에서 나가려면 14를 입력해주세요. : ")
            val result = console.readIntSafely()
            //나가기
            if (result == 14)
                break
            if (result < 1 || result > 14) {
                console.print("잘못된 입력값입니다.\n")
                continue
            }
            //아닌경우 찾기
            val item: Item = when (result) {
                1 -> Pork()
                2 -> Tofu()
                3 -> Onion()
                4 -> Cabbage()
                5 -> SesameOil()
                6 -> Garlic()
                7 -> Leek()
                8 -> Egg()
                9 -> Snack()
                10 -> RedPepper()
                11 -> Cheese()
                12 -> RedPepperPaste()
                13 -> Mayonnaise()
                else -> throw IllegalArgumentException("잘못된 입력값입니다.") //도달하지는 않지만 else 브랜치로 생성
            }
            ingredients.removeItemsByName(item.name) //아이템 입력
            console.print("해당 재료를 뺐습니다 : ${item.name}\n")
        }
    }

    fun showItem() {
        ingredients.printItems()
    }

    /**
     * 게임을 종료합니다. (재료 기준 값 계산)
     */
    fun endGame() {
        val score = ingredients.calculateScore()
        if (score > SUCCESS_SCORE) //성공 스코어보다 클경우
            console.print("만두가 맛있습니다~! ")
        else
            console.print("만두가 맛이 없습니다..ㅜㅜ ")
        console.print("최종 점수 $score / $SUCCESS_SCORE \n") //최종 점수 출력
    }

}