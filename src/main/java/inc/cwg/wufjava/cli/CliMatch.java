package inc.cwg.wufjava.cli;

import inc.cwg.wufjava.models.Match;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CliMatch {
    public static void doViewMatches(Match match)
    {
        System.out.println(match.getHomeNation().getName() + " vs " + match.getAwayNation().getName());
        System.out.println(match.getScHome() + " - " + match.getScAway());
        ZonedDateTime matchZonedTime = match.getMatchTime().atZone(ZoneId.of("Europe/Paris"));
        ZonedDateTime convertedDateTime = matchZonedTime.withZoneSameInstant(ZoneId.of(match.getTimeZone()));
        String format = "yyyy-MM-dd HH:mm:ss z";
        System.out.println("date: " + convertedDateTime.format(DateTimeFormatter.ofPattern(format)));
    }
}
