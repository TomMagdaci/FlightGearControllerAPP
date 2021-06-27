package com.example.flightgearcontroller4.model

import android.content.Context
import android.widget.Toast
import com.example.flightgearcontroller4.MainActivity
import java.lang.Exception
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Socket
import java.util.concurrent.Callable
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.Future


class Model {
    private var throttle: Float = 0f
    private var elevator: Float = 0f
    private var rudder: Float = 0f
    private var aileron: Float = 0f
    private var ip: String = ""
    private var port: Int = 0
    private var client: java.net.Socket = Socket()
    private val executor = Executors.newFixedThreadPool(4)
    private val executor2 = Executors.newFixedThreadPool(1)
    private var prefix : String = "set /controls/flight/"

    private fun send_ (c : java.net.Socket, msg : String){
        c.outputStream.write(msg.toByteArray())
    }

    var Throttle: Float
        get() = throttle
        set(value){
            throttle=value
            if(client.isConnected) {
                var my_msg: String =
                    "set /controls/engines/current-engine/throttle " + throttle.toString() + "\r\n"
                executor.execute(Runnable { client.outputStream.write(my_msg.toByteArray()) })
            }
        }

    var Rudder: Float
        get() = rudder
        set(value){
            rudder=value
            if(client.isConnected) {
                var my_msg: String = prefix + "rudder " + rudder.toString() + "\r\n"
                executor.execute(Runnable { client.outputStream.write(my_msg.toByteArray()) })
            }
        }

    var Elevator: Float
        get() = elevator
        set(value){
            elevator=value
            if(client.isConnected) {
                var my_msg: String = prefix + "elevator " + elevator.toString() + "\r\n"
                executor.execute(Runnable { client.outputStream.write(my_msg.toByteArray()) })
            }
        }

    var Aileron: Float
        get() = aileron
        set(value){
            aileron=value
            if(client.isConnected) {
                var my_msg : String = prefix + "aileron " + aileron.toString()+ "\r\n"
                executor.execute(Runnable {client.outputStream.write(my_msg.toByteArray())})
            }
        }

    var Ip: String
        get() = ip
        set(value){
            //var i: InetAddress = InetAddress.value
            ip=value
        }
    private var i:Int =0
    private fun connect_ (){
        //var i:InetAddress = InetAddress.getByName(ip)
        //client = Socket(ip, port)
/*        executor2.execute(Runnable {
                //client = Socket()
                //need to be in try and catch
                client.connect(InetSocketAddress(ip, port))
        })*/

        var fc: CompletableFuture<Int> = CompletableFuture.supplyAsync({
            try {
                client.connect(InetSocketAddress(ip, port))
                1
            } catch (e: Exception){
                0
            }
        },executor2)


        executor2.shutdown()
        //executor2.awaitTermination(2,java.util.concurrent.TimeUnit.SECONDS)
/*        while (!executor2.isTerminated) {
        }*/
        if (fc.get()==0){
            throw Exception("Cant connect")
        }

    }
    var Port: String
        get() = port.toString()
        set(value){
            port = value.toInt()
            connect_()
        }
}

//20.6 1830