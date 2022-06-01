package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.models.*;
import inc.cwg.wufjava.services.*;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Controller
public class DataController {
    private final WufBoardService wufBoardService;
    private final ConfService confService;
    private final NationService nationService;
    private final WorldCupService worldCupService;
    private final ConfCupService confCupService;
    private final ConfLeagueService confLeagueService;
    private final MatchService matchService;

    public DataController(WufBoardService wufBoardService, ConfService confService, NationService nationService,
                          WorldCupService worldCupService, ConfCupService confCupService, ConfLeagueService confLeagueService,
                          MatchService matchService) {
        this.wufBoardService = wufBoardService;
        this.confService = confService;
        this.nationService = nationService;
        this.worldCupService = worldCupService;
        this.confCupService = confCupService;
        this.confLeagueService = confLeagueService;
        this.matchService = matchService;
    }

    @PostConstruct
   private void init(){
        if(wufBoardService.fetchWufBoard(1) == null){
            WufBoard wuf = new WufBoard("WUF", "WUF",209,"2018");
            wuf = wufBoardService.saveWufBoard(wuf);
            Conf americas = new Conf("Amériques", "américain", 41, "2018",wuf);
            americas = confService.saveConf(americas);
            Nation usa = new Nation("Etats-Unis", 1373.41, 0, americas, "2018","FedEx Field",
                     10, 1,"America/New_York",wuf);
           usa = nationService.saveNation(usa);
            WorldCup worldCup2021 = new WorldCup("Coupe du Monde", "2021",
                    LocalDate.parse("2021-06-03"), LocalDate.parse("2021-07-17"),usa);
            worldCup2021 = worldCupService.saveWorldCup(worldCup2021);
            wuf.getWorldCups().add(worldCup2021);

            Conf europe = new Conf("Europe", "européen", 54, "2018", wuf);
            europe = confService.saveConf(europe);
            Nation germany = new Nation("Allemagne", 1133.98, 0, europe, "2018","Olympiastadion Berlin",
                    28, 12,"Europe/Berlin",wuf);
            germany = nationService.saveNation(germany);
            ConfCup euCup2019 = new ConfCup("Coupe d'Europe", "2019",
                    LocalDate.parse("2019-06-03"), LocalDate.parse("2019-07-06"), germany,europe);
            euCup2019 = confCupService.saveConfCup(euCup2019);
            europe.getConfCups().add(euCup2019);
            ConfLeague eu1A2019 = new ConfLeague("Ligue des Nations - Europe", "2020", "1A", europe);
            eu1A2019 = confLeagueService.saveConfLeague(eu1A2019);
            europe.getConfLeagues().add(eu1A2019);
            ConfLeague eu2A2019 = new ConfLeague("Ligue des Nations - Europe", "2020", "2A", europe);
            eu2A2019 = confLeagueService.saveConfLeague(eu2A2019);
            europe.getConfLeagues().add(eu2A2019);
            europe = confService.saveConf(europe);

            Nation france = new Nation("France", 1294.97, 0, europe,"2018",
                    "Stade de France",  13, 6,"Europe/Paris",wuf);
            france.setWorldCupParticipations(1);
            france.setBestWorldCup(worldCup2021);
            france.setLastWorldCup(worldCup2021);
            france.setLastWCResult("quarts de finale");
            france.setBestWCResult("quarts de finale");
            france.setConfCupParticipations(1);
            france.setBestConfCup(euCup2019);
            france.setLastConfCup(euCup2019);
            france.setLastCCResult("finaliste");
            france.setBestCCResult("finaliste");
            france.setLastConfLeague(eu1A2019);
            france.setLastCLResult("3eme");
            france.setBestConfLeague(eu1A2019);
            france.setBestCLResult("3eme");

            france = nationService.saveNation(france);
            LocalDateTime locDate1 = LocalDateTime.parse("2021-11-20T21:00:00");
            Nation england = new Nation ("Angleterre", 1877.43, 0, europe,
                    "2018", "Twickenham Stadium",  1, 1,"Europe/London",wuf);
            england = nationService.saveNation(england);
            france.getMatchesAway().add(matchService.addMatch(england, france, 18, 16, locDate1, "Europe/Paris"));

            LocalDateTime locDate2 = LocalDateTime.parse("2021-11-13T21:00:00");
            Nation ireland = new Nation("Irlande",1442.74,0,europe,"2018","Aviva Stadium",
                    8,4,"Europe/Dublin",wuf);
           ireland = nationService.saveNation(ireland);
            france.getMatchesAway().add(matchService.addMatch(ireland,france, 14, 16, locDate2, "Europe/Paris"));

            LocalDateTime locDate3 = LocalDateTime.parse("2021-07-09T03:00:00");
            Conf asia = new Conf("Asie","Astiatique",59,"2018", wuf);
            asia = confService.saveConf(asia);
            Nation nzl = new Nation("Nouvelle-Zélande",1815.07,0,asia,"2018","Eden Park",
                    3,1,"Pacific/Auckland",wuf);
            nzl = nationService.saveNation(nzl);
            france.getMatchesAway().add(matchService.addMatch(nzl,france, 85, 51, locDate3, "Europe/Paris"));

            LocalDateTime locDate4 = LocalDateTime.parse("2021-07-02T04:00:00");
            Nation croatia = new Nation("Croatie",1523.75,0,europe,"2018","Stadion Maksimir",
                    5,3,"Europe/Zagreb",wuf);
          croatia = nationService.saveNation(croatia);
            france.getMatchesAway().add(matchService.addMatch(croatia,france, 14, 42, locDate4, "Europe/Paris"));

            LocalDateTime locDate5 = LocalDateTime.parse("2021-06-27T04:00:00");
            Conf africa = new Conf("Afrique","Africaine",56,"2018", wuf);
            africa = confService.saveConf(africa);
            Nation southAfrica = new Nation("Afrique du Sud",1849.6,0,africa,"2018","Ellis Park",
                    2,1,"Africa/Johannesburg",wuf);
            southAfrica = nationService.saveNation(southAfrica);
            france.getMatchesAway().add(matchService.addMatch(southAfrica,france, 52, 13, locDate5, "Europe/Paris"));


            europe.getNations().add(france);
            wuf.getNations().add(france);

            Nation italy = new Nation("Italie", 1153.25, 0, europe, "2018", "Stadio Olympico",
                    25, 10,"Europe/Rome",wuf);
            italy.setWorldCupParticipations(0);
            italy.setBestWorldCup(worldCup2021);
            italy.setLastWorldCup(worldCup2021);
            italy.setBestWCResult("qualifications");
            italy.setLastWCResult("qualifications");
            italy.setConfCupParticipations(1);
            italy.setBestConfCup(euCup2019);
            italy.setLastConfCup(euCup2019);
            italy.setBestCCResult("quarts de finale");
            italy.setLastCCResult("quarts de finale");
            italy.setLastConfLeague(eu2A2019);
            italy.setLastCLResult("3eme");
            italy.setBestConfLeague(eu2A2019);
            italy.setBestCLResult("3eme");

            italy = nationService.saveNation(italy);

            LocalDateTime localDateTime1 = LocalDateTime.parse("2021-10-23T21:00:00");
            Nation wales = new Nation("Pays de Galles",1567.2,0,europe,"2018","Millenium Stadium",
                    4,2,"Europe/London",wuf);
           wales = nationService.saveNation(wales);
            italy.getMatchesHome().add(matchService.addMatch(italy,wales,9, 16, locDate1, "Europe/Rome"));

            LocalDateTime localDateTime2= LocalDateTime.parse("2021-10-16T21:00:00");
            italy.getMatchesAway().add(matchService.addMatch(croatia,italy,14, 16, locDate2, "Europe/Rome"));

            Nation russia = new Nation("Russie",1117.13,0,europe,"2018","Luzhniki Stadium",
                    36,15,"Europe/Moscow",wuf);
           russia = nationService.saveNation(russia);
            LocalDateTime localDateTime3= LocalDateTime.parse("2021-09-18T21:00:00");
            italy.getMatchesHome().add(matchService.addMatch(italy,russia,16, 14, locDate3, "Europe/Rome"));

            LocalDateTime localDateTime4 = LocalDateTime.parse("2021-09-11T21:00:00");
            italy.getMatchesAway().add(matchService.addMatch(germany,italy,14, 16, locDate4, "Europe/Rome"));

            Nation switzerland = new Nation("Suisse",1127.61,0,europe,"2018","Wankdorf Stadium",
                   30,13,"Europe/Zurich",wuf );
            switzerland = nationService.saveNation(switzerland);
            LocalDateTime localDateTime5= LocalDateTime.parse("2021-08-21T21:00:00");
            italy.getMatchesAway().add(matchService.addMatch(switzerland,italy,23, 13, locDate5, "Europe/Rome"));

            europe.getNations().add(italy);
            wuf.getNations().add(italy);

            england.setWorldCupParticipations(1);
            england.setBestWorldCup(worldCup2021);
            england.setLastWorldCup(worldCup2021);
            england.setBestWCResult("4eme");
            england.setLastWCResult("4eme");
            england.setConfCupParticipations(1);
            england.setBestConfCup(euCup2019);
            england.setLastConfCup (euCup2019);
            england.setBestCCResult("vainqueur");
            england.setLastCCResult("vainqueur");
            england.setLastConfLeague(eu1A2019);
            england.setLastCLResult("2eme");
            england.setBestConfLeague(eu1A2019);
            england.setBestCLResult("2eme");

            england = nationService.saveNation(england);

            locDate1 = LocalDateTime.parse("2021-11-20T21:00:00");
           england.getMatchesHome().add(matchService.addMatch(england,france,18, 16, locDate1, "Europe/London"));

            locDate2 = LocalDateTime.parse("2021-10-16T18:30:00");
            england.getMatchesHome().add(matchService.addMatch(england,wales, 16 ,14, locDate2, "Europe/London"));

            locDate3 = LocalDateTime.parse("2021-07-17T03:00:00");
            england.getMatchesHome().add(matchService.addMatch(england,southAfrica, 38, 40, locDate3, "Europe/London"));

            Nation australia = new Nation("Australie",1469.09,0,asia,"2018","Stadium Australia",
                    6,2,"Australia/Sydney",wuf);
            australia = nationService.saveNation(australia);
            locDate4 = LocalDateTime.parse("2021-07-14T00:30:00");
            england.getMatchesHome().add(matchService.addMatch(england,australia, 121, 127, locDate4, "Europe/London"));

            locDate5 = LocalDateTime.parse("2021-07-08T00:30:00");
            england.getMatchesAway().add(matchService.addMatch(ireland,england, 15, 55, locDate5, "Europe/London"));


            europe.getNations().add(england);
            wuf.getNations().add(england);
            wuf.getConfs().add(europe);

            ConfCup amCup2019 = new ConfCup("Coupe des Amériques", "2019", LocalDate.parse("2019-04-01"),
                    LocalDate.parse("2019-05-04"), usa,americas);
            amCup2019 = confCupService.saveConfCup(amCup2019);
            americas.getConfCups().add(amCup2019);
            ConfLeague am1A2019 = new ConfLeague("Ligue des Nations - Amériques", "2020", "1A", americas);
            americas.getConfLeagues().add(am1A2019);
            am1A2019 = confLeagueService.saveConfLeague(am1A2019);
            usa.setWorldCupParticipations(1);
            usa.setBestWorldCup(worldCup2021);
            usa.setLastWorldCup(worldCup2021);
            usa.setBestWCResult("huitièmes de finale");
            usa.setLastWCResult("huitièmes de finale");
            usa.setConfCupParticipations(1);
            usa.setBestConfCup(amCup2019);
            usa.setLastConfCup(amCup2019);
            usa.setBestCCResult("vainqueur");
            usa.setLastCCResult("vainqueur");
            usa.setLastConfLeague(am1A2019);
            usa.setLastCLResult("vainqueur");
            usa.setBestConfLeague(am1A2019);
            usa.setBestCLResult("vainqueur");

            usa = nationService.saveNation(usa);
            Nation panama = new Nation("Panama",1123.35,0,americas,"2018","Estadio Rommel Fernández",
                    33,5,"America/Panama",wuf);
            panama = nationService.saveNation(panama);
            locDate1 = LocalDateTime.parse("2021-11-21T03:00:00");
            usa.getMatchesHome().add(matchService.addMatch(usa,panama, 16, 14, locDate1, "America/New_York"));

            Nation canada = new Nation("Canada", 1336.97, 0, americas, "2018","TD Place",
                    11, 2,"America/Toronto",wuf);
            canada = nationService.saveNation(canada);
            locDate2 = LocalDateTime.parse("2021-11-14T03:00:00");
            usa.getMatchesHome().add(matchService.addMatch(usa,canada, 16, 14, locDate2, "America/New_York"));

            Nation japan = new Nation("Japon",1454.49,0,asia,"2018","Japan National Stadium",
                    7,3,"Asia/Tokyo",wuf);
            japan = nationService.saveNation(japan);
            locDate3 = LocalDateTime.parse("2021-06-30T03:00:00");
            usa.getMatchesHome().add(matchService.addMatch(usa,japan,23, 73, locDate3, "America/New_York"));

            Nation sweden = new Nation("Suède",1384.6,0,europe,"2018","Friends Arena",
                    9,5,"Europe/Stockholm",wuf);
            sweden = nationService.saveNation(sweden);
            locDate4 = LocalDateTime.parse("2021-06-25T03:00:00");
            usa.getMatchesHome().add(matchService.addMatch(usa,sweden, 21, 20, locDate4, "America/New_York"));

            Nation namibia = new Nation("Namibie",1253.96,0,africa,"2018","Hage Geingob Rugby Stadium",
                   16,3,"Africa/Windhoek",wuf);
            namibia = nationService.saveNation(namibia);
            locDate5 = LocalDateTime.parse("2021-06-19T03:00:00");
            usa.getMatchesHome().add(matchService.addMatch(usa,namibia, 145, 19, locDate5, "America/New_York"));


            americas.getNations().add(usa);
            wuf.getNations().add(usa);

            canada.setWorldCupParticipations(1);
            canada.setBestWorldCup(worldCup2021);
            canada.setLastWorldCup(worldCup2021);
            canada.setBestWCResult("huitièmes de finale");
            canada.setLastWCResult("huitièmes de finale");
            canada.setConfCupParticipations(1);
            canada.setBestConfCup(amCup2019);
            canada.setLastConfCup(amCup2019);
            canada.setBestCCResult("finaliste");
            canada.setLastCCResult("finaliste");
            canada.setLastConfLeague(am1A2019);
            canada.setLastCLResult("2eme");
            canada.setBestConfLeague(am1A2019);
            canada.setBestCLResult("2eme");

            canada = nationService.saveNation(canada);
            locDate1 = LocalDateTime.parse("2021-11-14T03:00:00");
            canada.getMatchesAway().add(matchService.addMatch(usa,canada, 16, 14, locDate1,"America/Toronto"));

            Nation mexico = new Nation("Mexique",1232.1,0,americas,"2018","Estadio Azteca",
                   17,3,"America/Mexico_City",wuf);
            mexico = nationService.saveNation(mexico);
            locDate2 = LocalDateTime.parse("2021-10-17T03:00:00");
            canada.getMatchesHome().add(matchService.addMatch(canada,mexico, 16, 9, locDate2, "America/Toronto"));

            Nation argentina = new Nation("Argentine",1088.31,0,americas,"2018","José Amalfitani Stadium",
                    42,7,"America/La_Paz",wuf);
            argentina = nationService.saveNation(argentina);
            locDate3 = LocalDateTime.parse("2021-09-19T01:00:00");
            canada.getMatchesHome().add(matchService.addMatch(canada,argentina,16,9, locDate3, "America/Toronto"));

            Nation scotland = new Nation("Ecosse", 1267.92,0,europe,"2018","Murrayfield Stadium",
                    14,7,"Europe/London",wuf);
            scotland = nationService.saveNation(scotland);
            locDate4 = LocalDateTime.parse("2021-07-01T03:00:00");
            canada.getMatchesHome().add(matchService.addMatch(canada,scotland,31, 105, locDate4,"America/Toronto"));

            Nation kenya = new Nation("Kenya",1307.61,0,africa,"2018","Nyayo National Stadium",
                    12,2,"Africa/Nairobi",wuf);
            kenya = nationService.saveNation(kenya);
            locDate5 = LocalDateTime.parse("2021-06-27T01:00:00");
            canada.getMatchesHome().add(matchService.addMatch(canada,kenya, 63,55, locDate5, "America/Toronto"));


            americas.getNations().add(canada);

            wuf.getNations().add(canada);
            wuf.getConfs().add(americas);

            wufBoardService.saveWufBoard(wuf);
        }
    }
}
