
package org.example;

import javax.jms.Connection;

import javax.jms.Destination;

import javax.jms.Message;

import javax.jms.MessageConsumer;

import javax.jms.Session;

import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class Consumer implements Runnable {

    @Override

    public void run() {

        try {

            ActiveMQConnectionFactory factory =

            new ActiveMQConnectionFactory("tcp://localhost:61616");

            //Cria a conexão com ActiveMQ

            Connection connection = factory.createConnection();

            // Inicia a conexão

            connection.start();

            // Cria a sessão

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //Crea a fila e informa qual o destinatário.

            Destination queue = session.createQueue("Queue");

            MessageConsumer consumer = session.createConsumer(queue);

            Message message = consumer.receive();

            if (message instanceof TextMessage) {

                TextMessage textMessage = (TextMessage) message;

                String text = textMessage.getText();

                System.out.println("Consumer Received: " + text);

            }

            session.close();

            connection.close();

        }

        catch (Exception ex) {

            System.out.println("Exception Occured");

        }

    }

}

