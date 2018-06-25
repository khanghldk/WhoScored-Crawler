/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demogoogle;

import crawler.WhoScoredCrawler;
import data.Club;
import data.League;
import data.Player;
import function.ClubFunction;
import function.LeagueFunction;
import function.PlayerFunction;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Character;

/**
 *
 * @author haleduykhang
 */
public class DemoGoogle {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, ParseException {

        try {
            setDriverProperty();
            WhoScoredCrawler crawler = new WhoScoredCrawler();

            List<League> list = LeagueFunction.getLeagues();
            
            crawler.crawlMatches(list.get(4));
            
            crawler.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void setDriverProperty() {
        File file = new File("chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    }
}
