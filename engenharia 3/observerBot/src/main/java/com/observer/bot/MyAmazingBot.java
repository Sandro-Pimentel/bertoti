package com.observer.bot;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyAmazingBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;
    private GerenciadorEventos gerenciadorEventos;
    private Placar placar;
    private Tabela tabela;
    private Partida partida;
    public static long chat_id;
    private ScheduledExecutorService scheduler;

    public MyAmazingBot(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
        gerenciadorEventos = new GerenciadorEventos();
        scheduler = Executors.newScheduledThreadPool(1);
        placar = new Placar(botToken);
        tabela = new Tabela();
        partida = new Partida();
    }

    @Override
    public void consume(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText() ;
            chat_id = update.getMessage().getChatId();

            SendMessage message = null;
            if(message_text.equals("/fatec")) {
                message = SendMessage
                        .builder()
                        .chatId(chat_id)
                        .text("voce esta na fatec")
                        .build();
            }else if(message_text.equals("/subscribe")) {
                message = SendMessage // Create a message object
                        .builder()
                        .chatId(chat_id)
                        .text("Você se inscreveu no jogo com sucesso")
                        .build();
                gerenciadorEventos.addObserver("Gol Fora", this.placar);
                gerenciadorEventos.addObserver("Gol Casa", this.placar);
                gerenciadorEventos.addObserver("Gol Fora", this.tabela);
                gerenciadorEventos.addObserver("Gol Casa", this.tabela);
            } else if(message_text.equals("/unsubscribe")){
                message = SendMessage // Create a message object
                        .builder()
                        .chatId(chat_id)
                        .text("Você se desinscreveu do jogo com sucesso")
                        .build();
                gerenciadorEventos.removeObserver("Gol Fora", this.placar);
                gerenciadorEventos.removeObserver("Gol Casa", this.placar);
                gerenciadorEventos.removeObserver("Gol Fora", this.tabela);
                gerenciadorEventos.removeObserver("Gol Casa", this.tabela);
            } else if(message_text.equals("/start")) {
                message = SendMessage
                        .builder()
                        .chatId(chat_id)
                        .text("Partida iniciada")
                        .build();
                scheduler.scheduleAtFixedRate(() -> {
                    partida.golCasa();
                    System.out.println("gol");
                }, 10, 30, TimeUnit.SECONDS);
            } else {
                message = SendMessage
                        .builder()
                        .chatId(chat_id)
                        .text(update.getMessage().getText())
                        .build();
            }
            try {
                System.out.println(message.toString());
                telegramClient.execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }
    }
}