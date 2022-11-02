package ru.geekbrains.myapplibrary

class CounterPresenter(private val view: MainView) {

    private val model = CountersModule()

    // HW заменить id кнопок на константы
    fun onCounterClick(id: Int) {
        when (id) {
            btnOne -> {
                val newValue = model.next(0)
                view.setText(newValue.toString(), 0)
            }
            btnTwo -> {
                val newValue = model.next(1)
                view.setText(newValue.toString(), 1)
            }
            btnThree -> {
                val newValue = model.next(2)
                view.setText(newValue.toString(), 2)
            }
        }
    }
}