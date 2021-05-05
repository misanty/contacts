package contacts;

import inputController.CrudRealization;
import inputController.RepositoryCrud;
import menu.ExecuteCrud;
import menu.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        RepositoryCrud crud = CrudRealization.getInstance();
        crud.setFileName(args[0]);
        ExecuteCrud executeCrud = ExecuteCrud.getInstance(crud);
        Menu menuOption = new Menu(executeCrud);
        menuOption.execute();

    }


}






