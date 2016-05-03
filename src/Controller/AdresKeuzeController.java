package Controller;

import View.AdresKeuzeView;

/**
 *
 * @author Sonja
 */
public class AdresKeuzeController {
    public static void adresStart() {
        AdresKeuzeView view = new AdresKeuzeView();
        int select = view.getSelect();
            switch (select) {
                case 1:
                    //AdresController.createAdresView();
                    break;
                case 2:
                    //updateAdresMenu();
                    break;
                case 3:
                    //readAdresMenu();
                    break;
                case 4:
                    //readAdresByIDMenu();
                    break;
                case 5:
                    //deleteAdresMenu();
                    break;
                case 0:
                    //HoofdMenu.startMenu();
                    break;
                default:
                    view.herhaalKeuze();
                    break;
            }
    }
}