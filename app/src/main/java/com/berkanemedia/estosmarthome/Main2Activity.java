package com.berkanemedia.estosmarthome;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {

    private MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), "tcp://176.31.162.71:1883",
                clientId);

        MqttConnectOptions options = new MqttConnectOptions();
        options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1);
        //IMqttToken token = client.connect(options);

        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Toast.makeText(Main2Activity.this, "connected", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Toast.makeText(Main2Activity.this, "not connected", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void openTheDoor(View view) {
        String topic = "inTopic";
        String payload = "o";

        try {
            client.publish(topic, payload.getBytes(),0,false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void closeTheDoor(View view) {
        String topic = "inTopic";
        String payload = "O";

        try {
            client.publish(topic, payload.getBytes(),0,false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void pubR(View view) {
        String topic = "inTopic";
        String payload = "r";
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        if(simpleSwitch.isChecked()){
            payload = "R";
        }

        try {
            client.publish(topic, payload.getBytes(),0,false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void pubE(View view) {
        String topic = "inTopic";
        String payload = "e";
        Switch simpleSwitch = (Switch) findViewById(R.id.switch2);
        if(simpleSwitch.isChecked()){
            payload = "E";
        }

        try {
            client.publish(topic, payload.getBytes(),0,false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void pubC(View view) {
        String topic = "inTopic";
        String payload = "c";
        Switch simpleSwitch = (Switch) findViewById(R.id.switch3);
        if(simpleSwitch.isChecked()){
            payload = "C";
        }

        try {
            client.publish(topic, payload.getBytes(),0,false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void pubD(View view) {
        String topic = "inTopic";
        String payload = "d";
        Switch simpleSwitch = (Switch) findViewById(R.id.switch4);
        if(simpleSwitch.isChecked()){
            payload = "D";
        }

        try {
            client.publish(topic, payload.getBytes(),0,false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void pubA(View view) {
        String topic = "inTopic";
        String payload = "a";
        Switch simpleSwitch = (Switch) findViewById(R.id.switch5);
        if(simpleSwitch.isChecked()){
            payload = "A";
        }

        try {
            client.publish(topic, payload.getBytes(),0,false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void pubB(View view) {
        String topic = "inTopic";
        String payload = "b";
        Switch simpleSwitch = (Switch) findViewById(R.id.switch6);
        if(simpleSwitch.isChecked()){
            payload = "B";
        }

        try {
            client.publish(topic, payload.getBytes(),0,false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
