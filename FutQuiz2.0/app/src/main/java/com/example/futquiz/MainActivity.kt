package com.example.futquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var position = 0
    var random = 0
    var win = 0
    lateinit var questions: ArrayList<Question>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setupViews()


    }

    fun loadQuestions(){
        questions = ArrayList()

        var question = Question("¿El de la imagen es Erling Haaland?",R.drawable.haaal, true)
        questions.add(question)

        question = Question("¿El de la imagen es Lionel Messi?",R.drawable.messi, true)
        questions.add(question)

        question = Question("¿El de la imagen es Cristiano Ronaldo?",R.drawable.ronadlo, true)
        questions.add(question)

        question = Question("¿El de la imagen es Kylian Mbappe?",R.drawable.mbappe, true)
        questions.add(question)

        question = Question("¿El de la imagen es Joao felix?",R.drawable.griezman, false)
        questions.add(question)

        question = Question("¿El de la imagen es Eden Hazard?",R.drawable.ronadlo, false)
        questions.add(question)

        question = Question("¿El de la imagen es Karin Benzema?",R.drawable.mbappe, false)
        questions.add(question)

        question = Question("¿El de la imagen es NyemarJr?",R.drawable.neymar, true)
        questions.add(question)


        question = Question("¿El de la imagen es Antoine Griezman?",R.drawable.joao, false)
        questions.add(question)

    }
    fun setupViews() {

       showSentence()

        butYes.setOnClickListener {

            if (questions[random].answer ) {
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this
                        ,"Incorrecto", Toast.LENGTH_LONG).show()
            }
        }

        butNo.setOnClickListener {
            if (!questions[random].answer) {
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this
                        ,"Incorrecto", Toast.LENGTH_LONG).show()
            }
        }
        butNext.setOnClickListener {
            showSentence()
        }

    }


    fun showSentence(){
        random = Random.nextInt(0,9)
        textQuestion.text = questions[random].question
        haaland.setImageResource(questions[random].image)
    }
}