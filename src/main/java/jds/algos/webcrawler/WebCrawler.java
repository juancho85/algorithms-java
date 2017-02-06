package jds.algos.webcrawler;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * bfs applied to a simple web crawler.
 */
@Component
public class WebCrawler {

    private Queue<String> queue;
    private List<String> discovedWebsitesList;
    private static String URL_REGEX = "http://(\\w+\\.)*(\\w+)";

    public WebCrawler() {
        this.queue = new LinkedList<>();
        this.discovedWebsitesList = new ArrayList<>();
    }

    public void discoverWeb(String root) {
        this.queue.add(root);
        this.discovedWebsitesList.add(root);

        while (!queue.isEmpty()) {
            String v = this.queue.remove();
            String rawHtml = readUrl(v);
            Pattern pattern = Pattern.compile(URL_REGEX);
            Matcher matcher = pattern.matcher(rawHtml);
            while(matcher.find()) {
                String actualUrl = matcher.group();
                //check whether we have already visited
                if(!discovedWebsitesList.contains(actualUrl)) {
                    discovedWebsitesList.add(actualUrl);
                    System.out.printf("Website fount with URL: %s.%n", actualUrl);
                    queue.add(actualUrl);
                }
            }
        }
    }

    private String readUrl(String v) {
        String rawHtml = "";

        try {
            URL url = new URL(v);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = "";

            while((inputLine = in.readLine()) != null) {
                rawHtml += inputLine;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rawHtml;
    }
}
