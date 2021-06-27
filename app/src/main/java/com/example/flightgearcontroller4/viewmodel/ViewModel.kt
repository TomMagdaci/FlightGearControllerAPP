package com.example.flightgearcontroller4.viewmodel

import com.example.flightgearcontroller4.model.Model
import kotlin.math.roundToInt

class ViewModel(tempModel: Model) {

    private var my_model: Model = tempModel


    var VM_Throttle: Int
        get() {
            var f: Float = my_model.Throttle*100f
            var i: Int = f.roundToInt()
            return i
        }
        set(value){
            var f: Float = value/100f
            my_model.Throttle=f
        }

    var VM_Rudder: Int
        get() {
            var f: Float = my_model.Rudder*100f
            var i: Int = f.roundToInt()
            return i
        }
        set(value){
            var f: Float = value/100f
            my_model.Rudder=f
        }

    var VM_Elevator: Float
        get() = my_model.Elevator
        set(value){
            my_model.Elevator=value
        }

    var VM_Aileron: Float
        get() = my_model.Aileron
        set(value){
            my_model.Aileron=value
        }

    var VM_Port: String
        get() =my_model.Port
        set(value){
            my_model.Port=value
        }

    var VM_IP: String
        get() =my_model.Ip
        set(value){
            my_model.Ip=value
        }

}