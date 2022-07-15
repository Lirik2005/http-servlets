package com.lirik.client;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class UrlExample {

    public static void main(String[] args) throws IOException {

        /**
         * Протокол http/https указывать ОБЯЗАТЕЛЬНО!!!
         */

        URL url = new URL("https://www.google.com");

        URLConnection urlConnection = url.openConnection();  // таким образом открываем соединение к URL

        urlConnection.getHeaderFields();  // возвращает headers
        urlConnection.getContent(); // возвращает тело запроса, т.е. HTML-страницу

        /**
         * Кроме адреса ресурса, в конструктор URL можно отдавать и файл, который надо прочитать. Но в целом такое и не требуется
         */

        URL file = new URL("file:/Users/anduser/study_JAVA/httpServlets/src/com/lirik/socket/udp/DatagramRunner.java");

        URLConnection fileConnection = file.openConnection();
    }
}
