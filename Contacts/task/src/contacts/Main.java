package contacts;

import inputController.CrudRealization;
import inputController.RepositoryCrud;
import menu.ExecuteCrud;
import menu.Menu;

public class Main {


    public static void main(String[] args) {


        RepositoryCrud crud = CrudRealization.getInstance();
        if (args.length > 0)
            crud.setFileName(args[0]);
        ExecuteCrud executeCrud = ExecuteCrud.getInstance(crud);
        Menu menuOption = new Menu(executeCrud);
        menuOption.execute();

    }


}






