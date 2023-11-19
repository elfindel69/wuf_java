package inc.cwg.wufjava.controllers;

import inc.cwg.wufjava.models.*;
import inc.cwg.wufjava.models.Conf;
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
    private final StadiumService stadiumService;
    private final MatchCupService matchCupService;
    private final LeagueService leagueService;
    private final MatchLeagueService matchLeagueService;

    public DataController(WufBoardService wufBoardService, ConfService confService, NationService nationService,
                          WorldCupService worldCupService, ConfCupService confCupService, ConfLeagueService confLeagueService,
                          MatchService matchService, StadiumService stadiumService, MatchCupService matchCupService,
                          LeagueService leagueService, MatchLeagueService matchLeagueService) {
        this.wufBoardService = wufBoardService;
        this.confService = confService;
        this.nationService = nationService;
        this.worldCupService = worldCupService;
        this.confCupService = confCupService;
        this.confLeagueService = confLeagueService;
        this.matchService = matchService;
        this.stadiumService = stadiumService;
        this.matchCupService = matchCupService;
        this.leagueService = leagueService;
        this.matchLeagueService = matchLeagueService;
    }

    @PostConstruct
   private void init(){
        if(wufBoardService.fetchWufBoard(1) == null){
            WufBoard wuf = new WufBoard("WUF", "WUF",209,"2018");
            wuf = wufBoardService.saveWufBoard(wuf);
            Conf americas = new Conf("Amériques", "américain", 41, "2018",wuf);
            americas = confService.saveConf(americas);
            Nation usa = new Nation("Etats-Unis", 1373.41, 0, americas, "2018",null,
                     10, 1,"America/New_York",wuf);
            usa = nationService.saveNation(usa);
            Stadium fedExField = stadiumService.addStadium("FedEx Field","Washington",usa);
            usa.setMainStadium(fedExField);
            WorldCup worldCup2021 = new WorldCup("Coupe du Monde", "2021",
                    LocalDate.parse("2021-06-03"), LocalDate.parse("2021-07-17"),usa);
            worldCup2021 = worldCupService.saveWorldCup(worldCup2021);
            wuf.getWorldCups().add(worldCup2021);
            League wc2021GroupE = new League("Coupe du Monde 2021","2021","Groupe E");
            wc2021GroupE.setCup(worldCup2021);
            wc2021GroupE = leagueService.saveLeague(wc2021GroupE);
            League wc2021GroupD = new League("Coupe du Monde 2021","2021","Groupe D");
            wc2021GroupD.setCup(worldCup2021);
            wc2021GroupD = leagueService.saveLeague(wc2021GroupD);
            League wc2021GroupF = new League("Coupe du Monde 2021","2021","Groupe F");
            wc2021GroupF.setCup(worldCup2021);
            wc2021GroupF = leagueService.saveLeague(wc2021GroupF);


            Conf europe = new Conf("Europe", "européen", 54, "2018", wuf);
            europe = confService.saveConf(europe);
            Nation germany = new Nation("Allemagne", 1133.98, 0, europe, "2018",null,
                    28, 12,"Europe/Berlin",wuf);
            germany = nationService.saveNation(germany);
            Stadium olympia = stadiumService.addStadium("Olympiastadion Berlin","Berlin",germany);
            germany.setMainStadium(olympia);

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
            ConfCup qualifsEu2023 = new ConfCup("Qualifications Coupe d'Europe 2023","2021",
                    LocalDate.parse("2021-09-06"),LocalDate.parse("2021-11-28"),null,europe);
            qualifsEu2023 = confCupService.saveConfCup(qualifsEu2023);

            Nation france = new Nation("France", 1294.97, 0, europe,"2018",
                    null,  13, 6,"Europe/Paris",wuf);
            france = nationService.saveNation(france);
            Stadium sdf = stadiumService.addStadium("Stade de France","Saint Denis",france);
            france.setMainStadium(sdf);
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
                    "2018", null,  1, 1,"Europe/London",wuf);
            england = nationService.saveNation(england);
            Stadium twickhenham = stadiumService.addStadium("Twickenham Stadium","London",england);
            england.setMainStadium(twickhenham);
            england = nationService.saveNation(england);
            france.getMatchesAway().add(matchCupService.addMatchCup(england, france, 18, 16, locDate1, "Europe/Paris",twickhenham,qualifsEu2023));

            LocalDateTime locDate2 = LocalDateTime.parse("2021-11-13T21:00:00");
            Nation ireland = new Nation("Irlande",1442.74,0,europe,"2018",null,
                    8,4,"Europe/Dublin",wuf);
            ireland = nationService.saveNation(ireland);
            Stadium aviva= stadiumService.addStadium("Aviva Stadium","Dublin",ireland);
          ireland.setMainStadium(aviva);
            nationService.saveNation(ireland);
            france.getMatchesAway().add(matchCupService.addMatchCup(ireland,france, 14, 16, locDate2, "Europe/Dublin",aviva,qualifsEu2023));

            LocalDateTime locDate3 = LocalDateTime.parse("2021-07-09T03:00:00");
            Conf asia = new Conf("Asie","Astiatique",59,"2018", wuf);
            asia = confService.saveConf(asia);
            Nation nzl = new Nation("Nouvelle-Zélande",1815.07,0,asia,"2018",null,
                    3,1,"Pacific/Auckland",wuf);
            nzl = nationService.saveNation(nzl);
            Stadium edenPark = stadiumService.addStadium("Eden Park","Auckland",nzl);
            nzl.setMainStadium(edenPark);
            nationService.saveNation(nzl);
            Stadium yankee = stadiumService.addStadium("Yankee Stadium","New York",usa);
            france.getMatchesAway().add(matchCupService.addMatchCup(nzl,france, 85, 51, locDate3, "America/New_York",fedExField,worldCup2021));

            LocalDateTime locDate4 = LocalDateTime.parse("2021-07-02T03:00:00");
            Nation croatia = new Nation("Croatie",1523.75,0,europe,"2018",null,
                    5,3,"Europe/Zagreb",wuf);
            croatia = nationService.saveNation(croatia);
            Stadium maksimir = stadiumService.addStadium("Stadion Maksimir","Zagreb",croatia);
         croatia.setMainStadium(maksimir);
            nationService.saveNation(croatia);
            france.getMatchesAway().add(matchCupService.addMatchCup(croatia,france, 14, 42, locDate4, "America/New_York",fedExField,worldCup2021));

            LocalDateTime locDate5 = LocalDateTime.parse("2021-06-27T03:00:00");
            Conf africa = new Conf("Afrique","Africaine",56,"2018", wuf);
            africa = confService.saveConf(africa);
            Nation southAfrica = new Nation("Afrique du Sud",1849.6,0,africa,"2018",null,
                    2,1,"Africa/Johannesburg",wuf);
            southAfrica = nationService.saveNation(southAfrica);
            Stadium ellisPark = stadiumService.addStadium("Ellis Park","Johannesburg",southAfrica);
            southAfrica.setMainStadium(ellisPark);
            nationService.saveNation(southAfrica);
            france.getMatchesAway().add(matchLeagueService.addMatchLeague(southAfrica,france, 52, 13, locDate5, "America/New_York",yankee,wc2021GroupE));


            europe.getNations().add(france);
            wuf.getNations().add(france);

            Nation italy = new Nation("Italie", 1153.25, 0, europe, "2018", null,
                    25, 10,"Europe/Rome",wuf);
            italy = nationService.saveNation(italy);
            Stadium olympico = stadiumService.addStadium("Stadio Olympico","Rome",italy);
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
            Nation wales = new Nation("Pays de Galles",1567.2,0,europe,"2018",null,
                    4,2,"Europe/London",wuf);
            wales = nationService.saveNation(wales);
            Stadium millenium = stadiumService.addStadium("Millenium Stadium","Cardiff",wales);
           wales.setMainStadium(millenium);
            nationService.saveNation(wales);

            italy.getMatchesHome().add(matchCupService.addMatchCup(italy,wales,9, 16, locDate1, "Europe/Rome",olympico,qualifsEu2023));
         italy.getMatchesAway().add(matchCupService.addMatchCup(croatia,italy,14, 16, locDate2, "Europe/Zagreb",maksimir,qualifsEu2023));

            Nation russia = new Nation("Russie",1117.13,0,europe,"2018",null,
                    36,15,"Europe/Moscow",wuf);
            russia = nationService.saveNation(russia);
            Stadium luzhniki = stadiumService.addStadium("Luzhniki Stadium","Moscow",russia);
            russia.setMainStadium(luzhniki);
            nationService.saveNation(russia);
           
            italy.getMatchesHome().add(matchCupService.addMatchCup(italy,russia,16, 14, locDate3, "Europe/Rome",olympico,qualifsEu2023));

            italy.getMatchesAway().add(matchCupService.addMatchCup(germany,italy,14, 16, locDate4, "Europe/Berlin",olympia,qualifsEu2023));

            Nation switzerland = new Nation("Suisse",1127.61,0,europe,"2018",null,
                   30,13,"Europe/Zurich",wuf );
            switzerland = nationService.saveNation(switzerland);
            Stadium wankdorf = stadiumService.addStadium("Wankdorf Stadium","Berne",switzerland);
            switzerland.setMainStadium(wankdorf);
            nationService.saveNation(switzerland);
          
            italy.getMatchesAway().add(matchCupService.addMatchCup(switzerland,italy,23, 13, locDate5, "Europe/Zurich",wankdorf,qualifsEu2023));

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



            locDate2 = LocalDateTime.parse("2021-10-16T18:30:00");
            england.getMatchesHome().add(matchCupService.addMatchCup(england,wales, 16 ,14, locDate2, "Europe/London",twickhenham,qualifsEu2023));

            locDate3 = LocalDateTime.parse("2021-07-17T03:00:00");
            england.getMatchesHome().add(matchCupService.addMatchCup(england,southAfrica, 38, 40, locDate3, "America/New_York",yankee,worldCup2021));

            Nation australia = new Nation("Australie",1469.09,0,asia,"2018",null,
                    6,2,"Australia/Sydney",wuf);
            australia = nationService.saveNation(australia);
            Stadium stadiumAustralia = stadiumService.addStadium("Stadium Australia","Sydney",australia);
            australia.setMainStadium(stadiumAustralia);
            nationService.saveNation(australia);
            locDate4 = LocalDateTime.parse("2021-07-14T00:30:00");
            england.getMatchesHome().add(matchCupService.addMatchCup(england,australia, 121, 127, locDate4, "America/New_York",yankee,worldCup2021));
            Stadium gilette = stadiumService.addStadium("Gillette Stadium","Boston",usa);
            locDate5 = LocalDateTime.parse("2021-07-08T00:30:00");
            england.getMatchesAway().add(matchCupService.addMatchCup(ireland,england, 15, 55, locDate5, "America/New_York",gilette,worldCup2021));


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

            ConfCup qualifsAm2023 = new ConfCup("Qualifications Coupe des Amériques 2023","2021", LocalDate.parse("2021-09-06"),
                    LocalDate.parse("2021-11-28"),null,americas);
            qualifsAm2023 = confCupService.saveConfCup(qualifsAm2023);
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
            Nation panama = new Nation("Panama",1123.35,0,americas,"2018",null,
                    33,5,"America/Panama",wuf);
            panama = nationService.saveNation(panama);
            Stadium rommelFernandez = stadiumService.addStadium("Estadio Rommel Fernández","Panama City",panama);
            panama.setMainStadium(rommelFernandez);
            nationService.saveNation(panama);
            locDate1 = LocalDateTime.parse("2021-11-21T03:00:00");
            usa.getMatchesHome().add(matchCupService.addMatchCup(usa,panama, 16, 14, locDate1, "America/New_York",fedExField,qualifsAm2023));

            Nation canada = new Nation("Canada", 1336.97, 0, americas, "2018",null,
                    11, 2,"America/Toronto",wuf);
            canada = nationService.saveNation(canada);
            Stadium tdPlace = stadiumService.addStadium("TD Place","Ottawa",canada);
            canada.setMainStadium(tdPlace);
            canada = nationService.saveNation(canada);
            locDate2 = LocalDateTime.parse("2021-11-14T03:00:00");
            usa.getMatchesHome().add(matchCupService.addMatchCup(usa,canada, 16, 14, locDate2, "America/New_York",fedExField,qualifsAm2023));

            Nation japan = new Nation("Japon",1454.49,0,asia,"2018",null,
                    7,3,"Asia/Tokyo",wuf);
            japan = nationService.saveNation(japan);
            japan.setMainStadium(stadiumService.addStadium("Japan National Stadium","Tokyo",japan));
            nationService.saveNation(japan);
            locDate3 = LocalDateTime.parse("2021-06-30T03:00:00");
            Stadium subaruPark = stadiumService.addStadium("Subaru Park","Philadelphia",usa);
            usa.getMatchesHome().add(matchCupService.addMatchCup(usa,japan,23, 73, locDate3, "America/New_York",subaruPark,worldCup2021));

            Nation sweden = new Nation("Suède",1384.6,0,europe,"2018",null,
                    9,5,"Europe/Stockholm",wuf);
            sweden = nationService.saveNation(sweden);
            sweden.setMainStadium(stadiumService.addStadium("Friends Arena","Solna",sweden));
            nationService.saveNation(sweden);
            locDate4 = LocalDateTime.parse("2021-06-25T03:00:00");
            usa.getMatchesHome().add(matchLeagueService.addMatchLeague(usa,sweden, 21, 20, locDate4, "America/New_York",subaruPark,wc2021GroupD));

            Nation namibia = new Nation("Namibie",1253.96,0,africa,"2018",null,
                   16,3,"Africa/Windhoek",wuf);
            namibia = nationService.saveNation(namibia);
            namibia.setMainStadium(stadiumService.addStadium("Hage Geingob Rugby Stadium","Windhoek",namibia));
            nationService.saveNation(namibia);
            locDate5 = LocalDateTime.parse("2021-06-19T03:00:00");
            usa.getMatchesHome().add(matchLeagueService.addMatchLeague(usa,namibia, 145, 19, locDate5, "America/New_York",yankee,wc2021GroupD));


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


            Nation mexico = new Nation("Mexique",1232.1,0,americas,"2018",null,
                   17,3,"America/Mexico_City",wuf);
            mexico = nationService.saveNation(mexico);
            mexico.setMainStadium(stadiumService.addStadium("Estadio Azteca","Mexico City",mexico));
            nationService.saveNation(mexico);
            locDate2 = LocalDateTime.parse("2021-10-17T03:00:00");
            canada.getMatchesHome().add(matchCupService.addMatchCup(canada,mexico, 16, 9, locDate2, "America/Toronto",tdPlace,qualifsAm2023));

            Nation argentina = new Nation("Argentine",1088.31,0,americas,"2018",null,
                    42,7,"America/La_Paz",wuf);
            argentina = nationService.saveNation(argentina);
            argentina.setMainStadium(stadiumService.addStadium("José Amalfitani Stadium","La Paz",argentina));
            nationService.saveNation(argentina);
            locDate3 = LocalDateTime.parse("2021-09-19T01:00:00");
            canada.getMatchesHome().add(matchCupService.addMatchCup(canada,argentina,16,9, locDate3, "America/Toronto",tdPlace,qualifsAm2023));

            Nation scotland = new Nation("Ecosse", 1267.92,0,europe,"2018",null,
                    14,7,"Europe/London",wuf);
            scotland = nationService.saveNation(scotland);
            scotland.setMainStadium(stadiumService.addStadium("Murrayfield Stadium","Edinburgh",scotland));
            nationService.saveNation(scotland);
            locDate4 = LocalDateTime.parse("2021-07-01T03:00:00");
            canada.getMatchesHome().add(matchCupService.addMatchCup(canada,scotland,31, 105, locDate4,"America/New_York",fedExField,worldCup2021));

            Nation kenya = new Nation("Kenya",1307.61,0,africa,"2018",null,
                    12,2,"Africa/Nairobi",wuf);
            kenya = nationService.saveNation(kenya);
            kenya.setMainStadium(stadiumService.addStadium("Nyayo National Stadium","Nairobi",kenya));
            nationService.saveNation(kenya);
            locDate5 = LocalDateTime.parse("2021-06-27T01:00:00");
            canada.getMatchesHome().add(matchLeagueService.addMatchLeague(canada,kenya, 63,55, locDate5, "America/New_York",fedExField,wc2021GroupF));


            americas.getNations().add(canada);

            wuf.getNations().add(canada);
            wuf.getConfs().add(americas);

            wufBoardService.saveWufBoard(wuf);
        }
    }
}
