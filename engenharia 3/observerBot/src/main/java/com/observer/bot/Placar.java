package com.observer.bot;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class Placar implements Observer {
    private final TelegramClient telegramClient;
    private long chat_id;

    public Placar(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
        chat_id = MyAmazingBot.chat_id;
    }

    @Override
    public void update(String event, int placarCasa, int placarFora) {
        System.out.println("Placar atualizado:");
        System.out.println("Evento: " + event);
        System.out.println("Casa: " + placarCasa + " | Fora: " + placarFora);
        SendMessage message = SendMessage
                .builder()
                .chatId(chat_id)
                .text(event +  " atualizado(a): " + placarCasa + "X" + placarFora)
                .build();
        try {
            telegramClient.execute(message);
        } catch(TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
