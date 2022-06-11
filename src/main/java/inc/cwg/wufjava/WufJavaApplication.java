package inc.cwg.wufjava;

import inc.cwg.wufjava.cli.CliConf;
import inc.cwg.wufjava.cli.CliMenu;
import inc.cwg.wufjava.cli.CliNation;
import inc.cwg.wufjava.controllers.MenuController;
import inc.cwg.wufjava.controllers.NationController;
import inc.cwg.wufjava.controllers.RankingController;
import inc.cwg.wufjava.models.Conf;
import inc.cwg.wufjava.models.Nation;
import inc.cwg.wufjava.models.WufBoard;
import inc.cwg.wufjava.services.ConfService;
import inc.cwg.wufjava.services.NationService;
import inc.cwg.wufjava.services.WufBoardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class WufJavaApplication implements CommandLineRunner {

	private final WufBoardService wufBoardService;
	private final MenuController contMenu;
	private final NationController nationController;
	private final RankingController rankingController;
	private final ConfService confService;
	private final NationService nationService;

	public WufJavaApplication(WufBoardService wufBoardService, MenuController contMenu, NationController nationController,
							  RankingController rankingController, ConfService confService, NationService nationService) {
		this.wufBoardService = wufBoardService;
		this.contMenu = contMenu;
		this.nationController = nationController;
		this.rankingController = rankingController;
		this.confService = confService;
		this.nationService = nationService;
	}

	public static void main(String[] args) {
		SpringApplication.run(WufJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		WufBoard wuf = wufBoardService.fetchWufBoard(1);
		char key = 'y';
		do{
			Scanner sc = new Scanner(System.in);
			int startMenu = CliMenu.startMenu();
			//scores
			if (startMenu == 1)
			{

				contMenu.execScores();
			}
			//points
			if (startMenu == 2)
			{

				contMenu.execPoints();
			}
			//nations
			if (startMenu == 3)
			{



				int confMenu = CliConf.menuConf(wuf.getConfs());
				//Europe


				Conf conf = confService.fetchConf(confMenu);
				CliConf.doViewConf(conf);


				if(!conf.getNations().isEmpty()){

					int natMenu = CliNation.menuNations(conf.getNations());

					Nation nation = nationService.fetchNation(natMenu);
					nationController.viewNation(nation);

				}

			}
			//World ranking
			if (startMenu == 4)
			{
				List<Nation> list = rankingController.fetchWorldRanking(wuf);
				rankingController.viewRanking(list);
			}
			System.out.println("continuer? (y/n)");
			key = sc.nextLine().charAt(0);
		}while(key !='n');

	}
}
