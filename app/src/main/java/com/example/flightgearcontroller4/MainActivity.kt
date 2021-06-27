package com.example.flightgearcontroller4

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import com.example.flightgearcontroller4.model.Model
import com.example.flightgearcontroller4.viewmodel.ViewModel
import org.w3c.dom.Text
import java.lang.Exception
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {

    private var my_model: Model = Model()
    private var my_viewModel: ViewModel = ViewModel(my_model)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var joyStick: com.example.flightgearcontroller4.views.Joystick = findViewById(R.id.joystick)
        joyStick.d = {x: Float, y: Float->run{my_viewModel.VM_Aileron=x
            my_viewModel.VM_Elevator=y
        }}
        joyStick.debug = {x: Float, y: Float->run{val toast = Toast.makeText(getApplicationContext(), x.toString()+", "+y.toString(), Toast.LENGTH_LONG)
            toast.show()}}

        val seekBarThrottle = findViewById<SeekBar>(R.id.throttle)
        seekBarThrottle?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                my_viewModel.VM_Throttle=progress
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })


        val seekBarRudder = findViewById<SeekBar>(R.id.rudder)
        seekBarRudder?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                my_viewModel.VM_Rudder=progress
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })


        val conButton = findViewById<Button>(R.id.button)

        conButton.setBackgroundColor(Color.DKGRAY)
        conButton?.setOnClickListener{
            val text1 = findViewById<EditText>(R.id.editTextIP)
            val text2 = findViewById<EditText>(R.id.editTextPort)

            try {
                my_viewModel.VM_IP = text1.text.toString()
                my_viewModel.VM_Port = text2.text.toString()
            }
            catch (e: Exception){
                val toast = Toast.makeText(getApplicationContext(), "error: cant connect", Toast.LENGTH_LONG)
                toast.show()
            }
            finally {
                // optional finally block
            }
        }
    }
}
//21.6 00:15