package ru.geekbrains.myapplibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.myapplibrary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private var bindingNull: ActivityMainBinding? = null
    private val binding get() = bindingNull!!
    private lateinit var presenter: CounterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingNull = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding) {
            btnButton1.setOnClickListener {
                presenter.onCounterClick(R.id.btnButton1)
            }
            btnButton2.setOnClickListener {
                presenter.onCounterClick(R.id.btnButton2)
            }
            btnButton3.setOnClickListener {
                presenter.onCounterClick(R.id.btnButton3)
            }
        }
    }

    private fun initPresenter() {
        presenter = CounterPresenter(this)
    }

    // HW заменить position на константы
    override fun setText(counter: String, position: Int) {
        with(binding) {
            when (position) {
                zero -> tvText1.text = counter
                one -> tvText2.text = counter
                two -> tvText3.text = counter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingNull = null
    }

}